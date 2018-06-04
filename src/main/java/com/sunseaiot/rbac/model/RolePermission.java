package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @description : 角色与许可映射实体
 * @author: liuchuang
 * @date: 2018/5/28 下午5:37
 * @modified by:
 */
@Setter
@Getter
public class RolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}
