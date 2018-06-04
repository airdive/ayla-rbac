package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.RoleLabel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description : 角色标签控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:31
 * @modified by:
 */
@Controller
@RequestMapping("label")
public class RoleLabelController {

    @ApiOperation(value = "角色标签列表", notes = "角色标签列表", produces = "application/json")
    @GetMapping("list")
    public List<RoleLabel> list(){

        return null;
    }

    @ApiOperation(value = "获取角色标签", notes = "通过角色标签Id获取角色标签", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path", dataType = "String")
    @GetMapping("{id}")
    public RoleLabel getById(@PathVariable Integer id){

        return null;
    }

    @ApiOperation(value = "删除角色标签", notes = "删除角色标签", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "角色标签Id", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return null;
    }

}
