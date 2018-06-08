package com.sunseaiot.rbac.service;

import com.sunseaiot.rbac.model.UserLabel;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 上午11:11
 * @modified by:
 */
public interface UserLabelService {

    int deleteByUserAndLabel(Integer userId, Integer labelId);

    int insert(UserLabel record);

}
