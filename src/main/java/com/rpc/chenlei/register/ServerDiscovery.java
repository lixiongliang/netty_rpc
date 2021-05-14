package com.rpc.chenlei.register;


import com.alibaba.nacos.api.exception.NacosException;

import java.net.InetSocketAddress;

/**
 * 服务发现
 */
public interface ServerDiscovery {

    /**
     * 根据服务名找到InetSocketAddress
     */
    InetSocketAddress  getService(String serviceName) throws NacosException;

}
