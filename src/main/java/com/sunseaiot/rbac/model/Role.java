package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description : 角色
 * @author: liuchuang
 * @date: 2018/5/28 下午5:31
 * @modified by:
 */
@Setter
@Getter
public class Role {
    private Integer id;

    private String name;

    private List<Permission> permissions;
}
