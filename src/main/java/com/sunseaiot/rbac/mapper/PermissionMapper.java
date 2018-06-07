package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(String operation, Integer resourceId);

    Permission selectByPrimaryKey(Integer permissionId);

    List<Permission> selectByRoleId(Integer roleId);

    List<Permission> selectAll();

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}