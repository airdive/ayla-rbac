package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description : TODO
 * @author: liuchuang
 * @date: 2018/6/4 下午5:24
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {
    @Autowired
    private PermissionMapper mapper;

    @Test
    public void testSelectByPrimaryKey(){
        Permission per = mapper.selectByPrimaryKey(1);
        System.out.println(per);
    }


}
