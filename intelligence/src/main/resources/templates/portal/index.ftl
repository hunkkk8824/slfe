<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>多源情报系统</title>
  <#include "portalHead.ftl"/>
</head>
<body>

<#include "common/header.ftl"/>

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
            <a href="" class="fly-avatar">
              <img src="${base}/static/portal/res/images/data.png" >
            </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="${base}/portal/detail">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="" link>
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
              <a href="" class="fly-avatar">
                  <img src="${base}/static/portal/res/images/data.png" >
              </a>
            <h2>
              <a class="layui-badge">导入完成</a>
              <a href="${base}/portal/detail">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="" link>
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
             <a href="" class="fly-avatar">
                 <img src="${base}/static/portal/res/images/data.png" >
             </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="${base}/portal/detail">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="" link>
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
              <a href="" class="fly-avatar">
                  <img src="${base}/static/portal/res/images/data.png" >
              </a>
            <h2>
              <a class="layui-badge">执行失败</a>
              <a href="${base}/portal/detail">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="" link>
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
              <a href="" class="fly-avatar">
                  <img src="${base}/static/portal/res/images/data.png" >
              </a>
            <h2>
              <a class="layui-badge">执行中</a>
              <a href="${base}/portal/detail">动向情报数据导入</a>
            </h2>
            <div class="fly-list-info">
              <a href="" link>
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
          <div class="laypage-main">
              <span class="laypage-curr">1</span>
              <a href="${base}/jie/page/2/">2</a>
              <a href="${base}/jie/page/3/">3</a>
              <a href="${base}/jie/page/4/">4</a>
              <a href="${base}/jie/page/5/">5</a>
              <span>…</span>
              <a href="${base}/jie/page/148/" class="laypage-last" title="尾页">尾页</a>
              <a href="${base}/jie/page/2/" class="laypage-next">下一页</a>
          </div>
        </div>

      </div>
    </div>
  <#include "common/right.ftl"/>
  </div>
</div>

<#include "common/footer.ftl"/>

<script>
    layui.config({
        version: "3.0.0"
        ,base: '${base}/static/portal/res/mods/'
    }).extend({
        fly: 'index'
    }).use(['fly', 'face'], function(){
        var $ = layui.$
                ,fly = layui.fly;
        //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
        /*
        $('.detail-body').each(function(){
          var othis = $(this), html = othis.html();
          othis.html(fly.content(html));
        });
        */
    });

</script>

</body>
</html>