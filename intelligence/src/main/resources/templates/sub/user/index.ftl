<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-用户管理</title>
    <style type="text/css">
        #toolbar input, button, select {
            float: left;
            margin-top: 10px;
            margin-left: 10px;
            margin-bottom: 10px;
            font-size: 12px;
        }

    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div class="example-wrap">

    <div class="hidden-xs" id="toolbar" role="group">
        <input style="width:250px;" name="keyWordInfo" id="keyWordInfo" placeholder="手机号、登录名、企业名称"
               class="input-sm form-control">
        <select style="width:143px;height: 30px" id="valid" name="valid" class="form-control">
            <option value="">全部</option>
            <option value="1">启用</option>
            <option value="0">禁用</option>
        </select>
        <button id="query" type="button" class="btn btn-sm btn-primary">
            搜索
        </button>
        <button style="margin-left: 10px" id="btn_add" type="button" class="btn btn-sm btn-primary">
            新增
        </button>
    </div>
    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">
    (function (base) {

        //初始化事件
        function initEvent() {
            //2.查询按钮事件
            $('#query').click(function () {
                $('#table').bootstrapTable('refresh', {
                    pageNumber: 1
                });
            })

            //3.重置按钮事件
            $('#clear').click(function () {
                $('#queryForm')[0].reset();
                $("#selectOption").hide();

            });

            $('#btn_add').on('click', function () {
                layer.open({
                    type: 2,
                    title: '新增用户',
                    fix: false,
                    shadeClose: true,
                    area: ['800px', '800px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: base + "/user/toAdd",
                    end: function () {
                        $('#query').trigger('click');
                    }
                });
            });
        };

        //得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                keyword: $('#keyWordInfo').val(),
                valid: $('#valid').val() ? parseInt($('#valid').val()) : null,

            };
            return temp;
        };

        window.operateEvents = {
            'click .btn_editRoles': function (e, value, row, index) {

                layer.open({
                    type: 2,
                    title: '角色编辑',
                    fix: false,
                    shadeClose: true,
                    area: ['420px', '540px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: [base + "/user/toEditRoles?userid=" + row.userid, 'no'],
                });
            },
        };

        function initTable() {
            $('#table').bootstrapTable({
                url: base + '/user/getUserList',    //请求后台的URL（*）
                method: 'post',                     //请求方式（*）
                contentType: "application/json",
                toolbarAlign: 'right',               //工具栏对齐方式
                buttonsAlign: 'right',               //按钮对齐方式
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                    //是否启用排序
                sortOrder: "asc",                   //排序方式
                sortName: "userid",                  // 排序字段
                queryParams: queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 15,                       //每页的记录行数（*）
                pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                height: 650,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                showRefresh: false,                   //刷新按钮
                columns: [{
                    field: 'useraccount',
                    sortable: true,
                    sortOrder: "asc",
                    title: '账号'
                }, {
                    field: 'cellphone',
                    sortable: true,
                    sortOrder: "asc",
                    title: '手机号'
                }, {
                    field: 'organizationname',
                    sortable: true,
                    sortOrder: "asc",
                    title: '组织名称'
                }, {
                    field: 'isemergencycontact',
                    sortable: true,
                    sortOrder: "asc",
                    title: '紧急联系人',
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '是';
                        } else {
                            return '否';
                        }
                    }
                }, {
                    field: 'realname',
                    sortable: true,
                    sortOrder: "asc",
                    title: '真实名称'
                }, {
                    field: 'gender',
                    sortable: true,
                    sortOrder: "asc",
                    title: '性别',
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '男';
                        } else {
                            return '女';
                        }
                    }
                }, {
                    field: 'organizationtype',
                    sortable: true,
                    sortOrder: "asc",
                    title: '账户类型',
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '前端门户';
                        } else if (value == 2) {
                            return '后台管理员';
                        } else {
                            return '其他';
                        }
                    }
                }, {
                    field: 'valid',
                    sortable: true,
                    sortOrder: "asc",
                    title: '状态',
                    formatter: function (value, row, index) {
                        if (value) {
                            return '<span class="label label-success">启用</span>';
                        } else {
                            return '<span class="label label-default">禁用</span>';
                        }
                    }
                }, {
                    field: 'Button',
                    title: '操作',
                    formatter: function (value, row, index) {

                        return [
                            '<button  type="button" class="btn btn-default btn-sm btn_editRoles">角色编辑</button> ',
                        ].join('');
                    },
                    events: operateEvents
                }]
            });


        }

        $(function () {
            initTable();
            initEvent();
        });
    })(base);
</script>
</body>

</html>
