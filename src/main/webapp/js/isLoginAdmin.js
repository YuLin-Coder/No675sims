layui.use(['layer','element'], function() {

	$.ajax({
		url: "isLoginAdmin",
		type: 'POST',
		data: {
			
		},
		success: function(result) {
			if(result == 0){
				layer.msg('您还没有登录');
				window.open("login.html","_parent");
			}
			
		},
		error: function(e) {
			console.log(e.status);
			layer.msg('登录错误');
			window.open("login.html","_parent");
		}
	});
	
});