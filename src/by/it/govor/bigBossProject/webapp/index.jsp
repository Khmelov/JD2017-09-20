<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Вывод данных</p>
</div>

<div class="row">
    <div class="col-md-3">Проц</div>
    <div class="col-md-3">Видюха</div>
    <div class="col-md-3">Материнка</div>
    <div class="col-md-3">ОЗУ</div>
    <div class="col-md-3">БП</div>
    <div class="col-md-3">ЖД</div>

</div>

<br>

<c:forEach items="${ad}" var="ad">
    <div class="row">
        <div class="col-md-3">${ad.processor} </div>
        <div class="col-md-3">${ad.video_card} </div>
        <div class="col-md-3">${ad.motherboard} </div>
        <div class="col-md-3">${ad.ram} </div>
        <div class="col-md-3">${ad.power_supply} </div>
        <div class="col-md-3">${ad.HDD} </div>
    </div>
<br>
</c:forEach>

<%@ include file="include/end-html.jsp" %>