package com.sunseaiot.rbac.service.impl;

import com.sunseaiot.rbac.mapper.UserRoleMapper;
import com.sunseaiot.rbac.model.UserRole;
import com.sunseaiot.rbac.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/8 上午11:32
 * @modified by:
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByUserAndRole(Integer userId, Integer roleId) {
        return userRoleMapper.deleteByUserAndRole(userId,roleId);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }
}
