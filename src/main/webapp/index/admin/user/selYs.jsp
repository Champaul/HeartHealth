<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>医生管理</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	 <link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
   <!-- 引入JQuery支持的库 -->
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<!-- 引入artDailog支持的库 -->
<link rel="stylesheet" href="<%=basePath%>resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript" src="<%=basePath%>resource/admin/artDialog/dist/dialog-plus.js"></script>
  <script type="text/javascript">
  		//显示头像
		 function toShowPhoto(id){
  			
			 var d = dialog({
				 id:'photo',//唯一的弹出框
				 title:'头像显示',
				 content:'<img width="200" src="<%=basePath%>user/show/'+id+'" alt="暂无头像" onerror="this.src=\'upload/guest.png\'"/>'
			 });
			 d.show();
			
		 }
	</script>
</head>
		

<body>
<form action="user/selYs" method="post" rel="page">
<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="javascript:void(0)">医生管理</a></li>
		<li><a href="javascript:void(0)">查看医生信息</a></li>
	</ul>
</div>
<div class="formbody">
	<div class="formtitle" style="cursor: pointer;" id="formtitle"><span>条件查询</span></div>
	<ul class="forminfo" style="display: none;" id="forminfo">
		<li>
			<label>医生姓名</label>
			<input name="account"  type="text" class="dfinput" placeholder="请输入医生姓名" />
		</li>
		
		<li>
			<label>&nbsp;</label>
			<input name="" type="submit" class="btn" value="查询"/>
			<input name="" type="reset" class="btn" value="重置"/>
		</li>
	</ul>
</div>

		<table class="imgtable"border = "5" >
			<thead>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>联系方式</th>
				<th>家庭住址 </th>
				<th>身份证号码</th>
				<th>科室</th>
				<th>类型</th>
				<th>简介</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
		<c:if test="${!empty userList}">
			<c:forEach items="${userList}" var="list" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>
				<a href="javascript:void(0);" title="点击头像，查询头像" class="tablelink" 
					onclick="toShowPhoto('${list.id}')">
				${list.account}</a>
				</td>
				<td>${list.age}</td>
				<td>${list.tel}</td>
				<td>${list.address}</td>
				<td>${list.idk}</td>
				<td>${list.jsnumber}</td>
				<td>${list.chexing}</td>
				<td>${list.state}</td>
				<td>
					<a href = "user/showYs?id=${list.id}"><font color="blue">修改</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
					<a href = "user/deleteYs?id=${list.id}" onclick="deleteUser()"><font color="blue">删除</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>	
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty userList}">
			<tr>
				<td colspan="8" align="center">
					<strong><font color="red">暂时没有数据，请添加</font></strong>
				</td>
			</tr>
		</c:if>
		</tbody>
		</table>
		<div class="rightinfo">
			<div class="tools">
				<ul class="toolbar1">
				<li class="click"><span><img src="<%=basePath %>resource/admin/images/t01.png"/></span><a href="index/ys/myinfo/addUser.jsp">添加医生信息</a></li>
				</ul>
			</div>
		</div>
		<div class="pagin">
			<ul class="paginList">
				当前第&nbsp;<i class="blue"> ${pageInfo.pageNum}&nbsp;</i>页，
				共&nbsp;<i class="blue">&nbsp;${pageInfo.total}&nbsp;</i>条记录，
				共&nbsp;<i class="blue"> ${countPage}&nbsp;</i>页&nbsp;&nbsp;
				<a href="user/selYs?page=1">首页</a>&nbsp;&nbsp;
			    <a href="user/selYs?page=${pageInfo.hasPreviousPage==false?1:pageInfo.prePage}">上一页</a>&nbsp;&nbsp;
			    <a href="user/selYs?page=${pageInfo.hasNextPage==false?pageInfo.pages:pageInfo.nextPage}">下一页</a>&nbsp;&nbsp;
			    <a href="user/selYs?page=${pageInfo.pages}">尾页</a>&nbsp;&nbsp;
			</ul>
	    </div>
</form>

<script type="text/javascript" src="<%=basePath %>resource/admin/jQuery/jquery.js"></script>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	  function deleteUser(){
		alert("删除成功");
		}
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("请选择要操作的记录");
			return false;
		}else{
			alert( "您操作的值为："+$("input[name='id']:checked").val())
		}
	}
	$(function(){
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$("#formtitle").click(function(){
			$("#forminfo").slideToggle("slow");
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		$('.imgtable tbody tr:odd').addClass('odd');
	});
    
</script>

</body>

</html>

