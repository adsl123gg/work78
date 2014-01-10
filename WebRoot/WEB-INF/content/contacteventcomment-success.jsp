<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>联系人事件</title>
	
</head>
<body class="well">
	
  <div class="container" style="width:800px;background-color:white;height:600px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		<table style="width:100%;">
		<tbody>
			<tr>
				<td>
					<div style="margin-left:20px">
						<span style="font-size:20px"><strong><a href="">${contact.name}</a></strong>的事件</span><br />
						${contactEvent.user.name}添加于${contactEvent.createtime}
					</div>
				</td>
				<td width="10%">
					<%-- <a href="editcontactevent.action?contacteventid=${contactEvent.id}" class="icon icon-edit"></a>|
					<a href="delcontactevent.action?contacteventid=${contactEvent.id}&contact_id=${contact.id}" class="icon icon-trash"></a> --%>
				</td>
			</tr>
		</tbody>
		</table>
	</div>
	
	<div class="main" style="margin-top:20px">
		<div class="content " style="margin-left:20px">
			<p>${contactEvent.info}</p>
		</div>
		
		<table class="table top comments container" style="width:600px">
			<tbody>
				<c:forEach items="${contactComments}" var="contactComment">
					<tr id="">
						<td width="10%">
							<a id="">
								<img width="60px" height="60px" src="img/${contactComment.user.avatar}" alt="">
							</a>
						</td>
						<td>
							<div class="comment" style="padding-bottom:5px;">
								<div style="float:right">
									<a href="delcontacteventcomment.action?contactCommentId=${contactComment.id}&contacteventid=${contactEvent.id}" title="删除这个评论" class="icon icon-trash" ></a>
								</div>
								<div class="date">${contactComment.createtime}</div>
								<span class="meta">${contactComment.user.name}</span>
								
							</div>
											
							<div class="content">
								<p>${contactComment.content}</p>
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
						<form id="form" action="addcontactcomment.action" method="post">
							<input type="hidden" name="contacteventid" value="${contactEvent.id}"/>
							<textarea id="textarea" name="contactComment.content" style="width:665px" rows="4"></textarea>
							<button id="btn" class="btn btn-primary pull-right">添加评论</button>
							<a href="tocontact.action?contact_id=${contact.id}" class="btn pull-right">取消</a>
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
				}		
			});
		});
	</script>

</body>
</html>