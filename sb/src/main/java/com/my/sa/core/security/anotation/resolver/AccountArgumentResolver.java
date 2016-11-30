package com.my.sa.core.security.anotation.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.my.sa.core.security.anotation.SignInAccount;
import com.my.sa.core.util.SessionUtils;
import com.my.sa.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(SignInAccount.class);
    }

    @Override
    public User resolveArgument(MethodParameter parameter,
                                ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest
                .getNativeRequest(HttpServletRequest.class);
        HttpSession session = request.getSession();
        return (User) session.getAttribute(SessionUtils.SIGN_IN_USER);
    }

}
