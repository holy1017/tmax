/**
 * 
 */
$(document).ready(function() {
	$("#loginbt").click(function() {
		var para = $("#loginform").serialize();
		// var para = "action=loginchack.jsp&method=post";
		//alert("login.js:"+para)
		$.ajax({
			type : "post",
			/*url : "loginchack.jsp",*/
			url : "logindb.jsp",
			data : para,
			success : function(data) {
				$("#login").html(data)
			},
			error : function(data, status) {
				alert("error:" + status)
			}
		})

	})
})