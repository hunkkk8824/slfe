<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="${base}/static/portal/res/images/logo.png" alt="layui">
        </a>
        <ul class="layui-nav fly-nav layui-hide-xs">
            <li class="layui-nav-item">
                <a href="${base}/index" target="_blank"><i class="iconfont icon-ui"></i>后台</a>
            </li>
        </ul>

        <ul class="layui-nav fly-nav-user">


            <!-- 登入后的状态 -->

            <li class="layui-nav-item">
                <a class="fly-nav-avatar" href="javascript:;">
                    <cite class="layui-hide-xs">${nickname}</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/logout" style="text-align: center;">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
<div class="fly-panel fly-column">
    <div class="layui-container">
        <ul class="layui-clear">
            <li class="layui-hide-xs layui-this"><a href="/portal/index">首页</a></li>
            <li><a href="/resourcecatalog/index">资源目录</a></li>
            <li><a href="/portal/add">数据交换</a></li>
            <#--<li><a href="">系统运行情况</a></li>-->
            <#--<li><a href="">数据服务监控</a></li>-->
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li>
        </ul>

        <div class="fly-column-right layui-hide-xs">
            <span class="fly-search"><i class="layui-icon"></i></span>
            <a href="/portal/add" class="layui-btn">发布数据交换</a>
        </div>
    </div>
</div>