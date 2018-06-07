package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.Device;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 管理员设备控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:28
 * @modified by:
 */
@RestController
@RequestMapping("admin/device")
@Api(value = "Devices (Admin)", description = "管理员设备相关操作")
public class AdminDeviceController {

    @ApiOperation(value = "激活设备", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "dsn", value = "设备dsn", required = true, dataType = "String")
    @PutMapping("active")
    public String activeDevice(String dsn){

        return null;
    }

    @ApiOperation(value = "失效设备", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "dsn", value = "设备dsn", required = true, paramType = "query", dataType = "String")
    @PutMapping("invalid")
    public String invalidDevice(String dsn){

        return null;
    }

    @ApiOperation(value = "关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("assign_role")
    public String assignRole(String roleId){

        return null;
    }

    @ApiOperation(value = "解关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("revoke_role")
    public String revokeRole(String roleId){

        return null;
    }

    @ApiOperation(value = "关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("assign_role_label")
    public String assignRoleLabel(String labelId){

        return null;
    }

    @ApiOperation(value = "解关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("revoke_role_label")
    public String revokeRoleLabel(String labelId){

        return null;
    }

}
