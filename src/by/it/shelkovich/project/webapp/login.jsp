<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<form class="form-horizontal" action="${pageContext.request.contextPath}/?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Войти</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="username">Имя пользователя</label>
  <div class="col-md-4">
  <input id="username" name="username" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/footer.jsp" %>