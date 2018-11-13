//测试数据
var curAdd = window.location.href;
var virtualData;
if (curAdd.indexOf('www.dnforever.com') == -1) {
  virtualData = [{
      "id": 1,
      "parentid": null,
      "title": "测试-静态",
      "url": "/login",
      "inUse": true,
      "position": null,
      "updatetime": "2018-10-09T17:29:19.000+0000",
      "createtime": "2018-10-09T17:29:24.000+0000"
    },
    {
      "id": 2,
      "parentid": null,
      "title": "测试2-静态",
      "url": "/login",
      "inUse": true,
      "position": null,
      "updatetime": "2018-10-09T17:33:55.000+0000",
      "createtime": "2018-10-09T17:29:24.000+0000"
    }
  ]
} else {
  $.ajax({
    type: 'post',
    url: 'http://www.dnforever.com/menu',
    data: '',
    success: function(data) {
      virtualData = data;
    }
  })
}
//导航栏高亮
$('.home-nav-menu').click(function() {
  $('.home-nav-menu').removeClass('home-nav-active');
  $(this).addClass('home-nav-active');
  console.log(virtualData);
  console.log(curAdd.indexOf('www.dnforever.com') == -1);
});
//swiper轮播图
var swiper = new Swiper('.swiper-container', {
  slidesPerView: 1,
  spaceBetween: 30,
  loop: true,
  autoplay: {
    disableOnInteraction: false,
  },
  autoplayDisableOnInteraction:true,
  pagination: {
    el: '.swiper-pagination',
    clickable: true,
  },
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
});