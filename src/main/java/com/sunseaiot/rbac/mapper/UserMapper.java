package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.User;
import com.sunseaiot.rbac.model.param.UserParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int insertByUserParam(UserParam userParam);

    User selectByUserId(Integer userId);

    User selectByUsername(String uername);

    User selectByEmail(String email);

    User selectByPhone(String phone);

    List<User> selectAll();

    User verifyUser(String email, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updatePasswordByUsername(String username,String password);
}