<#assign base= request.contextPath />
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${base}/static/system/img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="colorlib">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>多源情报系统-数据资源目录</title>

<#--<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">-->
    <!--
    CSS
    ============================================= -->
    <link rel="stylesheet" href="${base}/static/system/css/linearicons.css">
    <link rel="stylesheet" href="${base}/static/system/css/font-awesome.min.css">
    <link rel="stylesheet" href="${base}/static/system/css/bootstrap.css">
    <link rel="stylesheet" href="${base}/static/system/css/magnific-popup.css">
    <link rel="stylesheet" href="${base}/static/system/css/jquery-ui.css">
    <link rel="stylesheet" href="${base}/static/system/css/nice-select.css">
    <link rel="stylesheet" href="${base}/static/system/css/animate.min.css">
<#--<link rel="stylesheet" href="http://at.alicdn.com/t/font_205919_gs446lbdhoyr2j4i.css">-->
    <link rel="stylesheet" href="${base}/static/system/css/swiper.min.css">
    <link rel="stylesheet" href="${base}/static/system/css/bootstrap-table.css">
    <link rel="stylesheet" href="${base}/static/system/css/owl.carousel.css">
    <link rel="stylesheet" href="${base}/static/system/css/main.css">
</head>
<style>
    .price-area {
        margin: 0;
    }
</style>
<body>
<#include "../common/header.ftl"/>
<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container">

        <div class="row">
            <div class="col-lg-4">
                <ul class="left-tree" id="left-tree">

                <#list dataSetCodeEnums as item>
                    <li data-name="${item.getDisplayName()}" data-code="${item.getValue()}"
                        class="tree-menu">${item.getDisplayName()}<i class="fa fa-star" aria-hidden="true"></i></i>
                    </li>

                </#list>

                <#--<li class="tree-menu active">动向情报<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_融合目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_人工目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                <#--<li class="tree-menu">情报_数据_多平台电子战目标<i class="fa fa-star" aria-hidden="true"></i></li>-->
                </ul>
            </div>
            <div class="col-lg-8">
                <div class="single-price">
                    <h4>Luxury Packages</h4>

                    <ul class="nav nav-tabs">
                        <li><a href="#tab1" data-toggle="tab" class="active">表结构</a></li>


                        <!--非游客模式显示数据-->
                    <#if touristRoleCount == 0>
                        <li><a href="#tab2" data-toggle="tab">数据</a></li>
                    </#if>

                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade active show touristContent" id="tab1">


                        </div>
                        <div class="tab-pane fade" id="tab2">

                            <#if touristRoleCount == 0>
                                <table id="table" class="table table-hover statics-table"></table>
                            </#if>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End price Area -->


<!-- start footer Area -->
<#include "../common/footer.ftl"/>
<!-- End footer Area -->

<script src="${base}/static/system/js/vendor/jquery-2.2.4.min.js"></script>
<script src="${base}/static/system/js/popper.min.js"></script>
<script src="${base}/static/system/js/vendor/bootstrap.min.js"></script>
<script src="${base}/static/system/js/jquery-ui.js"></script>
<script src="${base}/static/system/js/easing.min.js"></script>
<script src="${base}/static/system/js/swiper.min.js"></script>
<script src="${base}/static/system/js/hoverIntent.js"></script>
<script src="${base}/static/system/js/superfish.min.js"></script>
<script src="${base}/static/system/js/bootstrap-treeview.js"></script>
<script src="${base}/static/system/js/bootstrap-table-zh-CN.js"></script>
<script src="${base}/static/system/js/bootstrap-table.js"></script>
<script src="${base}/static/system/js/jquery.ajaxchimp.min.js"></script>
<script src="${base}/static/system/js/jquery.magnific-popup.min.js"></script>
<script src="${base}/static/system/js/jquery.nice-select.min.js"></script>
<script src="${base}/static/system/js/owl.carousel.min.js"></script>
<script src="${base}/static/system/js/mail-script.js"></script>
<script src="${base}/static/js/plugins/layer/layer.min.js"></script>
<script src="${base}/static/system/js/datamenu.js"></script>

