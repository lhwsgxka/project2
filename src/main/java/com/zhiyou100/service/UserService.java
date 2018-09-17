package com.zhiyou100.service;

import com.zhiyou100.dao.UserMapper;
import com.zhiyou100.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int deleteByPrimaryKey(Integer usId) {
        return userMapper.deleteByPrimaryKey(usId);
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer usId) {
        return userMapper.selectByPrimaryKey(usId);
    }

    public User selectBySelective(String name, String password) {
        return userMapper.selectBySelective(name, password);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}