package com.rpc.chenlei.client;

import com.alibaba.nacos.api.exception.NacosException;
import com.rpc.chenlei.client.handler.RpcResponseMessageHandler;
import com.rpc.chenlei.loadBalancer.RoundRobinRule;
import com.rpc.chenlei.message.RpcRequestMessage;
import com.rpc.chenlei.protocol.MessageCodecSharable;
import com.rpc.chenlei.protocol.ProcotolFrameDecoder;
import com.rpc.chenlei.register.NacosServerDiscovery;
import com.rpc.chenlei.register.ServerDiscovery;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 管理Rpc客户端的channel
 */
@Slf4j
public class RpcClientManager {

    //单例channel
    private static final Bootstrap bootstrap;
    static NioEventLoopGroup group;
    private final ServerDiscovery serviceDiscovery;
    //                       根据序号key来判断是哪个请求的消息      value是用来接收结果的 promise 对象
    public static final Map<Integer, Promise<Object>> PROMISES;
    //channel集合  可能请求多个服务
    private static Map<String, Channel> channels;
    private static final Object LOCK = new Object();

    static {
        bootstrap = new Bootstrap();
        group=new NioEventLoopGroup();
        initChannel();
        channels = new ConcurrentHashMap<>();
        PROMISES = new ConcurrentHashMap<Integer, Promise<Object>>();
    }

    public RpcClientManager() {
        this.group = new NioEventLoopGroup();
        this.serviceDiscovery = new NacosServerDiscovery(new RoundRobinRule());
    }


    /**
     * 获取channel  没有就建立链接
     *
     * @param inetSocketAddress
     * @return
     */
    public static Channel get(InetSocketAddress inetSocketAddress) {
        String key = inetSocketAddress.toString();
        //判断是否存在
        if (channels.containsKey(key)) {
            Channel channel = channels.get(key);
            if (channels != null && channel.isActive()) {
                return channel;
            }
            channels.remove(key);
        }
        //建立连接
        Channel channel;
        try {
            channel = bootstrap.connect(inetSocketAddress).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("连接出错");
        }
        channels.put(key, channel);
        return channel;
    }

    // 初始化 channel 方法
    private static Bootstrap initChannel() {
        //日志handler
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        //消息处理handler
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        //处理相应handler
        RpcResponseMessageHandler RPC_HANDLER = new RpcResponseMessageHandler();
        bootstrap.channel(NioSocketChannel.class)
                .group(group)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //定长解码器
                        ch.pipeline().addLast(new ProcotolFrameDecoder());
                        ch.pipeline().addLast(LOGGING_HANDLER);
                        ch.pipeline().addLast(MESSAGE_CODEC);
                        ch.pipeline().addLast(RPC_HANDLER);
                    }
                });
        return bootstrap;
    }

    /**
     * 发送消息根据用户名 服务发现 找到地址
     *
     * @param msg
     */
    public void sendRpcRequest(RpcRequestMessage msg) throws NacosException {
        InetSocketAddress service = serviceDiscovery.getService(msg.getInterfaceName());
        Channel channel = get(service);
        channel.writeAndFlush(msg).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                log.debug("客户端发送消息成功");
            }
        });
    }
}
