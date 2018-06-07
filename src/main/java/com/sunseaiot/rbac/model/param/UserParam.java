package com.sunseaiot.rbac.model.param;

import lombok.Getter;
import lombok.Setter;

/**
 * @description : 创建用户的参数
 * @author: liuchuang
 * @date: 2018/6/7 上午11:56
 * @modified by:
 */
@Setter
@Getter
public class UserParam {

    private String username;

    private String password;

    private String email;

    private String phone;

    private static final long serialVersionUID = 1L;
}
