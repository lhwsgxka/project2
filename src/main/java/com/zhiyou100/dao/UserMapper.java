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

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}