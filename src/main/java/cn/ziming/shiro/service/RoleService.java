package cn.ziming.shiro.service;

import java.util.List;

public interface RoleService {
    List<String> selectNameByUid(Integer uid);
}
