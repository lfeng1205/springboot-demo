package com.clfeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clfeng.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qian
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User queryUserByName(String name);
}
