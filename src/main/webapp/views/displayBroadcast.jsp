<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>display broadcast</title>

<script src="<c:url value='/3rd/sockJS/sockjs-0.3.4.min.js'/>"></script>
<script src="<c:url value='/3rd/stomp/stomp.min.js'/>"></script>
<script type="text/javascript">
var noticeSocket = function () {    
	  var s = new SockJS('/socket');    
	  var stompClient = Stomp.over(s);    
	  stompClient.connect({}, function () {         
	    console.log('notice socket connected!');
	    stompClient.subscribe('/topic/notice', function (data) {            
	      $('#billboard').html(data.body);        
	    });    
	 });
	};
	
	noticeSocket();
</script>

</head>
<body>
<div id="billboard">
</div>
</body>
</html>