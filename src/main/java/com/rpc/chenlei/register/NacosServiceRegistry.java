package com.rpc.chenlei.register;

import java.net.InetSocketAddress;

public class NacosServiceRegistry implements ServerRegister{


    /**
     * 服务注册
     * @param serviceName
     * @param inetSocketAddress
     */
    @Override
    public void register(String serviceName, InetSocketAddress inetSocketAddress) {

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
