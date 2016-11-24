package com.my.sb.core.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DK on 2016/3/1.
 */
public class SessionUtils {

    public final static String SIGN_IN_USER = "SIGN_IN_USER";
    public static final String ACCESS_TOKEN = "Access-Token";

    public static String getToken(HttpServletRequest httpServletRequest) {
        return CryptoUtils.encryptByMd5(httpServletRequest.getSession().getId());
    }
}
