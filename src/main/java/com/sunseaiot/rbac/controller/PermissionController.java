package com.sunseaiot.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Permission;
import com.sunseaiot.rbac.model.response.ResponseData;
import com.sunseaiot.rbac.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 许可控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@RestController
@RequestMapping("permission")
@Api(value = "permission", description = "许可相关操作")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "创建许可", notes = "operation为许可的操作类型(read/write),resourceId对应资源的Id", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operation", value = "操作类型", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "resourceId", value = "资源Id", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping
    public ResponseData create(String operation, Integer resourceId){
        int count = permissionService.insert(operation,resourceId);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "许可列表", notes = "列出所有许可信息", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", defaultValue = "0", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10", paramType = "query", dataType = "String")
    })
    @GetMapping("list")
    public PageInfo<Permission> list(@RequestParam(required = false, defaultValue = "0")Integer pageNo, @RequestParam(required = false, defaultValue = "10")Integer pageSize){
        return permissionService.selectAll(pageNo, pageSize);
    }

    @ApiOperation(value = "获取许可信息", notes = "通过许可的ID查询许可信息", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "许可的id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Permission getById(@PathVariable Integer id){
        return permissionService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "修改许可", notes = "修改许可的信息", produces = "application/json")
    @ApiImplicitParam(name = "permission", value = "许可的实体对象", required = true, paramType = "body", dataType = "Permission")
    @PutMapping("modify")
    public ResponseData modify(Permission permission){
        int count = permissionService.updateByPrimaryKey(permission);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "删除许可信息", notes = "通过许可的ID删除许可信息", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "许可的id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public ResponseData delete(@PathVariable Integer id){
        int count = permissionService.deleteByPrimaryKey(id);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

}
