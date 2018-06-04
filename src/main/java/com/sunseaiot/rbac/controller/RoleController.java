package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.Role;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 角色管理
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @ApiOperation(value = "创建角色", notes = "创建角色信息", produces = "application/json")
    @ApiImplicitParam(name = "role", value = "角色实体对象", required = true, paramType = "body", dataType = "Role")
    @PostMapping
    public String create(Role role){

        return null;
    }

    @ApiOperation(value = "角色列表", notes = "角色列表", produces = "application/json")
    @GetMapping("list")
    public List<Role> list(){

        return null;
    }

    @ApiOperation(value = "获取角色", notes = "通过角色Id获取角色", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Role getById(@PathVariable Integer id){

        return null;
    }

    @ApiOperation(value = "修改角色", notes = "修改角色信息", produces = "application/json")
    @ApiImplicitParam(name = "role", value = "角色Id", required = true, paramType = "body", dataType = "Role")
    @PutMapping("modify")
    public String modify(Role role){

        return null;
    }

    @ApiOperation(value = "删除角色", notes = "删除角色", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return null;
    }

}
