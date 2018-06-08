package com.sunseaiot.rbac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class DeviceRole implements Serializable {
    private Integer id;

    private String dsn;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public DeviceRole(String dsn,Integer roleId){
        this.dsn = dsn;
        this.roleId = roleId;
    }
}