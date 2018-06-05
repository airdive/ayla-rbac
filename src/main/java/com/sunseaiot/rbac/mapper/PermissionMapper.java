package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    List<Permission> selectByRoleId(Integer roleId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}