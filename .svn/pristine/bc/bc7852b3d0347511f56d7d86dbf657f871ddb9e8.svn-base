<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title></title>
	
</head>
<body style="background-color:#F3F1EC">
	
	<div class="tabbable container" style="margin-top:70px;width:800px"> 
		<div style="background-color:#F0F5F8;padding-top:20px;padding-left:20px">
			<span style="font-size:30px">修改个人信息</span>
			<ul class="nav nav-tabs" style="margin-top:20px">
				<li class="active"><a href="#tab1" data-toggle="tab">基本信息</a></li>
				<li><a href="#tab2" data-toggle="tab">修改密码</a></li>
				<li><a href="#tab3" data-toggle="tab">修改头像</a></li>
			</ul>
		</div>
		
		<div class="tab-content" style="background-color:white;margin-top:-19px;height:350px">
			<div class="tab-pane active" id="tab1" style="margin-top:20px">
				
				<form method="post" id="form-name" class="simple_form user-form" action="updateUserName.action" style="margin-left:20px">
					<div class="control-group string optional">
						<label for="user_name" class="string optional control-label">姓名</label>
						<div class="controls">
							<input type="text" value="${user.name}" size="50" name="user.name" id="n" class="string optional"/>
						</div>
					</div>
					<div class="control-group email optional">
						<label for="user_email" class="email optional control-label"> Email</label>
						<div class="controls">
							<input type="text" readonly="readonly" value="${user.email}" size="50"  name="user.email" id="" class="string email optional"/>
						</div>
					</div>
				 
					<div class="form-actions">
						<input type="button" id="name" value="保存修改" name="" class="btn"/>
					</div>
				</form>
				
				
			</div>
			<div class="tab-pane" id="tab2" style="margin-top:20px;margin-left:20px">
				<form action="updateUserPwd.action" method="post" id="form-pwd">
					<label>当前密码</label>
					<input type="password" name="user.password" id="old" />
					
					<label>新密码</label>
					<input type="password" name="newPwd" id="new" />
					
					<label>重新输入新密码</label>
					<input type="password" name="newPwd2" id="new2" />
					
					<div class="form-actions">
						<input type="button" id="pwd" value="保存修改" class="btn"/>
					</div>
				</form>
			</div>
			<div class="tab-pane" id="tab3" style="margin-top:20px;margin-left:20px">
				<form action="updateUserAvatar.action" method="post" id="form-avatar" enctype="multipart/form-data">
					<img style="width:50px;height:50px" src="img/${user.avatar}"></img><br />
					
					<input type="file" name="avatar" id="a" />
					<label >从本地电脑选择一张大头照 (不要超过2M)</label>
					
					<div class="form-actions">
						<input type="button"  value="保存修改" id="avatar" class="btn"/>
					</div>
				</form>
				
			</div>
		</div>
    </div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#name").click(function(){
				if($("#n").val()!=''){
					$("#form-name").submit();
				}else{
					alert("用户姓名不能为空！");
				}
				
			});
			$("#pwd").click(function(){
				if($("#old").val()==''){
					alert("旧密码未填");
				}else if($("#new").val()==''){
					alert("新密码未填");
				}else if($("#new2").val()==''){
					alert("确认你密码未填");
				}else if($("#new").val()!=$("#new2").val()){
					alert("新密码与确认密码不相同");
				}else{
					$("#form-pwd").submit();
				}
				
				
			});
			$("#avatar").click(function(){
				if($("#a").val()!=''){
					$("#form-avatar").submit();
				}else{
					alert("未上传文件");
				}
			});
		});
	</script>
	
</body>
</html>