package com.theaking.dao;

import com.theaking.pojo.Workload;

public interface WorkloadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workload record);

    int insertSelective(Workload record);

    Workload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workload record);

    int updateByPrimaryKey(Workload record);
}