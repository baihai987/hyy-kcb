package com.hyy.kcb.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.sys.SysUser;
import com.hyy.kcb.domain.sys.dto.SysUserDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.sys.ISysUserService;


@Controller
@RequestMapping(value = "/sys/sysUser/1.0", method = RequestMethod.POST)
public class SysUserController extends ApiBaseController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping(value = "save")
    @ResponseBody
    public WebResout saveObj(@ModelAttribute SysUser sysUser, HttpServletRequest request) throws BusinessException {

        logger.debug("SysUserController exe saveObj param={}", sysUser);

        int i = sysUserService.insert(sysUser);
        if (i > 0) {
            return success(request);
        }
        return fail(request);
    }

    @GetMapping(value = "listAll")
    @ResponseBody
    public WebResout listAll(HttpServletRequest request) throws BusinessException {
        logger.debug("SysUserController exe listAll ");
        List<SysUser> list = sysUserService.selectAll();
        logger.debug("SysUserController exe listAll out={}", list);
        return success(request, list);
    }

    @GetMapping(value = "getById/{id}")
    @ResponseBody
    public WebResout getById(HttpServletRequest request, @PathVariable int id) throws BusinessException {

        logger.debug("SysUserController exe getById?id={}", id);

        SysUser sysUser = sysUserService.selectById(id);
        if (sysUser == null) {
            return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
        }
        logger.debug("SysUserController exe getById out={} ", sysUser);
        return success(request, sysUser);
    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public WebResout delete(HttpServletRequest request, @PathVariable int id) throws BusinessException {
        logger.debug("SysUserController exe delete?id={}", id);

        SysUser sysUser = sysUserService.selectById(id);
        if (sysUser == null) {
            return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
        }
        sysUserService.deleteById(id);
        logger.debug("SysUserController exe delete?id={}", id);

        return success(request);
    }

    @PutMapping(value = "update")
    @ResponseBody
    public WebResout update(HttpServletRequest request, @ModelAttribute SysUser sysUser) throws BusinessException {

        logger.debug("SysUserController exe update?baseAd={}", sysUser);

        int i = sysUserService.updateObj(sysUser);
        if (i > 0) {
            return success(request);
        }
        return fail(request);
    }

    /**
     * currentPage: 当前页码
     * numPerPage：每页显示条数
     **/
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public WebResout list(HttpServletRequest request, Pager<SysUser> pager,
                          @ModelAttribute SysUserDTO sysUserDto) throws BusinessException {

        logger.debug("SysUserController exe list?pager={}", pager);
        logger.debug("SysUserController exe list?SysUserDto={}", sysUserDto);

        pager.setParams(sysUserDto);
        sysUserService.selectTList(pager);

        logger.debug("SysUserController exe list out={}", pager);

        return success(request, pager);
    }

    /**
     * String[] pw = MD5Util.generatePasswd(sysUser.getPassword(), sysUser.getUserName());
     * 		sysUser.setPassword(pw[0]);
     * 		sysUser.setSalt(pw[1]);
     * 		sysUser.setState("1"); //正常
     * 		sysUser.setCreateUser(super.getUserInfo(request).getId());
     * 		sysUser.setCreateDate(new Date());
     */
}
