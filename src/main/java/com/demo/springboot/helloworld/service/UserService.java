package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.User;
import com.demo.springboot.helloworld.common.domain.UserExample;
import com.demo.springboot.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginnameEqualTo(user.getLoginname());
        List<User> users = userMapper.selectByExample(userExample);
        return (users.size()>0?users.get(0):null);

    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public User selectById(int id) {
        User user = userMapper.selectById(id);
        return user;
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
