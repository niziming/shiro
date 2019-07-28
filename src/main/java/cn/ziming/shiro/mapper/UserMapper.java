package cn.ziming.shiro.mapper;

import cn.ziming.shiro.common.utils.IMapper;
import cn.ziming.shiro.model.User;

public interface UserMapper extends IMapper<User>{
    // @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    // long countByExample(UserExample example);
    //
    // @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    // int deleteByExample(UserExample example);
    //
    // @Insert({
    //     "insert into user (id, username, ",
    //     "password, role)",
    //     "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
    //     "#{password,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR})"
    // })
    // int insert(User record);
    //
    // @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    // int insertSelective(User record);
    //
    // @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    // @Results({
    //     @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
    //     @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
    //     @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
    //     @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR)
    // })
    // List<User> selectByExample(UserExample example);
    //
    // @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    // int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    //
    // @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    // int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}