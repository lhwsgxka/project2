package com.zhiyou100.dao;

import com.zhiyou100.pojo.Funding;

public interface FundingMapper {
    int deleteByPrimaryKey(Integer fdId);

    int insert(Funding record);

    int insertSelective(Funding record);

    Funding selectByPrimaryKey(Integer fdId);

    int updateByPrimaryKeySelective(Funding record);

    int updateByPrimaryKey(Funding record);
}