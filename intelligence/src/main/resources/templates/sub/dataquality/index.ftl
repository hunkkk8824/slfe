<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-数据质量管理</title>
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

    <div class="btn-group hidden-xs" id="toolbar" role="group">
        <input style="width:250px;" name="code" id="code" placeholder="资源编码"
               class="input-sm form-control">


    <#--审核状态-->
        <select id="auditStatus" name="auditStatus" class="form-control" style="width:143px;height: 30px">
            <option value="">全部</option>
        <#list auditStatusEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>

            <#--<option value="0">未评定</option>-->
            <#--<option value="1">差</option>-->
            <#--<option value="2">良</option>-->
            <#--<option value="3">优</option>-->

        </select>
    <#--质量评定-->
        <select id="quality" name="quality" class="form-control" style="width:143px;height: 30px">
            <option value="">全部</option>
        <#list qualityEvaluateEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>
            <#--<option value="0">待审核</option>-->
            <#--<option value="1">已审核</option>-->
            <#--<option value="2">已驳回</option>-->


        </select>
        <button id="query" type="button" class="btn btn-sm btn-primary">
            搜索
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

        };

        //得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                code: $('#code').val(),
                quality: $('#quality').val(),
                auditStatus:$("#auditStatus").val(),

            };
            return temp;
        };

        window.operateEvents = {
        <#--'click .btn_editRoles': function (e, value, row, index) {-->

        <#--layer.open({-->
        <#--type: 2,-->
        <#--title: '权限编辑',-->
        <#--fix: false,-->
        <#--shadeClose: true,-->
        <#--area: ['420px', '540px'],-->
        <#--skin: 'layui-layer-rim', //加上边框-->
        <#--zIndex: 9999,-->
        <#--shift: Math.floor(Math.random() * 6 + 1),-->
        <#--content: ["${base}/role/toEditPermissions?roleId=" + row.roleid, 'no'],-->
        <#--});-->
        <#--},-->};

        function initTable() {
            $('#table').bootstrapTable({
                url: base + '/dataQuality/getList',    //请求后台的URL（*）
                method: 'post',                     //请求方式（*）
                contentType: "application/json",
                toolbarAlign: 'right',               //工具栏对齐方式
                buttonsAlign: 'right',               //按钮对齐方式
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                    //是否启用排序
                sortOrder: "asc",                   //排序方式
                sortName: "id",                  // 排序字段
                queryParams: queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 15,                       //每页的记录行数（*）
                pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                height: 650,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                showRefresh: false,                   //刷新按钮
                columns: [{
                    field: 'code',
                    title: '资源编码'
                }, {
                    field: 'name',
                    title: '资源名称'
                }, {
                    field: 'preImportTotalCount',
                    title: '预导入总数'
                }, {
                    field: 'importSuccessCount',
                    title: '导入成功数'
                }, {
                    field: 'importStatusStr',
                    title: '导入状态'
                }, {
                    field: 'commitUserName',
                    title: '提交人名称'
                }, {
                    field: 'commitTimeStr',
                    title: '提交时间'
                }, {
                    field: 'auditUserName',
                    title: '审核人名称'
                }, {
                    field: 'auditTimeStr',
                    title: '审核时间'
                }, {
                    field: 'auditStatusStr',
                    title: '审核状态'
                }, {
                    field: 'isCancelStr',
                    title: '是否已撤销'
                }, {
                    field: 'quality',
                    title: '质量评定'
                }, {
                    field: 'sourceExchangerCode',
                    title: '来源交换机编码'
                }, {
                    field: 'sourceExchangerName',
                    title: '来源交换机名称'
                }, {
                    field: 'Button',
                    title: '操作',
                    formatter: function (value, row, index) {

                        return [
                            '<button  type="button" class="btn btn-default btn-sm btn_detail">查看</button> ',
                            '<button  type="button" class="btn btn-default btn-sm btn_audit">审核</button> ',
                            '<button  type="button" class="btn btn-default btn-sm btn_judge">评定</button> ',
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
