<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title></title>
	
</head>
<body class="well">
	
	<div class="container" style="width:960px;background-color:white;margin-top:70px;height:600px">
		<div class="well screen" style="height:30px;margin:0px;background-color:#F0F5F8">
			<div class="page-header header" style="">
				<span style="font-size:30px">最新动态</span>		
			</div>
		</div>
		
		<div id="main" class="main" style="margin-top:20px">
			<table class="table crm-table dashboard">
				<tbody>
					<c:forEach items="${messages}" var="message">
						<tr id="">
							<td class="icon" width="20%">
								<i style="margin-left:20px" class="label label-success">${message.type}</i>
							</td>
							<td>
								${message.info}
							</td>
							<td class="actions date" width="10%">
								<span class="">${message.createtime}</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div style="margin-right:20px" class="pull-right pagination">
		  <ul>
		    <li><a  href="getMsg.action?p=prev&nowpage=${no}">上一页</a></li>
		    <li><a  href="getMsg.action?p=next&nowpage=${no}">下一页</a></li>
		  </ul>
		</div>
		
	</div>
	
	
</body>
</html>