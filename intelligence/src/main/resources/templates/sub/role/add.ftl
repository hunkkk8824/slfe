<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-角色管理</title>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div style="margin-left: 3%;">
    <form class="form-horizontal m-t" id="roleForm" style="margin-left: 15px;margin-right: 15px;">

        <!--
        <div class="form-group">
            <label class="col-sm-3 control-label">角色编码：</label>
            <div class="col-sm-8">
                <input id="rolecode" name="rolecode" class="form-control" value="" type="text"
                       placeholder="角色编码" style="width:400px;">
            </div>
        </div>
        !-->
        <div class="form-group">
            <label class="col-sm-3 control-label">角色名称：</label>
            <div class="col-sm-8">
                <input id="rolename" name="rolename" placeholder="角色名称" value="" class="form-control"
                       type="text" style="width:400px;">
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

        // 初始化新增窗口
        function initDlg() {

            $('#btn_cancel').on('click', function () {
                close();
            });


            // 表单验证绑定
            var validator = $("#roleForm").validate({
                rules: {

                    rolename: {
                        required: true
                    },

                },
                messages: {

                    rolename: {
                        required: "请输入角色名称"
                    }


                },
                submitHandler: function (form) { //不通过回调

                    var data = {
                        rolename: $("#rolename").val(),
                    }
                    layer.load(3);
                    $.ajax({
                        type: 'post',
                        url: base + '/role/save',
                        dataType: 'json',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (res) {
                            layer.closeAll('loading');
                            var msg = res.msg;
                            var code = res.code;
                            if (code == '0') {
                                layer.msg(msg, {icon: 1});
                                pageReload();
                            } else {
                                layer.msg(msg, {icon: 0});
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
            $("#addRoleDlg input").removeClass('error');

        };


        // 关闭layer
        function close() {
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

            initDlg()
        });

    })(base);
</script>
</body>

</html>
