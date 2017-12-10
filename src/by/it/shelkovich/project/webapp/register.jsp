<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<form class="form-horizontal" action="${pageContext.request.contextPath}/?command=register" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Регистрация</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="username">Имя пользователя</label>
  <div class="col-md-4">
  <input id="username" name="username" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">минимум 6 символов</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">минимум 6 символов</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">email@domail.com</span>
  </div>
</div>

<!-- Multiple Checkboxes (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="showPersonalData">Показывать всем персональные данные</label>
  <div class="col-md-4">
    <label class="checkbox-inline" for="showPersonalData-0">
      <input type="checkbox" name="showPersonalData" id="showPersonalData-0" value="1">
      да
    </label>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Имя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="surname">Фамилия</label>
  <div class="col-md-4">
  <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md">

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
  <label class="col-md-4 control-label" for="register"></label>
  <div class="col-md-4">
    <button id="register" name="register" class="btn btn-primary">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/footer.jsp" %>


