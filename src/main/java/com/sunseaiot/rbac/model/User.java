package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description : 用户
 * @author: liuchuang
 * @date: 2018/5/28 下午5:47
 * @modified by:
 */
@Setter
@Getter
@ToString
public class User {
    private Integer userId;

    private Integer parentId;

    private Integer level;

    private String username;

    private String password;

    private String email;

    private String phone;

    private List<Role> roles;

    private Boolean canAssignRoleLabel;

    private List<RoleLabel> roleLabels;

    private String orgId;

    private String createAt;

    private String updateAt;

    private static final long serialVersionUID = 1L;
}
