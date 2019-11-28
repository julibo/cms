package com.julibo.pig.cms.tools.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author carson
 * @date 2019-11-28
 */
@Component
@Log4j2
public class BaseInterceptor implements HandlerInterceptor {

    /**
     * 实现前置方法
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();

        log.info("UserAgent: {}", request.getHeader("User-Agent"));


        // 拦截器处理用户权限
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login")) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //这个方法可以往request中添加一些公共的工具类给前端页面进行调用

    }



    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //当请求处理完成调用
    }

}
