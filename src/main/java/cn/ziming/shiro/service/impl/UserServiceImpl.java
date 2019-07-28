package cn.ziming.shiro.service.impl;

import cn.ziming.shiro.mapper.UserMapper;
import cn.ziming.shiro.model.User;
import cn.ziming.shiro.model.UserExample;
import cn.ziming.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public User selectOne(User user) {
        User userQueary = userMapper.selectOne(user);
        return userQueary;
    }

    @Override
    public User quearyUserInfo(String info) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(info);

        User user = userMapper.selectOneByExample(userExample);


        return user;
    }

}
