package com.sunseaiot.rbac.service;

import com.sunseaiot.rbac.model.UserRole;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午11:12
 * @modified by:
 */
public interface UserRoleService {

    int deleteByUserAndRole(Integer userId, Integer roleId);

    int insert(UserRole record);

}
