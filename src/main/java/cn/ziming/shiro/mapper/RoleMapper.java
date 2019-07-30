package cn.ziming.shiro.mapper;

import cn.ziming.shiro.common.utils.IMapper;
import cn.ziming.shiro.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends IMapper<Role> {
    @Select("SELECT NAME from user_role a, role b where a.ROLE_ID = b.ID and USER_ID = #{uid}")
    List<String> selectNameByUid(Integer uid);
}