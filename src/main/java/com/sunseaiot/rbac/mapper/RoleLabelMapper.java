package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.RoleLabel;

public interface RoleLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleLabel record);

    int insertSelective(RoleLabel record);

    RoleLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleLabel record);

    int updateByPrimaryKey(RoleLabel record);
}