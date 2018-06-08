package com.sunseaiot.rbac.service.impl;

import com.sunseaiot.rbac.mapper.UserLabelMapper;
import com.sunseaiot.rbac.model.UserLabel;
import com.sunseaiot.rbac.service.UserLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/8 下午1:44
 * @modified by:
 */
@Service
public class UserLabelServiceImpl implements UserLabelService{
    @Autowired
    private UserLabelMapper userLabelMapper;

    @Override
    public int deleteByUserAndLabel(Integer userId, Integer labelId) {
        return userLabelMapper.deleteByUserAndLabel(userId, labelId);
    }

    @Override
    public int insert(UserLabel record) {
        return userLabelMapper.insert(record);
    }
}
