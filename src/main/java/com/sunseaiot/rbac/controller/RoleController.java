package com.sunseaiot.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Role;
import com.sunseaiot.rbac.model.param.RoleParam;
import com.sunseaiot.rbac.model.response.ResponseData;
import com.sunseaiot.rbac.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 角色管理
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@RestController
@RequestMapping("role")
@Api(value = "role", description = "角色相关操作")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "创建角色", notes = "创建角色信息", produces = "application/json")
    @ApiImplicitParam(name = "roleParam", value = "角色参数对象", required = true, paramType = "body", dataType = "RoleParam")
    @PostMapping
    public ResponseData create(RoleParam roleParam){
        int count = roleService.insert(roleParam);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "角色列表", notes = "角色列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", defaultValue = "0", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10", paramType = "query", dataType = "Integer")
    })
    @GetMapping("list")
    public PageInfo<Role> list(@RequestParam(required = false, defaultValue = "0")Integer pageNo, @RequestParam(required = false, defaultValue = "10")Integer pageSize){
        return roleService.selectAll(pageNo, pageSize);
    }

    @ApiOperation(value = "获取角色", notes = "通过角色Id获取角色", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Role getById(@PathVariable Integer id){
        return roleService.selectDetail(id);
    }

    @ApiOperation(value = "修改角色名称", notes = "修改角色名称信息", produces = "application/json")
    @ApiImplicitParam(name = "roleName", value = "角色Id", required = true, paramType = "body", dataType = "Role")
    @PutMapping("modifyRoleName")
    public ResponseData modifyRoleName(Role role){
        int count = roleService.updateByPrimaryKey(role);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "删除角色", notes = "删除角色", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public ResponseData delete(@PathVariable Integer id){
        int count = roleService.deleteByPrimaryKey(id);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

}
