<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h1>Профиль</h1>
</div>
<p><b> Login: ${user.login} </b></p>
<p><b> Email: ${user.email} </b></p>

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



<center>
    <br><br><br><br><br><br>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Logout</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</center>
<%@ include file="include/end-html.jsp" %>