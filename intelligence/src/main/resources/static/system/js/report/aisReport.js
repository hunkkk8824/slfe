(function (_path) {
    /** 通用变量 */
    var publicCache = {};
    var map = new BMap.Map("gpsMap", {
        minZoom: 1,
        maxZoom: 7
    });


    //初始化数据
    var initData = function () {
        publicCache.path = _path;
        //地图初始化
        map.centerAndZoom(new BMap.Point(121.55, 24.94), 7);  // 初
        // map.setCurrentCity("台北");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
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
            hideLog();
        });

        //初始化地图点数据
        // var point = new BMap.Point(122.2998046875,26.3918696718);
        // addMarker(point);
        // var bounds = map.getBounds();
        // var sw = bounds.getSouthWest();
        // var ne = bounds.getNorthEast();
        // var lngSpan = Math.abs(sw.lng - ne.lng);
        // var latSpan = Math.abs(ne.lat - sw.lat);
        // for (var i = 0; i < 25; i++) {
        //     var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
        //     addMarker(point);
        // }


    };

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

    //隐藏log
    var hideLog = function (point) {
        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();
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
        });

        $("#fenxi").click(function () {

            var strokeColor=['','green','red','yellow'];
            var rows = $('#table').bootstrapTable('getData');
            var reqPoints = [];
            $.each(rows, function (i, n) {
                reqPoints.push({longitude: n.longitude, latitude: n.latitude});
            });

            $.ajax({
                type: "POST",
                url: _path + '/report/getAirwayData',
                data: JSON.stringify({
                    points: reqPoints
                }),
                dataType: "json",
                contentType: 'application/json',
                success: function (data) {

                    if (!data) {
                        return;
                    }

                    map.centerAndZoom(new BMap.Point(data[0][0].x, data[0][0].y), 5);  // 初
                    $.each(data, function (i, p) {

                        var points = [];
                        $.each(p, function (i, n) {
                            points.push(new BMap.Point(n.x, n.y));
                        });

                        debugger
                        var curve = new BMapLib.CurveLine(points, {
                            strokeColor: strokeColor[parseInt(3*Math.random())+1],
                            strokeWeight: 3,
                            strokeOpacity: 0.5
                        }); //创建弧线对象
                        map.addOverlay(curve); //添加到地图中
                    });



                }
            });



        });
    };

    //得到查询的参数
    function queryParams(params) {

        var temp = {
            limit: params.limit,    //页面大小
            offset: params.offset,   //页码
            resourceName: $('#resourceName').val(),
            startTime: $('#startTime').val(),
            endTime: $("#endTime").val(),
            shipType: $("#shipType").val(),
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
            height: 480,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
            }, {
                field: 'destid',
                title: '目的港ID'
            }, {
                field: 'srcid',
                title: '数据源标识'
            }, {
                field: 'distance',
                title: '到目的港剩余距离'
            }, {
                field: 'speed',
                title: '平均航速'
            }, {
                field: 'draught',
                title: '吃水'
            }, {
                field: 'shipTypeStr',
                title: '船舶类型'
            }],
            onLoadSuccess: function (data) {


                map.clearOverlays();
                // showAirwayData(); //航线地图显示
                if (data != null && data.rows != null && data.rows.length > 0) {

                    var points = [];  // 添加海量点数据
                    for (var i = 0; i < data.rows.length; i++) {
                        points.push(new BMap.Point(data.rows[i].longitude, data.rows[i].latitude));
                    }
                    addMarker(points);
                }
            }
        });
    }

    //航线地图显示
    function showAirwayData() {

        $.post(_path + '/report/getAirwayData', function (data) {

            debugger
            var points = [];
            $.each(data, function (i, n) {
                points.push(new BMap.Point(n.longitude, n.latitude));
            });

            var curve = new BMapLib.CurveLine(points, {strokeColor: "green", strokeWeight: 1, strokeOpacity: 0.3}); //创建弧线对象
            map.addOverlay(curve); //添加到地图中
        });

    }

    // 页面初始化
    $(function () {
        initData();
        initEvent();
        initTable();
    });
})(_path);