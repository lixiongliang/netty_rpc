package com.rpc.chenlei.server;

import com.rpc.chenlei.protocol.MessageCodecSharable;
import com.rpc.chenlei.protocol.ProcotolFrameDecoder;
import com.rpc.chenlei.server.handler.RpcRequestMessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class RpcServiceManager {
    protected String host;
    protected int port;

    public RpcServiceManager(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        //日志
        LoggingHandler LOGGING = new LoggingHandler(LogLevel.DEBUG);
        //消息节码器
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        //RPC请求处理器
        RpcRequestMessageHandler RPC_HANDLER = new RpcRequestMessageHandler();
        try {
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 256)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
                            pipeline.addLast(new ProcotolFrameDecoder());//定长解码器
                            pipeline.addLast(LOGGING);
                            pipeline.addLast(MESSAGE_CODEC);
                            pipeline.addLast(RPC_HANDLER);
                        }
                    });
            //绑定端口
            Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
