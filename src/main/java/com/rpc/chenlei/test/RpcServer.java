package com.rpc.chenlei.test;


import com.alibaba.nacos.api.exception.NacosException;
import com.rpc.chenlei.register.NacosServerRegistry;
import com.rpc.chenlei.server.RpcServiceManager;

import java.net.InetSocketAddress;

public class RpcServer {
    public static void main(String[] args) throws InterruptedException, NacosException {
        //向注册中心中注册服务
        NacosServerRegistry registry = new NacosServerRegistry();
        registry.register("com.rpc.chenlei.server.service.HelloService",new InetSocketAddress("127.0.0.1",8080));
        new RpcServiceManager("127.0.0.1",8080).start();
    }
}
