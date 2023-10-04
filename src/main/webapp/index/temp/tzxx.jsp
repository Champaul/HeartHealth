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

	<%
			
			Integer id = (Integer)session.getAttribute("id");
			
			String account = (String)session.getAttribute("account");
			account = account == null?"":account;
		%>


</head>



<body>



<!--header-->


<div class="header"> 

	<div class="w1000">
	<p>你好，欢迎<font size="3" color="red"><a href="<%=basePath %>web/selGr"><%=account %></a></font>光临心理健康咨询系统！</p>

        <div class="contact">
           <c:if test="${empty sessionScope.account}">
        <a href="<%=basePath %>index/temp/login.jsp">登录</a> 
        <a href="<%=basePath %>index/temp/register.jsp">注册</a>
        </c:if>
        <c:if test="${!empty sessionScope.account}">
            <a href="<%=basePath %>grzy"><%=account %></a>  
        <a href="<%=basePath %>userZx">注销</a>
        </c:if>
        </div>
	</div>

</div>




<div class="w1000">

	<div class="header_bottom">

			<a href="index.jsp"><img src="<%=basePath %>index/temp/images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

       		<ul>

      	  <li>
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

		<!--banner开始-->

		<div class="banner_erji">

        	<img src="<%=basePath %>index/temp/images/banner_2.jpg" width="1000" height="187" alt="" title="">

        </div>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>其他目录</h1>

                	<ul class="ul_left">

                    

                    

         <li><h3><a href="<%=basePath%>comm/selTz">公告</a></h3>

</li>

        


</li>

        

		
</li>

         	</ul>

                 
                </div>

                <div class="left_lx">

                	<h1>联系方式</h1>
					<p>地址：江苏省南京市江宁区弘景大道99号</p>


					<p>电话：18761217896</p>

					<p>QQ：773340537</p>

					<p>网址：www.champaul.top</p>

					<p>邮编：224100</p>

                </div>

            </div>

        	<div class="rightbar">

            	<div class="bread"><a href="index.jsp">首页</a> > 文章</div>

                

            	<div class="con_news">

                	<p class="p_tit2">

                    	<span><font size="5"></font> &nbsp;&nbsp;标题：<font color="red">${data.mycd}</font>
                    	</span>
                    	 发布人:${data.lname}-${data.idk}-${data.address}　　发布时间：${data.dcrq} 赞：${data.kid}
                    	
						</p>
                	<div class="con">

               		   <p>
 			
                 
	<p>

		&nbsp;&nbsp;&nbsp;&nbsp;${data.content}<br /><br /><br />

<br />
<p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="<%=basePath %>${data.photo}" width="40%" height="30%"/><br />
	<p>
	  
	
	<p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=basePath%>comm/zan1?id=${data.id}"><img src="<%=basePath %>index/temp/images/zan.jpg" width="30" height="30" alt="图片" /><font color="red" size="2">赞（${data.kid}）</font></a>
		<br />

	</p>

                    </div>

              </div>

              

               

               

            </div>

        </div>

		<!--content结束--> 

</div>

<!--footer开始-->

<div class="footer"> 

	<p><a href="index.jsp">首页</a> |  <a href="http://www.nhc.gov.cn/zhuz/index.shtml" target="_index">中华人民共和国卫生健康委员会</a>  | <a href="http://www.dxy.cn/" target="_index">丁香园</a>  | <a href="connection.jsp">联系我们</a> <a href="template/connection.html"></a></p>

<p>Copyright &copy; 2023－2023 All Rights Reserved 版权所有</p>
  <p>地址：江苏省南京市江宁区弘景大道99号 <a href="http://www.mycodes.net/" target="_blank"></a> </p>
  
</div>


<!--footer 结束--> 


</body>

</html>

