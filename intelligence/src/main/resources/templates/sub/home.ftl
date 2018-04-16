<!DOCTYPE html>
<html>

<head>

    <#include "../head.ftl">

    <title>多源情报系统-首页</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">

        <div class="ibox-content">
            <img alt="image" src="${base}/static/img/p_big2.jpg" width="1620" height="300">
        </div>
    </div>

    <div class="ibox float-e-margins">

        <div class="ibox-content">
            <div class="row row-lg">


                <div class="col-sm-12">
                    <h4 class="example-title">最新资源</h4>
                    <div class="example">
                        <table id="exampleTableFromData" data-mobile-responsive="true">
                            <thead>
                            <tr>
                                <th data-field="First">资源名称</th>
                                <th data-field="date">上传时间</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Panel Basic -->

</div>


</body>

<!-- Peity -->
<script src="${base}/static/js/demo/bootstrap-table-demo.js"></script>
</html>
