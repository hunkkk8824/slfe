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

<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <div class="single-price">
                    <h4>报表1</h4>
                    <div class="tab-content">
                        <div class="tab-pane fade active show" id="tab1">
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
                            <div class="chart" id="chart1" style="height: 400px;">chart1</div>
                            <div class="row" style="height: 300px;">
                                <div class="col-lg-12">
                                    <table class="table table-hover statics-table" ></table>
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

<script src="${base}/static/system/js/report.js"></script>
</body>
</html>