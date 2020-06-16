package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.User;

public interface UserExtendMapper {

    User selectById(int id);

}
