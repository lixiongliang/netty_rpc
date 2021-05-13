package com.rpc.chenlei.test;

import com.rpc.chenlei.server.service.HelloService;

import static com.rpc.chenlei.client.RpcClientManager.getProxyService;

public class RpcClient {
    public static void main(String[] args) {
        HelloService service = getProxyService(HelloService.class);
        System.out.println(service.sayHello("zhangsan"));
//        System.out.println(service.sayHello("lisi"));
//        System.out.println(service.sayHello("wangwu"));
    }
}
