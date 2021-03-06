<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>添加联系人</title>
	
</head>
<body class="well">
	
  <div class="container" style="background-color:white;width:800px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		<div style="font-size:30px;padding-top:13px;padding-left:20px">
			添加联系人
		</div>
	</div>
	<form class="form-horizontal" id="form" action="updatecontact.action" style="margin-top:20px">
		
		<input type="hidden" name="contact_id" value="${contact.id}" />
		
        <fieldset>
          <div class="control-group">
            <label for="input01" class="control-label"><span style="color:red"></span>姓名</label>
            <div class="controls">
              <input type="text" id="name" class="input-xlarge" name="contact.name" value="${contact.name}">
               <span style="color:red">(必填)</span>
            </div>
          </div>
		  <div class="control-group">
            <label for="input01" class="control-label">职位</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.post }" name="contact.post">
            </div>
          </div>
		  <div class="control-group">
            <label for="input01" class="control-label">公司</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.companyname}" name="contact.companyname">
            </div>
          </div>
		  <div class="control-group">
            <label for="input01" class="control-label">电话</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.phone}" name="contact.phone">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">邮箱</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.email }" name="contact.email">
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">IM</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.im}" name="contact.im">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">网站</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.website}" name="contact.website">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">地址</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.address}" name="contact.address">
			  
            </div>
          </div>
          <div class="control-group">
            <label for="input01" class="control-label">新浪微博</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${contact.weibo}" name="contact.weibo">
			
            </div>
          </div>
		    
		   <div class="control-group">
            <label for="input01" class="control-label">背景信息</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge" value="${contact.bg_info}" name="contact.bg_info"></textarea>
			   
            </div>
          </div>
		  
        </fieldset>
		<div class="form-actions">
            <button class="btn btn-primary" type="button" id="save">保存联系人</button>
            <a class="btn" href="tocontact.action?contact_id=${contact.id}">取消</a>
          </div>
      </form>
  </div>

	<script type="text/javascript">
  	$(document).ready(function(){
  		$("#save").click(function(){
  			if($("#name").val()!=''){
  				$("#form").submit();
  			}else{
  				alert("联系人姓名不能为空！");
  			}
  		});
  	});
  </script>

	
</body>
</html>