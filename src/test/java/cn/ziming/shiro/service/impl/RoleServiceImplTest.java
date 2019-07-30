package cn.ziming.shiro.service.impl;

import cn.ziming.shiro.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {
    @Autowired
    RoleService roleService;
    @Test
    public void selectNameByUid() {
        List<String> strings = roleService.selectNameByUid(1);
        System.out.println(strings);
    }
}