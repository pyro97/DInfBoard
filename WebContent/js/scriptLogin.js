$(document).ready( function() {
	$("#check").click( function() {
		$("#output").html("");
		var username=$("#username").val();
		var password=$("#password").val();
		if(!username || !password) {
			$("#output").html("Hai lasciato dei campi vuoti");
			if(!username) {
				$("#username").css("border-color","red");
			}
			if(!password) {
				$("#password").css("border-color","red");
			}
		}
		else {
			
			
			$.post("CheckServlet", function(data,status) {
				
				if(status=="success") {
					var obj=JSON.parse(data);
					var username=$("#username").val();
					var x;
					var flag=false;
					for(x in obj.email) {
						if(username==obj.email[x] || username==obj.username[x]) {
							flag=true;
						}
					}
					
					if(flag) {
						$("#loginForm").submit();
					}
					else {
						$("#output").html("Hai inserito una mail non presente nei nostri sistemi");
					}
				}
			})
			
		}
		
	})
})