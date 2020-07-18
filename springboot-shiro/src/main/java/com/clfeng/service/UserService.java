package com.clfeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clfeng.model.User;

public interface UserService extends IService<User> {

    User queryUserByName(String name);
}
