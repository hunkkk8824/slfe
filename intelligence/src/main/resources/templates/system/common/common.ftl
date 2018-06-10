<#assign base= request.contextPath />

<#--freemarker数字默认不加逗号-->
<#setting number_format="#">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="多源情报系统">
<meta name="description" content="多源情报系统">
<!--[if lt IE 9]>
 <meta http-equiv="refresh" content="0;ie.html"/>
 <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="${base}/static/portal/res/layui/css/layui.css">
<link rel="stylesheet" href="${base}/static/system/css/linearicons.css">
<link rel="stylesheet" href="${base}/static/system/css/font-awesome.min.css">
<link rel="stylesheet" href="${base}/static/system/css/bootstrap.css">
<link rel="stylesheet" href="${base}/static/system/css/magnific-popup.css">
<link rel="stylesheet" href="${base}/static/system/css/jquery-ui.css">
<link rel="stylesheet" href="${base}/static/system/css/nice-select.css">
<link rel="stylesheet" href="${base}/static/system/css/animate.min.css">
<link rel="stylesheet" href="${base}/static/system/css/swiper.min.css">
<link rel="stylesheet" href="${base}/static/system/css/bootstrap-table.css">
<link rel="stylesheet" href="${base}/static/system/css/owl.carousel.css">
<link rel="stylesheet" href="${base}/static/system/css/main.css">


<script src="${base}/static/system/js/vendor/jquery-2.2.4.min.js"></script>
<script src="${base}/static/system/js/popper.min.js"></script>
<script src="${base}/static/system/js/vendor/bootstrap.min.js"></script>
<script src="${base}/static/system/js/jquery-ui.js"></script>
<script src="${base}/static/system/js/easing.min.js"></script>
<script src="${base}/static/system/js/swiper.min.js"></script>
<script src="${base}/static/system/js/hoverIntent.js"></script>
<script src="${base}/static/system/js/superfish.min.js"></script>
<script src="${base}/static/system/js/bootstrap-treeview.js"></script>
<#--<script src="${base}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"-->
        <#--type="text/javascript"></script>-->
<script src="${base}/static/system/js/bootstrap-table.js"></script>
<script src="${base}/static/system/js/bootstrap-table-zh-CN.js"></script>
<script src="${base}/static/system/js/jquery.ajaxchimp.min.js"></script>
<script src="${base}/static/system/js/jquery.magnific-popup.min.js"></script>
<script src="${base}/static/system/js/jquery.nice-select.min.js"></script>
<script type="text/javascript" src="${base}/static/system/js/echarts4.min.js"></script>
<script type="text/javascript" src="${base}/static/system/js/china.js"></script>
<script src="${base}/static/system/js/owl.carousel.min.js"></script>
<script src="${base}/static/system/js/mail-script.js"></script>
<script src="${base}/static/portal/res/layui/layui.all.js"></script>


<script type="text/javascript">
    var base = '${base}';


    function PostAjax(url, requestData, successCallBack) {

        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(requestData),
            dataType: "json",
            contentType: 'application/json',
            success: function (data) {

                if (parseInt(data.code) == 0) {
                    layer.msg("操作成功!", {icon: 1});
                } else {
                    layer.msg("操作失败!", {icon: 0});
                }

                if (successCallBack) {
                    successCallBack();
                }

            }
        });
    }

    function isEmpty(str) {

        return !Boolean(str) || str == "undefined" || str == "null";
    }
</script>