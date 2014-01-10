<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>任务</title>
</head>
<body>
	
  <div class="row container" style="margin-top:70px;width:800px">
	  <div class="">
		<div class="" style="background-color:#F0F5F8">
			<div >
				<h2 style="display:inline">机会</h2>
			</div>
		</div>
		
		<div class="alert alert-info" style="width:70px;position:absolute;right:0px;top:100px">
	        <strong class="container"><a href="toaddchance.action" >创建机会</a></strong>
	      </div>
		
		<div class="">
		  <table class="table" >
			
			<tbody class="container">
				<c:forEach items="${chances}" var="chance">
					 <tr>
						<td width="90%">
							<div style="margin-left:20px">
								<a href="chance-event.action?chance_id=${chance.id}">${chance.name}</a> <br>
								${chance.info}<br>
								<span style="background:${chance.chanceType.color};" class="label">${chance.chanceType.name}</span>
								${chance.money}<br>
								来自${chance.user.name}
							</div>
							
						</td>
						<td width="10%">
							<strong class="pull-right">跟踪</strong>
						</td>
						
					</tr>
				</c:forEach>
			 
			  
			</tbody>
		  </table>
		</div>
	</div>
		
	</div>

</body>
</html>