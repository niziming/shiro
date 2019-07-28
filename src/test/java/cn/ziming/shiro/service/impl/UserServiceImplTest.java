package cn.ziming.shiro.service.impl;

import cn.ziming.shiro.model.User;
import cn.ziming.shiro.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void select() {
        List<User> select = userService.selectAll();

    }

    @Test
    public void selectOne() {
        User user = new User();
        user.setUsername("ziming");
        user.setPassword("ziming");
        User user1 = userService.selectOne(user);
        System.out.println(user1);
    }

    @Test
    public void quearyUserInfo() {
    }
}