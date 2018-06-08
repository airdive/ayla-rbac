package com.sunseaiot.rbac.service;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Device;

import java.util.List;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午9:31
 * @modified by:
 */
public interface DeviceService {

    int deleteByDsn(String dsn);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByDsn(String dsn);

    PageInfo<Device> selectAll(Integer pageNo, Integer pageSize);

    int updateByDsnSelective(Device record);

    int updateByDsn(Device record);

}
