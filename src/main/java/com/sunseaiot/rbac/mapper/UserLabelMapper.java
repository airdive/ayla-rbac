package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.UserLabel;

public interface UserLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLabel record);

    int insertSelective(UserLabel record);

    UserLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLabel record);

    int updateByPrimaryKey(UserLabel record);
}