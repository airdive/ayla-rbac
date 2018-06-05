package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description : 设备
 * @author: liuchuang
 * @date: 2018/5/29 上午9:26
 * @modified by:
 */
@Setter
@Getter
@ToString
public class Device {
    private String dsn;

    private String mac;

    private String oemModel;

    private String productName;

    private String templateId;

    private String connectedAt;

    private String key;

    private String hasProperties;

    private String productClass;

    private String conectionStatus;

    private String lat;

    private String lng;

    private List<Role> roles;

    private List<RoleLabel> roleLabels;

    private static final long serialVersionUID = 1L;
}
