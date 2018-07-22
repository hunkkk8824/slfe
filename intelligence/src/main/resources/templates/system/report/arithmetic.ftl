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

<#include "../common/common.ftl"/>

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
<script>
    var _path = '${base}';
</script>
<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container" style="border: 1px solid #ccc;border-radius: 6px;">

        <div class="row">
            <div class="col-lg-12">
                <div class="single-price">
                    <h4>数据挖掘</h4>

                </div>
            </div>
            <div class="col-lg-12">
                <div class="right-content">
                    <div class="col-lg-12" style="margin-top: 0px;">
                        <form class="form-inline">
                            <select name="type" id="type" class="default-select key-input">
                                <option value="1">ACO-蚁群算法</option>
                                <option value="2">RandomForest-随机森林算法</option>
                                <option value="3">CABDDCC-基于连通图的分裂聚类算法</option>
                                <option value="4">Chameleon-两阶段合并聚类算法</option>
                                <option value="5">DBSCAN-基于密度的聚类算法</option>
                                <option value="6">GA-遗传算法</option>
                                <option value="7">GA_Maze-遗传算法在走迷宫游戏中的算法</option>
                                <option value="8">KDTree-k维空间关键数据检索算法工具类</option>
                            </select>

                            <button id="arithmetic" type="button" style="margin-left: 20px;" class="genric-btn info">
                                <a href="#">
                                    <i class="fa fa-play"></i>
                                </a>计算
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <label style="margin-top: 20px;"><strong>输入:</strong></label>
                <textarea class="readTextarea" id="txtInput" style=" text-align: left;
                         height: 450px; border: 1px solid #d4bc15;margin-bottom: 10px;margin-top: -10px;">
                </textarea>
            </div>
            <div class="col-lg-6">
                <label style="margin-top: 20px;"><strong>结果:</strong></label>
                <textarea class="readTextarea" id="txtResult" style=" text-align: left;
                         height: 450px; border: 1px solid #d4bc15;margin-bottom: 10px;margin-top: -10px;">
                </textarea>
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
<script src="${base}/static/system/js/bootstrap-table.js"></script>
<script src="${base}/static/system/js/bootstrap-table-zh-CN.js"></script>
<script src="${base}/static/system/js/jquery.ajaxchimp.min.js"></script>
<script src="${base}/static/system/js/jquery.magnific-popup.min.js"></script>
<script src="${base}/static/system/js/jquery.nice-select.min.js"></script>
<script src="${base}/static/js/plugins/layer/layer.min.js"></script>

<script type="text/javascript" src="${base}/static/system/js/echarts4.min.js"></script>
<script type="text/javascript" src="${base}/static/system/js/china.js"></script>

<script src="${base}/static/system/js/owl.carousel.min.js"></script>
<script src="${base}/static/system/js/mail-script.js"></script>
<#--<script src="${base}/static/system/js/report/tabpage.js"></script>-->

<script type="application/javascript">

    $(function(){
        $('#arithmetic').on('click',function(){
            arithmetic();
        });
    });

    function arithmetic(){
        // 获取参数
        var input = $.trim($('#txtInput').val());
        if(!input){
            layer.msg("请输入参数！",{icon:0});
            return;
        }
        var arr = input.split('\n');
        var type = $('#type').val();
        var params = {
            arr : arr,
            type : type
        };

        layer.load(3);
        $.ajax({
            type: 'post',
            url: _path + '/report/getArithmeticResult',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(params),
            success: function (res) {
                layer.closeAll('loading');
                if(!res){
                    layer.msg('系统异常',{icon:2});
                }else{
                    if(res.data){
                        $('#txtResult').val(res.data);
                    }else{
                        layer.msg('系统异常',{icon:2});
                    }
                }
            }, error: function (xhr, status) {
                layer.closeAll('loading');
                //提示层
                layer.msg("系统出现异常！", {icon: 0});
            }
        });
    }
</script>
</body>

</html>