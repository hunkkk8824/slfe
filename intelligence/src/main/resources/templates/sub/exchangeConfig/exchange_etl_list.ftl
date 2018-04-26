<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>数据集配置</title>
    <style type="text/css">
        #toolbar input, button,select {
            float: left;
            margin-top: 10px;
            margin-left: 10px;
            margin-bottom: 10px;
            font-size: 12px;
        }

    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div class="example-wrap">
    <input type="hidden" id="exchangerId" value="${exchangerId}"/>
    <div class="btn-group hidden-xs" id="toolbar" role="group">
        <input style="width:250px;" name="keyWordInfo" id="keyWordInfo" placeholder="数据集名称/数据集编码" class="input-sm form-control">
        <select style="width:143px;height: 30px" id="valid" name="valid" class="form-control" >
            <option value="">全部</option>
            <option value="1">启用</option>
            <option value="0">禁用</option>
        </select>
        <button id="query" type="button" class="btn btn-sm btn-primary">
            搜索
        </button>
        <button  style="margin-left: 10px" id="btn_add" type="button" class="btn btn-sm btn-primary">
            新增
        </button>
    </div>
    <table id="table" data-height="400" data-mobile-responsive="true">

    </table>

</div>

<script type="text/javascript">
    (function (base) {

        //初始化事件
        function initEvent() {
            //2.查询按钮事件
            $('#query').click(function () {
                $('#table').bootstrapTable('refresh', {
                    pageNumber: 1
                });
            })

            //3.重置按钮事件
            $('#clear').click(function () {
                $('#queryForm')[0].reset();
                $("#selectOption").hide();

            });

            $('#btn_add').on('click', function () {
                var exchangerId = $('#exchangerId').val();
                layer.open({
                    type: 2,
                    title: '新增交换配置',
                    fix: false,
                    shadeClose: true,
                    area: ['600px', '250px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: base + "/exchangeConfig/toExchangeEtlAdd?exchangerId="+exchangerId,
                    end: function () {
                        $('#query').trigger('click');
                    }
                });
            });
        };

        //得到查询的参数
        function queryParams(params) {

            var temp = {
                limit: params.limit,    //页面大小
                offset: params.offset,   //页码
                exchangerId:$('#exchangerId').val(),
                keyword: $('#keyWordInfo').val(),
                valid: $('#valid').val() ? parseInt($('#valid').val()) : null,

            };
            return temp;
        };

        window.operateEvents = {
            'click .btn_edit': function (e, value, row, index) {
                layer.open({
                    type: 2,
                    title: '编辑交换配置',
                    fix: false,
                    shadeClose: true,
                    area: ['600px', '250px'],
                    skin: 'layui-layer-rim', //加上边框
                    zIndex: 9999,
                    shift: Math.floor(Math.random() * 6 + 1),
                    content: base + "/exchangeConfig/toExchangeEtlEdit?id=" + row.id,
                    end: function () {
                        $('#query').trigger('click');
                    }
                });
            },
            'click .btn_delete': function (e, value, row, index) {
                var msg =  row.valid == 1?"停用":"启用";
                var valid = row.valid == 0? 1:0;
                layer.confirm('是否确认'+msg+'？', {
                    btn: ['确认','取消'] //按钮
                }, function(){
                    deleteConfig(row.id,valid);
                }, function(){
                    // nothing
                });
            },
        };

        function deleteConfig(id,valid){
            layer.load(3);
            var data = {
                id: id,
                valid:valid
            };
            $.ajax({
                type: 'post',
                url: base + '/exchangeConfig/editExchangeEtl',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    layer.closeAll('loading');
                    var msg = res.msg;
                    var code = parseInt(res.code);
                    debugger
                    if (code == 0) {
                        layer.msg("操作成功",{icon: 1});
                        pageReload();
                    } else {
                        layer.msg("操作失败",{icon: 2});
                    }
                }, error: function (xhr, status) {
                    layer.closeAll('loading');
                    //提示层
                    layer.msg("系统出现异常！", {icon: 0});
                }
            });
        }

        function initTable() {
            $('#table').bootstrapTable({
                url: base + '/exchangeConfig/getExchangeEtlList',    //请求后台的URL（*）
                method: 'post',                     //请求方式（*）
                contentType: "application/json",
                toolbarAlign: 'right',               //工具栏对齐方式
                buttonsAlign: 'right',               //按钮对齐方式
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                    //是否启用排序
                sortOrder: "asc",                   //排序方式
                sortName: "id",                    // 排序字段
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
                    field: 'datasetName',
                    sortable: true,
                    sortOrder: "asc",
                    title: '数据集名称'
                }, {
                    field: 'datasetCode',
                    sortable: true,
                    sortOrder: "asc",
                    title: '数据集编码'
                }, {
                    field: 'valid',
                    sortable: true,
                    sortOrder: "asc",
                    title: '状态',
                    formatter: function (value, row, index) {
                        if (value) {
                            return '<span class="label label-success">启用</span>';
                        } else {
                            return '<span class="label label-default">禁用</span>';
                        }
                    }
                }, {
                    field: 'Button',
                    title: '操作',
                    formatter: function (value, row, index) {
                        var msg =  row.valid == 1?"停用":"启用";
                        return [
                            '<button  type="button" class="btn btn-default btn-sm btn_edit">修改</button> ',
                            '<button  type="button" class="btn btn-default btn-sm btn_delete">'+msg+'</button> '
                        ].join('');
                    },
                    events: operateEvents
                }]
            });


        }

        // 页面刷新
        var pageReload = function (millisec) {
            var s = 1000;
            if (!millisec) {
                s = millisec;
            }
            setTimeout(function () {
                $('#table').bootstrapTable('refresh', {
                    pageNumber: 1
                });
            }, s);
        };

        $(function () {
            initTable();
            initEvent();
        });
    })(base);
</script>
</body>

</html>
