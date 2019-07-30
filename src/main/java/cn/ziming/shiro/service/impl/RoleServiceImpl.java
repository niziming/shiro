package cn.ziming.shiro.service.impl;

import cn.ziming.shiro.mapper.RoleMapper;
import cn.ziming.shiro.model.Role;
import cn.ziming.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<String> selectNameByUid(Integer uid) {
        List<String> strings = roleMapper.selectNameByUid(uid);
        return strings;
    }
}
