package com.theaking.dao;

import com.theaking.pojo.Proect;

public interface ProectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proect record);

    int insertSelective(Proect record);

    Proect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Proect record);

    int updateByPrimaryKey(Proect record);
}