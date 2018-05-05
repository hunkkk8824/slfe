<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-数据质量管理</title>
    <style type="text/css">
        #toolbar input, button, select {
            float: left;
            margin-top: 10px;
            margin-left: 10px;
            margin-bottom: 10px;
            font-size: 12px;
        }

    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

<#--&lt;#&ndash;前置交换机code&ndash;&gt;-->
<#--<input type="hidden" id="hd_sourceExchangerCode" value="">-->

<div class="example-wrap">

    <div class="hidden-xs" id="toolbar" role="group">

    <#--前置交换机-->
        <select id="sourceExchangerCode" name="sourceExchangerCode" class="form-control"
                style="width:250px;height: 30px">
            <option value="">全部-前置交换机</option>
        <#list sourceExchangerCodeList as item>
            <option value="${item.code}">${item.name}</option>
        </#list>
        </select>


    <#--资源编码-->
        <input style="width:250px;" name="code" id="code" placeholder="资源编码"
               class="input-sm form-control">

    <#--数据集编码-->
        <select id="dataSetCode" name="dataSetCode" class="form-control" style="width:250px;height: 30px">
            <option value="">全部-数据集编码</option>
        <#list dataSetCodeEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>
        </select>

    <#--审核状态-->
        <select id="auditStatus" name="auditStatus" class="form-control" style="width:143px;height: 30px">
            <option value="">全部-审核状态</option>
        <#list auditStatusEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>

        </select>
    <#--质量评定-->
        <select id="quality" name="quality" class="form-control" style="width:143px;height: 30px">
            <option value="">全部-质量评定</option>
        <#list qualityEvaluateEnums as item>
            <option value="${item.getValue()}">${item.getDisplayName()}</option>
        </#list>

        </select>
        <button id="query" type="button" class="btn btn-sm btn-primary">
            搜索
        </button>

    </div>
    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">

    var menutype = parseInt('${menutype}');
    (function (base, menutype) {

        var baseUrl = base + "/dataQuality";

        //初始化事件
        function initEvent() {
            //2.查询按钮事件
            $('#query').click(function () {

//                var sourceExchangerCode = $("#hd_sourceExchangerCode").val();
//                if (isEmpty(sourceExchangerCode)) {
//
//                    layer.msg("没有选择前置交换机");
//                    return;
//                }


                $('#table').bootstrapTable('refresh', {
                    pageNumber: 1
                });
            })

        };

        //得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                code: $('#code').val(),//资源编码
                dataSetCode: $('#dataSetCode').val(),//数据集编码
                quality: $('#quality').val(),
                auditStatus: $("#auditStatus").val(),
                sourceExchangerCode: $("#sourceExchangerCode").val(),

            };
            return temp;
        };

        //审核
        function audit(request) {

            PostAjax(baseUrl + "/audit", request, refreshTable);
        }

        //查看明细
        function openDetail(request) {

            var url = baseUrl + "/toDetail?dataSetCode=" + request.dataSetCode + "&&resourceCode=" + request.resourceCode;

            layer.open({
                type: 2,
                title: '资源详情',
                area: ['1310px', '600px'],
                skin: 'layui-layer-rim', //加上边框
                content: [encodeURI(url),]
            });
        }

        function cancelResource(request) {
            PostAjax(baseUrl + "/cancelResource", request, refreshTable);
        }

        function refreshTable() {
            $('#query').click();
        }

        //质量评定
        function evaluateQuality(request) {

            PostAjax(baseUrl + "/evaluateQuality", request, refreshTable);
        }

        window.operateEvents = {
            'click .btn_audit': function (e, value, row, index) {

                var request = {
                    resourceId: row.id,
                    auditStatus: null
                };


                layer.confirm('是否合格通过？', {
                    btn: ['通过', '不通过'], //按钮
                    shade: false, //不显示遮罩
                    btn1: function () {//通过
                        request.auditStatus = AuditStatusEnum.Audited;
                        audit(request);
                    },
                    btn2: function () {//不通过
                        request.auditStatus = AuditStatusEnum.Dismissal;
                        audit(request);
                    }
                });
            },
            'click .btn_judge': function (e, value, row, index) {

                var request = {
                    resourceId: row.id,
                    quality: null
                };


                layer.confirm('请评定该资源质量', {
                    btn: ['优', '良', '差'], //按钮
                    shade: false, //不显示遮罩
                    btn1: function () {//优
                        request.quality = QualityEvaluateEnum.Excellent;
                        evaluateQuality(request);
                    },
                    btn2: function () {//良
                        request.quality = QualityEvaluateEnum.Good;
                        evaluateQuality(request);
                    },
                    btn3: function () {//差
                        request.quality = QualityEvaluateEnum.Difference;
                        evaluateQuality(request);
                    }
                });
            },
            'click .btn_log': function (e, value, row, index) {

                layer.open({
                    type: 2,
                    title: '导入日志',
                    fix: false,
                    shadeClose: true,
                    area: ['820px', '740px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: [base + "/dataQuality/toExportLog?resourceId=" + row.id, 'no'],
                });
            },
            'click .btn_cancelResource': function (e, value, row, index) {

                var request = {
                    resourceId: row.id
                }

                layer.confirm('确定撤销', {
                    btn: ['确认', '取消'], //按钮
                    shade: false, //不显示遮罩
                    btn1: function () {//确认
                        cancelResource(request);
                    },

                });
            },
            'click .btn_detail': function (e, value, row, index) {

                var request = {
                    dataSetCode: row.datasetCode,
                    resourceCode: row.code,
                };

                openDetail(request);
            }
        };

        function initTable() {
            $('#table').bootstrapTable({
                url: base + '/dataQuality/getList',    //请求后台的URL（*）
                method: 'post',                     //请求方式（*）
                contentType: "application/json",
                toolbarAlign: 'right',               //工具栏对齐方式
                buttonsAlign: 'right',               //按钮对齐方式
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                    //是否启用排序
                sortOrder: "asc",                   //排序方式
                sortName: "id",                  // 排序字段
                queryParams: queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 15,                       //每页的记录行数（*）
                pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                height: 650,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                showRefresh: false,                   //刷新按钮
                columns: [{
                    field: 'code',
                    title: '资源编码'
                }, {
                    field: 'name',
                    title: '资源名称'
                }, {
                    field: 'preImportTotalCount',
                    title: '预导入总数'
                }, {
                    field: 'importSuccessCount',
                    title: '导入成功数'
                }, {
                    field: 'importStatusStr',
                    title: '导入状态'
                }, {
                    field: 'commitUserName',
                    title: '提交人名称'
                }, {
                    field: 'commitTimeStr',
                    title: '提交时间'
                }, {
                    field: 'auditUserName',
                    title: '审核人名称'
                }, {
                    field: 'auditTimeStr',
                    title: '审核时间'
                }, {
                    field: 'auditStatusStr',
                    title: '审核状态'
                }, {
                    field: 'isCancelStr',
                    title: '是否已撤销'
                }, {
                    field: 'qualityStr',
                    title: '质量评定'
                }, {
                    field: 'sourceExchangerCode',
                    title: '来源交换机编码'
                }, {
                    field: 'sourceExchangerName',
                    title: '来源交换机名称'
                }, {
                    field: 'Button',
                    title: '操作',
                    formatter: function (value, row, index) {

                        var btns = [
                            '<button  type="button" class="btn btn-primary btn-sm btn_detail">查看数据</button> ',
                            '<button  type="button" class="btn btn-primary btn-sm btn_log">查看日志</button> ',];

                        //数据质量管理
                        if (menutype == 1) {
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_audit">审核</button>');
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_judge">评定</button>');
                        }
                        else {
                            //交换日志
                            btns.push('<button  type="button" class="btn btn-primary btn-sm btn_cancelResource">撤销</button>');
                        }

                        return btns.join('');

                    },
                    events: operateEvents
                }]
            });


        }

        $(function () {
            initTable();
            initEvent();
        });
    })(base, menutype);
</script>
</body>

</html>
