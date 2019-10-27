package com.lurenqiang.car.Intercept;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器{}",request.getRequestURI());
        //通过getAttribute获取session的值
        Object user = request.getSession().getAttribute("user");
        //判断是否有保存值，有即证明登录成功
        if(user!=null){
            //session不空，表示有保存值，有登陆，放行
            return true;
         }else{
            log.info("没有权限");
                //没有值，没有登录，返回到登录页面：
                response.sendRedirect("/car/api/login/login_in");
                //同时设置错误信息
                request.setAttribute("msg","没有权限");
                return false; }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
