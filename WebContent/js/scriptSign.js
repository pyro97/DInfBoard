$(document).ready( function() {
	
	$("#check").click( function() {
		$("#output").html("");
		$("#output1").html("");
		$("#output2").html("");
		var email=$("#email").val();
		var username=$("#username").val();
		var password=$("#password").val();
		if(!email || !username || !password) {
			$("#output").html("Hai lasciato dei campi vuoti");
			if(!email) {
				$("#email").css("border-color","red");
			}
			if(!username) {
				$("#username").css("border-color","red");
			}
			if(!password) {
				$("#password").css("border-color","red");
			}
		}
		
		else {
			
			var user=username.split("");
			var i;
			var flag=false;
			for(i=0;i<user.length;i++) {
				if(user[i]==" ") {
					flag=true;
				}
			}
			if(flag) {
				$("#output2").html("Hai inserito una username contenente spazi");
			}
			else {
				$.post("CheckServlet", function(data,status) {
					
					if(status=="success") {
						var obj=JSON.parse(data);
						var x;
						for(x in obj.email) {
							if(email==obj.email[x]) {
								$("#output1").html("Hai inserito una email già presente nei nostri sistemi, inserisci una nuova email");
							}
						}
						for(x in obj.username) {
							if(username==obj.username[x]) {
								$("#output2").html("Hai inserito una username già presente nei nostri sistemi, inserisci una nuova username");
							}
						}
						
						var output1=$("#output1").text();
						var output2=$("#output2").text();
						if(!output1 && !output2) {
							$("#registrationForm").submit();
						}
					}
				})
			}
			
		}
		
	})
	
})