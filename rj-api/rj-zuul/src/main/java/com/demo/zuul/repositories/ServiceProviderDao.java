package com.demo.zuul.repositories;

import com.demo.common.bean.ServiceProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProviderDao
{
    /**
     * 获取所有的服务
     * @return 服务
     */
    List<ServiceProvider> getApiServiceProviderList();
}
