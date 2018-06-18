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
    <title>Travel</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
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

    <style>
        .tab-content {
            width: 100%;
            height: 500px;
        }

        .price-area {
            margin: 0;
        }

        .readTextarea {
            width: 100%;
            margin-top: 30px;
            border-radius: 6px;
        }

        .keyword {
            display: inline-block;
            height: 38px;
            vertical-align: top;
            line-height: 38px;
            border: 1px solid #343a40;
            padding: 0 10px;
            border-radius: 6px;
            color: #000;
        }

        .key-input {
            width: 300px;
            display: inline-block;
        }

        .key-input.short {
            width: 100px;
        }

        .video-wrapper {
            background-color: #ccc;
            height: 400px;
            margin: 25px 20px;
            box-sizing: border-box;
        }

        .tab-pane {
            width: 100%;
            height: 100%;
        }

        .img-wrapper {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .img-wrapper img {
            width: 30%;
            height: 30%;
        }

        .select-condition {
            border: none;
        }

        .price-area .single-price {
            border: none;
            background: transparent;
            box-shadow: none;
        }
    </style>
    <script>

    </script>
</head>

<body>
<#include "../common/header.ftl"/>
<!-- #header -->

<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container" style="border: 1px solid #ccc;border-radius: 6px;">

        <div class="row">

            <div class="col-lg-12">
                <div class="single-price">
                    <h4>目标融合识别</h4>

                </div>
            </div>

            <div class="col-lg-4">
                <div class="select-condition row">
                    <div class="col-lg-12" style="margin-top: 20px;">
                        <input type="file" id="fileUpload" style="display:none;">
                        <button type="button" id="btn_txtExport" style="float: right;" class="genric-btn primary">
                            <a href="#">
                                <i class="fa fa-table"></i>
                            </a>文本导入
                        </button>
                    </div>
                    <div class="col-lg-12">
                        <div class="readTextarea" id="txtResult" style=" text-align: left;
    padding: 5px; height: 500px; border: 1px solid #d4bc15;margin-top: 10px;"></div>
                    <#--<textarea class="readTextarea" name="" id="txtResult" cols="30" rows="20" readonly="true">-->
                    <#--这是一段只读的文本框-->
                    <#--</textarea>-->
                    </div>
                    <div class="col-lg-12" style="margin-top: 20px;">
                        <span class="keyword ">关键词</span>
                        <input type="text" id="txtkeyword" class="key-input input form-control short">
                        <button type="button" id="btn_txtShiBie" style="margin-left: 20px;" class="genric-btn info">
                            <a href="#">
                                <i class="fa fa-play"></i>
                            </a>开始识别
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="right-content">
                    <div class="col-lg-12" style="margin-top: 20px;">
                        <select name="" id="" class="default-select key-input">
                            <option value="">选择传感器信息</option>
                            <option value="1">电子侦察</option>
                            <option value="2">激光</option>
                            <option value="3">通讯</option>
                            <option value="4">光电</option>
                        </select>
                    <#--<input type="file" id="imgFileUpload" style="display:none;">-->
                    <#--<button id = "btn_otherExport" type="button" style="margin-left: 20px;" class="genric-btn info">-->
                    <#--<a href="#">-->
                    <#--<i class="fa fa-play"></i>-->
                    <#--</a>上传图片-->
                    <#--</button>-->
                        <button id="btnRongHe" type="button" style="margin-left: 20px;" class="genric-btn info">
                            <a href="#">
                                <i class="fa fa-play"></i>
                            </a>融合识别
                        </button>
                    </div>
                </div>
                <ul class="nav nav-tabs">
                    <li>
                        <a href="#tab1" data-toggle="tab" class="active">图片</a>
                    </li>
                <#--<li>-->
                <#--<a href="#tab2" data-toggle="tab">视频</a>-->
                <#--</li>-->
                <#--<li>-->
                <#--<a href="#tab3" data-toggle="tab">表格</a>-->
                <#--</li>-->
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade active show" id="tab1">
                        <div class="col-lg-12 img-wrapper">
                            <input type="file" id="imgFileUpload1" style="display:none;">
                            <img id="img1" src="${base}/static/system/img/empty.png" alt="">

                            <input type="file" id="imgFileUpload2" style="display:none;">
                            <img id="img2" src="${base}/static/system/img/empty.png" alt="">

                            <input type="file" id="imgFileUpload3" style="display:none;">
                            <img id="img3" src="${base}/static/system/img/empty.png" alt="">
                        </div>
                    </div>
                    <div class="tab-pane fade" id="tab2">
                        <div class="select-condition row">

                            <div class="col-lg-12 wrapper">
                                <div class="video-wrapper">
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="tab3">
                        <table class="table table-hover statics-table"></table>
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
<script src="${base}/static/js/plugins/layer/layer.min.js"></script>

<script type="text/javascript" src="${base}/static/system/js/echarts4.min.js"></script>
<script type="text/javascript" src="${base}/static/system/js/china.js"></script>

<script src="${base}/static/system/js/owl.carousel.min.js"></script>
<script src="${base}/static/system/js/mail-script.js"></script>
<script src="${base}/static/system/js/report/tabpage.js"></script>

<script type="application/javascript">

    $("#btnRongHe").click(function () {
       var keyword=  $("#txtkeyword").val();
       if(keyword==null || keyword==''){
           alert("关键字不允许为空");
       }else if(keyword == '斯坦尼斯'){
           $("#img1").attr("src","/static/system/img/stns_new.png");
       }else{
           alert("该关键字无法识别");
       }

    });

    $("#btn_txtExport").click(function () {

        $("#fileUpload").click();

    });

    $("#img1").click(function () {
        $("#imgFileUpload1").click();
    });

    $("#img2").click(function () {
        $("#imgFileUpload2").click();
    });
    $("#img3").click(function () {
        $("#imgFileUpload3").click();
    });

    function readAsText() {
        debugger
        var file = document.getElementById("fileUpload").files[0];
        var reader = new FileReader();
        //将文件以文本形式读入页面
        reader.readAsText(file, 'gb2312');
        reader.onload = function (f) {

            $("#txtResult").html(this.result);
        }
    }


    $("#btn_txtShiBie").click(function () {
        var txtkeyword = $.trim($("#txtkeyword").val());
        if (txtkeyword == '') {
            layer.msg('请输入关键字');
            return false;
        }

        var content = $("#txtResult").html();
        var values = content.split(txtkeyword);
        $("#txtResult").html(values.join('<span style="background:red;color: white">' + txtkeyword + '</span>'));
    });

    $("#fileUpload").click(function (e) {
        $("#fileUpload").val('');
    });

    $("#fileUpload").change(function (e) {
        readAsText();
    })


    $("#imgFileUpload1").change(function () {
        var file = this.files[0];
        if (window.FileReader) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            //监听文件读取结束后事件
            reader.onloadend = function (e) {
                $("#img1").attr("src", e.target.result);    //e.target.result就是最后的路径地址
            };
        }
    });

    $("#imgFileUpload2").change(function () {
        var file = this.files[0];
        if (window.FileReader) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            //监听文件读取结束后事件
            reader.onloadend = function (e) {
                $("#img2").attr("src", e.target.result);    //e.target.result就是最后的路径地址
            };
        }
    });

    $("#imgFileUpload3").change(function () {
        var file = this.files[0];
        if (window.FileReader) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            //监听文件读取结束后事件
            reader.onloadend = function (e) {
                $("#img3").attr("src", e.target.result);    //e.target.result就是最后的路径地址
            };
        }
    });

</script>
</body>

</html>