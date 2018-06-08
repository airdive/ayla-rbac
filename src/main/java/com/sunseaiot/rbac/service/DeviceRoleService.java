package com.sunseaiot.rbac.service;

import com.sunseaiot.rbac.model.DeviceRole;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午9:32
 * @modified by:
 */
public interface DeviceRoleService {

    int deleteByDsnAndRole(String dsn, Integer roleId);

    int insert(DeviceRole record);

}
