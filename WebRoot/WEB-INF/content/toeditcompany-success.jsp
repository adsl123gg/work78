<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>编辑公司</title>
</head>
<body class="well">
	
  
 <div class="container" style="background-color:white;width:800px;margin-top:70px">
	<div class="" style="background-color:#F0F5F8;height:50px">
		<div style="font-size:30px;padding-top:13px;padding-left:20px">
		编辑公司
	</div>
	</div>
	<form class="form-horizontal" id="form" action="updatecompany.action" style="margin-top:20px">
        <fieldset>
          <div class="control-group">
            <label for="input01" class="control-label"><span style="color:red"></span>名称</label>
            <div class="controls">
              <input type="text" id="name" class="input-xlarge" value="${company.name}" name="company.name">
              <input type="hidden" name="companyid" value="${company.id}" />
              <span style="color:red">(必填)</span>
            </div>
          </div>
		
		  <div class="control-group">
            <label for="input01" class="control-label">电话</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${ company.phone}" name="company.phone">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">邮箱</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${ company.email}" name="company.email">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">IM</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${company.im }" name="company.im">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">网站</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${company.website }" name="company.website">
			  
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">地址</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${ company.address}" name="company.address">
			  
            </div>
          </div>
         
		     <div class="control-group">
            <label for="input01" class="control-label">新浪微博</label>
            <div class="controls">
              <input type="text" id="input01" class="input-xlarge" value="${ company.weibo}" name="company.weibo">
			
            </div>
          </div>
		   <div class="control-group">
            <label for="input01" class="control-label">背景信息</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge" name="company.bg_info">${company.bg_info}</textarea>
			  
            </div>
          </div>
		  
        </fieldset>
		<div class="form-actions">
            <button class="btn btn-primary" id="save" type="button">保存公司</button>
            <a class="btn" href="tocompany.action?companyid=${company.id}"  id="cancle">取消</a>
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