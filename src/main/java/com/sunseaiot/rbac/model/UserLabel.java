package com.sunseaiot.rbac.model;

import java.io.Serializable;

/**
 * @author 
 */
public class UserLabel implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer labelId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}