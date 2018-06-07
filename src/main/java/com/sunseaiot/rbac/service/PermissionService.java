package com.sunseaiot.rbac.service;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Permission;

import java.util.List;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午9:35
 * @modified by:
 */
public interface PermissionService {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(String operation, Integer resourceId);

    Permission selectByPrimaryKey(Integer permissionId);

    List<Permission> selectByRoleId(Integer roleId);

    PageInfo<Permission> selectAll(Integer pageNo, Integer pageSize);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
