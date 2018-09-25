package com.zhiyou100.service;

import com.zhiyou100.dao.FundingMapper;
import com.zhiyou100.pojo.Funding;
import com.zhiyou100.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FundingService {
    @Autowired
    FundingMapper fundingMapper;

    public int deleteByPrimaryKey(Integer fdId) {
        return fundingMapper.deleteByPrimaryKey(fdId);
    }

    public int insert(Funding record) {
        return fundingMapper.insert(record);
    }

    public int insertSelective(Funding record) {
        return fundingMapper.insertSelective(record);
    }
//通过项目id查询到用户
    public List<User> selectByUserAndId(int id){

        return fundingMapper.selectByUserAndId(id);
    }
    //通过项目id 和用户id完成查询参与的金币
    public  Funding selectByUidAndPid(int uid,int pid){
        return fundingMapper.selectByUidAndPid(uid,pid);
    }



    public Funding selectByPrimaryKey(Integer fdId) {
        return fundingMapper.selectByPrimaryKey(fdId);
    }

    public int updateByPrimaryKeySelective(Funding record) {
        return fundingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Funding record) {
        return fundingMapper.updateByPrimaryKey(record);
    }
}
