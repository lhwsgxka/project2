package com.zhiyou100.service;

import com.zhiyou100.dao.RealCheckMapper;
import com.zhiyou100.pojo.RealCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealCheckService {
    @Autowired
    RealCheckMapper realCheckMapper;

    public int deleteByPrimaryKey(Integer usId) {
        return realCheckMapper.deleteByPrimaryKey(usId);
    }

    public int insert(RealCheck record) {
        return realCheckMapper.insert(record);
    }

    public int insertSelective(RealCheck record) {
        return realCheckMapper.insertSelective(record);
    }

    public RealCheck selectByPrimaryKey(Integer usId) {
        return realCheckMapper.selectByPrimaryKey(usId);
    }

    public int updateByPrimaryKeySelective(RealCheck record) {
        return realCheckMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RealCheck record) {
        return realCheckMapper.updateByPrimaryKey(record);
    }

}