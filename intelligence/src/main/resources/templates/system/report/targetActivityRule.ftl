<#assign base= request.contextPath />
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
    <title>目标活动规律</title>

<#include "../common/common.ftl"/>
    <!--离线地图-->
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/map_load.js"></script>
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/tools/Heatmap_min.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/offlinemap/css/map.css"/>
    <style>
        .tab-content {
            width: 100%;
            height: 1050px;
        }
        .price-area{
            margin: 0;
        }
        .table tr{
            height:20px;
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
                    <h4>目标活动规律</h4>
                    <div class="tab-content">
                        <div class="tab-pane fade active show" id="tab1">
                            <div class="select-condition row">

                                <div class="col-lg-2 wrapper">数据源</div>
                                <div class="col-lg-4 wrapper">

                                    <select name="" id="dataSetCode" class="default-select">
                                    <#list dataSetCodeEnums as item>

                                      <option value="${item.getValue()}">${item.getDisplayName()}</option>

                                    </#list>

                                    </select>
                                </div>
                                <div class="col-lg-2 wrapper">机舰名</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" placeholder="机舰名" id="jjm" class="input form-control">
                                </div>
                                <div class="col-lg-2 wrapper">机弦号</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" placeholder="机弦号" id="jxh" class="input form-control">
                                </div>
                                <div class="col-lg-2 wrapper">军民标识</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" placeholder="军民标识" id="jmbz" class="input form-control">
                                </div>



                                <div class="col-lg-2 wrapper">起止时间</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="sbsjStartTime" type="text" class="input form-control" placeholder="上报开始时间">
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <input id="sbsjEndTime" type="text" class="input form-control" placeholder="上报结束时间">
                                </div>



                                <div class="col-lg-6 wrapper">
                                    <button id="query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="map" style="height: 300px;margin-top: 10px;"></div>
                            <div class="row" style="height: 500px;">
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

<script src="${base}/static/system/js/report/targetActivityRule.js"></script>
</body>
</html>