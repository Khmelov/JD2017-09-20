<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<c:if test="${user != null}">
    <h4>Здравствуйте ${user.getUsername()}</h4>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/?command=profile" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>Ваши данные:</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="username">Имя пользователя</label>
      <div class="col-md-4">
      <input id="username" name="username" type="text" placeholder="" class="form-control input-md" required="" value="${user.getUsername()}">
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
      <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="" value="${user.getEmail()}">
      <span class="help-block">email@domail.com</span>
      </div>
    </div>

    <!-- Multiple Checkboxes (inline) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="showPersonalData">Показывать всем персональные данные</label>
      <div class="col-md-4">
        <label class="checkbox-inline" for="showPersonalData-0">
          <input type="checkbox" name="showPersonalData" id="showPersonalData-0" value="1" ${user.getShowPersonalData()? "checked=''": ""}>
          да
        </label>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Имя</label>
      <div class="col-md-4">
      <input id="name" name="name" type="text" placeholder="" class="form-control input-md" value="${user.getName()}">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="surname">Фамилия</label>
      <div class="col-md-4">
      <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md" value="${user.getSurname()}">

      </div>
    </div>

    <!-- Textarea -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="description">Описание</label>
      <div class="col-md-4">
        <textarea class="form-control" id="description" name="description">${user.getDescription()}</textarea>
      </div>
    </div>

    <!-- Button (Double) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="update"></label>
      <div class="col-md-8">
        <button id="update" name="update" class="btn btn-success">Обновить</button>
        <button id="delete" name="delete" class="btn btn-danger">Удалить пользователя</button>
      </div>
    </div>

    </fieldset>
    </form>


</c:if>

<%@ include file="include/footer.jsp" %>


