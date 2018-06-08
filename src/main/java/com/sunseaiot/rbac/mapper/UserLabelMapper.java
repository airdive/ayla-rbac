package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.UserLabel;
import org.springframework.stereotype.Component;

@Component
public interface UserLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserAndLabel(Integer userId, Integer labelId);

    int insert(UserLabel record);

    UserLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLabel record);

    int updateByPrimaryKey(UserLabel record);
}