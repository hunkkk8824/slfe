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
    <title>多源情报系统-数据交换</title>
<#include "common/common.ftl"/>
</head>
<style>
    .price-area {
        margin: 0;
    }

    .tab-content {
        height: 450px;
    }

    .wrapper {
        padding: 0;
    }

    .pre-name {
        width: 100px;
        text-align: center;
        border-radius: 6px;
        float: right;
        color: #000;
        border: 1px solid #ced4da;
    }

    .select {
        width: 100%;
        height: 40px;
        border-radius: 6px;
        text-indent: 40px;
    }

    .fa-plus-square-o, .fa-cloud-upload {
        color: #fff;
        margin-right: 6px;

    }

    .success.genric-btn {
        margin-bottom: 10px;
    }

    .primary.genric-btn, .success.genric-btn {
        float: right;
        margin-left: 15px;
    }
</style>
<body>
<#include "./common/header.ftl"/>

<!-- Start price Area -->
<section class="price-area section-gap">
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <div class="single-price">
                    <h4 style="text-align: left;text-indent: 20px;">数据导入</h4>
                    <div class="tab-content">
                        <div class="tab-pane fade active show" id="tab1">
                            <div class="select-condition row">

                                <div class="col-lg-2 wrapper">
                                    <span class="pre-name">前置机</span>
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <select name="exchanger" id="exchanger" class="select" data-display="Select">
                                        <option value="">请选择</option>
                                         <#list exchangerPOs as exchanger>
                                          <option value="${exchanger.code}" data-exchangerid="${exchanger.id}">${exchanger.name}</option>
                                         </#list>
                                    </select>
                                </div>

                                <div class="col-lg-5 wrapper"></div>

                                <div class="col-lg-2 wrapper">
                                    <span class="pre-name">数据集</span>
                                </div>
                                <div class="col-lg-4 wrapper">
                                    <select  name="dataset" id="dataset" class="select" data-display="Select">
                                        <option value="">请选择</option>
                                       <#list dataSets as dataset>
                                            <option value="${dataset.value}">${dataset.displayName}</option>
                                       </#list>
                                    </select>
                                </div>
                                <div class="col-lg-6 wrapper"></div>
                                <div class="col-lg-2 wrapper">
                                    <button id="btn_export" type="button" class="genric-btn primary"><a href="#"><i
                                            class="fa fa-plus-square-o"></i></a>立即导入
                                    </button>
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


<!-- start footer Area -->
<#include "./common/footer.ftl"/>
<!-- End footer Area -->

<script type="text/javascript">
    $(function(){

        $("#exchanger").change(function () {
            debugger
            var code = $(this).val();
            $.ajax({
                type: 'GET',
                url: '${base}/exchangeConfig/getDatasetByExchangerCode',
                data: {code:code},
                dataType:  'json',
                success: function(result){
                    $("#dataset").html("");
                    $("#dataset").append($("<option>").val("").text(""));
                    $.each(result, function(key, val) {

                        var option1 = $("<option>").val(val.datasetCode).text(val.datasetName);
                        $("#dataset").append(option1);
                    });
                    $("#dataset").get(0).selectedIndex=0;
                }
            });
        });

        $("#btn_export").on("click",function(){
            var exchanger = $("#exchanger option:selected");
            var dataset = $("#dataset option:selected");
            var data = {
                datasetCode:dataset.val(),
                datasetName:dataset.text(),
                sourceExchangerCode:exchanger.val(),
                sourceExchangerName:exchanger.text()
            };

            if(!data.sourceExchangerCode){
                layer.msg("请选择交换机!", {icon: 0});
            }

            if(!data.datasetCode){
                layer.msg("请选择数据集!", {icon: 0});
            }

            $.ajax({
                type: 'POST',
                url: '${base}/resource/save',
                dataType:  'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function(result){
                    if(result)
                    {
                        layer.msg(result.msg);
                    }                    // donothing
                }
            });
        });
    });


</script>
</body>
</html>