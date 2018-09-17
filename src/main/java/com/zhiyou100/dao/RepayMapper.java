package com.zhiyou100.dao;

import com.zhiyou100.pojo.Repay;

public interface RepayMapper {
    int deleteByPrimaryKey(Integer ryId);

    int insert(Repay record);

    int insertSelective(Repay record);

    Repay selectByPrimaryKey(Integer ryId);

    int updateByPrimaryKeySelective(Repay record);

    int updateByPrimaryKeyWithBLOBs(Repay record);

    int updateByPrimaryKey(Repay record);
}