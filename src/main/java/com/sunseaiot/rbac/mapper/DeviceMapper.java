package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(String dsn);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String dsn);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}