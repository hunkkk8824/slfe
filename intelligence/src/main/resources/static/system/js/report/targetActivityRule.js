(function (_path) {
    /** 通用变量 */
    var publicCache = {};


    //初始化数据
    var initData = function () {
        publicCache.path = _path;
    };

    //初始化事件
    var initEvent = function () {

        laydate.render({
            elem: '#sbsjStartTime',
            type: 'datetime',
            format: 'yyyy-MM-dd HH:mm:ss',
        });

        laydate.render({
            elem: '#sbsjEndTime',
            type: 'datetime',
            format: 'yyyy-MM-dd HH:mm:ss',
        });

        $('#query').click(function () {

            doSearch();
        })

    };

    //1.百度地图API功能
    var map = new BMap.Map("map", {
        minZoom: 1,
        maxZoom: 7
    });    // 创建Map实例

    //隐藏百度地图商标
    function hideLog() {

        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();

    }

    function initChartMap(params) {
        // 获取坐标
        var url = publicCache.path + "/report/getLocations?v=" + new Date();
        layer.load(3);
        $.ajax({
            type: 'post',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(params),
            success: function (res) {
                layer.closeAll('loading');
                if (res) {
                    initMarker(res);
                }
            }, error: function (xhr, status) {
                layer.closeAll('loading');
                //提示层
                layer.msg("系统出现异常！", {icon: 0});
            }
        });
    }

    //添加标注
    function addMarker(points) {


            map.centerAndZoom(points[0], 5);
            var options = {
                size: BMAP_POINT_SIZE_SMALL,
                shape: BMAP_POINT_SHAPE_STAR,
                color: '#d340c3'
            }
            var pointCollection = new BMap.PointCollection(points, options);  // 初始化PointCollection
            pointCollection.addEventListener('click', function (e) {
                layer.msg('单击点的坐标为：' + e.point.lng + ',' + e.point.lat);  // 监听点击事件
            });
            map.addOverlay(pointCollection);  // 添加Overlay

    }

    //热力图
    function addHeatmap(points) {

        map.centerAndZoom(points[0], 5);
        var heatmapOverlay = new BMapLib.HeatmapOverlay({"radius": 100, "visible": true});
        map.addOverlay(heatmapOverlay);
        heatmapOverlay.setDataSet({data: points, max: 100});

    }

    function initMarker(data) {

        map.clearOverlays();

        var points = [];  // 添加海量点数据
        for (var i = 0; i < data.length; i++) {
            points.push(new BMap.Point(data[i].jd, data[i].wd));
        }

        if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制热力图

            if (points.length > 100) {
                addHeatmap(points);//热力图
            }
            else {
                addMarker(points);
            }
        } else {
            layer.msg('请在chrome、safari、IE8+以上浏览器查看本示例');
        }
    }

    // 初始化地图
    var initMap = function () {
        map.centerAndZoom(new BMap.Point(116.404, 39.915), 6);  // 初
        map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        //map.addControl(new BMap.NavigationControl());   //缩放按钮
        map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]}));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持

        //监听地图缩放
        map.addEventListener("zoomend", function () {
            hideLog();
            if (this.getZoom() > 10) {
                layer.msg("默认只有10级地图, 超过无法显示");
            }
        });

        //地图加载完成
        map.addEventListener("tilesloaded", function () {
            hideLog()
        });

    };

    function getBaseParam() {

        return {
            tableName: $.trim($('#dataSetCode').val()),
            jjm: $.trim($("#jjm").val()),//机舰名
            jxh: $.trim($("#jxh").val()),//机弦号
            jmbz: $.trim($("#jmbz").val()),//军民标识,
            sbsjStartTime: $.trim($("#sbsjStartTime").val()),
            sbsjEndTime: $.trim($("#sbsjEndTime").val())
        }
    }

    function doSearch() {

        var param = getBaseParam();

        if (!param.tableName) {
            layer.msg("请选择数据集", {icon: 0});
            return false;
        }
        getColumnsByDataSetCode(param.tableName, initTable);
        initChartMap(param);
    }

    //根据表名称或列设置
    function getColumnsByDataSetCode(code, callBack) {
        var url = publicCache.path + "/dataQuality/getColumnsByDataSetCode?v=" + new Date();
        $.get(url, {
            dataSetCode: code,//表名称
        }, function (data) {
            if (callBack) {
                callBack(data);
            }

        });
    }

    //得到查询的参数
    function queryParams(params) {
        var param = getBaseParam();
        param.limit = params.limit;//页面大小
        param.offset = params.offset;   //页码
        return param;
    };


    function initTable(tableColumns) {
        $('#table').bootstrapTable("destroy");
        $('#table').bootstrapTable({
            url: publicCache.path + "/report/getList?v=" + new Date(),    //请求后台的URL（*）
            method: 'post',                         //请求方式（*）
            contentType: "application/json",
            toolbarAlign: 'right',                 //工具栏对齐方式
            buttonsAlign: 'right',                 //按钮对齐方式
            striped: false,                         //是否显示行间隔色
            cache: false,                           //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                      //是否显示分页（*）
            sortable: false,                       //是否启用排序
            sortOrder: "asc",                      //排序方式
            sortName: "id",                        // 排序字段
            queryParams: queryParams,                //传递参数（*）
            sidePagination: "server",            //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                         //初始化加载第一页，默认第一页
            pageSize: 25,                          //每页的记录行数（*）
            pageList: [25, 50, 100],              //可供选择的每页的行数（*）
            strictSearch: true,
            clickToSelect: true,                //是否启用点击选中行
            height: 480,                          //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            showRefresh: false,                   //刷新按钮
            columns: tableColumns,
            onLoadSuccess: function (res) {

                // var allTableData = $('#table').bootstrapTable('getData');//获取表格的所有内容行
                // initMarker(allTableData);
            }
        });
    }

    function initChart(){

        var option = {
            title: {
                text: '目标活动规律',
                subtext: '活动规律同比',
                x: 'center'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            legend: {
                top:50,
                data:['去年','今年','同比增长率']
            },
            grid:{
                left:30,
                right:45,
                top:80,
                bottom:20,
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['1月','2月','3月','4月','5月','6月','7月','8月'],
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '数量',
                    min: 0,
                    max: 50,
                    interval: 10,
                    axisLabel: {
                        formatter: '{value} '
                    }
                },
                {
                    type: 'value',
                    name: '同比增长率',
                    min: 0,
                    max: 100,
                    interval: 20,
                    axisLabel: {
                        formatter: '{value} %'
                    }
                }
            ],
            series: [
                {
                    name:'去年',
                    type:'bar',
                    data:[20, 10, 15, 30, 25, 12, 30, 21]
                },
                {
                    name:'今年',
                    type:'bar',
                    data:[22, 13, 23, 35, 31, 20, 31, 25]
                },
                {
                    name:'同比增长率',
                    type:'line',
                    yAxisIndex: 1,
                    data:[10,30, 53.33,16.67, 24,66.67, 3.33, 19.05]
                }
            ]
        };

        var myChart = echarts.init(document.getElementById('chart'));
        myChart.setOption(option);
    }

    // 页面初始化
    $(function () {
        initChart();
        initData();
        initEvent();
        initMap();
    });
})(_path);