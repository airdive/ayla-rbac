package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @description : 角色标签
 * @author: liuchuang
 * @date: 2018/5/28 下午5:40
 * @modified by:
 */
@Setter
@Getter
public class RoleLabel {
    private Integer id;

    private String key;

    private String value;

    private String desc;
}
