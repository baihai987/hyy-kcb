package com.hyy.kcb.config.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyy.kcb.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.commons.exception.TokenException;

import java.nio.channels.SeekableByteChannel;

public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse response,
                             Object object) {


        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        System.out.println("token---------------"+token);

        String url = httpServletRequest.getRequestURL().toString();
        System.out.println("................................"+url);
        if (url.contains("token/login")
                || url.contains("token/logout")
                || url.contains("login")
                || url.contains("logout")
                || url.contains("/upLoadImagesByNoToken")
                || url.contains("loginSuccess")
                || url.contains("/sockjs-node/info")
                || url.contains("test")
        ) {
            System.out.println("登录登出................................" + url);
            return true;
        }

        if(url.contains("error")) {
            throw new TokenException(ConstantEnum.WEB_SER_ERROR.getVal(),ConstantEnum.WEB_SER_ERROR.getDesc());
        }
        if(url.contains("unauth")) { //未登录
//       	 throw new TokenException(ConstantEnum._WEB_NOT_LOGIN.getVal(),ConstantEnum._WEB_NOT_LOGIN.getDesc());
            return true;
        }

//        if (StringUtils.isEmpty(token)) {
//            logger.info("AuthenticationInterceptor.preHandle  token is null");
//            throw new TokenException(ConstantEnum._TOKEN_FAIL_NULL.getVal(), ConstantEnum._TOKEN_FAIL_NULL.getDesc());
//        }

//        String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
//        System.out.println("取出的token为----------："+ sessionId);
//        if (!sessionId.equals(token)) {
//            logger.info("AuthenticationInterceptor.preHandle  token error");
//            throw new TokenException(ConstantEnum._TOKEN_FAIL_IS_ERROR.getVal(), ConstantEnum._TOKEN_FAIL_IS_ERROR.getDesc());
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) {

    }
}

