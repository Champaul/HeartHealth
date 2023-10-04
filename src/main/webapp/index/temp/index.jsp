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

<link href="<%=basePath%>index/temp/css/base.css" rel="stylesheet" type="text/css">

<link href="<%=basePath%>index/temp/css/pagename.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="<%=basePath%>index/temp/js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" src="<%=basePath%>index/temp/js/jquery.SuperSlide.2.1.js"></script>

</head>

		<%
			String account = (String)session.getAttribute("account");
			account = account == null?"":account;
			Integer id = (Integer)session.getAttribute("id");
			 
			
		%>

<body>



<!--header开始--> 

<div class="header"> 

	<div class="w1000">
	<p>你好，欢迎<font size="3" color="red"><a href="#"><%=account %></a></font>光临心理健康咨询系统！</p>

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

			<a href="index.jsp"><img src="<%=basePath%>index/temp/images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

       		<ul>

            	<li><a href="<%=basePath%>index/temp/index.jsp">网站首页</a></li>       

				<li><a href="<%=basePath%>index/temp/historic.jsp">医生简介</a></li>
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

		<div class="banner"> 

            <div class="bd">

                <ul>

                    <li style="background:url(<%=basePath%>index/temp/images/banner_4.jpg) no-repeat center top;"></li>

                    <li style="background:url(<%=basePath%>index/temp/images/banner_2.jpg) no-repeat center top;"></li>

                   <li style="background:url(<%=basePath%>index/temp/images/banner_7.jpg) no-repeat center top;"></li>

                </ul>

            </div>

            <div class="hd">

                <ul>

                    <li></li>

                    <li></li>

                </ul>

            </div>

            <a class="prev" href="javascript:void(0)"></a>

            <a class="next" href="javascript:void(0)"></a>

        </div>
		 <!--调用JS模块图片滚动--> 
        <script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",delayTime:1000,interTime:5000,autoPlay:true, autoPage:true, trigger:"click" });</script>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content"> 

			<p class="p_tit1">新闻动态</p>	

			<ul class="ul_jishu clearfix">

            	<li class="fl">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/pic_1.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">千里之行从“心”开始</a>
					心理健康教育是中等职业学校德育工作的重要组成部分。教育部最近颁布的《中等职业学校德育大纲》明确指出：中等职业学校德育是对用户进行思想、政治、道德、法律和心理健康的教育。
                </li>

            	<li class="fl ml20">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/pic_2.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">少年的两性关系与情感问题</a>
             	成长是一种令人喜悦与振奋的事，它不仅代表着生命的融通与提升，同时也是人生另一种诠释与蜕变。正处于叛逆期的年轻朋友们，一方面觉得已经长大了，可以独立自主：一方面仍需要依赖父母生活。在心理方面希望走向独立，又期待依附在父母亲身边。
                    </p>

                </li>

                <li class="fr">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/pic_3.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">常见的“异常”心理</a>
               
        精神正常并不意味着没有一点问题，关键是这些症状的产生背景、持续时间、严重程度以及对个体和环境的不良影响如何。正常人也可能出现短暂的异常现象，时间短，程度轻，尚不能沾上精神疾病的名称。
                </li>

            </ul>	


            <div class="feilei">

            	<div class="fl1 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_4.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl2 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_5.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl3 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_6.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl4 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_7.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl5 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_8.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl6 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_9.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

                <div class="fl7 fldiv">

                	<a href="#"><img src="<%=basePath%>index/temp/images/pic_10.jpg" width="75" height="76" alt="" title=""></a>

                    <p><a href="#"></a></p>

                </div>

            </div>


		</div>

		<!--content 结束--> 

</div>

<!--footer开始-->

<div class="footer"> 

	<p><a href="index.jsp">首页</a> |  <a href="http://www.nhc.gov.cn/zhuz/index.shtml" target="_index">中华人民共和国卫生健康委员会</a>  | <a href="http://www.dxy.cn/" target="_index">丁香园</a>  | <a href="connection.jsp">联系我们</a> <a href="template/connection.html"></a></p>

<p>Copyright &copy; 2023－2023 All Rights Reserved 版权所有 </p>
  <p>地址：江苏省南京市江宁区弘景大道99号 <a href="http://www.mycodes.net/" target="_blank"></a> </p>
  
</div>



<!--footer 结束--> 

</body>

</html>

