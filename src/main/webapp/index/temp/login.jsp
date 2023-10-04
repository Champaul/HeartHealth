<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
			String account = (String)session.getAttribute("account");
			account = account == null?"":account;
			Integer id = (Integer)session.getAttribute("id");
			 
			
			String message = (String)request.getAttribute("message");
			message = message == null?"":message;
			
		%>
		<script>  
		function changeVerifyCode(){  
		    document.getElementById("validateCodeImg").src="<%=basePath %>VerifyCodeServlet?t="+Math.random();  
		      
		}  
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>心理健康咨询系统</title>

<meta content="心理健康咨询系统" name="keywords" />

<meta content="心理健康咨询系统" name="description" />

<link href="<%=basePath %>index/temp/css/base.css" rel="stylesheet" type="text/css">

<link href="<%=basePath %>index/temp/css/pagename.css" rel="stylesheet" type="text/css">




</head>



<body>



<!--header-->



<div class="header"> 

	<div class="w1000">
	<p>你好，欢迎<font size="3" color="red"><a href="<%=basePath %>web/selGr"><%=account %></a></font>光临心理健康咨询系统！</p>

        <div class="contact">
           <c:if test="${empty account}">
        <a href="<%=basePath %>index/temp/login.jsp">登录</a> 
        <a href="<%=basePath %>index/temp/register.jsp">注册</a>
        </c:if>
        <c:if test="${!empty account}">
            <a href="<%=basePath %>grzy"><%=account %></a>  
        <a href="<%=basePath %>userZx">注销</a>
        
        </c:if>
        </div>
	</div>

</div>




<div class="w1000">

	<div class="header_bottom">

			<a href="<%=basePath %>index/temp/index.jsp"><img src="<%=basePath %>index/temp/images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

       		<ul>

            <li><a href="<%=basePath%>index/temp/index.jsp">网站首页</a></li>       
				<li><a href="<%=basePath%>index/temp/historic.jsp">平台简介</a></li> 	

 				<li><a href="<%=basePath%>comm/selXxYd">文章</a></li>    
                <li><a href="<%=basePath%>comm/selTz">公告</a></li>
                  
				 <li><a href="<%=basePath%>index/temp/about.jsp">关于我们</a></li>      

                <li><a href="<%=basePath%>index/temp/connection.jsp">联系我们</a></li>

     		</ul>  

    </div>       

</div>
<!--header结束--> 

<div class="container"> 		

		<!--banner-->

		<div class="banner_erji">

        	<img src="<%=basePath %>index/temp/images/banner_2.jpg" width="1000" height="187" alt="" title="">        </div>

		<!--banner end--> 

		

		<!--content-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>其他目录</h1>

                	<ul class="ul_left">

                    

                    

        <li>
          <h3><a href="<%=basePath %>index/temp/login.jsp">登录</a></h3>

</li>

        

        <li>
          <h3><a href="<%=basePath %>index/temp/register.jsp">注册</a></h3>

</li>



        

         	</ul>

                 
              </div>


            </div>

        	<div class="rightbar">

            	<div class="bread"><a href="<%=basePath %>index/temp/index.jsp">首页</a> >登录</div>

                <div class="contact_nei">
  <form action="<%=basePath %>userLogin" method="post" onsubmit="return login()">
	<ul>
		<li>
			<label>登录账号：</label><input id="txtCode" name="account" value="<%=account %>" type="text" style="width:180px;" class="yuyue_in" placeholder="请输入账号" /> 
		</li>
		<li>
			<label>登录密码：</label><input id="txtUserTel" name="password" type="password" class="yuyue_in" style="width:180px;" placeholder="请输入登陆密码" /> 
		</li>
		<li>
			<label>验证码： </label><input id="txtUserTel" name="code" type="text" class="yuyue_in" style="width:180px;" placeholder="请输入验证码" /> 
			 <img src="<%=basePath %>VerifyCodeServlet" border=0 id="validateCodeImg" style="height: 25px; width: 57px"/><a href="#" onclick="changeVerifyCode()">&nbsp;&nbsp;看不清？换一张</a>
		</li>
		<li>
		<font size = "5" color = "red" ><%=message %>
		</li>
		<li>
			<input name="btnSubmit" id="btnSubmit" type="submit" value="确认登录" class="btn" /> <a href="login.jsp"><input name="" type="reset" value="重置" class="btn" /></a> 
		</li>
	</ul>
	</form>
          

                </div>
               
               
               
            </div>
        </div>


		<!--content end--> 

</div>

<!--footer开始-->




<!--footer 结束--> 

</body>

</html>

