<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>机会</title>
	
</head>
<body class="well">
	
  <div class="container" style="width:800px;background-color:white;height:600px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:74px">
		<table style="width:100%;">
		<tbody><tr>
			<td width="10%" style="">
				<img src="img/dollar.png"></img>
			</td>
			<td>
				<strong>${chance.name}</strong>
				<br />
				
				${chance.money}
				
				<div data-toggle="buttons-radio" class="btn-group">
                    <button ref="none" class="c btn active">跟踪</button>
                    <button ref="success" class="c btn ">成功</button>
                    <button ref="fail" class="c btn ">失败</button>
                </div>
				
			</td>
			<td width="10%">
				<a href="toeditchance.action?chance_id=${chance.id}" >编辑机会</a><i class="icon icon-edit"></i>
			</td>
		</tr>
	</tbody></table>
	</div>
	<form class="form-horizontal" action="addchancevent.action" method="post" id="form" style="margin-top:20px">
        <input type="hidden" value="${chance.id}" name="chance_id"/>
		<div class="container" style="width:630px">
		  <textarea rows="3" id="textarea" name="chanceEventInfo" style="width:630px" class=""></textarea>
		</div>
		
		<div class="container" style="width:630px;margin-top:20px">
			<button class="btn btn-primary pull-right" type="button" id="btn">添加事件</button>
		</div>
        
          
    </form>

	
	<!-- chance event -->
	<table class="table top no-hover container" style="width:670px">
		<tbody>
			
			<c:forEach items="${chanceEvents}" var="chanceEvent"> 
				<tr>
					<td width="10%">
						<img src="img/text.png" alt="" />
					</td>
					<td>
						${chanceEvent.createtime} <br />
						${chance.user.name} 添加 <br />
						${chanceEvent.info}
					</td>
					<td width="20%">
						<a href="chance-event-comment.action?chance_event_id=${chanceEvent.id}">评论</a>
						<a href="chance-event-edit.action?chance_event_id=${chanceEvent.id}">编辑</a>
						<a onclick="delchanceevent(this)" chanceid="${chance.id}" eventid="${chanceEvent.id}" href="javascript:;">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
  </div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#textarea").val()!=""&&$("#textarea").val()!=null){
					$("#form").submit();	
				}else{
					alert("事件不允许为空");
				}
			});
			$(".c").click(function(){
				if($(this).attr("class").match("active")==null){
					var r=confirm("确定将机会状态改为"+$(this).text());
					if(r){
						$.get("changeChanceStatus.action",{"chanceStatus":$(this).attr("ref"),chance_id:"${chance.id}"});
					}else{
						return false;
					}
				}
			});
			
		});
		
		function delchanceevent(obj){
				var a=$(obj);
				var rs=confirm("删除事件会删除事件的所有评论，确定删除吗");
				if(rs){
					a.parent().parent().remove();
					$.get("chance-event-del.action",{"chance_event_id":a.attr("eventid"),"chance_id":a.attr("chanceid")});
				}
				//chance-event-del.action?chance_event_id=${chanceEvent.id}&chance_id=${chance.id}
		}
	</script>

</body>
</html>