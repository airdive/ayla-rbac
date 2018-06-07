package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}