 
 
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
    <div class="layui-col-md8 content detail">
      <div class="fly-panel detail-box">
        <h1>动向情报数据导入</h1>
        <div class="fly-detail-info">
          <span class="layui-badge">执行中</span>
		  
          <!-- <span class="layui-badge layui-bg-green fly-detail-column">导入成功</span>
          <span class="layui-badge" style="background-color: #999;">预备导入</span>
          <span class="layui-badge" style="background-color: #5FB878;">导入失败</span> -->
          
          <div class="fly-admin-box" data-id="123">
            <span class="layui-btn layui-btn-xs jie-admin" type="del">撤销</span>
            <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="1">编辑</span> 
            <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="1">删除</span>  
          </div>
         
        </div>
        <div class="detail-about">
          <a class="fly-avatar" href="../user/home.html">
            <img src="../../res/images/data.png" alt="创建人">
          </a>
          <div class="fly-detail-user">
            <a href="" class="fly-link">
              <cite>资源编码：QS2018050501001</cite>
            </a>
			
            
          </div>
          <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
            <span style="padding-right: 10px; color: #FF7200">创建人：张山</span>  
			<span style="padding-right: 10px; color: #FF7200">创建时间：2018-05-01 21:10:11</span>  
          </div>
        </div>
        <div class="detail-body photos">
			<div class="layui-elem-quote"> 
				 交换机名称：交换机00001 <br>
				 数据集名称：qb_sj_rhmb <br>
			</div>
            <table class="layui-table"> 
				<tbody> 
					<tr> 
					<td>预导入总数：10000</td> 
					<td>导入成功总数：9870</td> 
					</tr> 
				</tbody> 
			</table>
			
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			  <legend>交换日志</legend>
			</fieldset>
			<ul class="layui-timeline">
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:00 开始同步资源</div>
				  
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 数据验证开始</div>
				  
				  
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 ID[100000000],平台编号不可为空</div>
				  
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 ID[100000002],批号不可为空</div>
				</div>
			  </li>
			   <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 数据验证完成</div>
				</div>
			  </li>
			   <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 开始写入数据</div>
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 写入数据成功</div>
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 预导入数据3条,导入成功1条！</div>
				</div>
			  </li>
			  <li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis"></i>
				<div class="layui-timeline-content layui-text">
				  <div class="layui-timeline-title">2018-05-05 16:26:02 同步结束</div>
				</div>
			  </li>
			  
			  
			</ul>  
        </div>
      </div>
    </div>
	
    <#include "common/right.ftl"/>

  </div>
</div>

<#include "common/footer.ftl"/>

<script src="${base}/static/portal/res/layui/layui.js"></script>
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