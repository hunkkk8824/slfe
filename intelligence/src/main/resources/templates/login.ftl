<!DOCTYPE html>
<html lang="en">

<head>

    <#include "head.ftl">

    <title>多源情报系统 - 登录</title>

    <link href="${base}/static/css/login.css" rel="stylesheet">

    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[ 多源情报系统 ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>多源情报系统</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明一</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明二</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明三</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明五</li>
                </ul>
                <#--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
            </div>
        </div>
        <div class="col-sm-5">
            <form>
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到多源情报系统</p>
                <input id="username" type="text" class="form-control uname" placeholder="用户名"  />
                <input id="password" type="password" class="form-control pword m-b" placeholder="密码" />
                <a id="a_tourist" href="javascript:void(0)">您可以以游客模式访问</a>
                <button id="ajaxLogin" type="button" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2018 All Rights Reserved. 多源情报系统
        </div>
    </div>
</div>
</body>

<script>


    function login(username,password) {

        $.post("/lo/ajaxLogin", {
            "username": username,
            "password": password
        }, function (result) {
            if (result.status == 200) {
                location.href = "/index";
            } else {
                layer.msg(result.message);
            }
        });
    }
    $("#a_tourist").click(function () {

        login("tourist","123456");
    });

    $("#ajaxLogin").click(function () {

        var username = $("#username").val();
        var password = $("#password").val();
        login(username,password);
    });
</script>
</html>
