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
    //通过id查询权限
    public  List<String> findById(Integer id){
        return userMapper.findById(id);
    }
    //通过电话号码查询
    public User selectByPhone(String phone){
        return userMapper.selectByPhone(phone);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}