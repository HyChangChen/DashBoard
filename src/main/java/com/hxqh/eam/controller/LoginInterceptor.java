package com.hxqh.eam.controller;


import com.hxqh.eam.model.base.SessionInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lh on 2017-05-12.
 */

@Controller
@SessionAttributes(value = "sessionInfo")
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String[] IGNORE_URI = {"/system/first", "/indexFirst.jsp", "system/login", "scripts/", "css/", "favicon.ico"};
    private static final String LOGOUT_URL = "system/logout";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        //System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (url.contains(LOGOUT_URL)) {
            HttpSession session = request.getSession();
            session.removeAttribute("sessionInfo");
            session.invalidate();
        }
        if (!flag) {
            HttpSession session = request.getSession();
            //session.setMaxInactiveInterval(1*60);
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
            if (sessionInfo != null)
            {
                flag = true;
                return flag;
            }
            else
            {
                response.sendRedirect("/system/first");
                return flag;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
