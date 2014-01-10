<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title></title>
</head>
<body>
	
	<div class=" container" style="margin-top:74px">
		<div class="alert alert-alert">
            <h4 class="alert-heading">请登录。</h4>
        </div>
		
		<form  method="post" class="simple_form well" action="login.action" id="form">
			
			<div class="control-group  required">
				<div class="controls">
					<input type="text" size="50" placeholder="账号" name="user.name" id="" class="string email required span3"/>
				</div>
			</div>
			<div class="control-group password required">
				<div class="controls">
					<input type="password" size="50" placeholder="密码" name="user.password" id="" class="password required span3"/>
				</div>
			</div>
			
			<div  style="margin-bottom:10px">
				<img onclick="chance(this)" src="image.action" alt="" />
				<input style="margin-left:10px;width:30px" type="text"  name="result" id="result"/>
			</div>
			
			<div class="control-group optional">
				<div class="controls checkbox">
					<input type="checkbox"  value="a" name="rember" id=""/>
					记住登录状态
				</div>
			</div>
		
			<input type="button" value="登 录" name="" id="btn" class="btn btn btn-primary"/>
		</form>
	</div>
	
	<script type="text/javascript">
		function chance(obj){
			$(obj).remove();
			var image=$("<img>").attr("onclick","chance(this)").attr("src","image.action");
			image.insertBefore($("#result"));
		}
		
		
		$(document).ready(function(){
			$("#setting").hide();
			$("#btn").click(function(){
				if($("#result").val()==''){
					alert("请输入验证码的结果");
				}else{
					$("#form").submit();
					$("#btn").css("disabled","disabled");
				}
				
			});
			
		});
		
	</script>
	
</body>
</html>