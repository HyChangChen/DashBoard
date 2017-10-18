package com.hxqh.webService.client;

import com.hxqh.webService.service.CommonService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  cxfClient.java                             §
 * §┇File Path: com.hxqh.webService.client.cxfClient           §
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
public class cxfClient {
    private static final String JWS_RT_WSDL_URI = "http://localhost:8080/dashboard/ws/commService?wsdl";
    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static void cl1() {
        try {
            // 接口地址
            String address = "http://localhost:8080/dashboard/ws/commService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            // 创建一个代理接口实现
            CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userName = "test";
            // 调用代理接口的方法调用并返回结果
            String result = "";
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用方式
     */
    public static void cl2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/dashboard/ws/commService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects;
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "Ocean_Hy");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CXF 动态代理模式，不用生成本地WS代理类，
     * 通过反射调用 WS 的对应的方法，传入相应的参数
     * 访问cxf-server-web项目下的webservice;
     * 测试jaxws-rt发布WebService web方式。
     * 此测试实例，用于测试SEI和SIB的targetNamespace指定的webService接口：
     * http://localhost:8080/cxf_server_web/jws_services?wsdl；
     *
     * @author donald
     * 2017年7月8日
     * 下午7:24:12
     */




    public static void CxfDynamicClientOnJwsRtWeb() {
        try {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient(JWS_RT_WSDL_URI);
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(10000);
            policy.setAllowChunking(false);
            policy.setReceiveTimeout(10000);
            conduit.setClient(policy);
            Object[] invokeResult = client.invoke("sayHello", "Ocean_Hy");
            System.out.println("返回数据:" + invokeResult[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        cl2();
    }
}
