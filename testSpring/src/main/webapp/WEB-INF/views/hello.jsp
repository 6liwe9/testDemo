<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>My JSP 'hello.jsp' starting page</title>
    <script src="<%=request.getContextPath() %>/js/jquery.js" type="text/javascript">
</script>
  </head>
  <body>
   　<div id="wrap">
    <input type="radio" name="payMethod" value="1" />支付宝
    <input type="radio" name="payMethod" value="2" />财务通
    <input type="button" id="btn">
    <div id="inside">
    <p id='time'></p>
    </div>
</div>

  </body>
   <script type="text/javascript">

   $(${message}).each(function(i,a){
	 
	   alert(a.a);
	   alert(a.b);
   });
   
   $(function(){
       setInterval(getLoc,1000);
    });
   function getLoc(){
	   $.ajax({
		    url:'<%=request.getContextPath() %>/hello/time.action',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    timeout:50000,    //超时时间
		    data:{
		        value:1
		    },
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	$("#time").text(data.time);

		    },
		    error:function(xhr,textStatus){
		        console.log('错误');
		        console.log(xhr);
		        console.log(textStatus);
		    }
		});
   }
   $('#btn').click(function(){
	  var i=$('input[name="payMethod"]:checked').val();
	  $.ajax({
		    url:'<%=request.getContextPath() %>/hello/remote.action',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		        value:i
		    },
		    timeout:50000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	  $('#btn').val(data.key);
		    	var $p=$("<p>"+data.key+"</p>");
		    	$("div").append($p);

		    },
		    error:function(xhr,textStatus){
		        console.log('错误');
		        console.log(xhr);
		        console.log(textStatus);
		    }
		})
   });
   </script>
</html>