<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
</div>

<div class="row">
    <div class="col-md-1">Название игры</div>
        <div class="col-md-3">Жанр</div>
        <div class="col-md-3">Количетсво игроков</div>
        <div class="col-md-2">Взнос</div>
        <div class="col-md-1">Краткое описание</div>

</div>

<br>

<c:forEach items="${ads}" var="ad">
    <div class="row">
        <div class="col-md-1">${ad.Name} </div>
                <div class="col-md-3">${ad.Genre} </div>
                <div class="col-md-3">${ad.Number_Of_Players} </div>
                <div class="col-md-2">${ad.price} </div>
                <div class="col-md-1">${ad.Description} </div>
    </div>
<br>
</c:forEach>

<t:paginator count="${adCount}" step="${adStep}" urlprefix="?start="/>
<%@ include file="include/end-html.jsp" %>