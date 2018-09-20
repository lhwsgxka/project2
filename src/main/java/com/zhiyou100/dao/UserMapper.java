package com.zhiyou100.dao;

import com.zhiyou100.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer usId);

    int insert(User record);

    int insertSelective(User record);

    //查询
    User selectByPrimaryKey(Integer usId);

    User selectBySelective(@Param("name") String name, @Param("password")String password);

    //通过用户的id查询得到权限的内同
    List<String> findById(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//通过电话号码查询
    User selectByPhone(String phone);
}