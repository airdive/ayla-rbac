package com.sunseaiot.rbac.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description : 许可
 * @author: liuchuang
 * @date: 2018/5/28 下午5:27
 * @modified by:
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(value = {"handler"})  //mybatis的associate使用lazy模式时需要此注解
public class Permission {
    private Integer permissionId;

    private String operation;

    private Resource resources;
}
