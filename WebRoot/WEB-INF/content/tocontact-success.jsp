<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title></title>
	
</head>
<body class="well">
	
	<div class="tabbable container" style="margin-top:70px;width:800px"> 
		<div style="background-color:#F0F5F8;padding-top:20px;padding-left:20px">
			<table width="800px">
				<tr>
					<td width="10%">
						<img src="img/${contact.avatar}" alt="" />
					</td>
					<td width="">
						<strong style="font-size:20px">${contact.name}</strong><br />
						<c:forEach items="${bookMarkContacts}" var="bookMarkContact">
							<a href="" class="label">${bookMarkContact.bookMark.content}</a>
						</c:forEach>
						<a href="">编辑书签</a>
					</td>
					<td width="10%" >
						<a href="toeditcontact.action?contact_id=${contact.id}">编辑</a>
						<i class="icon icon-edit"></i>
					</td>
				</tr>
			</table>
			<div class="tabbable">
				<ul class="nav nav-tabs" style="margin-top:20px">
					<li class="active" style=";width:100px"><a style="padding-left:35px" href="#tab1" data-toggle="tab">事件</a></li>
					<li style="width:100px" class=""><a style="padding-left:35px" href="#tab2" data-toggle="tab">机会 </a></li>
					
				</ul>
			</div>
			
		</div>
		
		<div class="tab-content" style="background-color:white;margin-top:-19px;height:350px">
			<div class="tab-pane active" id="tab1" style="margin-top:20px">
				
				<form class="form-horizontal" id="contacteventinfo" action="addContactEventInfo.action" style="margin-top:20px">
					<input type="hidden" name="contact_id" value="${contact.id}"/>
					<div class="container" style="width:630px">
					  <textarea rows="3" name="contactEventInfo" id="info" style="width:630px" class=""></textarea>
					</div>
					
					<div class="container" style="width:630px;margin-top:20px">
						<button class="btn btn-primary pull-right" type="button" id="btn">添加事件</button>
					</div>
					  
				</form>
				
				<table class="table top no-hover container" style="width:670px">
					<tbody>
						<c:forEach items="${contactEvents}" var="contactEvent">
							<tr>
								<td width="10%">
									<img src="img/text.png" alt="" />
								</td>
								<td>
									${contactEvent.createtime} <br />
									${contactEvent.user.name} 添加 <br />
									${contactEvent.info}
								</td>
								<td width="20%">
									<a href="contacteventcomment.action?contacteventid=${contactEvent.id}">评论</a>
									<a href="editcontactevent.action?contacteventid=${contactEvent.id}">编辑</a>
									<a onclick="delcontactevent(this)" contacteventid="${contactEvent.id}" contact_id="${contact.id}" href="javascript:;">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				
				</table>
				
				
			</div>
			<div class="tab-pane " id="tab2" style="margin-top:20px;margin-left:20px">
				
				<table id="" class="table table-striped crm-table">
					<tbody>
						<c:forEach items="${contactChances}" var="contactChance">
							<tr class="">
								<td>
									<h4>
										<a href="chance-event.action?chance_id=${contactChance.id}">${contactChance.name}</a>
									</h4>
									
									<div class="description">${contactChance.chanceType.name}</div>
									<div class="price">
										${contactChance.money}
									</div>
								</td>
								<td class="" width="10%">
									<span class="label label-pending">${contactChance.status}</span>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>

				<a class="btn btn-primary" href="toaddcontactchance.action?contact_id=${contact.id}">添加机会</a>
  
			</div>
		
		</div>
		
		
    </div>
    
    <script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#info").val()!=''){
					$("#contacteventinfo").submit();
				}else{
					alert("事件不为空！");
				}
				
			});		
			
		});
		
		function delcontactevent(obj){
			var a=$(obj);
			var rs=confirm("删除联系人事件会删除该事件的所有评论，确定删除吗？");
			if(rs){
				a.parent().parent().remove();
				$.get("delcontactevent.action",{"contacteventid":a.attr("contacteventid"),"contact_id":a.attr("contact_id")});
			}
		}
		
	</script>
	
</body>
</html>