package com.sunseaiot.rbac.service.impl;

import com.sunseaiot.rbac.mapper.UserMapper;
import com.sunseaiot.rbac.model.User;
import com.sunseaiot.rbac.model.param.UserParam;
import com.sunseaiot.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/7 下午2:02
 * @modified by:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int createByUserParam(UserParam userParam) {
        return userMapper.insertByUserParam(userParam);
    }

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public User selectByUsername(String uername) {
        return userMapper.selectByUsername(uername);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public Boolean verifyUser(String email, String password) {
        User user = userMapper.verifyUser(email, password);
        return user == null ? false : true;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
