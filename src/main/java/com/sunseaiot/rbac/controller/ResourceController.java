package com.sunseaiot.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.Resource;
import com.sunseaiot.rbac.model.response.ResponseData;
import com.sunseaiot.rbac.service.ResourceService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description : 资源控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午6:32
 * @modified by:
 */
@RestController
@RequestMapping("resource")
@Api(value = "resource", description = "资源相关操作")
@Slf4j
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "创建资源", notes = "创建资源", produces = "application/json")
    @ApiImplicitParam(name = "name", value = "资源名称", required = true, paramType = "query", dataType = "String")
    @PostMapping
    public ResponseData create(String name){
        log.info(""+name);
        int count = resourceService.insert(name);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "资源列表", notes = "资源列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", defaultValue = "0", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10", paramType = "query", dataType = "Integer")
    })
    @GetMapping("list")
    public PageInfo<Resource> list(@RequestParam(required = false, defaultValue = "0")Integer pageNo,@RequestParam(required = false, defaultValue = "10")Integer pageSize){
        log.info(""+pageNo+", "+pageSize);
        PageInfo<Resource> pageInfo = resourceService.selectAll(pageNo, pageSize);
        log.info("total :"+pageInfo.getTotal()+", "+pageInfo.getList());
        return pageInfo;
    }

    @ApiOperation(value = "获取资源", notes = "获取资源", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("{id}")
    public Resource getById(@PathVariable Integer id){
        return resourceService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "修改资源信息", notes = "修改资源信息", produces = "application/json")
    @ApiImplicitParam(name = "resource", value = "资源实体对象", required = true, paramType = "body", dataType = "Resource")
    @PutMapping("modify")
    public ResponseData modify(Resource resource){
        Integer count = resourceService.updateByPrimaryKey(resource);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "删除资源", notes = "删除资源", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("{id}")
    public ResponseData delete(@PathVariable Integer id){
        Integer count = resourceService.deleteByPrimaryKey(id);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

}
