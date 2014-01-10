<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>添加公司</title>
</head>
<body class="well">
	
  
 <div class="container" style="background-color:white;width:800px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		<div style="font-size:30px;padding-top:13px;padding-left:20px">
		添加公司
	</div>
	</div>
	<form class="form-horizontal" id="form" action="addcompany.action" style="margin-top:20px">
        <fieldset>
          <div class="control-group">
            <label for="input01" class="control-label"><span style="color:red"></span>名称</label>
            <div class="controls">
              <input type="text" id="name" class="input-xlarge" name="company.name">
              <span style="color:red">(必填)</span>
            </div>
          </div>
		
		  <div class="control-group">
            <label for="input01" class="control-label">电话</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.phone">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">邮箱</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.email">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">IM</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.im">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">网站</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.website">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">地址</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.address">
			  
            </div>
          </div>
         
		     <div class="control-group">
            <label for="input01" class="control-label">新浪微博</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" name="company.weibo">
			
            </div>
          </div>
		   <div class="control-group">
            <label for="input01" class="control-label">背景信息</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge" name="company.bg_info"></textarea>
			  
            </div>
          </div>
		  <div class="control-group">
            <label class="control-label">谁可以看见？</label>
            <div class="controls">
              <label class="radio">
                <input type="radio" checked="checked" value="all" id="optionsRadios1" name="optionscompany">
                所有同事
              </label>
              <label class="radio">
                <input type="radio" value="me" id="optionsRadios2" name="optionscompany">
               只有我自己
              </label>
            </div>
          </div>
        </fieldset>
		<div class="form-actions">
            <button class="btn btn-primary" type="button" id="save">保存公司</button>
            <a class="btn" href="contacts.action"  id="cancle">取消</a>
          </div>
      </form>
  </div>
  
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#save").click(function(){
  			if($("#name").val()!=''){
  				$("#form").submit();
  			}else{
  				alert("公司名称不能为空！");
  			}
  		});
  	});
  </script>
  
</body>
</html>