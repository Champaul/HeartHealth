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




</head>

	<%
			String account = (String)session.getAttribute("account");
			account = account == null?"":account;
		%>

<body>



<!--header-->

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

			<a href="<%=basePath %>temp/index.jsp"><img src="<%=basePath%>index/temp/images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

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

		<div class="banner_erji">

        	<img src="<%=basePath%>index/temp/images/banner_2.jpg" width="1000" height="187" alt="" title="">

        </div>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>医生简介</h1>

                	<ul class="ul_left">

                    

                    

        <li><h3><a href="historic.jsp">医生简介</a></h3>

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

            	<div class="bread"><a href="<%=basePath %>temp/index.jsp">首页</a> > 医生简介</div>


            	<div class="con_news">

              <ul class="ul_jishu clearfix">

            	<li class="fl">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/a.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">吴医生-主任医师</a>
					黎颖贤，中医学硕士，本科毕业于广州医科大学，研究生毕业于广州中医药大学，对慢性心理应激、肠易激综合征等应激性疾病颇有研究，具有扎实的西医功底
                </li>

            	<li class="fl ml20">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/b.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">李医生-主任医师</a>
                    	全科医师，毕业于山东中医药大学，本科。曾在华侨医院进修学习，从事临床工作十余年，一贯崇尚大医精诚，坚持继承发展中医事业。在治疗中医内科常见病、四季病、痤疮、疮疡、月经不调、失眠、多汗症、小儿发热、疳积等方面疗效卓著
                    </p>

                </li>

                <li class="fl">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/c.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">王医生-教授</a>
                    	检验科检验技士，1996年7月毕业于湖北药检专科学校临床检验，2004年1月本科毕业于华南理工大学网络学院行政管理专业，1996年7月至2001年8月在南方医院检验科工作，2006年1月至今在华南理工大学医院检验科工作。
               
                </li>
                   <li class="fl ml20">

                	<a href="javascript:void(0)"><img src="<%=basePath%>index/temp/images/d.jpg" width="291" height="126" alt="" title=""></a>

<p>
                    	<a href="javascript:void(0)">周医生-专家</a>
                    	临床医学检验主管技师，毕业于广东医学院医学检验专业，获本科学历，学士学位，2005年8月应聘于华南理工大学医院检验科。2012年在广东省人民医院检验科进修临床检验、生化检验、免疫检验等技术
               
                </li>

            </ul>	


              </div>

              

               

               

            </div>

        </div>

		<!--content结束--> 

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

