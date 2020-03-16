package com.theaking.dao;

import com.theaking.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int checkUserName(String username);

    UserInfo selectLogin(@Param("username")String username,@Param("password")String password);
}