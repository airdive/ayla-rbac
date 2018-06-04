package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.Permission;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 许可控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @ApiOperation(value = "创建许可", notes = "operation为许可的操作类型(read/write),resourceId对应资源的Id", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operation", value = "操作类型", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "resourceId", value = "资源Id", required = true, paramType = "query", dataType = "Integer")
    })
    @PostMapping
    public String create(String operation, Integer resourceId){

        return null;
    }

    @ApiOperation(value = "许可列表", notes = "列出所有许可信息", produces = "application/json")
    @GetMapping("list")
    public List<Permission> list(){

        return null;
    }

    @ApiOperation(value = "获取许可信息", notes = "通过许可的ID查询许可信息", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "许可的id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Permission getById(@PathVariable Integer id){

        return null;
    }

    @ApiOperation(value = "修改许可", notes = "修改许可的信息", produces = "application/json")
    @ApiImplicitParam(name = "permission", value = "许可的实体对象", required = true, paramType = "body", dataType = "Permission")
    @PutMapping("modify")
    public String modify(Permission permission){

        return null;
    }

    @ApiOperation(value = "删除许可信息", notes = "通过许可的ID删除许可信息", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "许可的id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return null;
    }

}
