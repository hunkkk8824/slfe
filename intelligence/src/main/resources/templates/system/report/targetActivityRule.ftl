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
                    <h4>装备能力分析</h4>
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
                                <div class="col-lg-2 wrapper">统计类型</div>
                                <div class="col-lg-4 wrapper">
                                    <select name="" id="searchType" class="default-select">
                                        <option value="jjm">机舰名</option>
                                        <option value="jxm">机弦号</option>
                                        <option value="jmbs">军民标识</option>
                                    </select>
                                </div>

                                <div class="col-lg-2 wrapper">起止时间</div>
                                <div class="col-lg-4 wrapper">
                                    <input id="startTime" type="text" class="input form-control" placeholder="开始时间">
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <input id="endTime" type="text" class="input form-control" placeholder="结束时间">
                                </div>



                                <div class="col-lg-6 wrapper">
                                    <button id="query" type="button" class="btn btn-sm btn-primary">
                                        搜索
                                    </button>
                                </div>
                            </div>
                            <div class="chart" id="map" style="height: 400px;">map</div>
                            <div class="row" style="height: 500px;">
                                <div class="col-lg-12">
                                    <table class="table"  id="table" style="height: 400px;"></table>
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