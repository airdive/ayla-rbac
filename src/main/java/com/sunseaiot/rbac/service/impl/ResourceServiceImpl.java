package com.sunseaiot.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.mapper.ResourceMapper;
import com.sunseaiot.rbac.model.Resource;
import com.sunseaiot.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 资源服务类
 * @author: liuchuang
 * @date: 2018/6/6 上午9:19
 * @modified by:
 */
@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Integer deleteByPrimaryKey(Integer resourceId) {
        return resourceMapper.deleteByPrimaryKey(resourceId);
    }

    @Override
    public Integer insert(String name) {
        return resourceMapper.insert(name);
    }

    @Override
    public Resource selectByPrimaryKey(Integer resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public PageInfo<Resource> selectAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Resource> list = resourceMapper.selectAll();
        PageInfo<Resource> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }
}
