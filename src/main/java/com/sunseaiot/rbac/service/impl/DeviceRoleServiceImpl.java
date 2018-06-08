package com.sunseaiot.rbac.service.impl;

import com.sunseaiot.rbac.mapper.DeviceRoleMapper;
import com.sunseaiot.rbac.model.DeviceRole;
import com.sunseaiot.rbac.service.DeviceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/8 下午6:00
 * @modified by:
 */
@Service
public class DeviceRoleServiceImpl implements DeviceRoleService {
    @Autowired
    private DeviceRoleMapper deviceRoleMapper;

    @Override
    public int deleteByDsnAndRole(String dsn, Integer roleId) {
        return deviceRoleMapper.deleteByDsnAndRole(dsn, roleId);
    }

    @Override
    public int insert(DeviceRole record) {
        return deviceRoleMapper.insert(record);
    }
}
