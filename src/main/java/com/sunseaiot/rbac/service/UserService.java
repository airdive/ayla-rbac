package com.sunseaiot.rbac.service;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.User;
import com.sunseaiot.rbac.model.param.UserParam;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午11:11
 * @modified by:
 */
public interface UserService {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int createByUserParam(UserParam userParam);

    User selectByUserId(Integer userId);

    User selectByUsername(String uername);

    User selectByEmail(String email);

    User selectByPhone(String phone);

    PageInfo<User> selectAll(Integer pageNo, Integer pageSize);

    User verifyUser(String email, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updatePasswordByUsername(String username, String paasword);
}
