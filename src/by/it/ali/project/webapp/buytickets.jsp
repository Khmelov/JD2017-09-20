<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=BuyTickets" method="post">
<fieldset>

<!-- Form Name -->
<legend>Доступные билеты</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="destination">Направление</label>
  <div class="col-md-4">
  <input id="destination" name="destination" type="text" placeholder="Moscow, Rome, Madrid" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="company">Компания</label>
  <div class="col-md-4">
  <input id="company" name="company" type="text" placeholder="Belavia, Aeroflot, S7" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="date">Дата вылета</label>
  <div class="col-md-4">
  <input id="date" name="date" type="text" placeholder="YYYY-MM-DD" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Стоимость</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="Эконом - 130$, Бизнес - 200$" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buybutton"></label>
  <div class="col-md-4">
    <button id="buybutton" name="buybutton" class="btn btn-success">Купить</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>


