<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>心理健康咨询系统</title>  
    <link rel="stylesheet" href="<%=basePath%>resource/ht/css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>resource/ht/css/admin.css">
    <script src="<%=basePath%>resource/ht/js/jquery.js"></script>
    <script src="<%=basePath%>resource/ht/js/pintuer.js"></script>  
    <script type="text/javascript">
		$(function(){
			$("#account").focus();
		});
		function login(){
			var account=$.trim($("#account").val());//账号，trim 是移除两侧空白
			var password=$.trim($("#password").val());
			var code=$.trim($("#code").val());
			var role=$.trim($("#role").val());
			if(account.length==0){
				alert("账号不能为空");
				$("#account").focus();
				return false;
			}
			if(password.length==0){
				alert("密码不能为空");
				$("#password").focus();
				return false;
			}
		 	 if(code.length==0){
					alert("请输入验证码");
					$("#code").focus();
					return false;
			} 
			return true;
		}
	</script>
	<script>  
		function changeVerifyCode(){  
		    document.getElementById("validateCodeImg").src="<%=basePath %>VerifyCodeServlet?t="+Math.random();  
		      
		}  
	</script>


</head>
		<%
		
			String error = (String)request.getAttribute("message");
			error = error == null?"":error;
			String account = (String)request.getParameter("account");
			account = account == null?"":account;
		%>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="<%=basePath %>login" method="post" >
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>心理健康咨询系统</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" value="<%=account %>" name="account" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                          <input name="code" id="code" type="text" class="logincode" placeholder="请输入验证码"/>
                     	 <img src="<%=basePath %>VerifyCodeServlet" border=0 id="validateCodeImg" style="height: 25px; width: 57px"/><a href="#" onclick="changeVerifyCode()">&nbsp;&nbsp;看不清？换一张</a>
                        </div>
                    </div>
                </div>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <font size = "5" color = "red" ><%=error %></font>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>