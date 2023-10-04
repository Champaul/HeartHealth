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
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	 <link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
   <!-- 引入JQuery支持的库 -->
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<!-- 引入artDailog支持的库 -->
<link rel="stylesheet" href="<%=basePath%>resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript" src="<%=basePath%>resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript">
	  	function selSp(id){
	          var d = dialog({
	        	  	title:'关闭窗口',
	                width:500,
	                height:350,
	                url:'comm/selSp?id='+id,//可以是一个访问路径Action|Servlet等或者jsp页面资源
	                onclose: function () {
	                if (this.returnValu&="success") {
	                    window.location.href= window.location.href;
	                }
	            }
	          });
	           d.showModal();
	        }
	  	</script>

</head>
		

<body>
<form action="comm/selGg" method="post" rel="page">
<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="javascript:void(0)">文章管理</a></li>
		<li><a href="javascript:void(0)">文章信息</a></li>
	</ul>
</div>
<div class="formbody">
	<div class="formtitle" style="cursor: pointer;" id="formtitle"><span>条件查询</span></div>
	<ul class="forminfo" style="display: none;" id="forminfo">
		<li>
			<label>标题</label>
			<input name="title"  type="text" class="dfinput" placeholder="请输入标题" />
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
				<th>标题</th>
				<th>内容</th>
				<th>发布人</th>
				<th>发布日期</th>
				<th>图片</th>
				<th>点赞数</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="list" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${list.title}</td>
				<td>
				<a href="javascript:void(0);" onclick="selSp('${list.id}')"><font color="red">点击查看</font></a>
				</td>
				<td>${list.fname}</td>
				<td>${list.fdate}</td>
				<td class="imgtd"><img src="<%=basePath %>${list.state}" width="60" height="60"/></td>
				<td>${list.dz}</td>
				<td>
					<a href = "comm/showGg?id=${list.id}"><font color="blue">编辑</font></a>&nbsp;&nbsp;&nbsp;
					<c:if test="${list.zd == 0}">
						 <a href = "comm/zd?id=${list.id}"><font color="blue">置顶</font></a>&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:if test="${list.zd == 1}">
						 <a href = "comm/qxzd?id=${list.id}"><font color="blue">取消置顶</font></a>&nbsp;&nbsp;&nbsp;
					</c:if>
					<a href = "comm/deleteGg?id=${list.id}"><font color="blue">删除</font></a>
				</td>	
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list}">
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
				<li class="click"><span><img src="<%=basePath %>resource/admin/images/t01.png"/></span><a href="index/comm/gg/add.jsp">添加文章信息</a></li>
				</ul>
			</div>
		</div>
		<div class="pagin">
			<ul class="paginList">
				当前第&nbsp;<i class="blue"> ${pageInfo.pageNum}&nbsp;</i>页，
				共&nbsp;<i class="blue">&nbsp;${pageInfo.total}&nbsp;</i>条记录，
				共&nbsp;<i class="blue"> ${countPage}&nbsp;</i>页&nbsp;&nbsp;
				<a href="comm/selGg?page=1">首页</a>&nbsp;&nbsp;
			    <a href="comm/selGg?page=${pageInfo.hasPreviousPage==false?1:pageInfo.prePage}">上一页</a>&nbsp;&nbsp;
			    <a href="comm/selGg?page=${pageInfo.hasNextPage==false?pageInfo.pages:pageInfo.nextPage}">下一页</a>&nbsp;&nbsp;
			    <a href="comm/selGg?page=${pageInfo.pages}">尾页</a>&nbsp;&nbsp;
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

