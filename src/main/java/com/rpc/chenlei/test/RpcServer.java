package com.rpc.chenlei.test;


import com.rpc.chenlei.server.RpcServiceManager;

public class RpcServer {
    public static void main(String[] args) throws InterruptedException {
        new RpcServiceManager("127.0.0.1",8080).start();
    }
}
