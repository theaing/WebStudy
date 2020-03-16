package com.theaking.controller.portal;

import com.theaking.common.Const;
import com.theaking.common.ResponseCode;
import com.theaking.common.ServerResponse;
import com.theaking.pojo.UserInfo;
import com.theaking.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserInfoController {
    @Autowired
    private IUserInfoService iUserInfoService;

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @param session
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> Login(String username, String password, HttpSession session) {
        ServerResponse<UserInfo> login = iUserInfoService.Login(username, password);
        if (login.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, login.getData());
        }
        return login;
    }

    /**
     * 用户退出登陆
     *
     * @param session
     */
    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<UserInfo> Logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(UserInfo userInfo) {
        return iUserInfoService.register(userInfo);
    }

    @RequestMapping(value = "get_user.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> getUser(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if (userInfo == null) {
            return ServerResponse.createByErrorMsg("用户未登陆，无法获取当前用户信息");
        }
        return ServerResponse.createBySuccess(userInfo);
    }

    @RequestMapping(value = "get_userinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> getUserInfo(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if (userInfo == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆，需要强制登陆,state=10");
        }

        return iUserInfoService.getUserInfo(userInfo.getId());
    }

    @RequestMapping(value = "del_userinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delUserInfo(int id) {
        return iUserInfoService.delUserInfo(id);
    }

    @RequestMapping(value = "update_userinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> update_userinfo(HttpSession session, UserInfo userInfo) {
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("用户未登陆，无法获取当前用户信息");
        }
        userInfo.setId(user.getId());
        ServerResponse<UserInfo> userInfoServerResponse = iUserInfoService.updateUserinfo(userInfo);
        if (userInfoServerResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, userInfoServerResponse.getData());
        }
        return userInfoServerResponse;
    }
}
