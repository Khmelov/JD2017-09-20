<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать объявление</legend>
<fieldset>


<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Процессор</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">Intel Core i7-8700K</option>
      <option value="2">AMD Ryzen 5 1600</option>
      <option value="3">AMD Ryzen 3 1200</option>
      <option value="4">AMD Ryzen 7 1700</option>
      <option selected value="5">Intel Core i5-8400</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Видеокарта</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">MSI GeForce GTX 1060 Gaming X 6GB GDDR5</option>
      <option value="2">Palit GeForce GTX 1050 Ti Dual OC 4GB GDDR5 </option>
      <option value="3">Gigabyte GeForce GTX 1070 Ti Gaming 8GB GDDR5</option>
      <option value="4">Gigabyte AORUS GeForce GTX 1080 Ti 11GB GDDR5X</option>
      <option selected value="5">Intel Core i5-8400</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Видеокарта</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">MSI GeForce GTX 1060 Gaming X 6GB GDDR5</option>
      <option value="2">Palit GeForce GTX 1050 Ti Dual OC 4GB GDDR5 </option>
      <option value="3">Gigabyte GeForce GTX 1070 Ti Gaming 8GB GDDR5</option>
      <option value="4">Gigabyte AORUS GeForce GTX 1080 Ti 11GB GDDR5X</option>
      <option selected value="5">Gigabyte AORUS GeForce GTX 1080 Ti 11GB GDDR5X/option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Материнская плата</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">ASRock Z370 Pro4</option>
      <option value="2">ASUS ROG Strix B350-F Gaming </option>
      <option value="3">ASUS Prime Z370-A</option>
      <option value="4">ASRock B250M-HDV</option>
      <option selected value="5">ASRock Z370 Pro</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">ОЗУ</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">Kingston HyperX FURY 8GB DDR4</option>
      <option value="2">Kingston HyperX FURY 16GB DDR4 PC4-19200</option>
      <option value="3">Corsair Vengeance LED 2x16GB DDR4 PC4-24000 </option>
      <option value="4">Corsair Vengeance 4x16GB DDR4-SODIMM PC4-19200 </option>
      <option selected value="5">Kingston HyperX FURY 8GB DDR4</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Блок питания</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1">AeroCool Kcas 500W</option>
      <option value="2">AeroCool Kcas 600W</option>
      <option value="3">AeroCool Kcas 700W</option>
      <option value="4">AeroCool Kcas 1200W</option>
      <option selected value="5">AeroCool Kcas 500W</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Жесткий диск</label>
  <div class="col-md-5">
    <select id="Floors" name="Floors" class="form-control">
      <option value="1"> 1 Тб 5400об/мин</option>
      <option value="2">2 Тб 7200об/мин</option>
      <option value="3">3 Тб 7200об/мин</option>
      <option value="4">512гб 5400об/мин</option>
      <option selected value="5">512гб 5400об/мин</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
  </div>
</div>
</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
