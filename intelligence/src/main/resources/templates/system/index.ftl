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
    <title>多源情报系统-首页</title>

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
    .banner-area::after{
        position: absolute;
        display: block;
        top: 0;
        left: 0;
        background-color: rgba(0,0,0,0.2);
        width: 100%;
        height: 100%;
    }
</style>
<body>
<#include "./common/header.ftl"/>
<!-- #header -->
<!-- start banner Area -->
<section class="banner-area" style="width: 100%;">
    <div class="overlay overlay-bg"></div>
    <div class="swiper-container">
        <div class="swiper-wrapper" style="width: 100%;">
            <div class="swiper-slide" id="slide1">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">装备能力分析</h1>
                        <p class="text-white">
                            Aanalysis of equipment capability
                        </p>
                        <a href="${base}/report/report1" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
            <div class="swiper-slide" id="slide2">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">目标活动规律</h1>
                        <p class="text-white">
                            Law of target activity
                        </p>
                        <a href="${base}/report/toTargetActivityRule" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
            <div class="swiper-slide" id="slide3">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">航道提取分析</h1>
                        <p class="text-white">
                            Analysis of channel extraction
                        </p>
                        <a href="${base}/report/aisReport" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
            <div class="swiper-slide" id="slide4">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">目标融合识别</h1>
                        <p class="text-white">
                            Target fusion identification
                        </p>
                        <a href="${base}/report/toTargetFusionRecognition" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
            <div class="swiper-slide" id="slide5">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">知识提取</h1>
                        <p class="text-white">
                            Knowledge extraction
                        </p>
                        <a href="${base}/report/knowledgeReport" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
            <div class="swiper-slide" id="slide6">
                <div style="width: 1000px;margin: 400px auto;">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h1 class="text-white animateWhite">算法</h1>
                        <p class="text-white">
                            arithmetic
                        </p>
                        <a href="${base}/report/arithmetic" class="primary-btn text-uppercase">查看</a>
                    </div>
                    <div class="col-lg-4 col-md-6 banner-right">
                    </div>
                </div>
            </div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>

        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>

        <!-- 如果需要滚动条 -->
        <div class="swiper-scrollbar"></div>
    </div>

</section>


<!-- start footer Area -->
<#include "./common/footer.ftl"/>
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
<script src="${base}/static/system/js/main.js"></script>
<script src="${base}/static/js/plugins/layer/layer.min.js"></script>
</body>

</html>


