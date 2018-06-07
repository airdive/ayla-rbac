package com.sunseaiot.rbac.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/6 下午4:13
 * @modified by:
 */
@Setter
@Getter
@NoArgsConstructor
public class ResponseData<T> {
    private String code;

    private String message;

    private T data;

    public ResponseData(String code,String message){
        this.code=code;
        this.message=message;
    }
}
