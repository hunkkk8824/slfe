
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
                    <select name="exchanger" id="exchanger">
					  <option></option>
                      <#list exchangerPOs as exchanger>
                          <option value="${exchanger.code}" data-exchangerid="${exchanger.id}">${exchanger.name}</option>
                      </#list>
                    </select>
                  </div>
                  
                </div>
              </div>
                
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">数据集</label>
                  <div class="layui-input-inline" style="width: 300px;">
                    <select name="dataset" id="dataset">
					  <option></option>
                      <#list dataSets as dataset>
                          <option value="${dataset.value}">${dataset.displayName}</option>
                      </#list>
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

    $(function(){
        $("#exchanger").on("change",function(){
            var exchangerId = $("#exchanger option:selected").data('exchangerid');
            console.log("-------",exchangerId);
            $.get("/portal/getDatasetByExchangerId", { exchangerId: exchangerId },function(){

            } );
        });
    });


</script>

</body>
</html>