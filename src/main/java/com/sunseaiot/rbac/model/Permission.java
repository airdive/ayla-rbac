package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description : 许可
 * @author: liuchuang
 * @date: 2018/5/28 下午5:27
 * @modified by:
 */
@Setter
@Getter
@ToString
public class Permission {
    private Integer id;

    private String operation;

    private Resource resources;
}
