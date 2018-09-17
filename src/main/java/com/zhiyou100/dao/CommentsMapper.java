package com.zhiyou100.dao;

import com.zhiyou100.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer cmId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer cmId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);
}