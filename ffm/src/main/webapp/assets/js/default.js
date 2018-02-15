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
        
        //var tableData = "[{image:'image',title:'title1',description:'description of title 1',category:'1',test:'test',view:'view',apply:'apply'}]";
        /*
         * [{"id":1,"title":"Hello Title","descriptioin":"this is description of hello title","imgURl":"imgage.jpg","active":true},
         * {"id":2,"title":"title2","descriptioin":"this is description of title1","imgURl":"imgage1.jpg","active":true}]
         */
        
        	$table = $('#dataTable');
        	var jsonurl = 'http://localhost:8080/ffm/json/data/all/post';
        if($table.length){
        	console.log('inside table length');
        	$table.dataTable({
           	 ajax : {
           		 url :jsonurl,
           		 dataSrc : ''
           	 },
           	 columns:[
           		 {data:'imgURl',
           			 bSortable : false,
           			 mRender : function(data, type , row){
           				 str = '';
           				 str += '<img src="'+window.contextRoot+'/resources/img/'+data+'.PNG" class="imgDataTable">';
           				 return str;
           			 }
           		 },
           		 {data:'title'},
           		 {data:'descriptioin'},
           		 {data:'active'},
           		 {data:'id',
       			  mRender:function(data,type,row){
       				 return "date";
       			 }
           		 },
           		{data:'id',
       				 mRender:function(data,type,row){
       				var str = '';
       				str+='<button class="btn btn-default">View</button>';
       				return str;
       			}
           		},
           		{data:'id',
   				mRender:function(data,type,row){
   					var str = '';
   					str+='<button class="btn btn-default">Apply<button>'
   					return str;
   				}}
           	 ]
            });
        }
     
}); 