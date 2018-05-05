<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>多源情报系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="多源情报系统">
  <meta name="description" content="多源情报系统">
  <link rel="stylesheet" href="../../res/layui/css/layui.css">
  <link rel="stylesheet" href="../../res/css/global.css">
</head>
<body>

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="/">
      <img src="../../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
      <li class="layui-nav-item">
        <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>后台</a>
      </li>
    </ul>
    
    <ul class="layui-nav fly-nav-user">

      
      <!-- 登入后的状态 -->
      
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">张山</cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="爱谁谁"></i>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="/user/logout/" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>
<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear">
     <li class="layui-hide-xs layui-this"><a href="/">首页</a></li> 
      <li><a href="jie/index.html">资源目录</a></li> 
      <li><a href="jie/index.html">数据交换</a></li> 
      <li><a href="jie/index.html">系统运行情况</a></li> 
      <li><a href="jie/index.html">数据服务监控</a></li> 
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li> 
    </ul> 
    
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="add.html" class="layui-btn">发布数据交换</a> 
    </div> 
  </div>
</div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel" style="margin-bottom: 0;">
        
        <div class="fly-panel-title fly-filter">
		  <a href="" class="layui-this">全部</a>
          <span class="fly-mid"></span>
          <a href="" >预导入</a>
          <span class="fly-mid"></span>
          <a href="">执行中</a>
          <span class="fly-mid"></span>
          <a href="">导入完成</a>
          <span class="fly-mid"></span>
          <a href="">导入失败</a>
        </div>

        <ul class="fly-list">          
          <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="detail.html">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" link>
                <cite>admin</cite>
              </a>
              <span>时间：2018-05-05 17:38:00</span>
              
              <span class="layui-badge fly-badge-accept layui-hide-xs">待审核</span>
            </div>
            <div class="fly-list-badge">
              <span class="layui-badge layui-bg-black">差</span>
            </div>
          </li>
          <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a class="layui-badge">导入完成</a>
              <a href="detail.html">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" link>
                <cite>admin</cite>
              </a>
              <span>时间：2018-05-05 17:38:00</span>
              
              <span class="layui-badge fly-badge-accept layui-hide-xs">审核通过</span>
            </div>
            <div class="fly-list-badge">
              <span class="layui-badge layui-bg-red">优</span>
            </div>
          </li>
         <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="detail.html">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" link>
                <cite>admin</cite>
              </a>
              <span>时间：2018-05-05 17:38:00</span>
              
              <span class="layui-badge fly-badge-accept layui-hide-xs">待审核</span>
            </div>
            <div class="fly-list-badge">
              <span class="layui-badge layui-bg-black">差</span>
            </div>
          </li>
          <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a class="layui-badge">执行失败</a>
              <a href="detail.html">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" link>
                <cite>admin</cite>
              </a>
              <span>时间：2018-05-05 17:38:00</span>
              
              <span class="layui-badge fly-badge-accept layui-hide-xs">已驳回</span>
            </div>
            <div class="fly-list-badge">
              <span class="layui-badge layui-bg-black">差</span>

            </div>
          </li>
          <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="detail.html">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" link>
                <cite>admin</cite>
              </a>
              <span>时间：2018-05-05 17:38:00</span>
              
              <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>
            </div>
            <div class="fly-list-badge">
              <span class="layui-badge layui-bg-black">差</span>
            </div>
          </li>
        </ul>
        
        <!-- <div class="fly-none">没有相关数据</div> -->
    
        <div style="text-align: center">
          <div class="laypage-main"><span class="laypage-curr">1</span><a href="/jie/page/2/">2</a><a href="/jie/page/3/">3</a><a href="/jie/page/4/">4</a><a href="/jie/page/5/">5</a><span>…</span><a href="/jie/page/148/" class="laypage-last" title="尾页">尾页</a><a href="/jie/page/2/" class="laypage-next">下一页</a></div>
        </div>

      </div>
    </div>
    <div class="layui-col-md4">
      <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">资源分类</dt>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>动向情报表</a>
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报数据原始目标报表</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_原始电子战通信目标</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_原始电子战激光目标</a>
         
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_电子战电子侦察目标表</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_融合目标表</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_人工目标</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_密语表</a>
         
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_技侦态势目标</a>
          
        </dd>
        <dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_多平台水声目标</a>
          
        </dd>
		<dd>
          <a href=""><i class="layui-icon">&#xe60a;</i>情报_数据_多平台电子战目标</a>
          
        </dd>

        <!-- 无数据时 -->
        <!--
        <div class="fly-none">没有相关数据</div>
        -->
      </dl>
      
      <div class="fly-panel fly-link">
        <h3 class="fly-panel-title">友情链接</h3>
        <dl class="fly-panel-main">
          <dd><a href="http://www.baidu.com/" target="_blank">百度</a><dd>
          <dd><a href="http://taobao.com/" target="_blank">淘宝</a><dd>
          <dd><a href="http://js.com/" target="_blank">京东</a><dd>
          <dd><a href="http://news.qq.com" target="_blank">腾讯</a><dd>
          <dd><a href="mailto:xianxin@layui-inc.com?subject=%E7%94%B3%E8%AF%B7Fly%E7%A4%BE%E5%8C%BA%E5%8F%8B%E9%93%BE" class="fly-link">申请友链</a><dd>
        </dl>
      </div>

    </div>
  </div>
</div>

<div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div>

<script src="../../res/layui/layui.js"></script>
<script>
layui.cache.page = 'jie';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>