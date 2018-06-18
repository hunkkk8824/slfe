<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <title>多源情报系统-资源描述管理</title>
    <style type="text/css">

        /* table 样式 */
        #editor table {
            border-top: 1px solid #ccc;
            border-left: 1px solid #ccc;
        }

        #editor table td,
        #editor table th {
            border-bottom: 1px solid #ccc;
            border-right: 1px solid #ccc;
            padding: 3px 5px;
        }

        #editor table th {
            border-bottom: 2px solid #ccc;
            text-align: center;
        }

        /* blockquote 样式 */
        #editor blockquote {
            display: block;
            border-left: 8px solid #d0e5f2;
            padding: 5px 10px;
            margin: 10px 0;
            line-height: 1.4;
            font-size: 100%;
            background-color: #f1f1f1;
        }

        /* code 样式 */
        #editor code {
            display: inline-block;
            *display: inline;
            *zoom: 1;
            background-color: #f1f1f1;
            border-radius: 3px;
            padding: 3px 5px;
            margin: 0 3px;
        }

        #editor pre code {
            display: block;
        }

        /* ul ol 样式 */
        #editor ul, ol {
            margin: 10px 0 10px 20px;
        }
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div style="margin-left: 2%;margin-top: 2%">

    <div class="form-group">
        <label class="col-sm-3 control-label"><font color="red">* </font>资源名称：</label>
        <div class="col-sm-8">
            <input id="datasetName" name="datasetName" class="form-control" type="text" placeholder="资源名称"
                   value="${catalogDescVo.datasetName}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label"><font color="red">* </font>资源编码：</label>
        <div class="col-sm-8">
            <input id="datasetCode" name="datasetCode" class="form-control" placeholder="资源编码" type="text"
                   value="${catalogDescVo.datasetCode}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label"><font color="red">* </font>内容：</label>
        <div class="col-sm-8">
            <div id="editor">
            </div>
        <#--<textarea id="content" name="content"  style="width:100%; height:200px; value="${catalogDescVo.content}">-->
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-8 col-sm-offset-4">
            <button class="btn btn-primary" id="save" type="button" id="btn_save">保存</button>
            <button class="btn btn-primary" id="cancel" type="button" id="btn_cancel" style="margin-left:30px;">取消
            </button>
        </div>
    </div>

</div>
<script type="text/javascript" src="${base}/static/js/plugins/wangEditor/wangEditor.min.js"></script>
<script type="text/javascript">

    var id = '${catalogDescVo.id}';
    var content = decodeURIComponent('${catalogDescVo.content}');

    (function (base) {


        function init() {

            $('#btn_cancel').on('click', function () {
                close();
            });
            initEditor(content);


            $("#cancel").click(function () {
                parent.layer.closeAll();
            });

            $("#save").click(function () {

                var index = layer.load();
                PostAjax(base + "/resourcecatalogDesc/edit", {
                    id: id,
                    datasetName: $.trim($("#datasetName").val()),
                    datasetCode: $.trim($("#datasetCode").val()),
                    content: getEditorHtml()
                }, function (data) {

                    layer.close(index);
                    if (data == 0) {
                        layer.msg(data.message);
                    }

                    setTimeout(function () {
                        parent.layer.closeAll();
                    }, 1200);

                });
            });

        };


        var editor;

        function initEditor(content) {
            var E = window.wangEditor;
            editor = new E('#editor');
            editor.customConfig.uploadImgShowBase64 = true
            editor.create();
            setEditorHtml(content);
        }

        function getEditorHtml() {
          return  editor.txt.html();
        }

        function setEditorHtml(content) {
            editor.txt.html(content)
        }

        // 页面初始化
        $(function () {
            init();
        });

    })(base);
</script>
</body>

</html>
