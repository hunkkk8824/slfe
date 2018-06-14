<#assign base= request.contextPath />
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
  <!-- Mobile Specific Meta -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Favicon-->
  <link rel="shortcut icon" href="img/fav.png">
  <!-- Author Meta -->
  <meta name="author" content="colorlib">
  <!-- Meta Description -->
  <meta name="description" content="">
  <!-- Meta Keyword -->
  <meta name="keywords" content="">
  <!-- meta character set -->
  <meta charset="UTF-8">
  <!-- Site Title -->
  <title>Travel</title>

  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
  <!--
    CSS
    ============================================= -->
  <link rel="stylesheet" href="${base}/static/system/css/linearicons.css">
  <link rel="stylesheet" href="${base}/static/system/css/font-awesome.min.css">
  <link rel="stylesheet" href="${base}/static/system/css/bootstrap.css">
  <link rel="stylesheet" href="${base}/static/system/css/magnific-popup.css">
  <link rel="stylesheet" href="${base}/static/system/css/jquery-ui.css">
  <link rel="stylesheet" href="${base}/static/system/css/nice-select.css">
  <link rel="stylesheet" href="${base}/static/system/css/animate.min.css">
  <#--<link rel="stylesheet" href="http://at.alicdn.com/t/font_205919_gs446lbdhoyr2j4i.css">-->
  <link rel="stylesheet" href="${base}/static/system/css/swiper.min.css">
  <link rel="stylesheet" href="${base}/static/system/css/bootstrap-table.css">
  <link rel="stylesheet" href="${base}/static/system/css/owl.carousel.css">
  <link rel="stylesheet" href="${base}/static/system/css/main.css">
  <style>
    .tab-content {
      width: 100%;
      height: 500px;
    }

    .price-area {
      margin: 0;
    }

    .readTextarea {
      width: 100%;
      margin-top: 30px;
      border-radius: 6px;
    }

    .keyword {
      display: inline-block;
      height: 38px;
      vertical-align: top;
      line-height: 38px;
      border: 1px solid #343a40;
      padding: 0 10px;
      border-radius: 6px;
      color: #000;
    }

    .key-input {
      width: 300px;
      display: inline-block;
    }
    .key-input.short{
      width: 100px;
    }

    .video-wrapper {
      background-color: #ccc;
      height: 400px;
      margin: 25px 20px;
      box-sizing: border-box;
    }
    .tab-pane{
      width: 100%;
      height: 100%;
    }
    .img-wrapper{
      width: 100%;
      height: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .img-wrapper img{
      width: 30%;
      height: 30%;
    }
    .select-condition{
      border: none;
    }
    .price-area .single-price{
      border: none;
      background: transparent;
      box-shadow: none;
    }
  </style>
</head>

<body>
<#include "../common/header.ftl"/>
  <!-- #header -->

  <!-- Start price Area -->
  <section class="price-area section-gap">
    <div class="container" style="border: 1px solid #ccc;border-radius: 6px;">

      <div class="row">

        <div class="col-lg-12">
          <div class="single-price">
            <h4>目标融合识别</h4>

          </div>
        </div>

        <div class="col-lg-4">
          <div class="select-condition row">
            <div class="col-lg-12" style="margin-top: 20px;">
              <button type="button" style="float: right;" class="genric-btn primary">
                <a href="#">
                  <i class="fa fa-table"></i>
                </a>文本导入</button>
            </div>
            <div class="col-lg-12">
              <textarea class="readTextarea" name="" id="" cols="30" rows="20" readonly="true">
                这是一段只读的文本框
              </textarea>
            </div>
            <div class="col-lg-12" style="margin-top: 20px;">
              <span class="keyword ">关键词</span>
              <input type="text" class="key-input input form-control short">
              <button type="button" style="margin-left: 20px;" class="genric-btn info">
                <a href="#">
                  <i class="fa fa-play"></i>
                </a>开始识别</button>
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="right-content">
            <div class="col-lg-12" style="margin-top: 20px;">
              <select name="" id="" class="default-select key-input">
                <#--<option value="">选择传感器信息</option>-->
                <#--<option value="1">激光</option>-->
              <#--<option value="2">通讯</option>-->
                  <option value="3">光电</option>

              </select>
              <button type="button" style="margin-left: 20px;" class="genric-btn info">
                <a href="#">
                  <i class="fa fa-play"></i>
                </a>融合识别</button>
            </div>
          </div>
          <ul class="nav nav-tabs">
            <li>
              <a href="#tab1" data-toggle="tab" class="active">图片</a>
            </li>
            <#--<li>-->
              <#--<a href="#tab2" data-toggle="tab">视频</a>-->
            <#--</li>-->
            <#--<li>-->
              <#--<a href="#tab3" data-toggle="tab">表格</a>-->
            <#--</li>-->
          </ul>
          <div class="tab-content">
            <div class="tab-pane fade active show" id="tab1">
              <div class="col-lg-12 img-wrapper">
                <img src="${base}/static/system/img/b2.jpg" alt="">
                <img src="${base}/static/system/img/b1.jpg" alt="">
                <img src="${base}/static/system/img/b3.jpg" alt="">
              </div>
            </div>
            <div class="tab-pane fade" id="tab2">
              <div class="select-condition row">

                <div class="col-lg-12 wrapper">
                  <div class="video-wrapper">
                  </div>
                </div>
              </div>

            </div>
            <div class="tab-pane fade" id="tab3">
              <table class="table table-hover statics-table" ></table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End price Area -->


  <!-- start footer Area -->
<#include "../common/footer.ftl"/>
  <!-- End footer Area -->

  <script src="${base}/static/system/js/vendor/jquery-2.2.4.min.js"></script>
  <script src="${base}/static/system/js/popper.min.js"></script>
  <script src="${base}/static/system/js/vendor/bootstrap.min.js"></script>
  <script src="${base}/static/system/js/jquery-ui.js"></script>
  <script src="${base}/static/system/js/easing.min.js"></script>
  <script src="${base}/static/system/js/swiper.min.js"></script>
  <script src="${base}/static/system/js/hoverIntent.js"></script>
  <script src="${base}/static/system/js/superfish.min.js"></script>
  <script src="${base}/static/system/js/bootstrap-treeview.js"></script>
  <script src="${base}/static/system/js/bootstrap-table-zh-CN.js"></script>
  <script src="${base}/static/system/js/bootstrap-table.js"></script>
  <script src="${base}/static/system/js/jquery.ajaxchimp.min.js"></script>
  <script src="${base}/static/system/js/jquery.magnific-popup.min.js"></script>
  <script src="${base}/static/system/js/jquery.nice-select.min.js"></script>



  <script type="text/javascript" src="${base}/static/system/js/echarts4.min.js"></script>
  <script type="text/javascript" src="${base}/static/system/js/china.js"></script>

  <script src="${base}/static/system/js/owl.carousel.min.js"></script>
  <script src="${base}/static/system/js/mail-script.js"></script>
  <script src="${base}/static/system/js/report/tabpage.js"></script>
</body>

</html>