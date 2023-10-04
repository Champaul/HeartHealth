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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>进行测试</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>resource/admin/commons/utils.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#optionsRadios1").focus();
	})
	function add(){
			var optionsRadios1=$.trim($("#optionsRadios1").val());
			debugger
			if(optionsRadios1.length==0){
				alert("请全部选择后提交");
				$("#optionsRadios1").focus();
				return false;
			}
			return true;
		}
	</script>
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="javascript:void(0)">测试管理</a></li>
		<li><a href="javascript:void(0)">提交测试</a></li>
	</ul>
</div>

<form action = "comm/addBf" method = "post"  class="validate" onsubmit="return add();" >
	<div class="formbody">
		<div class="formtitle"><span>基本信息</span></div>
		<ul class="forminfo">
	<c:if test="${!empty list}">
		<c:forEach items="${list}" var="list" varStatus="vs">
			<li>
			<p>${vs.index+1}. ${list.title}</p><br/>
				<input name="xs${list.id}" value="0" id="optionsRadios1" type="radio"  />是&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="xs${list.id}" value="1" id="optionsRadios1" type="radio"   />否
			</li>
			 </c:forEach>
			</c:if> 
		<c:if test="${empty list}">
			<tr>
				<td colspan="8" align="center">
					<strong><font color="red">暂时没有数据</font></strong>
				</td>
			</tr>
		</c:if>
		<br/>
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="提交"  />
				<input type="reset" class="btn" value="重置"  />
			</li>
		</ul>
	</div>
</form>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
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
<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/js/validate.js"></script>
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 
</body>
</html>
	