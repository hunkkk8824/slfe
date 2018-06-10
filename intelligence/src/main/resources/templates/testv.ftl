<!DOCTYPE html>

<html lang="en">
<head>

<#include "head.ftl">

    <title>多源情报系统-测试</title>
</head>

<body>
<div id="map_demo"></div>
</body>
<script type="text/javascript">
    // // 百度地图API功能
    // var map = new BMap.Map("map_demo");    // 创建Map实例
    // map.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初始化地图,设置中心点坐标和地图级别
    // map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！
    // map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    // map.addControl(new BMap.NavigationControl());   //缩放按钮
    // map.addControl(new BMap.MapTypeControl( {mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]} ));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持
    //
    // //监听地图缩放
    // map.addEventListener("zoomend", function(){
    //     if( this.getZoom() > 12 ) {
    //         layer.msg("默认只有12级地图, 超过无法显示");
    //     }
    // });
    //
    // var cr = new BMap.CopyrightControl({anchor: BMAP_ANCHOR_TOP_LEFT});   //设置版权控件位置
    // map.addControl(cr); //添加版权控件
    // var bs = map.getBounds();   //返回地图可视区域
    // cr.addCopyright({id: 1, content: "<a href='http://www.xiaoguo123.com/p/baidumap_offline_v21?baidumap' style='font-size:20px;background:yellow;margin-left:60px'>离线地图API V2.1, 默认8级地图, 点击获取更多信息</a>", bounds: bs});

</script>
</html>
