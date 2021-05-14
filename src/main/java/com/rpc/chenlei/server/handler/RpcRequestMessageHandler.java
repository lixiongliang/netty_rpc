package com.rpc.chenlei.server.handler;

import com.rpc.chenlei.message.RpcRequestMessage;
import com.rpc.chenlei.message.RpcResponseMessage;
import com.rpc.chenlei.server.service.HelloService;
import com.rpc.chenlei.server.service.ServicesFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
@ChannelHandler.Sharable
public class RpcRequestMessageHandler extends SimpleChannelInboundHandler<RpcRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequestMessage message) {
        RpcResponseMessage responseMessage=new RpcResponseMessage();
        try {
            HelloService service = (HelloService) ServicesFactory.getService(Class.forName(message.getInterfaceName()));
            Method method = service.getClass().getDeclaredMethod(message.getMethodName());
            Object invoke = method.invoke(service, message.getParameterValue());

            responseMessage.setReturnValue(invoke);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            responseMessage.setExceptionValue(new Exception("远程调用出错:"+e.getMessage()));
            e.printStackTrace();
        }
        ctx.writeAndFlush(responseMessage);
    }

}
