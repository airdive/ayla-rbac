package com.sunseaiot.rbac.service;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Resource;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午10:07
 * @modified by:
 */
public interface ResourceService {

    Integer deleteByPrimaryKey(Integer resourceId);

    Integer insert(String name);

    Resource selectByPrimaryKey(Integer resourceId);

    PageInfo<Resource> selectAll(Integer pageNo, Integer pageSize);

    Integer updateByPrimaryKey(Resource record);
}
