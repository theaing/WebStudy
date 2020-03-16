package com.theaking.service;

import com.theaking.common.ServerResponse;
import com.theaking.pojo.UserInfo;


public interface IUserInfoService {
    ServerResponse<UserInfo> Login(String username, String password);

    public ServerResponse<String> register(UserInfo userInfo);

    public ServerResponse delUserInfo(int id);

    public ServerResponse<UserInfo> updateUserinfo(UserInfo userInfo);
    public ServerResponse<UserInfo> getUserInfo(int id);
}
