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

<#--数据集群组code-->
<input type="hidden" id="hd_dataSetCode" value="">

<div class="ibox " id="exchange" style="width: 260px;float: left;margin-top: 10px;">

    <div id="jstree1">
        <ul>
            <li class="jstree-open">数据集群组
                <ul>
                <#list dataSetCodeEnums as item>

                    <li data-jstree='{"type":"html"}' data-code="${item.getValue()}">${tem.getDisplayName()}</li>
                </#list>

                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="example-wrap" style="width: auto;float: left;">


    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">

    (function (base) {

        var baseUrl = base + "/resourcecatalog";

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
                dataSetCode:$("#hd_dataSetCode").val(),//表名称
            }, function (data) {

                if(callBack){
                    callBack(data);
                }

            });
        }



        function initTable(columns) {

            $('#table').bootstrapTable({
                classes: 'table table-responsive',
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
                height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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

<script type="text/javascript">
    $(document).ready(function () {

        $('#jstree1').jstree({
            'core': {
                'check_callback': true
            },
            'plugins': ['types', 'dnd'],


        }).on("changed.jstree", function (e, d) {

          //  console.log(d.node.data.code);
          $("#hd_dataSetCode").val(d.node.data.code);
        });

    });

</script>
</body>

</html>




<#--<!DOCTYPE html>-->
<#--<html>-->

<#--<head>-->

<#--<#include "../../header.ftl">-->
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
