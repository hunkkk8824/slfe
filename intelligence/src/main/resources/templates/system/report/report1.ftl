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
    <title>装备能力分析</title>

    <#include "../common/common.ftl"/>
    <!--离线地图-->
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/map_load.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/offlinemap/css/map.css"/>

    <style>
        .tab-content {
            width: 100%;
            height: 1050px;
        }
        .price-area{
            margin: 0;
        }

        #map, #tab, #mapfrm {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }

        #menu {
            height: 100%;
            overflow-y: auto
        }

        td {
            font-size: 14px
        }

        h4 {
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
                    <h4>装备能力分析</h4>
                    <div class="tab-content" style="height: 1100px">
                        <div class="tab-pane fade active show" id="tab1">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">统计类型</div>
                                <div class="col-lg-4 wrapper">
                                    <select name="" id="searchType" class="default-select">
                                        <option value="cgqbh">传感器编号</option>
                                        <option value="ptbh">平台编号（平台名称）</option>
                                        <option value="ptlx">平台类型</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 wrapper">统计值</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" id="searchValue" class="input form-control">
                                </div>
                                <div class="col-lg-2 wrapper">数据源</div>
                                <div class="col-lg-4 wrapper">
                                    <#--<input type="text" class="input form-control">-->
                                    <select name="" id="dataSetCode" class="default-select">
                                        <option value="qb_sj_dptdzzmb">多平台电子战目标</option>
                                        <option value="qb_sj_dptssmb">多平台水声目标</option>
                                        <option value="qb_sj_jztsmb">技侦态势目标</option>
                                        <option value="qb_sj_rgmb">人工目标</option>
                                        <option value="qb_sj_ysdzzdzzcmb">电子战电子侦察目标</option>
                                        <option value="qb_sj_ysdzzjgmb">原始电子战激光目标</option>
                                        <option value="qb_sj_ysdzztmmb">原始电子战通信目标</option>
                                        <option value="qb_sj_ysmb">情报数据原始目标</option>
                                    </select>
                                </div>
                                <div class="col-lg-6 wrapper">
                                    <button id="query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>

                            <div>
                                <div class="chart" id="powerlaw_chart" style="float: left;width: 520px;height:400px"></div>
                                <div class="chart" id="map" style="float: left;width: 525px;height: 400px;margin-top: 10px;"></div>

                            </div>

                            <div class="row" style="margin-top: 10px;height: 500px;;clear: both">
                                <div class="col-lg-12">
                                    <table class="table"  id="table" style="height: 300px;"></table>
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

<script src="${base}/static/system/js/report/report1.js"></script>
</body>
</html>