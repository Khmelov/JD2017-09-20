<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SignUp" method="post">
<fieldset>

<!-- Form Name -->
<legend>Форма регистрации</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Your login" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="password" class="form-control input-md" required="">
    <span class="help-block">Не менее 8 символов</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="xxx@xxx.xxx" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="RegisterButton"></label>
  <div class="col-md-4">
    <button id="RegisterButton" name="RegisterButton" class="btn btn-primary">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>


