package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/5 下午12:00
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    private RoleMapper mapper;

    @Test
    public void testSelectByPrimaryKey(){
        Role role = mapper.selectBasicInfo(1);
        System.out.println(role);
    }

    @Test
    public void testSelectWithPermission(){
        Role role = mapper.selectWithPermission(1);
        System.out.println("role: "+role);
        System.out.println("role -> permissions :"+role.getPermissions());
    }

    @Test
    public void testSelectDetail(){
        Role role = mapper.selectDetail(1);
        System.out.println("role: "+role);
        System.out.println("role -> permissions :"+role.getPermissions());
    }
}
