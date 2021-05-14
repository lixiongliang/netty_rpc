package com.rpc.chenlei.register;

import com.alibaba.nacos.api.exception.NacosException;

import java.net.InetSocketAddress;

public class NacosServerRegistry implements ServerRegister{


    /**
     * 服务注册
     * @param serviceName
     * @param inetSocketAddress
     */
    @Override
    public void register(String serviceName, InetSocketAddress inetSocketAddress) throws NacosException {
        NacosUtils.registerServer(serviceName,inetSocketAddress);
    }

    /**
     * 根据服务名获取地址
     * @param serviceName
     * @return
     */
    @Override
    public InetSocketAddress getService(String serviceName) {
        return null;
    }
}