<#--数据集群组code-->
<input type="hidden" id="hd_dataSetCode" value="${defaultdataSetCode}">

</body>


<script type="text/javascript">

    var isTourist = parseInt('${touristRoleCount}') > 0;
    var base = '${base}';
    (function (base, isTourist) {

        var baseUrl = base + "/resourcecatalog";

//得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                dataSetCode: $("#hd_dataSetCode").val(),
            };
            return temp;
        };


//根据表名称或列设置
        function getColumnsByDataSetCode(callBack) {

            if ($("#table").size() == 0) {
                return false;
            }

            layer.load();
            $.get(baseUrl + "/getColumnsByDataSetCode", {
                dataSetCode: $("#hd_dataSetCode").val(),//表名称
            }, function (data) {

                if (callBack) {
                    callBack(data);
                }

            });
        }


        function initTable(columns) {

            $('#table').bootstrapTable("destroy");
            $('#table').bootstrapTable({
                //classes: 'table table-responsive',
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
                height: 850,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                showRefresh: false,                   //刷新按钮
                columns: columns,
                onLoadSuccess: function (data) {
                    layer.closeAll();
                }
            });

        }

        function treeInit() {

            $('#left-tree > .tree-menu').click(function () {

                $('#left-tree > .tree-menu').removeClass('active');
                $(this).addClass('active');

                $("#hd_dataSetCode").val($(this).data("code"));
                initData();
            });


            var dataSetCode = $("#hd_dataSetCode").val();
            $('li[data-code="' + dataSetCode + '"]').trigger('click');
        }

//获取游客模式内容
        function getTouristContent(dataSetCode) {
            $.get(baseUrl + '/getTouristContent', {
                dataSetCode: dataSetCode
            }, function (res) {
                $(".touristContent").html(res.data);
            });
        }

        function initData() {

            getTouristContent($("#hd_dataSetCode").val());
            getColumnsByDataSetCode(initTable);

        }

        $(function () {

            initData();
            treeInit();


        });
    })(base, isTourist);
</script>
</html>

<#--<!DOCTYPE html>-->
<#--<html>-->

<#--<head>-->

<#--<#include "../../head.ftl">-->
<#--<title>多源情报系统-数据资源目录</title>-->
<#--<style type="text/css">-->
<#--#toolbar input, button, select {-->
<#--float: left;-->
<#--margin-top: 10px;-->
<#--margin-left: 10px;-->
<#--margin-bottom: 10px;-->
<#--font-size: 12px;-->
<#--}-->

<#--;-->
<#--</style>-->
<#--</head>-->

<#--<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">-->

<#--&lt;#&ndash;数据集群组code&ndash;&gt;-->
<#--<input type="hidden" id="hd_dataSetCode" value="${defaultdataSetCode}">-->

<#--<div class="ibox " id="exchange" style="width: 18%;height:850px;float: left;background-color:#eae9e7ba">-->


<#--<div id="jstree1">-->
<#--<ul>-->
<#--<li class="jstree-open">数据集群组-->
<#--<ul>-->
<#--<#list dataSetCodeEnums as item>-->

<#--<li data-name="${item.getDisplayName()}"-->
<#--data-code="${item.getValue()}">${item.getDisplayName()}</li>-->
<#--</#list>-->

<#--</ul>-->
<#--</li>-->
<#--</ul>-->
<#--</div>-->
<#--</div>-->
<#--<div class="example-wrap" style="width: 80%;overflow-x:auto;margin-top: 10px;">-->

<#--<!--非游客模式显示数据&ndash;&gt;-->
<#--<#if touristRoleCount == 0>-->
<#--<table id="table" data-mobile-responsive="true">-->

<#--</table>-->
<#--</#if>-->


<#--<div id="touristContent" style="padding-left: 20px"></div>-->
<#--</div>-->


<#--<script type="text/javascript">-->

<#--var isTourist = parseInt('${touristRoleCount}') > 0;-->
<#--(function (base, isTourist) {-->

<#--var baseUrl = base + "/resourcecatalog";-->

<#--//得到查询的参数-->
<#--function queryParams(params) {-->

