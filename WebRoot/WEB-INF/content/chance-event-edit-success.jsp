<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>机会事件</title>
	
</head>
<body class="well">
	
  <div class="container" style="width:800px;background-color:white;height:600px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		
		<div style="padding-top:10px">
			<span style="font-size:20px;">编辑<strong> <a href="">${chance.name}</a> </strong>的事件 </span>  
		</div>
		
	</div>
	
	<div class="main" style="">
		<div class="container" style="margin-left:20px;margin-top:20px;width:735px">
			<form id="form" action="updateChanceEvent.action" method="post">
				<input type="hidden" name="chance_id" value="${chance.id}"/>
				<input type="hidden" name="chance_event_id" value="${chanceEvent.id}"/>
				<textarea name="chance_event_info" id="info" style="width:735px" rows="4">${chanceEvent.info}</textarea>
				<br />
				
				<button id="btn" class="btn btn-primary pull-right">保存修改</button>
				<a href="chance-event.action?chance_id=${chance.id}" class="btn pull-right" style="margin-right:10px">取消</a>
			</form>
			
		</div>
		
	</div>
	
  </div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#info").val()==''||$("#info").val()==null){
					alert("事件不允许为空！");
				}else{
					$("#form").submit();
				}
			});
		});
	</script>

</body>
</html>