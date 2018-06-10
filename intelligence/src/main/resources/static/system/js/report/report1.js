(function(_path) {
    /** 通用变量 */
    var publicCache= {};


    //初始化数据
    var initData = function(){
        publicCache.path = _path;
    };

    //初始化事件
    var initEvent = function(){
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
            offset: params.offset   //页码
            //keyword: $('#keyWordInfo').val(),
            //valid: $('#valid').val() ? parseInt($('#valid').val()) : null,

        };
        return temp;
    };


    function initTable(tableUrl,tableColumns) {
        $('#table').bootstrapTable({
            url: url,    //请求后台的URL（*）
            method: 'post',                     //请求方式（*）
            contentType: "application/json",
            toolbarAlign: 'right',               //工具栏对齐方式
            buttonsAlign: 'right',               //按钮对齐方式
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                    //是否启用排序
            sortOrder: "asc",                   //排序方式
            sortName: "userid",                  // 排序字段
            queryParams: queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 25,                       //每页的记录行数（*）
            pageList: [ 25, 50, 100],          //可供选择的每页的行数（*）
            strictSearch: true,
            clickToSelect: true,                //是否启用点击选中行
            height: 580,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
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
        initTable();
    });
})(_path);