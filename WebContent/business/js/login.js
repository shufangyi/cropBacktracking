jQuery(document).ready(function () {
    /*
        Fullscreen background
    */
    $.backstretch("./img/1.jpg");

    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
        $(this).removeClass('input-error');
    });
    var i=0;
    $('#submit').on('click', function (e) {
    	$(this).find('input[type="radio"]:checked').each(function () {
    			i=i+1;
        });
    	if(i==0)
    	{
    				
    		e.preventDefault();
    	    $(this).addClass('input-error');
    			}
    	else
    	{
    		$(this).removeClass('input-error');
    	}
   
        $(this).find('input[type="text"], input[type="password"], textarea').each(function () {
            if ($(this).val() == "") {
                e.preventDefault();
                $(this).addClass('input-error');
            } else {
                $(this).removeClass('input-error');
            }
        });
        
    });
});