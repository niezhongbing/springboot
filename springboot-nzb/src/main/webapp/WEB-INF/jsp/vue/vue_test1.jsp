<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="<%=basePath%>js/vue/vue-resource.js"></script>
<script src="<%=basePath%>js/vue/vue.min.js"></script>
<script type="text/javascript"  src="<%=basePath%>js/product/product.js"></script> 
<title>Insert title here</title>
</head>
<body>
 	<img alt="我是图片" src="<%=basePath%>image/2.jpg">
 </body>
</html>