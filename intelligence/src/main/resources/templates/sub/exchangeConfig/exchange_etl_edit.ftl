<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>新增配置</title>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:auto">
<div style="margin-left: 2%;margin-top: 2%">
    <input type="hidden" id="id" value="${exchangerEtlPO.id}"/>
    <form class="form-horizontal m-t" id="exchangeForm" style="margin-left: 15px;margin-right: 15px;margin-top: 5px;">
        <div class="form-group">
            <label class="col-sm-3 control-label"><font color="red">* </font>数据集名称：</label>
            <div class="col-sm-8">
                <select id="dataset" style="width:350px;height: 30px"  class="form-control">
                    <#list dataSets as dataset>
                        <option value="${dataset.value}" <#if dataset.value == exchangerEtlPO.datasetCode>selected</#if>>${dataset.displayName}</option>
                    </#list>
                </select>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-4" style="margin-left: 180px;">
                <button class="btn btn-primary" type="submit" id="btn_save" style="margin-left:30px;">保存</button>
                <button class="btn btn-primary" type="button" id="btn_cancel" style="margin-left:30px;">取消</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${base}/static/js/plugins/form/jquery.form.min.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript" src="${base}/static/js/plugins/validate/messages_zh.min.js"></script>
<script type="text/javascript">
    (function (base) {

        function init() {

            $('#btn_cancel').on('click', function () {
                close();
            });


            // 表单验证绑定
            var validator = $("#exchangeForm").validate({
                rules: {
                    dataset: {
                        required: true,
                    }
                },
                messages: {
                    dataset: {
                        required: "请选择数据集"
                    }
                },
                submitHandler: function (form) { //不通过回调
                    console.log("验证通过");
                    var selectOption = $('#dataset option:selected');
                    var dataSetCode = selectOption.val();
                    var datasetName = selectOption.text();
                    var data = {
                        id:$('#id').val(),
                        datasetCode: dataSetCode,
                        datasetName: datasetName
                    }
                    layer.load(3);
                    debugger
                    $.ajax({
                        type: 'post',
                        url: base + '/exchangeConfig/saveExchangeEtl',
                        dataType: 'json',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (res) {
                            layer.closeAll('loading');
                            var msg = res.msg;
                            var code = parseInt(res.code);
                            debugger
                            if (code == 0) {
                                layer.msg("添加成功",{icon: 1});
                                pageReload();
                            } else {
                                layer.msg("添加失败",{icon: 2});
                            }
                        }, error: function (xhr, status) {
                            layer.closeAll('loading');
                            //提示层
                            layer.msg("系统出现异常！", {icon: 0});
                        }
                    });
                },
                invalidHandler: function (form, validator) {
                    return false;
                }
            });

            validator.resetForm();
            // 移除error样式
            $("#exchangeForm input").removeClass('error');

        };

        // 关闭layer
        var close = function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        };

        // 页面刷新
        var pageReload = function (millisec) {
            var s = 1000;
            if (!millisec) {
                s = millisec;
            }
            setTimeout(function () {
                close();
            }, s);
        };

        // 页面初始化
        $(function () {

            init();
        });

    })(base);
</script>
</body>

</html>
