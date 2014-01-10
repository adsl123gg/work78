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
		<table style="width:100%;">
		<tbody>
			<tr>
				<td>
					<div style="margin-left:20px">
						<span style="font-size:20px"><strong><a href="">${chance.name}</a></strong>的事件</span><br />
						${user.name}添加于${chanceEvent.createtime}
					</div>
				</td>
				<%-- <td width="10%">
					<a href="chance-event-edit.action?chance_event_id=${chanceEvent.id}">编辑</a>|
					<a href="chance-event-del.action?chance_event_id=${chanceEvent.id}&chance_id=${chance.id}" class="icon icon-trash"></a>
				</td> --%>
			</tr>
		</tbody>
		</table>
	</div>
	
	<div class="main" style="margin-top:20px">
		<div class="content " style="margin-left:20px">
			<p>${chanceEvent.info}</p>
		</div>
		
		<table class="table top comments container" style="width:600px">
			<tbody>
				<c:forEach items="${chanceComments}" var="chanceComment">
					<tr id="">
						<td width="10%">
							<a id="">
								<img width="60px" height="60px" src="img/${chanceComment.user.avatar}" alt="">
							</a>
						</td>
						<td>
							<div class="comment" style="padding-bottom:5px;">
								<div style="float:right">
									<a href="deletechancecomment.action?chanceComment_id=${chanceComment.id}&chance_event_id=${chanceEvent.id}" title="删除这个评论" class="icon icon-trash" ></a>
								</div>
								<div class="date">${chanceComment.createtime}</div>
								<span class="meta">${user.name}</span>
								
							</div>
											
							<div class="content">
								<p>${chanceComment.content}</p>
							</div>
						</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td width="10%">
						<a id="">
							<img width="60px" height="60px" src="img/${user.avatar}" alt="">
						</a>
					</td>
					<td>
						<form id="form" action="addchancecomment.action" method="post">
							<input type="hidden" name="chance_event_id" value="${chanceEvent.id}"/>
							<textarea id="textarea" name="chanceComment.content" id="" style="width:665px" rows="4"></textarea>
							<button id="btn" class="btn btn-primary pull-right">添加评论</button>
							<a href="chance-event.action?chance_id=${chance.id}" class="btn pull-right">取消</a>
						</form>
						
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>
	
  </div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#textarea").val()!=""&&$("#textarea").val()!=null){
					$("#form").submit();	
					//alert($("#textarea").val());
				}			
			});
		});
	</script>

</body>
</html>