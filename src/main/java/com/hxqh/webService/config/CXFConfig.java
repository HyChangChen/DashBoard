package com.hxqh.webService.config;

import com.hxqh.webService.interceptor.AuthInterceptor;
import com.hxqh.webService.service.CommonService;
import com.hxqh.webService.service.imp.CommonServiceImp;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.xml.ws.Endpoint;


/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  CXFConfig.java                           §
 * §┇File Path: com.hxqh.webService.config.CXFConfig           §
 * §Descrption:                                          §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
@Configuration
public class CXFConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public CommonService commonService() {
        return new CommonServiceImp();
    }

    /**
     * JAX-WS
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), commonService());
        endpoint.publish("/CommonService");
        //增加密码访问
       // endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }
    /***
     * 更改WebService 的访问Url
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/ws/*");
        bean.setLoadOnStartup(0);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
