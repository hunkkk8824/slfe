(function(_path) {
    /** 通用变量 */
    var publicCache= {};


    //初始化数据
    var initData = function(){
        publicCache.path = _path;
    };

    //初始化事件
    var initEvent = function(){
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
        if(gpsRange!=null){
            var gpsPair = gpsRange.split(';');
            if(gpsPair.length>1){
                //开始和结束的经纬度同时存在才有意义
                if(gpsPair[0].split(',').length>0 && gpsPair[1].split(',').length>0){
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
    var map = new BMap.Map("map");    // 创建Map实例

    //隐藏百度地图商标
    function hideLog() {

        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();

    }

    // 初始化地图
    var initMap = function(){
        map.centerAndZoom(new BMap.Point(116.404, 39.915), 7);  // 初
        map.setCurrentCity("武汉");          // 设置地图中心显示的城市 new！始化地图,设置中心点坐标和地图级别
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        //map.addControl(new BMap.NavigationControl());   //缩放按钮
        map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]}));   //添加地图类型控件 离线只支持普通、卫星地图; 三维不支持

        //监听地图缩放
        map.addEventListener("zoomend", function () {
            hideLog();
            if (this.getZoom() > 7) {
                layer.msg("默认只有12级地图, 超过无法显示");
            }
        });

        //地图加载完成
        map.addEventListener("tilesloaded", function () {
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
            pageList: [ 25, 50, 100],          //可供选择的每页的行数（*）
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


    // 页面初始化
    $(function () {
        initData();
        initEvent();
        initMap();
    });
})(_path);