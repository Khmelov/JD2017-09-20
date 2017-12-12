<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать объявление</legend>
<fieldset>


<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="processor">Процессор</label>
  <div class="col-md-5">
    <select id="processor" name="processor" class="form-control">
      <option value="Intel Core i7-8700K">Intel Core i7-8700K</option>
      <option value="AMD Ryzen 5 1600">AMD Ryzen 5 1600</option>
      <option value="AMD Ryzen 3 1200">AMD Ryzen 3 1200</option>
      <option value="AMD Ryzen 7 1700">AMD Ryzen 7 1700</option>
      <option selected value="Intel Core i5-8400">Intel Core i5-8400</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="video_card">Видеокарта</label>
  <div class="col-md-5">
    <select id="video_card" name="video_card" class="form-control">
      <option value="MSI GeForce GTX 1060 Gaming X 6GB GDDR5">MSI GeForce GTX 1060 Gaming X 6GB GDDR5</option>
      <option value="Palit GeForce GTX 1050 Ti Dual OC 4GB GDDR5">Palit GeForce GTX 1050 Ti Dual OC 4GB GDDR5 </option>
      <option value="Gigabyte GeForce GTX 1070 Ti Gaming 8GB GDDR5">Gigabyte GeForce GTX 1070 Ti Gaming 8GB GDDR5</option>
      <option selected value="Gigabyte AORUS GeForce GTX 1080 Ti 11GB GDDR5X">Gigabyte AORUS GeForce GTX 1080 Ti 11GB GDDR5X</option>
    </select>
  </div>
</div>


<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="motherboard">Материнская плата</label>
  <div class="col-md-5">
    <select id="motherboard" name="motherboard" class="form-control">
      <option value="ASUS ROG Strix B350-F Gaming">ASUS ROG Strix B350-F Gaming </option>
      <option value="ASUS Prime Z370-A">ASUS Prime Z370-A</option>
      <option value="ASRock B250M-HDV">ASRock B250M-HDV</option>
      <option selected value="ASRock Z370 Pro">ASRock Z370 Pro</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="ram">ОЗУ</label>
  <div class="col-md-5">
    <select id="ram" name="ram" class="form-control">
      <option value="Kingston HyperX FURY 16GB DDR4 PC4-19200">Kingston HyperX FURY 16GB DDR4 PC4-19200</option>
      <option value="Corsair Vengeance LED 2x16GB DDR4 PC4-24000">Corsair Vengeance LED 2x16GB DDR4 PC4-24000 </option>
      <option value="Corsair Vengeance 4x16GB DDR4-SODIMM PC4-19200">Corsair Vengeance 4x16GB DDR4-SODIMM PC4-19200 </option>
      <option selected value="Kingston HyperX FURY 8GB DDR4">Kingston HyperX FURY 8GB DDR4</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="power_supply">Блок питания</label>
  <div class="col-md-5">
    <select id="power_supply" name="power_supply" class="form-control">
            <option value="AeroCool Kcas 600W">AeroCool Kcas 600W</option>
      <option value="AeroCool Kcas 700W">AeroCool Kcas 700W</option>
      <option value="AeroCool Kcas 1200W">AeroCool Kcas 1200W</option>
      <option selected value="AeroCool Kcas 500W">AeroCool Kcas 500W</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="HDD">Жесткий диск</label>
  <div class="col-md-5">
    <select id="HDD" name="HDD" class="form-control">
      <option value="1 Тб 5400об/мин"> 1 Тб 5400об/мин</option>
      <option value="2 Тб 7200об/мин">2 Тб 7200об/мин</option>
      <option value="3 Тб 7200об/мин">3 Тб 7200об/мин</option>
      <option selected value="512гб 5400об/мин">512 гб 5400об/мин</option>
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
