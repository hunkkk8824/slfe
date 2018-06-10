$(document).ready(function() {
  "use strict";
  

  var window_width = $(window).width(),
      window_height = window.innerHeight,
      header_height = $(".default-header").height(),
      header_height_static = $(".site-header.static").outerHeight(),
      fitscreen = window_height - header_height;

  $(".fullscreen,.banner-area, .swiper-wrapper").css("height", window_height)
  $(".fitscreen").css("height", fitscreen);

  var mySwiper = new Swiper ('.swiper-container', {
    loop: true,
    
    // 如果需要分页器
    pagination: {
      el: '.swiper-pagination',
    },
    
    // 如果需要前进后退按钮
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    
  })       

  if (document.getElementById("chart1")) {

    // 地图部分
    var mapChart = echarts.init(document.getElementById("chart1"));
  
    var mapoption = {
      title: {
        x: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        x: 'left',
        data: ['车辆分部', '报警分部']
      },
      bmap: {
        center: [104.114129, 37.550339],
        zoom: 5,
        roam: true,
        mapStyle: {
          styleJson: [{
              "featureType": "water",
              "elementType": "all",
              "stylers": {
                "color": "#044161"
              }
            },
            {
              "featureType": "land",
              "elementType": "all",
              "stylers": {
                "color": "#004981"
              }
            },
            {
              "featureType": "boundary",
              "elementType": "geometry",
              "stylers": {
                "color": "#064f85"
              }
            },
            {
              "featureType": "railway",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "highway",
              "elementType": "geometry",
              "stylers": {
                "color": "#004981"
              }
            },
            {
              "featureType": "highway",
              "elementType": "geometry.fill",
              "stylers": {
                "color": "#005b96",
                "lightness": 1
              }
            },
            {
              "featureType": "highway",
              "elementType": "labels",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "arterial",
              "elementType": "geometry",
              "stylers": {
                "color": "#004981"
              }
            },
            {
              "featureType": "arterial",
              "elementType": "geometry.fill",
              "stylers": {
                "color": "#00508b"
              }
            },
            {
              "featureType": "poi",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "green",
              "elementType": "all",
              "stylers": {
                "color": "#056197",
                "visibility": "off"
              }
            },
            {
              "featureType": "subway",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "manmade",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "local",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "arterial",
              "elementType": "labels",
              "stylers": {
                "visibility": "off"
              }
            },
            {
              "featureType": "boundary",
              "elementType": "geometry.fill",
              "stylers": {
                "color": "#029fd4"
              }
            },
            {
              "featureType": "building",
              "elementType": "all",
              "stylers": {
                "color": "#1a5787"
              }
            },
            {
              "featureType": "label",
              "elementType": "all",
              "stylers": {
                "visibility": "off"
              }
            }
          ]
        }
      },
      series: [{
          name: '车辆分部',
          type: 'map',
          mapType: 'china',
          roam: false,
          //type: 'scatter',
          //coordinateSystem: 'bmap',
          itemStyle: {
            normal: {
              label: {
                show: true
              }
            },
            emphasis: {
              label: {
                show: true
              }
            }
          },
          data: [{
              name: '北京',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '天津',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '上海',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '重庆',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '河北',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '河南',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '云南',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '辽宁',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '黑龙江',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '湖南',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '安徽',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '山东',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '新疆',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '江苏',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '浙江',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '江西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '湖北',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '广西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '甘肃',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '山西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '内蒙古',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '陕西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '吉林',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '福建',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '贵州',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '广东',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '青海',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '西藏',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '四川',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '宁夏',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '海南',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '台湾',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '香港',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '澳门',
              value: Math.round(Math.random() * 1000)
            }
          ]
        },
        {
          name: '报警分部',
          type: 'map',
          mapType: 'china',
          itemStyle: {
            normal: {
              label: {
                show: true
              }
            },
            emphasis: {
              label: {
                show: true
              }
            }
          },
          data: [{
              name: '北京',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '天津',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '上海',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '重庆',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '河北',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '安徽',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '新疆',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '浙江',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '江西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '山西',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '内蒙古',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '吉林',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '福建',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '广东',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '西藏',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '四川',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '宁夏',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '香港',
              value: Math.round(Math.random() * 1000)
            },
            {
              name: '澳门',
              value: Math.round(Math.random() * 1000)
            }
          ]
        }
      ]
    };
  
    mapChart.setOption(mapoption);
    $(window).resize(mapChart.resize);
  }

  if (document.getElementById("chart2")) {

    var pieChart = echarts.init(document.getElementById("chart2"));
    var pieoption = {
      title: {
        text: '月考核指数',
        textStyle: {
          color: '#fff',
        }
      },
      tooltip: {
        show: false
      },
      xAxis: {
        data: ['合格率', '入网率', '上线率', '完整率', '漂移率'],
        axisLabel: {
          textStyle: {
            color: '#fff',
            fontWeight: '80'
          }
        }
      },
      yAxis: {
        axisLabel: {
          formatter: function (value, index) {
            var txt = Math.round(value * 100) / 100 + '%';
            return txt;
          },
          textStyle: {
            color: '#fff',
            fontWeight: '80'
          }
        }
      },
      series: [{
        name: '五率',
        type: 'bar',
        data: [100, 98.43, 95.9, 83.48, 8.92],
        label: {
          show: true,
          position: 'top',
          formatter: function (v) {
            var val = v.data;
            if (val == 0) {
              return '';
            }
            var txt = Math.round(val * 100) / 100 + '%';
            return txt;
          }
        },
      }],
      color: ['#83bff6']
    };
  
    pieChart.setOption(pieoption);
    $(window).resize(pieChart.resize);
  }


  $('.statics-table').bootstrapTable({
    columns: [
      {
        field: 'id1',
        title: 'column1'
      },
      {
        field: 'id2',
        title: 'column3'
      },
      {
        field: 'id3',
        title: 'column3'
      },
      {
        field: 'id4',
        title: 'column4'
      },
    ],
    data: [
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
      { id1: 'data1',id2: 'data2',id3: 'data3',id4: 'data4'},
    ],
    sidePagination: "client",
    pageNumber: 1,
    pageSize: 15,
    height: 550,
    pagination: true,
    align: 'center',
    onPostBody: function () {
      $('.deal-icon.view').on('click', function () {
        layer.open({
          type: 1,
          content: $('.common-dialog-watch'),
          area: ['912px', '642px'],
          title: '弹框优化',
          shade: 0
        });
      });
    }
  });

  // ------- Datepicker  js --------//  

    $( function() {
      $( ".date-picker" ).datepicker();
    } );


  //------- Niceselect  js --------//  

  if (document.getElementById("default-select")) {
      $('select').niceSelect();
  };
  if (document.getElementById("default-select2")) {
      $('select').niceSelect();
  };
  if (document.getElementById("service-select")) {
      $('select').niceSelect();
  };    

  //------- Lightbox  js --------//  

  $('.img-gal').magnificPopup({
      type: 'image',
      gallery: {
          enabled: true
      }
  });

  $('.play-btn').magnificPopup({
      type: 'iframe',
      mainClass: 'mfp-fade',
      removalDelay: 160,
      preloader: false,
      fixedContentPos: false
  });

  //------- Superfish nav menu  js --------//  

  $('.nav-menu').superfish({
      animation: {
          opacity: 'show'
      },
      speed: 400
  });



  //------- Owl Carusel  js --------//  

  $('.active-hot-deal-carusel').owlCarousel({
      items:1,
      loop:true,
      autoplay:true,
      autoplayHoverPause: true,        
      smartSpeed:500,          
      margin:30,
      dots: true
  });

   $('.active-testimonial').owlCarousel({
          items: 2,
          loop: true,
          margin: 30,
          autoplayHoverPause: true,
          smartSpeed:500,              
          dots: true,
          autoplay: true,
          responsive: {
              0: {
                  items: 1
              },
              480: {
                  items: 1,
              },
              992: {
                  items: 2,
              }
          }
      });


      $('.active-recent-blog-carusel').owlCarousel({
          items: 3,
          loop: true,
          margin: 30,
          dots: true,
          autoplayHoverPause: true, 
          smartSpeed:500,               
          autoplay: true,
          responsive: {
              0: {
                  items: 1
              },
              480: {
                  items: 1,
              },
              768: {
                  items: 2,
              },
              961: {
                  items: 3,
              }
          }
      }); 

  //------- Mobile Nav  js --------//  

  if ($('#nav-menu-container').length) {
      var $mobile_nav = $('#nav-menu-container').clone().prop({
          id: 'mobile-nav'
      });
      $mobile_nav.find('> ul').attr({
          'class': '',
          'id': ''
      });
      $('body .main-menu').append($mobile_nav);
      $('body .main-menu').prepend('<button type="button" id="mobile-nav-toggle"><i class="lnr lnr-menu"></i></button>');
      $('body .main-menu').append('<div id="mobile-body-overly"></div>');
      $('#mobile-nav').find('.menu-has-children').prepend('<i class="lnr lnr-chevron-down"></i>');

      $(document).on('click', '.menu-has-children i', function(e) {
          $(this).next().toggleClass('menu-item-active');
          $(this).nextAll('ul').eq(0).slideToggle();
          $(this).toggleClass("lnr-chevron-up lnr-chevron-down");
      });

      $(document).on('click', '#mobile-nav-toggle', function(e) {
          $('body').toggleClass('mobile-nav-active');
          $('#mobile-nav-toggle i').toggleClass('lnr-cross lnr-menu');
          $('#mobile-body-overly').toggle();
      });

          $(document).on('click', function(e) {
          var container = $("#mobile-nav, #mobile-nav-toggle");
          if (!container.is(e.target) && container.has(e.target).length === 0) {
              if ($('body').hasClass('mobile-nav-active')) {
                  $('body').removeClass('mobile-nav-active');
                  $('#mobile-nav-toggle i').toggleClass('lnr-cross lnr-menu');
                  $('#mobile-body-overly').fadeOut();
              }
          }
      });
  } else if ($("#mobile-nav, #mobile-nav-toggle").length) {
      $("#mobile-nav, #mobile-nav-toggle").hide();
  }

  //------- Smooth Scroll  js --------//  

  $('.nav-menu a, #mobile-nav a, .scrollto').on('click', function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
          var target = $(this.hash);
          if (target.length) {
              var top_space = 0;

              if ($('#header').length) {
                  top_space = $('#header').outerHeight();

                  if (!$('#header').hasClass('header-fixed')) {
                      top_space = top_space;
                  }
              }

              $('html, body').animate({
                  scrollTop: target.offset().top - top_space
              }, 1500, 'easeInOutExpo');

              if ($(this).parents('.nav-menu').length) {
                  $('.nav-menu .menu-active').removeClass('menu-active');
                  $(this).closest('li').addClass('menu-active');
              }

              if ($('body').hasClass('mobile-nav-active')) {
                  $('body').removeClass('mobile-nav-active');
                  $('#mobile-nav-toggle i').toggleClass('lnr-times lnr-bars');
                  $('#mobile-body-overly').fadeOut();
              }
              return false;
          }
      }
  });

  $(document).ready(function() {

      $('html, body').hide();

      if (window.location.hash) {

          setTimeout(function() {

              $('html, body').scrollTop(0).show();

              $('html, body').animate({

                  scrollTop: $(window.location.hash).offset().top - 108

              }, 1000)

          }, 0);

      } else {

          $('html, body').show();

      }

  });


  jQuery(document).ready(function($) {
      // Get current path and find target link
      var path = window.location.pathname.split("/").pop();

      // Account for home page with empty path
      if (path == '') {
          path = 'index.html';
      }

      var target = $('nav a[href="' + path + '"]');
      // Add active class to target link
      target.addClass('menu-active');
  });

  $(document).ready(function() {
      if ($('.menu-has-children ul>li a').hasClass('menu-active')) {
          $('.menu-active').closest("ul").parentsUntil("a").addClass('parent-active');
      }
  });




  //------- Header Scroll Class  js --------//  


  //------- Google Map  js --------//  

  if (document.getElementById("map")) {
      google.maps.event.addDomListener(window, 'load', init);

      function init() {
          var mapOptions = {
              zoom: 11,
              center: new google.maps.LatLng(40.6700, -73.9400), // New York
              styles: [{
                  "featureType": "water",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#e9e9e9"
                  }, {
                      "lightness": 17
                  }]
              }, {
                  "featureType": "landscape",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#f5f5f5"
                  }, {
                      "lightness": 20
                  }]
              }, {
                  "featureType": "road.highway",
                  "elementType": "geometry.fill",
                  "stylers": [{
                      "color": "#ffffff"
                  }, {
                      "lightness": 17
                  }]
              }, {
                  "featureType": "road.highway",
                  "elementType": "geometry.stroke",
                  "stylers": [{
                      "color": "#ffffff"
                  }, {
                      "lightness": 29
                  }, {
                      "weight": 0.2
                  }]
              }, {
                  "featureType": "road.arterial",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#ffffff"
                  }, {
                      "lightness": 18
                  }]
              }, {
                  "featureType": "road.local",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#ffffff"
                  }, {
                      "lightness": 16
                  }]
              }, {
                  "featureType": "poi",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#f5f5f5"
                  }, {
                      "lightness": 21
                  }]
              }, {
                  "featureType": "poi.park",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#dedede"
                  }, {
                      "lightness": 21
                  }]
              }, {
                  "elementType": "labels.text.stroke",
                  "stylers": [{
                      "visibility": "on"
                  }, {
                      "color": "#ffffff"
                  }, {
                      "lightness": 16
                  }]
              }, {
                  "elementType": "labels.text.fill",
                  "stylers": [{
                      "saturation": 36
                  }, {
                      "color": "#333333"
                  }, {
                      "lightness": 40
                  }]
              }, {
                  "elementType": "labels.icon",
                  "stylers": [{
                      "visibility": "off"
                  }]
              }, {
                  "featureType": "transit",
                  "elementType": "geometry",
                  "stylers": [{
                      "color": "#f2f2f2"
                  }, {
                      "lightness": 19
                  }]
              }, {
                  "featureType": "administrative",
                  "elementType": "geometry.fill",
                  "stylers": [{
                      "color": "#fefefe"
                  }, {
                      "lightness": 20
                  }]
              }, {
                  "featureType": "administrative",
                  "elementType": "geometry.stroke",
                  "stylers": [{
                      "color": "#fefefe"
                  }, {
                      "lightness": 17
                  }, {
                      "weight": 1.2
                  }]
              }]
          };
          var mapElement = document.getElementById('map');
          var map = new google.maps.Map(mapElement, mapOptions);
          var marker = new google.maps.Marker({
              position: new google.maps.LatLng(40.6700, -73.9400),
              map: map,
              title: 'Snazzy!'
          });
      }
  }

  //------- Mailchimp js --------//  

  $(document).ready(function() {
      $('#mc_embed_signup').find('form').ajaxChimp();
  });

});