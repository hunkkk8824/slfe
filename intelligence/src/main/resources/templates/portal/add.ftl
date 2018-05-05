
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>数据交换</title>
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

<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">数据交换</li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form action="" method="post">
			  <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">前置机</label>
                  <div class="layui-input-inline" style="width: 300px;">
                    <select name="project">
					  <option></option>
                      <option value="c0001">前置机0001</option>
                      <option value="c0003">前置机0002</option>
                      <option value="c0002">前置机0003</option>
                    </select>
                  </div>
                  
                </div>
              </div>
                
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">数据集</label>
                  <div class="layui-input-inline" style="width: 300px;">
                    <select name="experience">
					  <option></option>
                      <option value="qb_sj_ysmb">情报数据原始目标报表</option>
                      <option value="qb_sj_ysdzztmmb">情报_数据_原始电子战通信目标</option>
                      <option value="qb_sj_ysdzzjgmb">情报_数据_原始电子战激光目标</option>
                      <option value="qb_sj_ysdzzdzzcmb">情报_数据_电子战电子侦察目标表</option>
                    </select>
                  </div>
                  
                </div>
              </div>
              
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit>立即导入</button>
              </div>
            </form>
          </div>
        </div>
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