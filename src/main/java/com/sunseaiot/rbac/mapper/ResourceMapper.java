package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}