<!DOCTYPE html>
<html>

<head>

<#include "head.ftl">
    <title>多源情报系统-首页</title>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>

        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="${base}/static/img/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                        <span class="block m-t-xs"><strong class="font-bold">${nickname}</strong></span>
                                        <span class="text-muted text-xs block">${userName}</span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">多源情报系统
                    </div>
                </li>
            <#list menuList as menu>

                <#if menu.parentId==1>
                    <li>
                        <a class="J_menuItem" href="${base}${menu.url}" data-index="1">
                            <i class="${menu.icon}"></i>
                        ${menu.name}</a>
                    </li>

                </#if>


            </#list>


                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/user/index" data-index="1">-->
                        <#--<i class="fa fa-user"></i>-->
                        <#--用户管理</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/role/index" data-index="2">-->
                        <#--<i class="fa fa-users"></i>-->
                        <#--角色管理</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/dataQuality/index?menutype=1" data-index="3">-->
                        <#--<i class="fa fa-database"></i>-->
                        <#--数据质量管理</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/exchangeConfig/index" data-index="4">-->
                        <#--<i class="fa fa-gears"></i>-->
                        <#--交换配置</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/dataQuality/index?menutype=2" data-index="5">-->
                        <#--<i class="fa fa-random"></i>-->
                        <#--交换日志</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/monitorLog/index" data-index="6">-->
                        <#--<i class="fa fa-eye"></i>-->
                        <#--监控日志</a>-->
                <#--</li>-->

                <#--<li>-->
                    <#--<a class="J_menuItem" href="${base}/resourcecatalog/index" data-index="7">-->
                        <#--<i class="fa fa-columns"></i>-->
                        <#--资源目录</a>-->
                <#--</li>-->


                <li>
                    <a target="_blank" href="${base}/index">

                        进入门户页</a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">

        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="${base}/resourcecatalog/index">数据质量管理</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${base}/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${base}/resourcecatalog/index" frameborder="0"
                    data-id="${base}/resourcecatalog/index" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right"> &copy; 2018 All Rights Reserved. 多源情报系统</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->

</div>


<!-- 自定义js -->
<script src="${base}/static/js/hplus.js"></script>
<script src="${base}/static/js/contabs.js" type="text/javascript"></script>

<!-- 第三方插件 -->
<script src="${base}/static/js/plugins/pace/pace.min.js"></script>
</body>

</html>
