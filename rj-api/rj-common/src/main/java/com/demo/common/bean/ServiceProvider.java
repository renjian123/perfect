package com.demo.common.bean;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @author tangjian
 * @version $Id: ServiceProvider.java, v 0.1 2017年11月8日 上午11:05:06 tangjian Exp $
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "dp_api_service_provider")
public class ServiceProvider implements Serializable {

    /** */
    private static final long serialVersionUID = 7430924314186022193L;

    @Id
    @Column(name = "asp_id")
    private String            id;

    @Column(name = "asp_path", nullable = false)
    @NotEmpty(message = "服务path不能为空")
    private String            path;

    @Column(name = "asp_service_id", nullable = false)
    @NotEmpty(message = "serviceId不能为空")
    private String            serviceId;

    @Column(name = "asp_url")
    private String            url;

    /** 0 false 1 true */
    @Column(name = "asp_retryable", nullable = false)
    private Integer           retryAble ;

    /** 0 false 1 true */
    @Column(name = "asp_enabled", nullable = false)
    private Integer           enabled ;

    /** 0 false 1 true */
    @Column(name = "asp_strip_prefix", nullable = false)
    private Integer           stripPrefix;

    @Column(name = "asp_app_name")
    private String            appName;
    
    @Column(name = "asp_service_type")
    private Integer            serviceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRetryAble() {
        return retryAble;
    }

    public void setRetryAble(Integer retryAble) {
        this.retryAble = retryAble;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(Integer stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

}
