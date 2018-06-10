<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="colorlib">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>多源情报系统</title>

    <#include "../common/common.ftl"/>

    <style>
        .tab-content {
            width: 100%;
            height: 1050px;
        }
        .price-area{
            margin: 0;
        }
    </style>
</head>
<body>
<#include "../common/header.ftl"/>
<script>
    var _path = '${base}';
</script>
<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <div class="single-price">
                    <h4>航道提取分析</h4>
                    <div class="tab-content">
                        <div class="tab-pane fade active show" id="tab1">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">目标类型</div>
                                <div class="col-lg-4 wrapper">
                                    <select name="" id="shipType" class="default-select">
                                        <option value="3">作业船</option>
                                        <option value="4">高速轮</option>
                                        <option value="5">拖船</option>
                                        <option value="6">客轮</option>
                                        <option value="7">货轮</option>
                                        <option value="8">油轮</option>
                                        <option value="">其他</option>

                                    </select>
                                </div>
                                <div class="col-lg-2 wrapper">地理范围选择</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="gpsRange" type="text" class="input form-control" placeholder="经度1,纬度1;经度2,纬度2" >
                                </div>
                                <div class="col-lg-2 wrapper">开始时间</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="startTime" type="text" class="input form-control">
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <input id="endTime" type="text" class="input form-control">
                                </div>
                                <div class="col-lg-24 wrapper">
                                    <button id="query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="chart1" style="height: 400px;">chart1</div>
                            <div class="row" style="height: 300px;">
                                <div class="col-lg-12">
                                    <table class="table table-responsive"  id="table"></table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End price Area -->

<script src="${base}/static/system/js/report/aisReport.js"></script>
</body>
</html>