package com.lihuia.flyaway.web.auth;

import com.lihuia.flyaway.common.exception.FlyawayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:03 AM
 */

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    /** 用户必须要穿token，拦截进行权限校验 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = TokenUtils.getToken(request);
        log.info("token: {}", token);
        if (StringUtils.isEmpty(token)) {
            throw new FlyawayException("Token不能为空");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
