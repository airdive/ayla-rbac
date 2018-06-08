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
public class DeviceLabel implements Serializable {
    private Integer id;

    private String dsn;

    private Integer labelId;

    private static final long serialVersionUID = 1L;

    public DeviceLabel(String dsn, Integer labelId){
        this.dsn = dsn;
        this.labelId = labelId;
    }
}