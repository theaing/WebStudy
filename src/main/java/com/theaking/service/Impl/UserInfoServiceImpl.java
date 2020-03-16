package com.theaking.service.Impl;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.theaking.common.Const;
import com.theaking.common.ServerResponse;
import com.theaking.dao.UserInfoMapper;
import com.theaking.pojo.UserInfo;
import com.theaking.service.IUserInfoService;
import com.theaking.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ServerResponse<UserInfo> Login(String username, String password) {
        int count = userInfoMapper.checkUserName(username);
        if (count == 0) {
            return ServerResponse.createByErrorMsg("用户名不存在");
        }
        //MD5

        UserInfo userInfo = userInfoMapper.selectLogin(username, MD5Util.MD5EncodeUtf8(password));
        if (userInfo == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }
        userInfo.setPwd(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", userInfo);
    }

    @Override
    public ServerResponse<String> register(UserInfo userInfo) {
        int count = userInfoMapper.checkUserName(userInfo.getName());
        if (count > 0) {
            return ServerResponse.createByErrorMsg("用户名已存在");
        }
        if (StringUtils.isEmpty(userInfo.getRole())){
            userInfo.setRole(Const.Role.ROLE_CUSTOMER);
        }
        userInfo.setPwd(MD5Util.MD5EncodeUtf8(userInfo.getPwd()));
        count = userInfoMapper.insert(userInfo);
        if (count == 0) {
            return ServerResponse.createByErrorMsg("注册失败");
        }
        return ServerResponse.createBySuccessMsg("注册 成功");
    }

    @Override
    public ServerResponse delUserInfo(int id) {
        int count = userInfoMapper.deleteByPrimaryKey(id);
        if (count == 1) {
            return ServerResponse.createBySuccessMsg("删除成功");
        }
        return ServerResponse.createByErrorMsg("删除失败");
    }

    @Override
    public ServerResponse<UserInfo> updateUserinfo(UserInfo userInfo) {
        int count = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        UserInfo user = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        if (count == 1) {
            return ServerResponse.createBySuccess("修改成功", user);
        }
        return ServerResponse.createByError("更新失败", userInfo);
    }

    @Override
    public ServerResponse<UserInfo> getUserInfo(int id) {
        UserInfo user = userInfoMapper.selectByPrimaryKey(id);
        if (user == null) {
            return ServerResponse.createByErrorMsg("获取用户失败");
        }
        return ServerResponse.createBySuccess("获取成功", user);
    }

}
