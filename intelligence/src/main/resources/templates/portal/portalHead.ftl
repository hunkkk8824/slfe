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
<link rel="stylesheet" href="${base}/static/portal/res/css/global.css">
<script src="${base}/static/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${base}/static/portal/res/layui/layui.js"></script>

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