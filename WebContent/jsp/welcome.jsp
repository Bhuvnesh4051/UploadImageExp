<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String welmsg=(String)request.getAttribute("uploadSuccess");

%>
<%--  <img src="${pageContext.request.contextPath}/avatar/${img}" border=0 width="48px" height="48px"/> --%>
 <img border="0" src="data:image/jpg;base64,<%=(String)request.getAttribute("uploadImg")%>"  height="200" width="200">
    <div>
    </body>
</html>


</body>
</html>