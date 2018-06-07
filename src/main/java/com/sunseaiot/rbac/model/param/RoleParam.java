package com.sunseaiot.rbac.model.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description : 创建角色的参数
 * @author: liuchuang
 * @date: 2018/6/6 下午6:04
 * @modified by:
 */
@Setter
@Getter
public class RoleParam {
    private String name;

    private List<Integer> permissionIds;
}