<#--var temp = {-->
<#--limit: params.limit,    //页面大小-->
<#--offset: params.offset,   //页码-->
<#--dataSetCode: $("#hd_dataSetCode").val(),-->
<#--};-->
<#--return temp;-->
<#--};-->


<#--//根据表名称或列设置-->
<#--function getColumnsByDataSetCode(callBack) {-->

<#--if ($("#table").size() == 0) {-->
<#--return false;-->
<#--}-->

<#--layer.load();-->
<#--$.get(baseUrl + "/getColumnsByDataSetCode", {-->
<#--dataSetCode: $("#hd_dataSetCode").val(),//表名称-->
<#--}, function (data) {-->

<#--if (callBack) {-->
<#--callBack(data);-->
<#--}-->

<#--});-->
<#--}-->


<#--function initTable(columns) {-->

<#--$('#table').bootstrapTable("destroy");-->
<#--$('#table').bootstrapTable({-->
<#--classes: 'table table-responsive',-->
<#--url: baseUrl + '/getDetail',    //请求后台的URL（*）-->
<#--method: 'post',                     //请求方式（*）-->
<#--contentType: "application/json",-->
<#--toolbarAlign: 'right',               //工具栏对齐方式-->
<#--buttonsAlign: 'right',               //按钮对齐方式-->
<#--striped: false,                      //是否显示行间隔色-->
<#--cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）-->
<#--pagination: true,                   //是否显示分页（*）-->
<#--sortable: true,                    //是否启用排序-->
<#--sortOrder: "asc",                   //排序方式-->
<#--sortName: "id",                  // 排序字段-->
<#--queryParams: queryParams,//传递参数（*）-->
<#--sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）-->
<#--pageNumber: 1,                       //初始化加载第一页，默认第一页-->
<#--pageSize: 15,                      //每页的记录行数（*）-->
<#--pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）-->
<#--strictSearch: true,-->
<#--clickToSelect: true,                //是否启用点击选中行-->
<#--height: 850,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度-->
<#--uniqueId: "id",                     //每一行的唯一标识，一般为主键列-->
<#--cardView: false,                    //是否显示详细视图-->
<#--detailView: false,                  //是否显示父子表-->
<#--showRefresh: false,                   //刷新按钮-->
<#--columns: columns,-->
<#--onLoadSuccess: function (data) {-->
<#--layer.closeAll();-->
<#--}-->
<#--});-->

<#--}-->

<#--function jstreeInit() {-->
<#--$('#jstree1').jstree({-->
<#--'core': {-->
<#--'check_callback': true-->
<#--},-->
<#--'plugins': ['types', 'dnd'],-->


<#--}).on("changed.jstree", function (e, d) {-->

<#--//  console.log(d.node.data.code);-->
<#--if (d && d.node && d.node.data && d.node.data.code) {-->
<#--$("#hd_dataSetCode").val(d.node.data.code);-->

<#--initData();-->

<#--}-->

<#--});-->


<#--var dataSetCode = $("#hd_dataSetCode").val();-->
<#--$('li[data-code="' + dataSetCode + '"] a').trigger('click');-->
<#--}-->

<#--//获取游客模式内容-->
<#--function getTouristContent(dataSetCode) {-->
<#--$.get(baseUrl + '/getTouristContent', {-->
<#--dataSetCode: dataSetCode-->
<#--}, function (res) {-->
<#--$("#touristContent").html(res.data);-->
<#--});-->
<#--}-->

<#--function initData() {-->

<#--getTouristContent($("#hd_dataSetCode").val());-->
<#--getColumnsByDataSetCode(initTable);-->
<#--// debugger-->
<#--// //游客模式-->
<#--// if (isTourist) {-->
<#--//     getTouristContent($("#hd_dataSetCode").val());-->
<#--// }-->
<#--// else {-->
<#--//     getColumnsByDataSetCode(initTable);-->
<#--// }-->
<#--}-->

<#--$(function () {-->

<#--initData();-->
<#--jstreeInit();-->


<#--});-->
<#--})(base, isTourist);-->
<#--</script>-->


<#--</body>-->

<#--</html>-->



