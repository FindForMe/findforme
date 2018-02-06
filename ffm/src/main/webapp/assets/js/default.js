$('document').ready(function(){
	//solving active menu problem...
	console.log('menu is '+menu);
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Hire Freelancer':
		$('#hire').addClass('active');
		break;
	case 'Find Work':
		$('#find').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'FindForMe':
		$('#home').addClass('active');
		break;
			
	}
	
	//var signin = $('#default-signin-modal').html();
	//$('.default-signin').html(signin);
	//$('#default-signin .default-pass').remove('.glyphicon-eye-close');
	
	$('.default-eye').click(function(){
		if($(this).hasClass('glyphicon-eye-close')){
			$('.default-pass').attr('type','text');
		}
		if($(this).hasClass('glyphicon-eye-open')){
			$('.default-pass').attr('type','password');
		}
		$(this).toggleClass('glyphicon-eye-close glyphicon-eye-open');
	});
	$('.carousel-caption').on('mouseenter' , function(){
		$('.carousel-img').css('filter','blur(10px)');
	});
	$('.carousel-caption').on('mouseleave' , function(){
		$('.carousel-img').css('filter','blur(0px)');
	});
        
        $('#search_category').on('keyup', function(){
            var txt = $(this).val().toLowerCase();
            $('.none').show();
            $('#search_table tr td').filter(function(){
                $(this).toggle($(this).text().toLowerCase().indexOf(txt)>-1)
            });
        });
        
        var data = "{title:'title1',description:'description of title 1',category:'1'}"
        
     $('#dataTable').dataTable({
    	 //data:data,
    	 columns:{
    		 data:"image1",
    		 data:"title1",
    		 data:"cat1",
    		 data:"user1",
    	 }
     });
}); 