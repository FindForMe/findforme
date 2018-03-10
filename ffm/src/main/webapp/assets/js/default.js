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
	case 'All Post':
		$('#viewPost').addClass('active');
		break;
	case 'ManagePost' :
		$('#managePost').addClass('active');
	
	}
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
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
        
       // var URL = window.
       
        
        /*
         * showing post
         */
        	$table = $('#dataTable');
        	
        if($table.length){
        	console.log('inside table length');
        	
        	var jsonUrl = '';

        	if(window.categoryId == ''){
            	jsonUrl = window.contextRoot+'/json/data/all/post';
        	}else{
        		jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/post';
        	}

        	console.log('jsonUrl : '+jsonUrl+'/n categoryId : '+window.categoryId);
        	
        	ajaxSend(jsonUrl,{},'GET','postDataTable');
        	
        	$table.dataTable({
           	 /*ajax : {
           		 url :jsonUrl,
           		 dataSrc : ''
           	 },
           	 columns:[
           		 {data:'code',
           			 bSortable : false,
           			 mRender : function(data, type , row){
           				 str = '';
           				 str += '<img src="'+window.contextRoot+'/resources/img/'+data+'.jpg" class="imgDataTable">';
           				 //console.log('img path : '+window.contextRoot+'/resources/img/'+data+'.jpg');
           				 return str;
           			 }
           		 },
           		 {data:'title'},
           		 {data:'description'},
           		 {data:'active'},
           		 {data:'id',
       			  mRender:function(data,type,row){
       				 return "date";
       			 }
           		 },
           		{data:'id',
           			 bSortable : false,
       				 mRender:function(data,type,row){
       				var str = '';
       				str+='<a href="'+window.contextRoot+'/show/'+data+'/post" class="btn btn-default">View</a>';
       				return str;
       			}
           		},
           		{data:'id',
           			bSortable : false,
           			mRender:function(data,type,row){
   					var str = '';
   					str+='<button class="btn btn-default">Apply<button>';
   					return str;
   				}}
           	 ]*/
            });
        }
     
        
        /*validating loginForm*/
        
        $loginForm = $('#loginForm');
        
        if($loginForm.length){
        	$loginForm.validate({
        		rules : {
        			username : {
        				required : true,
        				email : true
        			},
        			password : {
        				required : true,
        			}
        		},
        		message: {
        			username : {
        				required : 'Please enter you Email',
        				email : 'Please Enter a valid Email'
        			},
        			password : {
        				required : 'Please enter your password'
        			}
        		},
        		errorElement : 'em',
        		errorPlacement : function(error , element){
        			//add help block class
        			error.addClass('help-block');
        			//add the error label after the input	
        			error.insertAfter(element);
        		}
        		
        	});
        }
        
        
        /*
         * dismiss alert after 3 sec
         */
       $alert = $('.alert');
       if($alert.length){
    	   setTimeout(() => {
			$alert.fadeOut('slow');
		}, 3000);
       }
        
});

function ajaxSuccess(response , caller){
	console.log('ajaxSuccess');
	console.log('response : \n'+response+'\ncaller : \n'+caller);
}
function ajaxFailed(status, caller){
	console.log('ajaxSuccess');
	console.log('caller : \n'+caller+'\nstatus\n'+status);
}


