package com.java.dao;

import com.java.base.BaseDao;
import com.java.entity.Test;

public interface TestDao extends BaseDao<Test>{
    int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}