<div class="layui-col-md4">
    <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">资源分类</dt>
    <#list dataSetCodeEnums as item>
        <dd>
            <a target="_blank" href="${base}/resourcecatalog/index?defaultdataSetCode=${item.getValue()}"><i class="layui-icon">&#xe60a;</i>${item.getDisplayName()}</a>
        </dd>

    </#list>


        <!-- 无数据时 -->
        <!--
        <div class="fly-none">没有相关数据</div>
        -->
    </dl>

    <#--<div class="fly-panel fly-link">-->
        <#--<h3 class="fly-panel-title">友情链接</h3>-->
        <#--<dl class="fly-panel-main">-->
            <#--<dd><a href="http://www.baidu.com/" target="_blank">百度</a><dd>-->
            <#--<dd><a href="http://taobao.com/" target="_blank">淘宝</a><dd>-->
            <#--<dd><a href="http://js.com/" target="_blank">京东</a><dd>-->
            <#--<dd><a href="http://news.qq.com" target="_blank">腾讯</a><dd>-->
            <#--<dd><a href="mailto:xianxin@layui-inc.com?subject=%E7%94%B3%E8%AF%B7Fly%E7%A4%BE%E5%8C%BA%E5%8F%8B%E9%93%BE" class="fly-link">申请友链</a><dd>-->
        <#--</dl>-->
    <#--</div>-->

</div>