package cn.ziming.shiro.common.utils;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface IMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T> {

}
