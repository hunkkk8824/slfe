(function (_path) {
    /** 通用变量 */
    var publicCache = {};


    //初始化数据
    var initData = function () {
        publicCache.path = _path;
    };

    //添加地图数据
    var addMarker = function (point) {
        var marker = new BMap.Marker(point);
        var label = new BMap.Label("目标", {offset: new BMap.Size(20, -10)});
        marker.setLabel(label);
        map.addOverlay(marker);
    }

    //添加地图数据
    var addAisMarker = function (point) {
        var marker = new BMap.Marker(point);
        var label = new BMap.Label("目标", {offset: new BMap.Size(20, -10)});
        marker.setLabel(label);
        aisMap.addOverlay(marker);
    }

    //初始化事件
    var initEvent = function () {
        laydate.render({
            elem: '#startTime',
            type: 'datetime',
            format: 'yyyy-MM-dd HH:mm:ss',
        });

        laydate.render({
            elem: '#endTime',
            type: 'datetime',
            format: 'yyyy-MM-dd HH:mm:ss',
        });

        $('#query').click(function () {

            $('#table').bootstrapTable('refresh', {
                pageNumber: 1
            });
        })

        $('#aisQuery').click(function () {
            //设置参数
            var temp = {};

            //计算地理范围坐标
            var gpsRange = $("#aisGpsRange").val();
            if (gpsRange != null) {
                var gpsPair = gpsRange.split(';');
                if (gpsPair.length > 1) {
                    //开始和结束的经纬度同时存在才有意义
                    if (gpsPair[0].split(',').length > 0 && gpsPair[1].split(',').length > 0) {
                        temp.startLongitude = Number(gpsPair[0].split(',')[0]);
                        temp.startLatitude = Number(gpsPair[0].split(',')[1]);
                        temp.endLongitude = Number(gpsPair[1].split(',')[0]);
                        temp.endLatitude = Number(gpsPair[1].split(',')[1]);
                    }
                }
            }

            layer.load(3);
            $.ajax({
                type: 'post',
                url: _path + '/report/getSingleAisList',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(temp),
                success: function (res) {
                    layer.closeAll('loading');
                    aisMap.clearOverlays();
                    for (var i = 0; i < res.length; i++) {
                        var point = new BMap.Point(res[i].longitude, res[i].latitude);
                        addAisMarker(point);
                    }
                }, error: function (xhr, status) {
                    layer.closeAll('loading');
                    //提示层
                    layer.msg("系统出现异常！", {icon: 0});
                }
            });
        })
    };

    //得到查询的参数
    function queryParams(params) {

        var temp = {
            limit: params.limit,    //页面大小
            offset: params.offset,   //页码
            jjm: $('#jjm').val(),
            startTime: $('#startTime').val(),
            endTime: $("#endTime").val()
        };

        //计算地理范围坐标
        var gpsRange = $("#gpsRange").val();
        if (gpsRange != null) {
            var gpsPair = gpsRange.split(';');
            if (gpsPair.length > 1) {
                //开始和结束的经纬度同时存在才有意义
                if (gpsPair[0].split(',').length > 0 && gpsPair[1].split(',').length > 0) {
                    temp.startLongitude = Number(gpsPair[0].split(',')[0]);
                    temp.startLatitude = Number(gpsPair[0].split(',')[1]);
                    temp.endLongitude = Number(gpsPair[1].split(',')[0]);
                    temp.endLatitude = Number(gpsPair[1].split(',')[1]);
                }
            }
        }

        return temp;
    };

    //1.百度地图API功能
    var map = new BMap.Map("map", {
        minZoom: 1,
        maxZoom: 7
    });    // 创建Map实例

    var aisMap = new BMap.Map("aisMap", {
        minZoom: 1,
        maxZoom: 7
    });

    //隐藏百度地图商标
    function hideLog() {

        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();

    }

    // 初始化地图
    var initMap = function () {
        map.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初
        // map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        //map.addControl(new BMap.NavigationControl());   //缩放按钮
        map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]}));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持

        //监听地图缩放
        map.addEventListener("zoomend", function () {
            hideLog();
            if (this.getZoom() > 7) {
                layer.msg("默认只有7级地图, 超过无法显示");
            }
        });

        //地图加载完成
        map.addEventListener("tilesloaded", function () {
            hideLog()
        });

    };

    var initAisMap = function () {
        aisMap.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初
        // map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
        aisMap.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        //map.addControl(new BMap.NavigationControl());   //缩放按钮
        aisMap.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]}));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持

        //监听地图缩放
        aisMap.addEventListener("zoomend", function () {
            hideLog();
            if (this.getZoom() > 7) {
                layer.msg("默认只有7级地图, 超过无法显示");
            }
        });

        //地图加载完成
        aisMap.addEventListener("tilesloaded", function () {
            hideLog()
        });

    };

    function initTable() {
        $('#table').bootstrapTable({
            url: _path + '/report/getAisList',    //请求后台的URL（*）
            method: 'post',                     //请求方式（*）
            contentType: "application/json",
            toolbarAlign: 'right',               //工具栏对齐方式
            buttonsAlign: 'right',               //按钮对齐方式
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                    //是否启用排序
            sortOrder: "asc",                   //排序方式
            sortName: "ID",                  // 排序字段
            queryParams: queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 25,                       //每页的记录行数（*）
            pageList: [25, 50, 100],          //可供选择的每页的行数（*）
            strictSearch: true,
            clickToSelect: true,                //是否启用点击选中行
            height: 580,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            showRefresh: false,                   //刷新按钮
            columns: [{
                field: 'shipStatusStr',
                title: '状态'
            }, {
                field: 'rot',
                title: '转向率'
            }, {
                field: 'sog',
                title: '速度'
            }, {
                field: 'pos_acc',
                title: '定位设备精确度'
            }, {
                field: 'longitude',
                title: '经度'
            }, {
                field: 'latitude',
                title: '纬度'
            }, {
                field: 'etaStr',
                title: '预计到达时间'
            }]
        });
    }

    //装备威力规律
    var powerlawIns = new function () {

        var self = this;

        function initChart(data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('powerlaw_chart'));

            // 指定图表的配置项和数据
            var option = {
                color: ['#3398DB'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: data.x,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '装备威力',
                        type: 'bar',
                        barWidth: '60%',
                        data: data.y
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }

        function initSearch() {
            $("#powerlaw_query").click(function () {
                $.ajax({
                    type: 'post',
                    url: publicCache.path + "/report/powerlaw",
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        ptbh: $.trim($("#powerlaw_ptbh").val()),
                        ptmc: $.trim($("#powerlaw_ptmc").val()),
                        cgqbh: $.trim($("#powerlaw_cgqbh").val()),
                    }),
                    success: function (res) {
                        layer.closeAll('loading');
                        if (res) {
                            debugger
                            initChart(res)
                        }
                    }, error: function (xhr, status) {
                        layer.closeAll('loading');
                        //提示层
                        layer.msg("系统出现异常！", {icon: 0});
                    }
                });
            });
        };

        self.fo = {
            initSearch: initSearch
        }
    }


    // 页面初始化
    $(function () {
        initData();
        initEvent();
        initMap();
        initAisMap();
        powerlawIns.fo.initSearch();
    });
})(_path);