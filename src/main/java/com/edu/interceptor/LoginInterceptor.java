package com.edu.interceptor;

import com.edu.vo.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截Controller的方法调用
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在Controller执行前执行，返回值决定Controller方法是否执行
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("user");
        if (user == null){
            response.setContentType("application/json;charset=utf-8");
            //开放跨域
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter out = response.getWriter();
            ResultVO resultVO = ResultVO.error(2,"未登录");
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(resultVO);
            out.print(jsonValue);
            return false;
        }else {
            return true;
        }

    }

    /**
     * 在controller执行后，视图解析前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 在controller执行后，视图解析后
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
