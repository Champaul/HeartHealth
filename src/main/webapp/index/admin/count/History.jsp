<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath() + "/";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>历史记录</title>
    <link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
     <%
    String filename = (String)request.getAttribute("filename");
    String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;
   %>

<img src="<%= graphURL %>"width=800 height=500 border=0 usemap="#<%= filename %>">

</body>
</html>
