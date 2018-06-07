package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(String name);

    Role selectBasicInfo(Integer roleId);

    Role selectByName(String name);

    Role selectWithPermission(Integer roleId);

    Role selectDetail(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}