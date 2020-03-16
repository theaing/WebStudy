<%--
  Created by IntelliJ IDEA.
  User: liujinwei
  Date: 2020/3/3
  Time: 8:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0051)http://demo1.mycodes.net/denglu/HTML5_yonghudenglu/ -->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>HTML5响应式用户登录界面模板</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" media="screen" href="/resouces/login/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resouces/login/css/reset.css">
<body>

<div id="particles-js">
    <div class="login" style="display: block;">
        <div class="login-top">
            登录
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="/resouces/login/images/name.png"></div>
            <div class="login-center-input">
                <input type="text" name="username" id="username" value="" placeholder="请输入您的用户名"
                       onfocus="this.placeholder=&#39;&#39;" onblur="this.placeholder=&#39;请输入您的用户名&#39;">
                <div class="login-center-input-text">用户名</div>
            </div>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="/resouces/login/images/password.png"></div>
            <div class="login-center-input">
                <input type="password" name="password" id="password" value="" placeholder="请输入您的密码"
                       onfocus="this.placeholder=&#39;&#39;" onblur="this.placeholder=&#39;请输入您的密码&#39;">
                <div class="login-center-input-text">密码</div>
            </div>
        </div>
        <div class="login-button">
            登录
        </div>
    </div>
    <div class="sk-rotating-plane"></div>
    <canvas class="particles-js-canvas-el" width="1147" height="952" style="width: 100%; height: 100%;"></canvas>
</div>

<!-- scripts -->
<script src="/resouces/login/js/particles.min.js"></script>
<script src="/resouces/login/js/app.js"></script>
<script src="/resouces/login/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
    function hasClass(elem, cls) {
        cls = cls || '';
        if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
        return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
    }

    function addClass(ele, cls) {
        if (!hasClass(ele, cls)) {
            ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
        }
    }

    function removeClass(ele, cls) {
        if (hasClass(ele, cls)) {
            var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
            while (newClass.indexOf(' ' + cls + ' ') >= 0) {
                newClass = newClass.replace(' ' + cls + ' ', ' ');
            }
            ele.className = newClass.replace(/^\s+|\s+$/g, '');
        }
    }

    document.querySelector(".login-button").onclick = function () {

        var username = $("#username").val();
        var password = $("#password").val();
        if (username == '' || username == 'undefined') {
            alert("请填写用户名！");
            return;
        }
        if (password == '' || password == 'undefined') {
            alert("请填写密码！");
            return;
        }
        addClass(document.querySelector(".login"), "active")
        addClass(document.querySelector(".sk-rotating-plane"), "active")
        document.querySelector(".login").style.display = "none"
        $.ajax({
            url: '/user/login.do',
            data: {username: username, password: password},
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.status == 0) {
                    //window.location.href = encodeURI('views/main.jsp');
                    //window.parent.location = encodeURI('views/main.jsp');
                    //window.location.href = 'main/index.do'
                    //window.parent.location = 'main/index.do';
                } else {
                    removeClass(document.querySelector(".login"), "active");
                    removeClass(document.querySelector(".sk-rotating-plane"), "active");
                    document.querySelector(".login").style.display = "block";
                    alert(data.msg);
                }
            }
        });
    }
</script>
</body>
</html>
