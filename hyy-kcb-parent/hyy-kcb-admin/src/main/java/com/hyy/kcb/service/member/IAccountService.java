package com.hyy.kcb.service.member;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.member.Account;

import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:用户基础数据管理
 */
public interface IAccountService extends BaseService<Account>{

    Map findOutAndIn(Map<String, Object> map);
}
