jQuery(document).ready(function(){
	 

	/**************************************************************** Footer Accordion *********************************************************************/
		jQuery('.footer .footer-col .f_block > h4').append('<span class="toggle"></span>');
		jQuery('.footer h4').on("click", function(){
			if (jQuery(this).find('span').attr('class') == 'toggle opened') { jQuery(this).find('span').removeClass('opened').parents('.f_block').find('.footer-col-content').slideToggle(); }
			else {
				jQuery(this).find('span').addClass('opened').parents('.f_block').find('.footer-col-content').slideToggle();
			}
		});

	   

		    

!function($){
 var top_search=$('.top-search')
 $(window).bind('load resize',function(){
  var bodyWidth=$('.container').width()
  if(bodyWidth>=767){    
    if($flag===true)
  		$('#search_mini_form').show().css({opacity:1})
  	$flag = false;
  }else{    
    if($flag===false&&!top_search.hasClass('active'))
  		$('#search_mini_form').hide().css({opacity:0})
  	$flag = true;
  }
  })
}(jQuery);
});

 