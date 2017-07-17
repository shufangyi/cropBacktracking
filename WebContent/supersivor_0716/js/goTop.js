/**
 * Created by ting on 2017/7/4.
 */
//产品列表的轮播
$(document).ready(function(){
    $('#myCarousel').carousel({interval:3000});//每隔3秒自动轮播
});


//返回顶部
$(function () {

    let back_to_top = $('#goTop'); // 按钮

    /*
     点击返回按钮，返回顶部
     */
    back_to_top.on('click', function () {
        $('html,body').animate({
            scrollTop: 0
        }, 800)
    });
    /*
     监听window的scroll
     隐藏或显示按钮
     */
     $(window).on('scroll', function () {
        if ($(window).scrollTop() > $(window).height()) {
            back_to_top.fadeIn();
        } else {
            back_to_top.fadeOut();
        }
    });
    /*
     手动触发一次scroll事件
     */
    $(window).trigger('scroll');
});
