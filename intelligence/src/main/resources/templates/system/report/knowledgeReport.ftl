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
    <title>知识提取</title>

    <#include "../common/common.ftl"/>

    <!--离线地图-->
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/map_load.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/offlinemap/css/map.css"/>
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/tools/CurveLine.min.js"></script>
    <style>
        .tab-content {
            width: 100%;
            height: 750px;
        }
        .price-area{
            margin: 0;
        }</style>
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
                    <h4>知识提取</h4>

                    <ul class="nav nav-tabs">
                        <li><a href="#tab1" data-toggle="tab" class="active">目标活动规律</a></li>
                        <li><a href="#tab2" data-toggle="tab">装备威力规律</a></li>
                        <li><a href="#tab3" data-toggle="tab">航行规律</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade active show" id="tab1">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">机舰名</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="jjm" type="text" class="input form-control" placeholder="机舰名" >
                                </div>
                                <div class="col-lg-2 wrapper">地理范围</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="gpsRange" type="text" class="input form-control" placeholder="经度1,纬度1;经度2,纬度2" >
                                </div>
                                <div class="col-lg-2 wrapper">起止时间</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="startTime" type="text" class="input form-control" placeholder="开始时间">
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <input id="endTime" type="text" class="input form-control" placeholder="结束时间">
                                </div>
                                <div class="col-lg-24 wrapper">
                                    <button id="query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="map" style="margin-top:30px;"></div>
                        </div>
                        <div class="tab-pane fade" id="tab2">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">平台编号</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control" id="powerlaw_ptbh" placeholder="平台编号">
                                </div>
                                <div class="col-lg-2 wrapper">平台名称</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control" id="powerlaw_ptmc" placeholder="平台名称">
                                </div>
                                <div class="col-lg-2 wrapper">传感器编号</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control" id="powerlaw_cgqbh" placeholder="传感器编号">
                                </div>

                                <div class="col-lg-24 wrapper">
                                    <button id="powerlaw_query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="powerlaw_chart" style="width:980px;height:600px"></div>
                        </div>
                        <div class="tab-pane fade" id="tab3">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">区域选择</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="aisGpsRange" type="text" class="input form-control" placeholder="经度1,纬度1;经度2,纬度2" >
                                </div>
                                <div class="col-lg-2 wrapper">
                                    <button id="aisQuery" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="aisMap" style="margin-top:30px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End price Area -->
<script src="${base}/static/system/js/report/knowledgeReport.js"></script>
</body>
</html>