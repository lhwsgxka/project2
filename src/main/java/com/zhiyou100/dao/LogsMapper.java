package com.zhiyou100.dao;

import com.zhiyou100.pojo.Logs;

public interface LogsMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
}