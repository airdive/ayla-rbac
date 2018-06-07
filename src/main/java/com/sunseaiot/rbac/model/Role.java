package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description : 角色
 * @author: liuchuang
 * @date: 2018/5/28 下午5:31
 * @modified by:
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Role {
    private Integer roleId;

    private String name;

    private List<Permission> permissions;

    public Role(String name){
        this.name = name;
    }
}
