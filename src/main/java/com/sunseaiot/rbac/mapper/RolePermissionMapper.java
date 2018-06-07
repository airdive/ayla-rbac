package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.RolePermission;
import org.springframework.stereotype.Component;

@Component
public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}