<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="nav_bar.jsp" %>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>编辑机会</title>
	
</head>
<body class="well">
	
  
  <div class="container" style="width:800px;background-color:white;margin-top:70px">
	<div class="well" style="background-color:#F0F5F8">
		<div style="font-size:30px">
			编辑机会
		</div>
	</div>
	<form class="form-horizontal" action="updatechance.action" method="post" id="form">
        <fieldset>
          <input type="hidden" value="${chance.id}" name="chance_id"/>
		  <div class="control-group">
            <div class="control-label"><span style="color:red"></span>机会名称</div>
            <div class="controls">
              <input value="${chance.name}" type="text" id="nn" class="input-xlarge" name="chanc.name">
            </div>
          </div>
		  <div class="control-group">
            <label for="input01" class="control-label" style="display:inline">机会描述或背景信息</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge" name="chanc.info">${chance.info}</textarea>
            </div>
          </div>
		 
		  <div class="control-group">
            <label for="input01" class="control-label">金额</label>
            <div class="controls">
              <input type="text" id="input01" class="span2" value="${chance.money}" name="chanc.money">
			  <span class="add-on">元</span>
            </div>
          </div>
		    <div class="control-group">
            <label for="input01" class="control-label">分类</label>
            <div class="controls">
			  <select style="width:100px" class="span1 offset1" name="chanceType">
					<option value="${chance.chanceType.id}">${chance.chanceType.name}</option>
					<c:forEach items="${chanceTypes}" var="chanceType">
						<option value="${chanceType.id}">${chanceType.name}</option>
					</c:forEach>
					
				</select>
				<a href="editChanceType.action">新建/编辑 分类</a>
            </div>
          </div>
		
        </fieldset>
		<div class="form-actions container" style="width:500px">
            <button class="btn btn-primary" type="button" id="btn">保存修改</button>
            <a href="chance-event.action?chance_id=${chance.id}" class="btn">取消</a>
          </div>
      </form>
  </div>
	
  
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				//alert($("#c").val());
				if($("#nn").val()==''||$("#nn").val()==null){
					alert("机会名称不允许为空！");
					return false;
				}else{
					$("#form").submit();
				}
			});
		});
	</script>


</body>
</html>