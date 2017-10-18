package com.hxqh.webService.interceptor;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  SignInInterceptor.java                             §
 * §┇File Path: com.hxqh.webService.interceptor.SignInInterceptor           §
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


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import com.hxqh.eam.common.util.HttpUtils;
import com.hxqh.webService.model.BaseAgentIp;
import com.hxqh.webService.service.BaseAgentIpService;
import com.hxqh.webService.service.SessionConstants;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 【验证soapHead的签名信息】 SignInInterceptor
 *
 * @author Mr.Zhang
 */
public class SignInInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    private final Logger logger = Logger.getLogger(SignInInterceptor.class);

    /* 注入用于获取IP地址的service */
    @Resource(name = "baseAgentIpService")
    private BaseAgentIpService agentIpService;

    private SAAJInInterceptor saajIn = new SAAJInInterceptor();


    private String localPart = "authHeader";

    public SignInInterceptor() {
        super(Phase.PRE_INVOKE);
        getAfter().add(SAAJInInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage mess)

    {

        logger.info(">>>>>>>>>>>>>>>>>>signInInterceptor start<<<<<<<<<<<<<<<<<<<<");
        HttpServletRequest request = (HttpServletRequest) mess
                .get(AbstractHTTPDestination.HTTP_REQUEST);
        try {
            SOAPMessage doc = mess.getContent(SOAPMessage.class);
            if (doc == null) {
                saajIn.handleMessage(mess);
                doc = mess.getContent(SOAPMessage.class);
            }

            SOAPHeader head = doc.getSOAPHeader();
            if (head == null) {
                SOAPException soapExc = new SOAPException("没有head信息");
                throw new Fault(soapExc);
            }

            NodeList nodes = head.getElementsByTagName(localPart);
            if (nodes == null) {
                SOAPException soapExc = new SOAPException("没有head信息");
                throw new Fault(soapExc);
            }

			/*
             *  读取自定义的节点
			 */
            // 版本号
            NodeList version = head.getElementsByTagName("version");
            String versionStr = version.item(0).getTextContent();

            // 接口ID
            NodeList serviceId = head.getElementsByTagName("serviceId");
            String serviceIdStr = serviceId.item(0).getTextContent();

            // 渠道编号
            NodeList canalId = head.getElementsByTagName("canalId");
            String canalIdStr = canalId.item(0).getTextContent();

            // 请求时间
            NodeList requestdate = head.getElementsByTagName("requestDate");
            String requestdateStr = requestdate.item(0).getTextContent();

            /**
             * 保证与服务器时间前后相差不大于2分钟     当前时间 -请求时间  <= 2
             */
            long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
            long nh = 1000 * 60 * 60;//一小时的毫秒数
            long nm = 1000 * 60;//一分钟的毫秒数
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date nowDate = new Date();
            Date requestDate = df.parse(requestdateStr);
            long ddff = nowDate.getTime() - requestDate.getTime();
            long min = ddff % nd % nh / nm;//计算差多少分钟
            if (min > 2) {
                SOAPException soapExc = new SOAPException("认证超时！");
                throw new Fault(soapExc);
            }

            // 字符编码
            NodeList charset = head.getElementsByTagName("charset");
            String charsetStr = charset.item(0).getTextContent();

            // 签名
            NodeList signature = head.getElementsByTagName("signature");
            String signStr = signature.item(0).getTextContent();

            //随机数
            NodeList nonce = head.getElementsByTagName("nonce");
            String nonceStr = nonce.item(0).getTextContent();

            // 根据IP地址获取secret_key
            String ipAddress = HttpUtils.getIpAddr(request); // 取客户端IP地址
            Integer port = request.getRemotePort(); // 获取端口号
            BaseAgentIp baseAgentIp = agentIpService.getTokenByIp(ipAddress);
            String secretKey = baseAgentIp.getSecretKey();

            // 拼接签名信息
            String[] getSignStr = null;

            // a
            if (canalIdStr.equals("a")) {
                getSignStr = new String[]{"version=" + versionStr,
                        "&serviceId=" + serviceIdStr, "&canalId=a",
                        "&requestDate=" + requestdateStr, "&signMethod=MD5",
                        "&charset=" + charsetStr, "&nonce=" + nonceStr,
                        "&secret_key=" + secretKey.toUpperCase()};
            }
            //b
            if (canalIdStr.equals("b")) {
                getSignStr = new String[]{"version=" + versionStr,
                        "&serviceId=" + serviceIdStr, "&canalId=b",
                        "&requestDate=" + requestdateStr, "&signMethod=MD5",
                        "&charset=" + charsetStr, "&nonce=" + nonceStr,
                        "&secret_key=" + secretKey.toUpperCase()};
            }
            //o2o
            if (canalIdStr.equals("c")) {
                getSignStr = new String[]{"version=" + versionStr,
                        "&serviceId=" + serviceIdStr, "&canalId=c",
                        "&requestDate=" + requestdateStr, "&signMethod=MD5",
                        "&charset=" + charsetStr, "&nonce=" + nonceStr,
                        "&secret_key=" + secretKey.toUpperCase()};
            }
            if (getSignStr == null) {
                SOAPException soapExc = new SOAPException("签名错误");
                throw new Fault(soapExc);
            } else {
                if (HttpUtils.checkSign(getSignStr, signStr)) {
                    // 将请求的信息保存在session中
                    SessionConstants.clearValues();
                    SessionConstants.setValues(requestdateStr, canalIdStr,
                            ipAddress, port.toString());
                    logger.info("认证成功");
                } else {
                    SOAPException soapExc = new SOAPException("签名错误");
                    throw new Fault(soapExc);
                }
            }
            logger.info(">>>>>>>>>>>>>>>>>>signInInterceptor end<<<<<<<<<<<<<<<<<<<<");

        } catch (Exception e) {
            throw new Fault(e);
        }
    }

}
