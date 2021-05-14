package com.rpc.chenlei.test;

import com.rpc.chenlei.client.ClientProxy;
import com.rpc.chenlei.client.RpcClientManager;
import com.rpc.chenlei.register.NacosServerDiscovery;
import com.rpc.chenlei.server.service.HelloService;



public class RpcClient {
    public static void main(String[] args) {
        RpcClientManager clientManager = new RpcClientManager();
        HelloService service = new  ClientProxy(clientManager).getProxyService(HelloService.class);
        System.out.println(service.sayHello("zhangsan"));
//        System.out.println(service.sayHello("lisi"));
//        System.out.println(service.sayHello("wangwu"));
    }
}
