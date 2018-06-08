package com.sunseaiot.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.mapper.DeviceMapper;
import com.sunseaiot.rbac.model.Device;
import com.sunseaiot.rbac.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description :
 * @author: liuchuang
 * @date: 2018/6/8 下午3:15
 * @modified by:
 */
@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public int deleteByDsn(String dsn) {
        return deviceMapper.deleteByPrimaryKey(dsn);
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public int insertSelective(Device record) {
        return deviceMapper.insertSelective(record);
    }

    @Override
    public Device selectByDsn(String dsn) {
        return deviceMapper.selectByDsn(dsn);
    }

    @Override
    public PageInfo<Device> selectAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Device> list = deviceMapper.selectAll();
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int updateByDsnSelective(Device record) {
        return 0;
    }

    @Override
    public int updateByDsn(Device record) {
        return 0;
    }
}
