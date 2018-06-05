package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 资源控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@Controller
@RequestMapping("resource")
@Api(value = "resource", description = "资源相关操作")
public class ResourceController {

    @ApiOperation(value = "创建资源", notes = "创建资源", produces = "application/json")
    @ApiImplicitParam(name = "name", value = "资源名称", required = true, paramType = "query", dataType = "String")
    @PostMapping
    public String create(String name){

        return null;
    }

    @ApiOperation(value = "资源列表", notes = "资源列表", produces = "application/json")
    @GetMapping("list")
    public List<Resource> list(){

        return null;
    }

    @ApiOperation(value = "获取资源", notes = "获取资源", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Resource getById(@PathVariable Integer id){

        return null;
    }

    @ApiOperation(value = "修改资源信息", notes = "修改资源信息", produces = "application/json")
    @ApiImplicitParam(name = "resource", value = "资源实体对象", required = true, paramType = "body", dataType = "Resource")
    @PutMapping("modify")
    public String modify(Resource resource){

        return null;
    }

    @ApiOperation(value = "删除资源", notes = "删除资源", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return null;
    }

}
