package com.sunseaiot.rbac.service.impl;

import com.sunseaiot.rbac.mapper.DeviceLabelMapper;
import com.sunseaiot.rbac.model.DeviceLabel;
import com.sunseaiot.rbac.service.DeviceLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : 设备标签映射服务类
 * @author: liuchuang
 * @date: 2018/6/4 上午9:25
 * @modified by:
 */
@Service
public class DeviceLabelServiceImpl implements DeviceLabelService{
    @Autowired
    private DeviceLabelMapper deviceLabelMapper;

    @Override
    public int deleteByDsnAndLabel(String dsn, Integer labelId) {
        return deviceLabelMapper.deleteByDsnAndLabel(dsn, labelId);
    }

    @Override
    public int insert(DeviceLabel record) {
        return deviceLabelMapper.insert(record);
    }
}
