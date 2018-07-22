(function (_path) {
    /** 通用变量 */
    var publicCache = {};


    //初始化数据
    var initData = function () {
        publicCache.path = _path;
    };

    //初始化事件
    var initEvent = function () {

        $(window).resize(function () {
            $('#table').bootstrapTable('resetView');
        });

        $('#query').click(function () {
            //$('#table').bootstrapTable('refresh', {
            //    pageNumber: 1
            //});
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

    //添加标注
    function addMarker(points) {

        if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
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
        } else {
            layer.msg('请在chrome、safari、IE8+以上浏览器查看本示例');
        }
    }

    function initMarker(data) {

        map.clearOverlays();

        var points = [];  // 添加海量点数据
        for (var i = 0; i < data.length; i++) {
            points.push(new BMap.Point(data[i].jd, data[i].wd));
        }

        addMarker(points);
    }

    // 初始化地图
    var initMap = function () {
        map.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初
        map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
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


    //装备能力分析饼图
    function initChart(data) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('powerlaw_chart'));

        debugger
        var option = {
            title: {
                text: '装备能力分析',
                subtext: 'JL(距离)数目统计',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: data.titleList
            },
            series: [
                {
                    name: '装备能力分析',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: data.dataList,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
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
                    initChart(res[0].chartDataMap);
                }
            }, error: function (xhr, status) {
                layer.closeAll('loading');
                //提示层
                layer.msg("系统出现异常！", {icon: 0});
            }
        });
    }

    function doSearch() {
        var searchType = $('#searchType').val();
        var searchValue = $('#searchValue').val();
        var dataSetCode = $('#dataSetCode').val();
        if (!searchType) {
            layer.msg("请选择统计类型", {icon: 0});
            return false;
        }
        if (!searchValue) {
            layer.msg("请选择统计值", {icon: 0});
            return false;
        }
        if (!dataSetCode) {
            layer.msg("请选择数据集", {icon: 0});
            return false;
        }

        // 查询表数据
        getColumnsByDataSetCode(dataSetCode, initTable);
        // 查询地图数据
        var params = {
            tableName: dataSetCode
        };
        if ("cgqbh" == searchType) {
            params.cgqbh = searchValue;
        } else if ("ptbh" == searchType) {
            params.ptbh = searchValue;
        } else {
            params.ptlx = searchValue;
        }
        initChartMap(params);
    }

    //根据表名称或列设置
    function getColumnsByDataSetCode(code, callBack) {
        var url = publicCache.path + "/dataQuality/getColumnsByDataSetCode?v=" + new Date();
        $.get(url, {
            dataSetCode: code,//表名称
        }, function (data) {

            debugger
            if (callBack) {
                callBack(data);
            }

        });
    }

    //得到查询的参数
    function queryParams(params) {
        var searchType = $('#searchType').val();
        var searchValue = $('#searchValue').val();
        var dataSetCode = $('#dataSetCode').val();

        var temp = {
            limit: params.limit,    //页面大小
            offset: params.offset,   //页码
            tableName: dataSetCode
        };
        if ("cgqbh" == searchType) {
            temp.cgqbh = searchValue;
        } else if ("ptbh" == searchType) {
            temp.ptbh = searchValue;
        } else {
            temp.ptlx = searchValue;
        }
        return temp;
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
            height: 580,                          //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            showRefresh: false,                   //刷新按钮
            columns: tableColumns
        });
    }


    // 页面初始化
    $(function () {
        initData();
        initEvent();
        initMap();
        initChart({
            "dataList": [
                {"name": "80km-90km区间", "value": "0"},
                {"name": "90km-100km区间", "value": "0"},
                {"name": "100km以上区间", "value": "0"}],
            "x": [],
            "y": [],
            "titleList": ["80km-90km区间", "90km-100km区间", "100km以上区间"]
        });
    });
})(_path);