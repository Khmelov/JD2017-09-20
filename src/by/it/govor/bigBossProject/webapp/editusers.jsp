<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
    <div class=col-md-1>ID</div>
    <div class=col-md-2>Login</div>
    <div class=col-md-2>Password</div>
    <div class=col-md-2>Name</div>
    <div class=col-md-2>Nick</div>
    <div class=col-md-2>Telephone</div>
    <div class=col-md-2>Role</div>
</div>

<c:forEach items="${users}" var="user">
<form class="edit-user-${user.id}" action="do?command=EditUsers" method=POST>
    <div class="form-row">
        <input id="id" name="id" value="${user.id}" class="form-control input-md col-md-1" title="ID"/>
        <input id="login" name="login" value="${user.login}" class="form-control input-md col-md-2"/>
        <input id="password" name="password" value="${user.password}" class="form-control input-md col-md-2"/>
        <input id="name" name="name" value="${user.name}" class="form-control input-md col-md-2"/>
        <input id="nick" name="nick" value="${user.nick}" class="form-control input-md col-md-2"/>
        <input id="telephone" name="telephone" value="${user.telephone}" class="form-control input-md col-md-2"/>

        <select id="role" name="role_ID" class="form-control col-md-2">
            <c:forEach items="${role}" var="role">
                <option value="${role.id}" ${role.id==user.role_ID?"selected":""}>
                        ${role.role}
                </option>
            </c:forEach>
        </select>


        <button id="Update" name="Update" class="btn btn-success col-md-1">
            Update
        </button>

        <button id="Delete" name="Delete" class="btn btn-danger col-md-1">
            Delete
        </button>
    </div>
</form>
<br>
</c:forEach>

<%@ include file="include/end-html.jsp" %>


