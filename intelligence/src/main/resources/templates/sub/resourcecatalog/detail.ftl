<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">

    <title>多源情报系统-资源目录详情</title>

</head>

<body class="gray-bg">
<div class="tabs-container">

    <div class="tabs-top">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1"> 数据信息</a>
            </li>
            <li class=""><a data-toggle="tab" href="#tab-2"> 数据内容</a>
            </li>
            <li class=""><a data-toggle="tab" href="#tab-3"> 数据日志</a>
            </li>
        </ul>
        <div class="tab-content ">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <i class="fa fa-refresh"><strong>刷新</strong></i>
                    <iframe src="${base}/resourcecatalog/QB_SJ_YSDZZJGMB" frameborder="0" width="100%" height="700"></iframe>
                </div>
            </div>
            <div id="tab-2" class="tab-pane">
                <div class="panel-body">
                     <i class="	fa fa-search-plus"><strong>查询</strong></i>&nbsp;
                    <i class="fa fa-refresh"><strong>刷新</strong></i> &nbsp;
                    <i class="fa fa-cloud-download"><strong>下载</strong></i>
                    <br><br>
                    <table id="exampleTableContent" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="order">序号</th>
                            <th data-field="PH">批号</th>
                            <th data-field="PTBH">平台编号</th>
                            <th data-field="PTMC">平台名称</th>
                            <th data-field="PTLX">平台类型</th>
                            <th data-field="CGQBH">传感器编号</th>
                            <th data-field="XYLX">信息类型</th>
                            <th data-field="HJZT">航迹状态</th>
                            <th data-field="HJZL">航迹质量</th>
                            <th data-field="JSSJ">接收时间</th>
                            <th data-field="SBSJ">上报时间</th>
                            <th data-field="SX">属性</th>
                            <th data-field="GJ">国际</th>
                            <th data-field="JD">经度</th>
                            <th data-field="WD">维度</th>
                            <th data-field="GD">高度</th>
                            <th data-field="FW">方位</th>
                            <th data-field="FWWC">方位误差</th>
                            <th data-field="FWKXD">方位可信度</th>
                            <th data-field="YJ">仰角</th>
                            <th data-field="MCCFPLTZ">脉冲重复频率特征</th>
                            <th data-field="BMTZ">编码特征</th>
                            <th data-field="WXYLX">威胁源类型</th>
                            <th data-field="GDGRYS">无源光电干扰样式建议</th>
                            <th data-field="TTBH">探头编号</th>
                            <th data-field="BC">波长</th>
                            <th data-field="ZTLB"> 载体类别</th>
                            <th data-field="ZTLX">载体类型</th>
                            <th data-field="PTXH">平台型号</th>
                            <th data-field="JXH">机舷号</th>
                            <th data-field="JJM">舰名</th>
                            <th data-field="BMTZCD">编码特征长度</th>

                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div id="tab-3" class="tab-pane">
                <div class="panel-body">
                    <i class="fa fa-refresh"><strong>刷新</strong></i>
                    <br><br>
                    <table id="exampleTableLog" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="order">序号</th>
                            <th data-field="content">日志内容</th>
                            <th data-field="date">时间</th>
                            <th data-field="operator">操作人</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

    </div>

</div>


</body>
<!-- Peity -->
<script type="text/javascript">

    //数据日志
    (function () {
        var data = [{
            order: 1,
            content: '',
            date: '2018-4-11 12:34:34',
            operator: '胡生'
        }, {
            order: 2,
            content: '',
            date: '2018-4-12 11:24:14',
            operator: '张武'
        }];


        $('#exampleTableLog').bootstrapTable({
            data: data,
            // mobileResponsive: true,
            height: "550"
        });
    })();

    //数据日志
    (function () {
        var data = [{
            order: 1,
            PH:'PH201804012',
            PTBH:'PT201804012',
            PTMC:'平台名称',
            PTLX:'45',
            CGQBH:'567',
            XYLX:'3',
            HJZT:'3',
            HJZL:'4',
            JSSJ:'20180412',
            SBSJ:'20180412',
            SX:'45',
            GJ:'13',
            JD:'34.234567',
            WD:'212.345678',
            GD:'45.678',
            FW:'34.890',
            FWWC:'24.567',
            FWKXD:'2',
            YJ:'45.678',
            MCCFPLTZ:'455',
            BMTZ:'5343423',
            WXYLX:'344',
            GDGRYS:'55',
            TTBH:'53',
            BC:'35.789',
            ZTLB:'3434',
            ZTLX:'345',
            PTXH:'PT2344',
            JXH:'JX223435',
            JJM:'武汉磅',
            BMTZCD:'89',

        }, {
            order: 1,
            PH:'PH201804012',
            PTBH:'PT201804012',
            PTMC:'东海台',
            PTLX:'45',
            CGQBH:'567',
            XYLX:'3',
            HJZT:'3',
            HJZL:'4',
            JSSJ:'20180410',
            SBSJ:'20180410',
            SX:'65',
            GJ:'83',
            JD:'44.234567',
            WD:'112.345678',
            GD:'75.678',
            FW:'54.890',
            FWWC:'74.567',
            FWKXD:'2456',
            YJ:'45.678',
            MCCFPLTZ:'455',
            BMTZ:'67423',
            WXYLX:'344',
            GDGRYS:'55',
            TTBH:'53',
            BC:'39.789',
            ZTLB:'3434',
            ZTLX:'545',
            PTXH:'PT2344',
            JXH:'JX223435',
            JJM:'东海博一',
            BMTZCD:'89',
        }];


        $('#exampleTableContent').bootstrapTable({
            data: data,
            // mobileResponsive: true,
            height: "550"
        });
    })();

</script>
</html>
