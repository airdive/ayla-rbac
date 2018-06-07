package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.DeviceRole;
import org.springframework.stereotype.Component;

@Component
public interface DeviceRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceRole record);

    int insertSelective(DeviceRole record);

    DeviceRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceRole record);

    int updateByPrimaryKey(DeviceRole record);
}