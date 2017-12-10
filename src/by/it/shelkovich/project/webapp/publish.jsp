<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<form class="form-horizontal" action="${pageContext.request.contextPath}/?command=publish" method="POST" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->
<legend>Регистрация</legend>

<!-- File Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="imageFile">Фотография (*.jpg)</label>
  <div class="col-md-4">
    <input id="imageFile" name="imageFile" class="input-file" type="file">
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Описание</label>
  <div class="col-md-4">
    <textarea class="form-control" id="description" name="description"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Отправить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/footer.jsp" %>


