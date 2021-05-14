package com.rpc.chenlei.register;

import com.alibaba.nacos.api.exception.NacosException;

import java.net.InetSocketAddress;

public interface ServerRegister {
    /**
     * 将服务的名称和地址注册进服务注册中心
     * @param serviceName
     * @param inetSocketAddress
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress) throws NacosException;

    /**
     * 根据服务名称从注册中心获取到服务提供者的地址
     * @param serviceName
     * @return
     */
    InetSocketAddress getService(String serviceName);
}
