<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title></title>
	
</head>
<body style="background-color:#F3F1EC">
	
	<div class="container" style="width:800px;background-color:white;margin-top:70px">
		<div class="well screen" style="padding-top:0px;height:30px;margin:0px;background-color:#F0F5F8">
			<div class="page-header header" style="">
				<span style="font-size:30px">同事列表</span>		
			</div>
		</div>
		
		<div class="main" id="main" style="height:500px">
			<table class="table crm-table">
				<tbody>
				
					<c:forEach items="${colleagues}" var="c">
						<tr>
							<td width="50">
								<img style="width:50;height:50px" src="img/${c.avatar}"></img>
							</td>
							<td style="padding-left:40px">
								<div class="name" style="margin-top:5px">
									<strong>${c.name}</strong>
								</div>
								<div class="email">${c.email}</div>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		
	</div>
	
</body>
</html>