<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-用户角色</title>
    <style type="text/css">

        #ul {
            font-size: 14px;
            width: 100%;
            height: 100%;
            overflow: auto;
        }

        #ul li {
            padding-left: 40px;
            padding-right: 20px;
            margin: 3px 10px 3px 10px;
            border-radius: 4px;
            list-style-type: none;
        }

        #ul li:hover {
            background-color: #F5F5F5;

        }

        .checkbox input[type=checkbox] {
            margin-top: 8px;
        }

        .roleName {
            padding-left: 8px;
        }
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div style="height: 430px">
<#--<div style="border-bottom: 1px solid #E7EAEC; height: 40px">-->


<#--<div style=" margin-left: 350px; margin-top: -33px">-->
<#--<button id="closeRelateOrg" type="button" class="btn btn-success">搜索</button>-->
<#--</div>-->
<#--</div>-->
    <div style="height: 380px; width: 400px" id="roleList">
        <ul id="ul">
        <#list allRoles as n>
            <li><label><input type="checkbox" name="check" ${n.checked} value="${n.roleid}"><span
                    class="roleName">${n.rolename} </span></label></li>
        </#list>
        </ul>
    </div>
</div>
<div style="text-align: center;">
    <div class="btn-group" role="group">
        <button id="btn_saveRoles" type="button" class="btn btn-success">确认</button>
    </div>
    <div class="btn-group" role="group">
        <button id="btn_cancel" type="button" class="btn btn-default">关闭</button>
    </div>
</div>

<script type="text/javascript">

    var userid = '${userid}';

    (function (base, userid) {

        function getCheckedRoles() {
            var arr = $('#ul input:checked');

            var roles = [];
            $.each(arr, function (i, n) {
                roles.push({
                    roleid: parseInt($(n).val())
                });
            });

            return roles;
        }

        function initEvent() {

            //取消按钮
            $("#btn_cancel").bind("click", function () {
                parent.layer.closeAll()
            });

            //保存按钮
            $("#btn_saveRoles").bind("click", function () {


                var roles = getCheckedRoles();

                if (roles.length == 0) {
                    layer.msg("请选择权限");
                    return;
                }
                debugger
                var index = layer.load(1);
                $.ajax({
                    url:base + '/user/updateRoles',
                    dataType: 'json',
                    method: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({
                        userId: userid,
                        roles: roles,
                    }),
                    success: function (data) {
                        if (data && parseInt(data.code) == 0) {
                            layer.msg("关联角色成功");
                        }
                        else {
                            layer.msg("关联角色失败，请稍后重试。");
                        }
                        setTimeout(function () {
                            layer.close(index);
                            parent.layer.closeAll();
                        }, 1000);
                    }
                });

            })
        }

        $(function () {
            initEvent();
        });
    })(base, userid);
</script>
</body>

</html>
