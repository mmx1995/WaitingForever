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
$('.home-nav-menu').click(function(){
  $('.home-nav-menu').removeClass('home-nav-active');
  $(this).addClass('home-nav-active');
})