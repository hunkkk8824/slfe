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
<!-- 全局css -->
<link href="${base}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${base}/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<link href="${base}/static/css/font-awesome.css" rel="stylesheet">
<link href="${base}/static/css/animate.css" rel="stylesheet">
<link href="${base}/static/css/style.css?v=4.1.0" rel="stylesheet">
<link href="${base}/static/css/plugins/footable/footable.core.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/laydate/theme/default/laydate.css" media="all">
<link href="${base}/static/css/plugins/jsTree/style.min.css" rel="stylesheet">
<style type="text/css">

    select.form-control {
        padding: 0;
    }

    table th {
        background-color: #2f4050;
    }

    table th .th-inner {
        color: white;
    }

    .jstree-open > .jstree-anchor > .fa-folder:before {
        content: "\f07c";
    }

    .jstree-default .jstree-icon.none {
        width: 0;
    }

</style>


<!-- 全局js -->
<script src="${base}/static/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${base}/static/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${base}/static/js/plugins/metisMenu/jquery.metisMenu.js" type="text/javascript"></script>
<script src="${base}/static/js/plugins/slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${base}/static/js/plugins/layer/layer.min.js"></script>

<!-- Bootstrap table -->
<script src="${base}/static/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${base}/static/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript"></script>
<script src="${base}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"
        type="text/javascript"></script>
<script src="${base}/static/js/plugins/footable/footable.all.min.js"></script>
<script src="${base}/static/js/plugins/laydate/laydate.js"></script>

<!-- jsTree plugin javascript -->
<script src="${base}/static/js/plugins/jsTree/jstree.min.js"></script>

<!--离线地图-->
<script type="text/javascript" src="${base}/static/js/plugins/offlinemap/map_load.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/offlinemap/css/map.css"/>
<script type="text/javascript">
    var base = '${base}';

    //审核状态枚举
    var AuditStatusEnum = {
        Unaudited: 0,// "待审核",
        Audited: 1, //"已审核",
        Dismissal: 2,// "已驳回",
    };
    //质量评定枚举
    var QualityEvaluateEnum = {
        UnAssessed: 0,// "未评定",
        Difference: 1, //"差",
        Good: 2, //"良"
        Excellent: 3,// "优"
    };

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