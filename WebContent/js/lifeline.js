$(function () {
    $(".content").bind('click', function () {
        if ($(this).children('.detail').css('display') == 'none') {
            $(this).children('div.detail').fadeIn();
            // $(this).children('div.detail').slideDown(600);
            $('.txt>i').attr('class', 'fa fa-chevron-circle-up');
        } else if ($(this).children('.detail').css('display') == 'block') {
            // $(this).children('div.item-show').fadeOut();
            $(this).children('div.detail').slideUp(600);
            $('.txt>i').attr('class', 'fa fa-chevron-circle-down');
        }
    });
});