<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-数据d导入日志</title>
    <style type="text/css">


    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div class="example-wrap">


    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">
    var resourceId='${resourceId}';
    (function (base,resourceId) {

        //得到查询的参数
        function queryParams(params) {

            return {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                resourceId: resourceId,
            };
        };

        function initTable() {
            $('#table').bootstrapTable({
                url: base + '/resourcecatalog/getExportLog',    //请求后台的URL（*）
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
                    field: 'logContent',
                    title: '日志内容'
                }, {
                    field: 'createTimeStr',
                    title: '创建时间'
                },]
            });


        }

        $(function () {
            initTable();
        });
    })(base,resourceId);
</script>
</body>

</html>
