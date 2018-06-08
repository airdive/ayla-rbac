package com.sunseaiot.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Device;
import com.sunseaiot.rbac.model.DeviceRole;
import com.sunseaiot.rbac.model.response.ResponseData;
import com.sunseaiot.rbac.service.DeviceRoleService;
import com.sunseaiot.rbac.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 设备控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:28
 * @modified by:
 */
@RestController
@RequestMapping("device")
@Api(value = "/device", description = "设备相关操作")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceRoleService deviceRoleService;

    @ApiOperation(value = "查询设备列表", response = Device.class, responseContainer = "List", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", defaultValue = "0", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10", paramType = "query", dataType = "String")
    })
    @GetMapping("list")
    public PageInfo<Device> deviceList(@RequestParam(required = false, defaultValue = "0")Integer pageNo, @RequestParam(required = false, defaultValue = "10")Integer pageSize){
        return deviceService.selectAll(pageNo, pageSize);
    }

    @ApiOperation(value = "获取设备", response = Device.class, produces = "application/json")
    @ApiImplicitParam(name = "dsn", value = "设备序列号", required = true, paramType = "path", dataType = "String")
    @GetMapping("{dsn}")
    public Device getByDsn(@PathVariable String dsn){
        return deviceService.selectByDsn(dsn);
    }

    @ApiOperation(value = "修改设备信息", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "device", value = "设备", required = true, paramType = "body", dataType = "Device")
    @PostMapping("modify")
    public ResponseData modify(@RequestBody Device device){
        int count = deviceService.updateByDsnSelective(device);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dsn", value = "设备dsn", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("assign_role")
    public String assignRole(@RequestParam String dsn, @RequestParam Integer roleId){
        deviceRoleService.insert(new DeviceRole(dsn,roleId));
        return null;
    }

    @ApiOperation(value = "解关联角色", response = String.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dsn", value = "设备dsn", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("revoke_role")
    public String revokeRole(@RequestParam String dsn, @RequestParam Integer roleId){
        deviceRoleService.deleteByDsnAndRole(dsn,roleId);
        return null;
    }

    @ApiOperation(value = "关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("assign_role_label")
    public String assignRoleLabel(String dsn, String labelId){

        return null;
    }

    @ApiOperation(value = "解关联角色标签", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签ID", required = true, paramType = "query", dataType = "String")
    @PutMapping("revoke_role_label")
    public String revokeRoleLabel(String dsn, String labelId){

        return null;
    }

}
