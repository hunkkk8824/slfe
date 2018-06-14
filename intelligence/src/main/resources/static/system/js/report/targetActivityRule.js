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
    var map = new BMap.Map("map",{
        minZoom : 1,
        maxZoom : 7
    });    // 创建Map实例

    //隐藏百度地图商标
    function hideLog() {

        $('a[title="到百度地图查看此区域"]').hide();
        $('span[_cid="1"]').hide();

    }

    //添加标注
    function addMarker(point, isCgq, labelName) {
        var marker;
        if (isCgq) {
            //var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png",
            //    new BMap.Size(23, 25), {
            //        offset: new BMap.Size(10, 25),
            //        imageOffset: new BMap.Size(0, 0 -  index * 25)
            //
            //    });
            //var marker = new BMap.Marker(point, { icon: myIcon });
            marker = new BMap.Marker(point);
        } else {
            marker = new BMap.Marker(point);
        }
        var label = new BMap.Label(labelName, {offset: new BMap.Size(20, -10)});
        marker.setLabel(label);
        map.addOverlay(marker);
    }

    function initMarker(data) {
        map.clearOverlays();
        $.each(data, function (i, obj) {
            debugger
            var point = new BMap.Point(obj.jd, obj.wd);
            addMarker(point, obj.isCgq, obj.bz);
        });
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
            if (this.getZoom() > 7) {
                layer.msg("默认只有7级地图, 超过无法显示");
            }
        });

        //地图加载完成
        map.addEventListener("tilesloaded", function () {
            hideLog()
        });

    };

    function doSearch() {

        var dataSetCode = $('#dataSetCode').val();


        if (!dataSetCode) {
            layer.msg("请选择数据集", {icon: 0});
            return false;
        }
        getColumnsByDataSetCode(dataSetCode, initTable);

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
        var dataSetCode = $('#dataSetCode').val(),
            jjm = $("#jjm").val(),
            jxh = $("#jxh").val(),
            jmbz = $("#jmbz").val();

        var temp = {
            limit: params.limit,    //页面大小
            offset: params.offset ,   //页码
            tableName: dataSetCode,
            jjm: jjm,//机舰名
            jxh: jxh,//机弦号
            jmbz: jmbz,//军民标识,
            sbsjStartTime: $("#sbsjStartTime").val(),
            sbsjEndTime: $("#sbsjEndTime").val()
        };

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
            height: 480,                          //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            showRefresh: false,                   //刷新按钮
            columns: tableColumns,
            onLoadSuccess:function (res) {

                var allTableData = $('#table').bootstrapTable('getData');//获取表格的所有内容行
                initMarker(allTableData);
            }
        });
    }


    // 页面初始化
    $(function () {
        initData();
        initEvent();
        initMap();
    });
})(_path);