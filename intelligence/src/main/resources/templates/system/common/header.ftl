<header id="header" class="header-scrolled">
    <div class="header-top">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-sm-6 col-6 header-top-left">
                    <ul>
                        <li><a href="#">${nickname}</a></li>
                        <li><a href="${base}/logout">登出</a></li>
                    </ul>
                </div>
                <div class="col-lg-6 col-sm-6 col-6 header-top-right">
                    <div class="header-social">
                        <a href="${base}/manageindex">后台管理</i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="${base}/manageindex"><img src="${base}/static/system/img/logo.png" alt="" title="" style="height: 35px;"/></a>
                <span class="system-name">多源情报信息交叉分析工具开发平台</span>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="${base}/index">首页</a></li>
                    <li><a href="${base}/resourcecatalog/index">资源目录</a></li>
                    <li><a href="${base}/portal/add">数据交换</a></li>
                <#--${base}/system/add-->
                    <li class="menu-has-children"><a href="">数据应用</a>
                        <ul>
                            <li><a href="${base}/report/report1">装备能力分析</a></li>
                            <li><a href="${base}/report/targetActivityRule">目标活动规律</a></li>
                            <li><a href="${base}/report/aisReport">航道提取分析</a></li>
                            <li><a href="blog-single.html">目标融合识别</a></li>
                            <li><a href="blog-single.html">知识提取</a></li>
                        </ul>
                    </li>
                </ul>
            </nav><!-- #nav-menu-container -->
        </div>
    </div>
</header><!-- #header -->