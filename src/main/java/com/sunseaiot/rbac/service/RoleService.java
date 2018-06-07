package com.sunseaiot.rbac.service;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Role;
import com.sunseaiot.rbac.model.param.RoleParam;

import java.util.List;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午10:08
 * @modified by:
 */
public interface RoleService {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleParam roleParam);

    Role selectBasicInfo(Integer roleId);

    Role selectWithPermission(Integer roleId);

    Role selectDetail(Integer roleId);

    PageInfo<Role> selectAll(Integer pageNo, Integer pageSize);

    int updateByPrimaryKey(Role record);
}
