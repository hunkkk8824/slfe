
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>数据交换</title>
  <#include "portalHead.ftl"/>
</head>
<body>

<#include "common/header.ftl"/>

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