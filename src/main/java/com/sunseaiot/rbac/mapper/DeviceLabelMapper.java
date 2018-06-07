package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.DeviceLabel;
import org.springframework.stereotype.Component;

@Component
public interface DeviceLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceLabel record);

    int insertSelective(DeviceLabel record);

    DeviceLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceLabel record);

    int updateByPrimaryKey(DeviceLabel record);
}