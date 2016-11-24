package com.my.sb.core.security.interceptor;


import com.my.sb.core.exception.OrtException;
import com.my.sb.core.security.anotation.Security;
import com.my.sb.core.util.SessionUtils;
import com.my.sb.domain.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Security annotation = method.getAnnotation(Security.class);
            // 若方法有Security注解，则进行权限验证
            if (null != annotation && !checkToken(request)) {
                throw new OrtException(403, "权限出错!");
            }
        }
        return super.preHandle(request, response, handler);
    }

    private boolean checkToken(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        // 获取session中的用户
        User user = (User) session.getAttribute(SessionUtils.SIGN_IN_USER);
        // 获取请求头里的Access-Token
        String token = httpServletRequest.getHeader(SessionUtils.ACCESS_TOKEN);
        // 若用户登录信息存在且token信息一致，则通过权限验证
        return null != user && token.equals(SessionUtils.getToken(httpServletRequest));
    }

}
