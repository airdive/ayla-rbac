package com.sunseaiot.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.sunseaiot.rbac.model.User;
import com.sunseaiot.rbac.model.UserLabel;
import com.sunseaiot.rbac.model.UserRole;
import com.sunseaiot.rbac.model.param.UserParam;
import com.sunseaiot.rbac.model.response.ResponseData;
import com.sunseaiot.rbac.service.UserLabelService;
import com.sunseaiot.rbac.service.UserRoleService;
import com.sunseaiot.rbac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description : 用户控制器
 * @author: liuchuang
 * @date: 2018/5/29 下午4:10
 * @modified by:
 */
@RestController
@RequestMapping("user")
@Api(value = "user", description = "用户相关操作")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserLabelService userLabelService;

    @ApiOperation(value = "创建用户", notes = "创建用户信息", produces = "application/json")
    @ApiImplicitParam(name = "userParam", value = "用户实体对象", required = true, paramType = "body", dataType = "UserParam")
    @PostMapping
    public User create(@RequestBody UserParam userParam){
        userService.createByUserParam(userParam);
        return userService.selectByUsername(userParam.getUsername());
    }

    @ApiOperation(value = "登录", notes = "登录", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("login")
    public ResponseData login(@RequestParam String username, @RequestParam String password){
        User user = userService.verifyUser(username, password);
        return user != null ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "用户列表", notes = "用户列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", defaultValue = "0", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10", paramType = "query", dataType = "Integer")
    })
    @GetMapping("list")
    public PageInfo<User> list(@RequestParam(required = false, defaultValue = "0")Integer pageNo, @RequestParam(required = false, defaultValue = "10")Integer pageSize){
        return userService.selectAll(pageNo, pageSize);
    }

    @ApiOperation(value = "通过email查询用户", notes = "通过email查询用户", produces = "application/json")
    @ApiImplicitParam(name = "email", value = "邮箱", required = true, paramType = "query", dataType = "String")
    @GetMapping("byEmail")
    public User getByEmail(@RequestParam String email){
        return userService.selectByEmail(email);
    }

    @ApiOperation(value = "通过phone查询用户", notes = "通过phone查询用户", produces = "application/json")
    @ApiImplicitParam(name = "phone", value = "手机号码", required = true, paramType = "query", dataType = "String")
    @GetMapping("byPhone")
    public User getByPhone(@RequestParam String phone){
        return userService.selectByPhone(phone);
    }

    @ApiOperation(value = "通过roleId查询用户", notes = "通过roleId查询用户", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    @GetMapping("byRoleId")
    public List<User> getByRole(@RequestParam Integer roleId){

        return null;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户信息", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, paramType = "body", dataType = "User")
    @PutMapping("modify")
    public ResponseData modify(@RequestBody User user){
        int count = userService.updateByPrimaryKeySelective(user);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("passowrd")
    public ResponseData modifyPasswd(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword){
        User user = userService.verifyUser(username,oldPassword);
        int count = 0;
        if (user != null){
            count = userService.updatePasswordByUsername(username,oldPassword);
        }
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "关联角色", notes = "用户关联角色", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("assign_role")
    public ResponseData assignRole(@RequestParam Integer userId, @RequestParam Integer roleId){
        int count = userRoleService.insert(new UserRole(userId,roleId));
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "解关联角色", notes = "用户解关联角色", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("revoke_role")
    public ResponseData revokeRole(@RequestParam Integer userId, @RequestParam Integer roleId){
        int count = userRoleService.deleteByUserAndRole(userId, roleId);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiImplicitParam(name = "labelId", value = "角色标签Id", required = true, paramType = "query", dataType = "String")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "labelId", value = "角色标签Id", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("assign_role_label")
    public ResponseData assignLabel(@RequestParam Integer userId, @RequestParam Integer labelId){
        int count = userLabelService.insert(new UserLabel(userId,labelId));
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "解关联角色标签", notes = "用户解关联角色标签", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "labelId", value = "角色标签Id", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("revoke_role_label")
    public ResponseData revokeRoleLabel(@RequestParam Integer userId, @RequestParam Integer labelId){
        int count = userLabelService.deleteByUserAndLabel(userId,labelId);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

    @ApiOperation(value = "删除用户", notes = "删除id对应的用户", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("{id}")
    public ResponseData delete(@PathVariable Integer id){
        int count = userService.deleteByPrimaryKey(id);
        return count != 0 ? new ResponseData("200","success") : new ResponseData("400","fail");
    }

}
