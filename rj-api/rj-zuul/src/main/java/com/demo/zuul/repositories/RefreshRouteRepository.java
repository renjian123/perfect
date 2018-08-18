package com.demo.zuul.repositories;

import com.demo.common.bean.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author zhongqiu
 * @version $Id: RefreshRouteRepository.java, v 0.1 2017年11月7日 下午7:26:15 zhongqiu Exp $
 */
@Repository
public class RefreshRouteRepository
{
    @Autowired
    ServiceProviderDao serviceProviderDao;

    public List<ServiceProvider> getApiServiceProviderList()
    {
        return  serviceProviderDao.getApiServiceProviderList();
    }
}