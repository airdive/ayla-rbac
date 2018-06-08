package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.DeviceRole;
import org.springframework.stereotype.Component;

@Component
public interface DeviceRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByDsnAndRole(String dsn, Integer roleId);

    int insert(DeviceRole record);

    DeviceRole selectByPrimaryKey(Integer id);

    DeviceRole selectByDsnAndRole(String dsn, Integer roleId);

    int updateByPrimaryKeySelective(DeviceRole record);

    int updateByPrimaryKey(DeviceRole record);
}