package com.sunseaiot.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.mapper.PermissionMapper;
import com.sunseaiot.rbac.mapper.RoleMapper;
import com.sunseaiot.rbac.mapper.RolePermissionMapper;
import com.sunseaiot.rbac.model.Role;
import com.sunseaiot.rbac.model.RolePermission;
import com.sunseaiot.rbac.model.param.RoleParam;
import com.sunseaiot.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/6 下午5:45
 * @modified by:
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(RoleParam roleParam) {
        int count = roleMapper.insert(roleParam.getName());
        Role role = roleMapper.selectByName(roleParam.getName());
        List<Integer> permissionIds = roleParam.getPermissionIds();
        if (permissionIds !=null || permissionIds.size() > 0){
            RolePermission rp = null;
            for (Integer permissionId: permissionIds) {
                if (permissionMapper.selectByPrimaryKey(permissionId) != null){
                    rp = new RolePermission(role.getRoleId(),permissionId);
                    rolePermissionMapper.insert(rp);
                }
            }
        }
        return count;
    }

    @Override
    public Role selectBasicInfo(Integer roleId) {
        return roleMapper.selectBasicInfo(roleId);
    }

    @Override
    public Role selectWithPermission(Integer roleId) {
        return roleMapper.selectWithPermission(roleId);
    }

    @Override
    public Role selectDetail(Integer roleId) {
        return roleMapper.selectDetail(roleId);
    }

    @Override
    public PageInfo<Role> selectAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Role> list = roleMapper.selectAll();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
