package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    Role selectWithPermission(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}