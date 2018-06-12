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
                            <div class="chart" id="map">map</div>
                        </div>
                        <div class="tab-pane fade" id="tab2">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">平台编号</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control" id="ptbh" placeholder="平台编号">
                                </div>
                                <div class="col-lg-2 wrapper">传感器编号</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control" id="cgqbh" placeholder="传感器编号">
                                </div>
                            </div>
                            <div class="chart" id="chart2"></div>
                        </div>
                        <div class="tab-pane fade" id="tab3">
                            <div class="select-condition row">
                                <div class="col-lg-2 wrapper">条件1</div>
                                <div class="col-lg-4 wrapper">
                                    <input type="text" class="input form-control">
                                </div>
                                <div class="col-lg-2 wrapper">条件2</div>
                                <div class="col-lg-4 wrapper">
                                    <div class="confirm-switch">
                                        <input type="checkbox" id="confirm-switch" checked>
                                        <label for="confirm-switch"></label>
                                    </div>
                                    <span>是否打开</span>
                                </div>
                                <div class="col-lg-2 wrapper">条件3</div>
                                <div class="col-lg-4 wrapper">
                                    <select name="" id="" class="default-select">
                                        <option value="">选择1</option>
                                        <option value="">选择2</option>
                                        <option value="">选择3</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 wrapper">条件4</div>
                                <div class="col-lg-4 wrapper">

                                    <div class="confirm-checkbox">
                                        <input type="checkbox" id="confirm-checkbox">
                                        <label for="confirm-checkbox"></label>
                                    </div>
                                    <span>选项1</span>
                                    <div class="confirm-checkbox">
                                        <input type="checkbox" id="confirm-checkbox2">
                                        <label for="confirm-checkbox2"></label>
                                    </div>
                                    <span>选项2</span>
                                    <div class="confirm-checkbox">
                                        <input type="checkbox" id="confirm-checkbox3">
                                        <label for="confirm-checkbox3"></label>
                                    </div>
                                    <span>选项3</span>
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
<script src="${base}/static/system/js/report/knowledgeReport.js"></script>
</body>
</html>