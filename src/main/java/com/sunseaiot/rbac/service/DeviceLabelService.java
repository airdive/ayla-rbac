package com.sunseaiot.rbac.service;

import com.sunseaiot.rbac.model.DeviceLabel;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午9:26
 * @modified by:
 */
public interface DeviceLabelService {

    int deleteByDsnAndLabel(String dsn, Integer labelId);

    int insert(DeviceLabel record);

}
