<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
</head>
<body style="background-color:#F3F1EC">
	
  <div class="container" style="width:800px;background-color:white;height:500px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		<div style="font-size:22px;padding:16px 0px 0px 13px">机会分类</div>
	</div>
	
	<div class="main container" style="width:750px">
		<p style="margin-top:20px">修改分类会影响到同事们的机事件。比如，如果您将“设计”改为“LOGO设计”，所有分类为“设计”的机会都将改为“LOGO设计”。 请确认您的修改会通知到所有同事。</p>
		<div class="new">
			<form id="addform" action="addTaskType.action" class="well form-inline" method="post" >
				<input type="text" name="taskType.name" id="ttn" />
				<button id="add" class="btn" value="">添加</button>
			</form>
		</div>
		<form id="updateform" action="updateTaskType.action" method="post">
			<table class="table crm-table">
				<tbody>
					<c:if test="${message=='10001'}">
						<div class="alert alert-error">
						     该机会类型被使用，无法删除！	
						</div>			
					</c:if>
					
					<c:forEach items="${taskTypes}" var="taskType">
						<tr>
							<td width="30%">
								<input type="hidden" name="taskType.id" value="${taskType.id}"/>
								<input style="width:175px" name="taskType.color" id="${taskType.id}" type="text" value="${taskType.color}" class="iColorPicker" />
							</td>
							<td width="60%">
								<input type="text" name="taskType.name" style="width:70px" value="${taskType.name}" /> 
							</td>
							<td width="10%">
								<a class="icon icon-trash"  href="delTaskType.action?task_type_id=${taskType.id}" data-original-title="删除这个分类"></a>
							</td>
							
						</tr>
					</c:forEach>
					<tr>
						
					</tr>
				</tbody>
				
			</table>
			<button id="update" class="btn">完成编辑，返回</button>
		</form>
		
		
	</div>
	
  </div>
  
  <script type="text/javascript">
		$(document).ready(function(){
			$("#add").click(function(){
				if($("#ttn").val()!=''){
					$("#addform").submit();
				}else{
					alert("请输入新任务类型的名称！");
				}
			});
			
			$("#update").click(function(){
				$("#updateform").submit();
			});
			
		});	
  </script>
	
</body>
</html>