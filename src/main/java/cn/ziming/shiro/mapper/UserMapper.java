package cn.ziming.shiro.mapper;

import cn.ziming.shiro.common.utils.IMapper;
import cn.ziming.shiro.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends IMapper<User> {
    // @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    // long countByExample(UserExample example);
    //
    // @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    // int deleteByExample(UserExample example);
    //
    // @Delete({
    //     "delete from user",
    //     "where id = #{id,jdbcType=INTEGER}"
    // })
    // int deleteByPrimaryKey(Integer id);
    //
    // @Insert({
    //     "insert into user (id, username, ",
    //     "password)",
    //     "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
    //     "#{password,jdbcType=VARCHAR})"
    // })
    // int insert(User record);
    //
    // @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    // int insertSelective(User record);
    //
    // @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    // @Results({
    //     @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    //     @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
    //     @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    // })
    // List<User> selectByExample(UserExample example);
    //
    // @Select({
    //     "select",
    //     "id, username, password",
    //     "from user",
    //     "where id = #{id,jdbcType=INTEGER}"
    // })
    // @Results({
    //     @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    //     @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
    //     @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    // })
    // User selectByPrimaryKey(Integer id);
    //
    // @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    // int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    //
    // @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    // int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    //
    // @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    // int updateByPrimaryKeySelective(User record);
    //
    // @Update({
    //     "update user",
    //     "set username = #{username,jdbcType=VARCHAR},",
    //       "password = #{password,jdbcType=VARCHAR}",
    //     "where id = #{id,jdbcType=INTEGER}"
    // })
    // int updateByPrimaryKey(User record);
    @Select("SELECT PRIVILEGE from user_role a, role_privilege b, privilege c where a.ROLE_ID = b.ROLE_ID and b.PRIVILEGE_ID = c.ID and USER_ID = #{uid}")
    List<String> selectPrivilegeByUid(Integer uid);
}