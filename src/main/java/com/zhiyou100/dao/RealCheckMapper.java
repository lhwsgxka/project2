package com.zhiyou100.dao;

import com.zhiyou100.pojo.RealCheck;

import java.util.List;

public interface RealCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RealCheck record);

    int insertSelective(RealCheck record);

    RealCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RealCheck record);

    int updateByPrimaryKey(RealCheck record);
//通过页数查询
    List<RealCheck> selectByPage();
}