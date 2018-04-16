<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-用户管理</title>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div style="margin-left: 2%;margin-top: 2%">

    <form class="form-horizontal m-t" id="userForm" style="margin-left: 15px;margin-right: 15px;margin-top: 5px;">
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>账户：</label>
            <div class="col-sm-8">
                <input id="useraccount" name="useraccount" class="form-control" type="text" placeholder="账户">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>真实名称：</label>
            <div class="col-sm-8">
                <input id="realname" name="realname" class="form-control" placeholder="真实名称" type="text" maxlength="18">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>手机号：</label>
            <div class="col-sm-8">
                <input id="cellphone" name="cellphone" placeholder="手机号" class="form-control" type="text">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>昵称：</label>
            <div class="col-sm-8">
                <input id="nickname" name="nickname" class="form-control" placeholder="昵称" type="text" maxlength="18">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">是否是紧急联系人：</label>
            <div class="col-sm-8">
                <div class="checkbox-inline">
                    <label>
                        <input type="checkbox" name="isemergencycontact" value="1" style="margin-top:5px;">是
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>性别：</label>
            <div class="col-sm-8">
                <div class="radio-inline">
                    <label>
                        <input type="radio" name="gender" value="1" style="margin-top:5px;" checked> 男
                    </label>
                </div>
                <div class="radio-inline">
                    <label>
                        <input type="radio" name="gender" value="2" style="margin-top:5px;">女
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">生日：</label>
            <div class="col-sm-8">
                <input id="birthday" name="birthday" class="form-control" placeholder="生日" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">身份证：</label>
            <div class="col-sm-8">
                <input id="idnumber" name="idnumber" class="form-control" placeholder="身份证" type="text">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>密码：</label>
            <div class="col-sm-8">
                <input id="password" name="password" class="form-control" placeholder="密码" type="password">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>确认密码：</label>
            <div class="col-sm-8">
                <input id="confirm_password" name="confirm_password" placeholder="确认密码" class="form-control"
                       type="password">
                <!--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>!-->
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-4">
                <button class="btn btn-primary" type="submit" id="btn_save">保存</button>
                <button class="btn btn-primary" type="button" id="btn_cancel" style="margin-left:30px;">取消</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${base}/static/js/plugins/form/jquery.form.min.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/messages_zh.min.js"></script>
<script type="text/javascript">
    (function (base) {

        function init() {

            $('#btn_cancel').on('click', function () {
                close();
            });


            laydate.render({
                elem: '#birthday'
            });

            jQuery.validator.addMethod("isPassWord", function (value, element) {
                var regNull = /^\S*$/;
                var length = value.length;
                return this.optional(element) || ( length >= 5 && regNull.test(value));
            }, "密码不能包含空格");


            // 表单验证绑定
            var validator = $("#userForm").validate({
                rules: {
                    useraccount: {
                        required: true,
                    },
                    cellphone: {
                        required: true,
                        isMobile: true,

                    },
                    password: {
                        required: true,
                        minlength: 6,
                        isPassWord: true,
                    },
                    confirm_password: {
                        required: true,
                        minlength: 6,
                        equalTo: "#password"
                    },
                    nickname: {
                        required: true
                    },
                    gender: {
                        required: true
                    }
                    // birthday:{
                    //     required: true
                    // },
                    // idnumber:{
                    //     required: true
                    // }
                },
                messages: {
                    useraccount: {
                        required: "请输入账户",
                    },
                    cellphone: {
                        required: "请输入手机号",
                        isMobile: "请输入正确的手机号码",
                        remote: "手机号已注册"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: $.validator.format("密码不能小于{0}个字符")
                    },
                    confirm_password: {
                        required: "请输入确认密码",
                        minlength: $.validator.format("密码不能小于{0}个字符"),
                        equalTo: "两次输入密码不一致不一致"
                    },
                    nickname: {
                        required: "请输入昵称"
                    },
                    gender: {
                        required: "请输入选择性别"
                    }
                    // birthday:{
                    //     required: "请输入输入生日"
                    // },
                    // idnumber:{
                    //     required: "请输入身份证号码"
                    // }
                },
                submitHandler: function (form) { //不通过回调

                    console.log("验证通过");
                    //var data = $(form).serialize();
                    var $isemergencycontact = null;
                    var $gender = null;
                    var c = document.getElementsByName("isemergencycontact");
                    if (c[0].checked == true) {
                        $isemergencycontact = 1;
                    } else {
                        $isemergencycontact = 0;
                    }
                    var genderList = document.getElementsByName("gender");
                    $.each(genderList, function (inx, obj) {
                        if (obj.checked) {
                            $gender = parseInt(obj.value)
                        }
                    })
                    var data = {
                        useraccount: $("#useraccount").val(),
                        cellphone: $("#cellphone").val(),
                        realname: $("#realname").val(),
                        nickname: $("#nickname").val(),
                        isemergencycontact: $isemergencycontact,
                        gender: $gender,
                        birthday: $("#birthday").val(),
                        idnumber: $("#idnumber").val(),
                        password: $("#password").val(),
                        confirm_password: $("#confirm_password").val(),
                    }
                    layer.load(3);
                    debugger
                    $.ajax({
                        type: 'post',
                        url: base + '/user/save',
                        dataType: 'json',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (res) {
                            layer.closeAll('loading');
                            var msg = res.msg;
                            var code = parseInt(res.code);
                            debugger
                            if (code == 0) {
                                layer.msg("添加成功");
                                pageReload();
                            } else {
                                layer.msg("添加失败");
                            }
                        }, error: function (xhr, status) {
                            layer.closeAll('loading');
                            //提示层
                            layer.msg("系统出现异常！", {icon: 0});
                        }
                    });
                },
                invalidHandler: function (form, validator) {
                    return false;
                }
            });

            validator.resetForm();
            // 移除error样式
            $("#addUserDlg input").removeClass('error');

        };

        // 关闭layer
        var close = function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        };

        // 页面刷新
        var pageReload = function (millisec) {
            var s = 1000;
            if (!millisec) {
                s = millisec;
            }
            setTimeout(function () {
                close();
            }, s);
        };

        // 页面初始化
        $(function () {

            init();
        });

    })(base);
</script>
</body>

</html>
