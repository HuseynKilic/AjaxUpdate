<%@page pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
$(document).ready(function(){
	$("#kayit").focusout(function(e){ 
		 e = e || window.event;
		    var data = [];
		    var target = e.srcElement || e.target;   

		    while (target && target.nodeName !== "TR") {  
		        target = target.parentNode;
		    }
		    if (target) {  
		        var cells = target.getElementsByTagName("td");
		       
		            data.push(cells[0].innerHTML);
		        
		    }
	
		var id = $("#id"+data).text();
		var ad = $("#ad"+data).text();
		var soyad = $("#soyad"+data).text();
		var yas = $("#yas"+data).text();
		var sehir = $("#sehir"+data).text();
		$.ajax({
		    type: "POST",
		    url: "/AjaxProject/EditServlet2",
		    data: {"id":id, "ad":ad, "soyad":soyad, "yas":yas, "sehir":sehir},

		});
		
		
	});
	});


</script>

<body>
	<form action="ViewServlet" method="post">
		<table border='1' width='100%' id="kayit"> 
        	<tr><th>Id</th><th>Ad</th><th>Soyad</th><th>Yas</th><th>Sehir</th></tr>
        	<c:forEach items="${selected}" var="user">  
        		<tr><td id="id${user.id}">${user.id}</td>
        			<td id="ad${user.id}" contenteditable="true">${user.ad}</td>
        			<td id="soyad${user.id}" contenteditable="true">${user.soyad}</td>
        			<td id="yas${user.id}" contenteditable="true">${user.yas}</td>
        			<td id="sehir${user.id}" contenteditable="true">${user.sehir}</td></tr>  
        	</c:forEach>
        </table> 
    </form>  
     <br>
     <a href = "LoginServlet?action=logout">Logout</a>
     


</body>
</html>