package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Device;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMapper {
    int deleteByPrimaryKey(String dsn);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByDsn(String dsn);

    List<Device> selectAll();

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}