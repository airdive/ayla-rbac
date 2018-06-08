package com.sunseaiot.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.mapper.UserMapper;
import com.sunseaiot.rbac.model.User;
import com.sunseaiot.rbac.model.param.UserParam;
import com.sunseaiot.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageInfo<User> selectAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public User verifyUser(String email, String password) {
        return userMapper.verifyUser(email, password);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updatePasswordByUsername(String username, String paasword) {
        return userMapper.updatePasswordByUsername(username, paasword);
    }
}
