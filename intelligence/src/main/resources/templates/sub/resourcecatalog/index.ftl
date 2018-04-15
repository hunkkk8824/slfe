<!DOCTYPE html>
<html>

<head>

<#include "../../head.ftl">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>多源情报系统</title>

    <meta name="keywords" content="多源情报系统">
    <meta name="description" content="多源情报系统">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="file-manager">
                        <h5>前置机</h5>
                        <ul class="folder-list" style="padding: 0">
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201801</a>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201802</a>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201803</a>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201804</a>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i> PC201805</a>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa fa-server"></i>PC201806</a>
                            </li>
                        </ul>

                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
        <div style="height: 900px;overflow-y: auto" class="col-sm-9 animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">

                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    原始电子战激光目标表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC2018</small>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    融合目标表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC201801</small>
                                </div>
                            </a>
                        </div>

                    </div>

                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    电子战电子侦察目标表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC201801</small>
                                </div>
                            </a>
                        </div>
                    </div>

                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    原始电子战通信目标表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC201801</small>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    情报数据原始目标报表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC201801</small>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="file-box">
                        <div class="file">
                            <a href="javascript:void(0);">
                                <span class="corner"></span>

                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    动向情报表
                                    <br/>
                                    <small>更新时间：2018-04-13</small>
                                    <br/>
                                    <small>前置机：PC201801</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>



<script>
    $(document).ready(function () {

        $(".file a").click(function () {

            //iframe层
            layer.open({
                type: 2,
                title: '详情页',
                shadeClose: true,
                shade: 0.8,
                area: ['980px', '90%'],
                content: '${base}/resourcecatalog/detail'
            });
        });

    });
</script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>

</html>
