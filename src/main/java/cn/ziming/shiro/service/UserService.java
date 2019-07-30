package cn.ziming.shiro.service;

import cn.ziming.shiro.model.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    User selectOne(User user);

    User quearyUserInfo(String info);

    List<String> selectPrivilegeByUid(Integer uid);
}
