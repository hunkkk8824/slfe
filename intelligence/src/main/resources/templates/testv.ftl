<#assign base= request.contextPath />
<!DOCTYPE html>

<html lang="en">
<head>

    <style type="text/css">
        body, html, #map_demo, #tab, #mapfrm {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }

        #menu {
            height: 100%;
            overflow-y: auto
        }

        td {
            font-size: 14px
        }

        h4 {
            margin: 0;
        }
    </style>
    <script src="${base}/static/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
    <script src="${base}/static/js/plugins/layer/layer.min.js"></script>
    <!--离线地图-->
    <script type="text/javascript" src="${base}/static/js/plugins/offlinemap/map_load.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/js/plugins/offlinemap/css/map.css"/>

    <title>多源情报系统-地图测试</title>
</head>

<body>
<div id="map_demo"></div>
</body>
<script type="text/javascript">

    //1.百度地图API功能
    var map = new BMap.Map("map_demo");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初
    map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    //map.addControl(new BMap.NavigationControl());   //缩放按钮
    map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]}));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持

    //监听地图缩放
    map.addEventListener("zoomend", function () {
        hideLog();
        if (this.getZoom() > 12) {
            layer.msg("默认只有12级地图, 超过无法显示");
        }
    });


    //随机向地图添加25个标注
    function addMarker(point) {
        var marker = new BMap.Marker(point);
        var label = new BMap.Label("祖国的心脏", {offset: new BMap.Size(20, -10)});
        marker.setLabel(label);
        map.addOverlay(marker);
    }

    var bounds = map.getBounds();
    var sw = bounds.getSouthWest();
    var ne = bounds.getNorthEast();
    var lngSpan = Math.abs(sw.lng - ne.lng);
    var latSpan = Math.abs(ne.lat - sw.lat);
    for (var i = 0; i < 25; i++) {
        var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
        addMarker(point);
    }

    //隐藏百度地图商标
    function hideLog() {

        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();

    }

    //地图加载完成
    map.addEventListener("tilesloaded", function () {
        hideLog()
    });
</script>
</html>
