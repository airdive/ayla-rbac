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
public class UserLabel implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer labelId;

    private static final long serialVersionUID = 1L;

    public UserLabel(Integer userId, Integer labelId){
        this.userId = userId;
        this.labelId = labelId;
    }
}