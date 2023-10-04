<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>心理健康咨询系统</title>

<meta content="心理健康咨询系统" name="keywords" />

<meta content="心理健康咨询系统" name="description" />

<link href="<%=basePath %>index/temp/css/base.css" rel="stylesheet" type="text/css">

<link href="<%=basePath %>index/temp/css/pagename.css" rel="stylesheet" type="text/css">




</head>
		<%
			String message = (String)request.getAttribute("message");
			message = message == null?"":message;
			String account = (String)session.getAttribute("account");
			account = account == null?"":account;
			Integer id = (Integer)session.getAttribute("id");
			id = id == null?null:id;
			 
		%>

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

			<a href="<%=basePath %>index/temp/index.html"><img src="<%=basePath %>index/temp/images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

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
  <form action="<%=basePath %>user/saveUser" enctype="multipart/form-data" method="post" onsubmit="return login()">
	<ul>
		<li>
			<label>您的姓名：</label><input id="txtUserName"  style="width:200px;" placeholder="请输入您的姓名" name="account" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的密码：</label><input id="txtUserTel" name="password" placeholder="请输入您的密码" style="width:200px;" type="password" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的性别：</label><input type="radio"  class="yuyue_ra"  name="chexing" value="男" /> <em>男</em> <input name="chexing" value="女" type="radio" class="yuyue_ra" /> <em>女</em>
		</li>
		<li>
			<label>您的年龄：</label><input id="txtUserTel" name="age" placeholder="请输入您的年龄" style="width:200px;" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的电话：</label><input id="txtUserName" style="width:200px;" placeholder="请输入您的电话" name="tel" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的职业：</label><input id="txtUserName" style="width:200px;" placeholder="请输入您的职业" name="address" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>角色：</label>
			<select class="yuyue_in" name="idk" id="txtUserName" style="width:200px;">
					<option value="">请选择角色</option>
					<option value="学生">学生</option>
					<option value="白领">白领</option>
		   </select>
		</li>
		<li>
			<label>您的照片：</label><input id="txtUserName" style="width:200px;" placeholder="请选择您的照片" name="photo" type="file" class="yuyue_in" /> 
		</li>
		<li>
			<input name="btnSubmit" id="btnSubmit" type="submit"  value="提交" class="btn" /> <a href="register.jsp"><input name="" type="reset" value="重置" class="btn" /> </a>
		</li>
	</ul>
	</form>
                </div>
               
            </div>
        </div>


		<!--content end--> 

</div>

<!--footer开始-->


<div class="footer"> 

	<p><a href="index.jsp">首页</a> |  <a href="http://www.nhc.gov.cn/zhuz/index.shtml" target="_index">中华人民共和国卫生健康委员会</a>  | <a href="http://www.dxy.cn/" target="_index">丁香园</a>  | <a href="connection.jsp">联系我们</a> <a href="template/connection.html"></a></p>

<p>Copyright &copy; 2023－2023 All Rights Reserved 版权所有</p>
  <p>地址：江苏省南京市江宁区弘景大道99号 <a href="http://www.mycodes.net/" target="_blank"></a> </p>
  
</div>


<!--footer 结束--> 
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	function toAdd(){
			alert("提交成功,请等待审核！");
	}
</script>
</body>

</html>

