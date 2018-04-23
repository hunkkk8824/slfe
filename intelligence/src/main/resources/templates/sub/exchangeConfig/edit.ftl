<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-交换配置</title>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:auto">
<div style="margin-left: 2%;margin-top: 2%">
    <input type="hidden" id="id" name="id" value="${config.id}"/>
    <form class="form-horizontal m-t" id="exchangeForm" style="margin-left: 15px;margin-right: 15px;margin-top: 5px;">
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>交换机名称：</label>
            <div class="col-sm-8">
                <input id="name" name="name" class="form-control" type="text" placeholder="交换机名称" value="${config.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>主机地址：</label>
            <div class="col-sm-8">
                <input id="host" name="host" class="form-control" placeholder="主机地址" type="text" value="${config.host}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>端口：</label>
            <div class="col-sm-8">
                <input id="port" name="port" placeholder="端口" class="form-control" type="text" value="${config.port}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>用户名：</label>
            <div class="col-sm-8">
                <input id="userName" name="userName" placeholder="用户名" class="form-control" type="text" value="${config.userName}">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>密码：</label>
            <div class="col-sm-8">
                <input id="password" name="password" class="form-control" placeholder="密码" type="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-4" style="margin-left: 180px;">
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


            jQuery.validator.addMethod("isPassWord", function (value, element) {
                var regNull = /^\S*$/;
                var length = value.length;
                return this.optional(element) || ( regNull.test(value));
            }, "密码不能包含空格");


            // 表单验证绑定
            var validator = $("#exchangeForm").validate({
                rules: {
                    name: {
                        required: true,
                    },
                    host: {
                        required: true
                    },
                    port: {
                        required: true
                    },
                    userName: {
                        required: true
                    },
                    password: {
                        required: true,
                        isPassWord: true
                    }
                },
                messages: {
                    name: {
                        required: "请输入交换机名称"
                    },
                    host: {
                        required: "请输入主机地址"
                    },
                    port: {
                        required: "请输入端口"
                    },
                    userName: {
                        required: "请输入用户名"
                    },
                    password: {
                        required: "请输入密码"
                    }
                },
                submitHandler: function (form) { //不通过回调
                    console.log("验证通过");
                    var data = {
                        id: $("#id").val(),
                        name: $("#name").val(),
                        host: $("#host").val(),
                        port: $("#port").val(),
                        userName: $("#userName").val(),
                        password: $("#password").val()
                    }
                    layer.load(3);
                    debugger
                    $.ajax({
                        type: 'post',
                        url: base + '/exchangeConfig/update',
                        dataType: 'json',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (res) {
                            layer.closeAll('loading');
                            var msg = res.msg;
                            var code = parseInt(res.code);
                            debugger
                            if (code == 0) {
                                layer.msg("修改成功");
                                pageReload();
                            } else {
                                layer.msg("修改失败");
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
            $("#exchangeForm input").removeClass('error');

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
