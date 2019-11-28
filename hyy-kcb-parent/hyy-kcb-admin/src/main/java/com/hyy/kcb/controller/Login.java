package com.hyy.kcb.controller;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.out.WebResout;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "login/1.0/admin/")
public class Login extends ApiBaseController {
    @PostMapping(value = "login")
    @ResponseBody
    public WebResout login(HttpServletRequest request){

        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        System.out.println(token);
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            return fail(request, ConstantEnum._WEB_NOT_LOGIN_ERROR.getVal(), "密码错误");
        } catch (LockedAccountException e) {
            return fail(request, ConstantEnum._WEB_NOT_LOGIN_ERROR.getVal(), "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return fail(request, ConstantEnum._WEB_NOT_LOGIN_ERROR.getVal(), "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return fail(request,ConstantEnum._TOKEN_OUT_TIME_VAL.getVal(),"token过期");
        }
        return success(request,"",subject.getSession().getId());
    }
    /**
     *  shiro未登录
     * @param request
     * @return
     */
    @GetMapping(value="/unauth")
    @ResponseBody
    public WebResout getInfo(HttpServletRequest request) {
        System.out.println("-------unauth--------");
        return fail(request, ConstantEnum._WEB_NOT_LOGIN.getVal(), ConstantEnum._WEB_NOT_LOGIN.getDesc());
    }


    /**
     *  shiro权限测试
     * @param request
     * @return
     */
    @GetMapping(value="/auth")
    @ResponseBody
    @RequiresPermissions("user:list")
    public WebResout authTest(HttpServletRequest request) {
        System.out.println("-------unauth--------");
        return fail(request, ConstantEnum._WEB_NOT_LOGIN.getVal(), ConstantEnum._WEB_NOT_LOGIN.getDesc());
    }

}
