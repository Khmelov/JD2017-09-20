<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать объявление</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Name">Название игры</label>
  <div class="col-md-4">
  <input id="Name" name="Name" type="text" placeholder="" value="TEST: Manitu land" class="form-control input-md" required="">
  <span class="help-block">укажите название игры</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Genre">Жанр</label>
  <div class="col-md-4">
  <input id="Genre" name="Genre" type="text" placeholder="" value="TEST: Deadlands" class="form-control input-md" required="">
  <span class="help-block">укажите жанр игры</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Number_Of_Players">Количество игроков</label>
  <div class="col-md-4">
  <input id="Number_Of_Players" name="Number_Of_Players" type="text" placeholder="" value="45" class="form-control input-md" required="">
  <span class="help-block">Укажите количество игроков (чел.)</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Взнос с игрока</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" value="60" class="form-control input-md" required="">
  <span class="help-block">Укажите цену у.е.</span>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Description">Краткое Описание</label>
  <div class="col-md-4">
    <textarea class="form-control" id="Description" name="Description">TEST: Wired Wild West</textarea>
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Готово</button>
  </div>
</div>

</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
