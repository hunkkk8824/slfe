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

    <div class="hidden-xs" id="toolbar" role="group">
        <input style="width:250px;" name="code" id="code" placeholder="资源编码"
               class="input-sm form-control">



    </div>
    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">

    (function (base) {

        var baseUrl = base + "/dataQuality";

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
                    field: 'qualityStr',
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

                        var btns = [
                            '<button  type="button" class="btn btn-primary btn-sm btn_detail">查看数据</button> ',
                            '<button  type="button" class="btn btn-primary btn-sm btn_log">查看日志</button> ',];

                        //数据质量管理

                        if (menutype == 1) {
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_audit">审核</button>');
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_judge">评定</button>');
                        }
                        else {
                            //交换日志
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_cancelResource">撤销</button>');
                        }

                        return btns.join('');

                    },
                    events: operateEvents
                }]
            });


        }

        $(function () {
            initTable();

        });
    })(base, menutype);
</script>
</body>

</html>
