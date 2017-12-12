<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
     <label class="col-md-4 control-label" for="LabelId"></label>
     <label class="col-md-4 control-label" for="LabelId"></label>
     <label class="col-md-4 control-label" for="LabelId"></label>
<div class="row">
    <div class=col-md-2></div>
    <div class=col-md-1>ID</div>
    <div class=col-md-1>Login</div>
    <div class=col-md-1>Password</div>
    <div class=col-md-1>Name</div>
    <div class=col-md-1>Nick</div>
    <div class=col-md-1>Telephone</div>
    <div class=col-md-1>Role</div>
</div>

<c:forEach items="${user}" var="user">
<form class="edit-user-${user.id}" action="do?command=EditUsers" method=POST>
    <div class="form-row">
        <label class="col-md-1 control-label" for="LabelId"></label>
        <label class="col-md-1 control-label" for="LabelId"></label>
        <input id="id" name="id" value="${user.id}" class="form-control input-md col-md-1" title="ID"/>

         <input id="login" name="login" value="${user.login}" class="form-control input-md col-md-1"/>
         <input id="password" name="password" value="${user.password}" class="form-control input-md col-md-1"/>

        <input id="name" name="name" value="${user.name}" class="form-control input-md col-md-1"/>
        <input id="nick" name="nick" value="${user.nick}" class="form-control input-md col-md-1"/>


        <input id="Telephone" name="Telephone" value="${user.telephone}" class="form-control input-md col-md-1"/>

        <select id="role" name="role_ID" class="form-control col-md-1">
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


