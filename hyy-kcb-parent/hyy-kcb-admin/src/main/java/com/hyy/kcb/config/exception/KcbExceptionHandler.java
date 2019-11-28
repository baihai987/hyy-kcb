package com.hyy.kcb.config.exception;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.commons.controller.BaseController;
import com.hyy.kcb.commons.exception.MethodException;
import com.hyy.kcb.commons.exception.TokenException;
import com.hyy.kcb.out.WebResout;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KcbExceptionHandler extends BaseController {
    @ExceptionHandler({TokenException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout processBizException(TokenException e) {
        return fail_exp(e.getExpCode(), e.getExpMsg());
    }

    @ExceptionHandler({MethodException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout methodException(MethodException e) {
        return fail_exp(e.getExpCode(), e.getExpMsg());
    }

    //shiro 授权
    @ExceptionHandler({ UnauthorizedException.class })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout processBizException(UnauthorizedException e) {
        logger.error(e.toString());
        return fail_exp(ConstantEnum._WEB_NOT_AUTH_ERROR.getVal(), ConstantEnum._WEB_NOT_AUTH_ERROR.getDesc());
    }

}
