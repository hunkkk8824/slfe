<#assign base= request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>多源情报系统-登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${base}/static/system/login/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/css/util.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/system/login/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form">
					<span class="login100-form-title p-b-34" style="font-size: 22px;">
						用户登录
					</span>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                    <input id="first-name" class="input100" type="text" name="username" placeholder="User name">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                    <input id="password" class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn">
                    <button id="ajaxLogin" class="login100-form-btn" style="font-size: 16px;">
                        登录
                    </button>
                </div>

                <div class="w-full text-center p-t-27 p-b-239">
						<span class="txt1">

						</span>

                <#--<a href="#" class="txt2">-->
                <#--忘记密码-->
                <#--</a>-->
                </div>

                <div class="w-full text-center">
                    <a href="#" class="txt3">
                        Sign Up
                    </a>
                </div>
            </form>

            <div class="login100-more" style="background-image: url('${base}/static/system/login/images/land-bg.jpg');"></div>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/bootstrap/js/popper.js"></script>
<script src="${base}/static/system/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/select2/select2.min.js"></script>
<script>
    $(".selection-2").select2({
        minimumResultsForSearch: 20,
        dropdownParent: $('#dropDownSelect1')
    });
</script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/daterangepicker/moment.min.js"></script>
<script src="${base}/static/system/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="${base}/static/system/login/js/main.js"></script>

</body>

<script type="text/javascript">


    function login(username, password) {

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

    // $("#a_tourist").click(function () {
    //
    //     login("tourist", "123456");
    // });

    $("#ajaxLogin").click(function () {

        var username = $("#first-name").val();
        var password = $("#password").val();
        login(username, password);
    });
</script>
</html>

<#--<!DOCTYPE html>-->
<#--<html lang="en">-->

<#--<head>-->

<#--<#include "head.ftl">-->

<#--<title>多源情报系统 - 登录</title>-->

<#--<link href="${base}/static/css/login.css" rel="stylesheet">-->

<#--<script>-->
<#--if (window.top !== window.self) {-->
<#--window.top.location = window.location;-->
<#--}-->
<#--</script>-->

<#--</head>-->

<#--<body class="signin">-->
<#--<div class="signinpanel">-->
<#--<div class="row">-->
<#--<div class="col-sm-7">-->
<#--<div class="signin-info">-->
<#--<div class="logopanel m-b">-->
<#--<h1>[ 多源情报系统 ]</h1>-->
<#--</div>-->
<#--<div class="m-b"></div>-->
<#--<h4>欢迎使用 <strong>多源情报系统</strong></h4>-->
<#--<ul class="m-b">-->
<#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明一</li>-->
<#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明二</li>-->
<#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明三</li>-->
<#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明四</li>-->
<#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 说明五</li>-->
<#--</ul>-->
<#--&lt;#&ndash;<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>&ndash;&gt;-->
<#--</div>-->
<#--</div>-->
<#--<div class="col-sm-5">-->
<#--<form>-->
<#--<h4 class="no-margins">登录：</h4>-->
<#--<p class="m-t-md">登录到多源情报系统</p>-->
<#--<input id="username" type="text" class="form-control uname" placeholder="用户名"  />-->
<#--<input id="password" type="password" class="form-control pword m-b" placeholder="密码" />-->
<#--<a id="a_tourist" href="javascript:void(0)">您可以以游客模式访问</a>-->
<#--<button id="ajaxLogin" type="button" class="btn btn-success btn-block">登录</button>-->
<#--</form>-->
<#--</div>-->
<#--</div>-->
<#--<div class="signup-footer">-->
<#--<div class="pull-left">-->
<#--&copy; 2018 All Rights Reserved. 多源情报系统-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</body>-->

<#--<script>-->


<#--function login(username,password) {-->

<#--$.post("/lo/ajaxLogin", {-->
<#--"username": username,-->
<#--"password": password-->
<#--}, function (result) {-->
<#--if (result.status == 200) {-->
<#--location.href = "/index";-->
<#--} else {-->
<#--layer.msg(result.message);-->
<#--}-->
<#--});-->
<#--}-->
<#--$("#a_tourist").click(function () {-->

<#--login("tourist","123456");-->
<#--});-->

<#--$("#ajaxLogin").click(function () {-->

<#--var username = $("#username").val();-->
<#--var password = $("#password").val();-->
<#--login(username,password);-->
<#--});-->
<#--</script>-->
<#--</html>-->
