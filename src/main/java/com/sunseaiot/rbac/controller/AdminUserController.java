package com.sunseaiot.rbac.controller;

import com.sunseaiot.rbac.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 管理员用户控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午4:10
 * @modified by:
 */
@RestController
@RequestMapping("admin/user")
@Api(value = "Users : Admin APIs of Users", description = "用户相关操作")
public class AdminUserController {

    @ApiOperation(value = "创建用户", notes = "创建用户信息", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, paramType = "body", dataType = "User")
    @PostMapping
    public String create(User user){

        return null;
    }

    @ApiOperation(value = "登录", notes = "登录", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("login")
    public String login(String username, String password){

        return null;
    }

    @ApiOperation(value = "用户列表", notes = "用户列表", produces = "application/json")
    @GetMapping("list")
    public String list(){

        return null;
    }

    @ApiOperation(value = "通过email查询用户", notes = "通过email查询用户", produces = "application/json")
    @ApiImplicitParam(name = "email", value = "邮箱", required = true, paramType = "query", dataType = "String")
    @GetMapping("byEmail")
    public User getByEmail(String email){

        return null;
    }

    @ApiOperation(value = "通过phone查询用户", notes = "通过phone查询用户", produces = "application/json")
    @ApiImplicitParam(name = "phone", value = "手机号码", required = true, paramType = "query", dataType = "String")
    @GetMapping("byPhone")
    public User getByPhone(String phone){

        return null;
    }

    @ApiOperation(value = "通过roleId查询用户", notes = "通过roleId查询用户", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    @GetMapping("byRoleId")
    public List<User> getByRole(Integer roleId){

        return null;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户信息", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, paramType = "query", dataType = "User")
    @PutMapping("modify")
    public String modify(User user){

        return null;
    }

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("passowrd")
    public String modifyPasswd(Integer userId, String oldPassword, String newPassword){

        return null;
    }

    @ApiOperation(value = "关联角色", notes = "用户关联角色", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    @PutMapping("associate_role")
    public String associateRole(String roleId){

        return null;
    }

    @ApiOperation(value = "解关联角色", notes = "用户解关联角色", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    @PutMapping("disassociate_role")
    public String disassociateRole(String roleId){

        return null;
    }

    @ApiOperation(value = "关联角色标签", notes = "用户关联角色标签", produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签Id", required = true, paramType = "query", dataType = "String")
    @PutMapping("associate_role_label")
    public String associateRoleLabel(String labelId){

        return null;
    }

    @ApiOperation(value = "解关联角色标签", notes = "用户解关联角色标签", produces = "application/json")
    @ApiImplicitParam(name = "labelId", value = "角色标签Id", required = true, paramType = "query", dataType = "String")
    @PutMapping("disassociate_role_label")
    public String disassociateRoleLabel(String labelId){

        return null;
    }

    @ApiOperation(value = "删除用户", notes = "删除id对应的用户", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return null;
    }

}
