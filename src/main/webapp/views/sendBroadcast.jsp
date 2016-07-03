<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>send broadcast</title>

<script src="<c:url value='/3rd/sockJS/sockjs-0.3.4.min.js'/>"></script>
<script src="<c:url value='/3rd/stomp/stomp.min.js'/>"></script>
<script type="text/javascript">    
    var stompClient = null;    
    function setConnected(connected) {        
        document.getElementById('connect').disabled = connected;        
        document.getElementById('disconnect').disabled = !connected;        
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';        
        document.getElementById('response').innerHTML = '';    
    }    
    // 开启socket连接
    function connect() {        
        var socket = new SockJS('/socket');        
        stompClient = Stomp.over(socket);        
        stompClient.connect({}, function (frame) {            
             setConnected(true);            
        });    
    }    
    // 断开socket连接
    function disconnect() {        
        if (stompClient != null) {            
            stompClient.disconnect();        
        }        
        setConnected(false);        
        console.log("Disconnected");    
    }    
    // 向‘/app/change-notice’服务端发送消息
    function sendName() {        
        var value = document.getElementById('name').value;            
        stompClient.send("/app/change-notice", {}, value);    
    } 
    
    connect();
</script>
</head>
<body>
	<div>    
	    <div>        
	        <button id="connect" onclick="connect();">Connect</button> 
	       <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>    
	    </div>    
	    <div id="conversationDiv">        
	        <p>            
	            <label>notice content?</label>        
	        </p>        
	        <p>            
	              <textarea id="name" rows="5"></textarea>        
	        </p>        
	        <button id="sendName" onclick="sendName();">Send</button>        
	        <p id="response"></p>    
	    </div>
	</div>
</body>
</html>