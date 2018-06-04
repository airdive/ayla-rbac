package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.Device;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 设备控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:28
 * @modified by:
 */
@Controller
@RequestMapping("device")
@Api(value = "/device", description = "设备相关操作")
public class DeviceController {

    @ApiOperation(value = "查询设备列表", response = Device.class, responseContainer = "List", produces = "application/json")
    @GetMapping("list")
    public List<Device> deviceList(){

        return null;
    }

    @ApiOperation(value = "获取设备", response = Device.class, produces = "application/json")
    @ApiImplicitParam(name = "dsn", value = "设备序列号", required = true, paramType = "path", dataType = "String")
    @GetMapping("{dsn}")
    public Device getByDsn(@PathVariable String dsn){

        return null;
    }

    @ApiOperation(value = "修改设备信息", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "device", value = "设备", required = true, dataType = "Device")
    @PostMapping("modify")
    public String modify(Device device){

        return null;
    }

    @ApiOperation(value = "关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("associate_role")
    public String associateRole(String roleId){

        return null;
    }

    @ApiOperation(value = "解关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("disassociate_role")
    public String disassociateRole(String roleId){

        return null;
    }

    @ApiOperation(value = "关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("associate_role_label")
    public String associateRoleLabel(String labelId){

        return null;
    }

    @ApiOperation(value = "解关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("disassociate_role_label")
    public String disassociateRoleLabel(String labelId){

        return null;
    }

}
