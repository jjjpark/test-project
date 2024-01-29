$(function(){
	timer=setInterval(function(){
		
		$.ajax({
			method:'get',
			url:'/rlist',
			data:data,
		}).done(function(res){
			
		})
	})
})