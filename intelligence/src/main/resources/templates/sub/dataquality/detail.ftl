<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-数据明细</title>
    <style type="text/css">

    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg">
<div class="example-wrap">

    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">

    var dataSetCode = '${dataSetCode}',
            resourceCode = '${resourceCode}';

    (function (base) {

        var baseUrl = base + "/dataQuality";

        //得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                dataSetCode: dataSetCode,
                resourceCode: resourceCode,

            };
            return temp;
        };


        //根据表名称或列设置
        function getColumnsByDataSetCode(code,callBack) {

            $.get(baseUrl + "/getColumnsByDataSetCode", {
                dataSetCode:code,//表名称
            }, function (data) {

                debugger
                if(callBack){
                    callBack(data);
                }

            });
        }



        function initTable(columns) {

            $('#table').bootstrapTable({
                url: baseUrl + '/getDetail',    //请求后台的URL（*）
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
                pageSize: 15,                      //每页的记录行数（*）
                pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                showRefresh: false,                   //刷新按钮
                columns:columns,
            });

        }

        $(function () {

            getColumnsByDataSetCode(dataSetCode,initTable);

        });
    })(base);
</script>
</body>

</html>
