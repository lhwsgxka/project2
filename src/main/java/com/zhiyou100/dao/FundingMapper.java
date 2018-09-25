package com.zhiyou100.dao;

import com.zhiyou100.pojo.Funding;
import com.zhiyou100.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundingMapper {
    int deleteByPrimaryKey(Integer fdId);

    int insert(Funding record);

    int insertSelective(Funding record);

    Funding selectByPrimaryKey(Integer fdId);

    int updateByPrimaryKeySelective(Funding record);

    int updateByPrimaryKey(Funding record);
//通过项目id查询到参与的用户
    List<User> selectByUserAndId(int id);
    //通过项目id 和用户id完成查询参与的金币
    Funding selectByUidAndPid(@Param("uid") int uid, @Param("pid") int pid);
}