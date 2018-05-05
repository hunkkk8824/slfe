<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-数据资源目录</title>
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

<#--前置交换机code-->
<input type="hidden" id="hd_sourceExchangerCode" value="">

<div class="ibox " id="exchange" style="width: 260px;float: left;margin-top: 10px;">

    <div id="jstree1">
        <ul>
            <li class="jstree-open">前置机群组
                <ul>
                    <li data-jstree='{"type":"html"}' data-code="前置机001">前置机001</li>
                    <li data-jstree='{"type":"html"}' data-code="前置机001">前置机002</li>

                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="example-wrap" style="width: auto;float: left;">


    <div class="hidden-xs" id="toolbar" role="group">


    <#--资源编码-->
        <input style="margin-left: 0;width:250px;" name="code" id="code" placeholder="资源编码"
               class="input-sm form-control">

    <#--数据集编码-->
        <select id="dataSetCode" name="dataSetCode" class="form-control" style="width:250px;height: 30px">
            <option value="">全部-数据集编码</option>
        <#list dataSetCodeEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>
        </select>

    <#--审核状态-->
        <select id="auditStatus" name="auditStatus" class="form-control" style="width:143px;height: 30px">
            <option value="">全部-审核状态</option>
        <#list auditStatusEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>

        </select>
    <#--质量评定-->
        <select id="quality" name="quality" class="form-control" style="width:143px;height: 30px">
            <option value="">全部-质量评定</option>
        <#list qualityEvaluateEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>

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

        var baseUrl = base + "/resourcecatalog";

        //初始化事件
        function initEvent() {
            //2.查询按钮事件
            $('#query').click(function () {

                var sourceExchangerCode = $("#hd_sourceExchangerCode").val();
                if (isEmpty(sourceExchangerCode)) {

                    layer.msg("没有选择前置交换机");
                    return;
                }


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
                code: $('#code').val(),//资源编码
                dataSetCode: $('#dataSetCode').val(),//数据集编码
                quality: $('#quality').val(),
                auditStatus: $("#auditStatus").val(),
                sourceExchangerCode: $("#hd_sourceExchangerCode").val(),

            };
            return temp;
        };


        //查看明细
        function openDetail(request) {

            var url = baseUrl + "/toDetail?dataSetCode=" + request.dataSetCode + "&&resourceCode=" + request.resourceCode;

            layer.open({
                type: 2,
                title: '资源详情',
                area: ['1510px', '600px'],
                skin: 'layui-layer-rim', //加上边框
                content: [encodeURI(url)]
            });
        }


        function refreshTable() {
            $('#query').click();
        }


        window.operateEvents = {

            'click .btn_detail': function (e, value, row, index) {

                var request = {
                    dataSetCode: row.datasetCode,
                    resourceCode: row.code,
                };

                openDetail(request);
            },
            'click .btn_log': function (e, value, row, index) {

                layer.open({
                    type: 2,
                    title: '导入日志',
                    fix: false,
                    shadeClose: true,
                    area: ['820px', '740px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: [baseUrl + "/toExportLog?resourceId=" + row.id, 'no'],
                });
            },
        };

        function initTable() {
            $('#table').bootstrapTable({
                url: baseUrl + '/getList',    //请求后台的URL（*）
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
                height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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

                        return btns.join('');

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

<script type="text/javascript">
    $(document).ready(function () {

        $('#jstree1').jstree({
            'core': {
                'check_callback': true
            },
            'plugins': ['types', 'dnd'],


        }).on("changed.jstree", function (e, d) {

          //  console.log(d.node.data.code);
          $("#hd_sourceExchangerCode").val(d.node.data.code);
        });

    });

</script>
</body>

</html>




<#--<!DOCTYPE html>-->
<#--<html>-->

<#--<head>-->

<#--<#include "../../head.ftl">-->
<#--<title>多源情报系统-资源目录首页</title>-->
<#--</head>-->

<#--<body class="gray-bg">-->
<#--<div class="wrapper wrapper-content">-->
<#--<div class="row">-->
<#--<div class="col-sm-3">-->
<#--<div class="ibox float-e-margins">-->
<#--<div class="ibox-content">-->
<#--<div class="file-manager">-->
<#--<h5>前置机</h5>-->
<#--<ul class="folder-list" style="padding: 0">-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201801</a>-->
<#--</li>-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201802</a>-->
<#--</li>-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201803</a>-->
<#--</li>-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201804</a>-->
<#--</li>-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201805</a>-->
<#--</li>-->
<#--<li><a href="javascript:void(0)"><i class="fa fa-server"></i>PC201806</a>-->
<#--</li>-->
<#--</ul>-->

<#--<div class="clearfix"></div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div style="height: 900px;overflow-y: auto" class="col-sm-9 animated fadeInRight">-->
<#--<div class="row">-->
<#--<div class="col-sm-12">-->

<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--原始电子战激光目标表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC2018</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->
<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--融合目标表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC201801</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->

<#--</div>-->

<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--电子战电子侦察目标表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC201801</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->

<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--原始电子战通信目标表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC201801</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->
<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--情报数据原始目标报表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC201801</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->
<#--<div class="file-box">-->
<#--<div class="file">-->
<#--<a href="javascript:void(0);">-->
<#--<span class="corner"></span>-->

<#--<div class="icon">-->
<#--<i class="fa fa-file"></i>-->
<#--</div>-->
<#--<div class="file-name">-->
<#--动向情报表-->
<#--<br/>-->
<#--<small>更新时间：2018-04-13</small>-->
<#--<br/>-->
<#--<small>前置机：PC201801</small>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->

<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->


<#--<script>-->
<#--$(document).ready(function () {-->

<#--$(".file a").click(function () {-->

<#--//iframe层-->
<#--layer.open({-->
<#--type: 2,-->
<#--title: '详情页',-->
<#--shadeClose: true,-->
<#--shade: 0.8,-->
<#--area: ['980px', '90%'],-->
<#--content: '${base}/resourcecatalog/detail'-->
<#--});-->
<#--});-->

<#--});-->
<#--</script>-->

<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->
<#--<!--统计代码，可删除&ndash;&gt;-->

<#--</body>-->

<#--</html>-->
