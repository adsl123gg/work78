<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>添加机会</title>
	
</head>
<body class="well">
	
  
  <div class="container" style="width:800px;background-color:white;margin-top:70px">
	<div class="well" style="background-color:#F0F5F8">
		<div style="font-size:30px">
			添加机会
		</div>
	</div>
	<form class="form-horizontal" action="addcontactchance.action" method="post" id="addform">
        <fieldset>
        
		  <div class="control-group">
            <div class="control-label"><span style="color:red"></span>机会名称</div>
            <div class="controls">
              <input type="text" id="chancename" class="input-xlarge" name="chance.name">
              <input type="hidden" class="input-xlarge" value="${contact.id}" name="contact_id">
              <span style="color:red">(必填)</span>
            </div>
          </div>
		  <div class="control-group">
            <label for="input01" class="control-label" style="display:inline">机会描述或背景信息</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge" name="chance.info"></textarea>
            </div>
          </div>
		 
		  <div class="control-group">
            <label for="input01" class="control-label">金额</label>
            <div class="controls">
              <input type="text" id="input01" class="span2" name="chance.money">
			  <span class="add-on">元</span>
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">分类</label>
            <div class="controls">
			  <select style="width:100px" class="span1 offset1" name="chanceType">
				
				<c:forEach items="${chanceTypes}" var="chanceType">
					<option value="${chanceType.id}">${chanceType.name}</option>
				</c:forEach>

				</select>
				<a href="toeditChanceType.action">新建/编辑 分类</a>
            </div>
          </div>
		    
		  <div class="control-group">
            <label class="control-label">谁可以看见？</label>
            <div class="controls">
              <label class="radio">
                <input type="radio" value="option1" id="optionsRadios1" name="optionsRadios">
                所有同事
              </label>
              <label class="radio">
                <input type="radio" value="option2" id="optionsRadios2" name="optionsRadios">
               只有我自己
              </label>
            </div>
          </div>
        </fieldset>
		<div class="form-actions container" style="width:500px">
            <button class="btn btn-primary" type="button" id="btn">添加这个机会</button>
            <a href="tocontact.action?contact_id=${contact.id}" class="btn">取消</a>
          </div>
      </form>
  </div>
	
  
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#chancename").val()!=''){
					$("#addform").submit();
				}else{
					alert("机会名称未填");
				}
				
			});
		});
	</script>


</body>
</html>