package com.sunseaiot.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.mapper.PermissionMapper;
import com.sunseaiot.rbac.mapper.ResourceMapper;
import com.sunseaiot.rbac.model.Permission;
import com.sunseaiot.rbac.model.Resource;
import com.sunseaiot.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description : 许可服务类
 * @author: liuchuang
 * @date: 2018/6/6 上午11:24
 * @modified by:
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int deleteByPrimaryKey(Integer permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public int insert(String operation, Integer resourceId) {
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null){return 0;}
        return permissionMapper.insert(operation, resourceId);
    }

    @Override
    public Permission selectByPrimaryKey(Integer permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public List<Permission> selectByRoleId(Integer roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    @Override
    public PageInfo<Permission> selectAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Permission> list = permissionMapper.selectAll();
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }
}
