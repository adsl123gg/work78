<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>任务</title>
	
</head>
<body class="well">
	
  <div class="row container" style="margin-top:70px;width:800px">
	  <div class="" style="background-color:#F0F5F8">
		<div class="" >
			<div >
				<h2 style="display:inline">任务</h2>
				<span style="float:right;margin-top:10px">
					<a href="task.action">待办的任务</a>|
					<a href="completetask.action">已完成的任务</a>
				</span>
			</div>
		</div>
		
		<div class="alert alert-info" style="width:70px;position:absolute;right:0px;top:100px">
	        <strong class="container"><a href="#addtask" data-toggle="modal">添加新任务</a></strong>
	      </div>
		
		<div class="" style="background-color:white;height:500px">
		  <table class="table" >
			
			<tbody class="container">
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td width="4%">
							<a href="javascript:void(0);" onclick="del(this)" id="${task.id}"  class="icon icon-trash" title="删除该任务"></a>
						</td>
						<td width="6%">
							<span style="background:${task.taskType.color};" class="label">${task.taskType.name}</span>
						</td>
						<td width="70%">
							<span style="font-size:30px">${task.name}</span> 
						</td >
						<td >
							<span class="pull-right label ">${task.createtime}</span>
						</td>
					</tr>
				</c:forEach>
			  
			  
			</tbody>
		  </table>
		</div>
	</div>
		
	</div>


	    <div class="modal hide  fade in" id="addtask">
		    <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal">×</button>
			    <h3>添加新任务</h3>
		    </div>
		    <div class="modal-body">
		    	<form action="addtask.action" method="post" id="form" style="margin-left:20px">
		    		<label>任务名称</label>
		    		<input type="text" id="name" name="task.name"/>
		    		<label>开始时间</label>
		    		<input type="text" name="task.starttime"/>
		    		<label>结束时间</label>
		    		<input type="text" name="task.deadline"/>
		    		<label>分类</label>
		    		<select name="task_type_id">
		    			 
		    			 <c:forEach items="${taskTypes}" var="taskType">
		    			 	<option value="${taskType.id}">${taskType.name}</option>
		    			 </c:forEach>
		    		</select>
		    		<br>
		    		<input type="checkbox" style="margin-right:16px"/>同事可以看见这个任务
		    	</form>
		    </div>
		    <div class="modal-footer">
			    <a href="#" class="btn" data-dismiss="modal">取消</a>
			    <button id="btn" class="btn btn-primary">添加</button>
		    </div>
	    </div>
	    
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				$("#form").submit();
			});
		});
		
		function del(obj){
			var rs=confirm("确定删除任务吗？");
			if(rs){
				var a=$(obj);
				a.parent().parent().remove();
				$.get("deletetask.action",{"task_id":a.attr("id")});
			}
		}
		
	</script>
	
</body>
</html>