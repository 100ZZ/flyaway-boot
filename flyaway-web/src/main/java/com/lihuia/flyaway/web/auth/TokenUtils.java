package com.lihuia.flyaway.web.auth;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:04 AM
 */


public class TokenUtils {


    /**
     * 从请求里捞token字段；先查看header，如果没有的话，再查看参数
     * @param httpRequest
     * @return
     */
    public static String getToken(HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}
