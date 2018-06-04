package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description : 用户与角色映射实体
 * @author: liuchuang
 * @date: 2018/5/28 下午5:37
 * @modified by:
 */
@Setter
@Getter
public class UserRole implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

}