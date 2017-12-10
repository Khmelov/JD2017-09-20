<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Users</h3>
</div>
<c:forEach items="${admUsersView.users}" var="user">
    <form class="edit-user-${user.id}" role="form" action="do?command=cmdadmusers" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${user.id}" class="form-control input-sm" title="ID"/>
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="name" name="name" value="${user.name}" class="form-control input-sm"/>
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="password" name="password" value="${user.password}" class="form-control input-sm"/>
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" class="form-control input-sm"/>
        </div>
      </div>
      <div class="margin-bottom-8"></div>
      <div class="row">
        <div class="form-group col-xs-offset-1 col-xs-4">
            <input type="text" id="email" name="email" value="${user.email}" class="form-control input-sm"/>
        </div>
        <div class="form-group col-xs-3">
            <select id="role" name="roleId" class="form-control input-sm">
                <c:forEach items="${admUsersView.roles}" var="role">
                    <option value="${role.id}" ${role.id == user.roleId ? "selected" : ""}>
                            ${role.role}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-xs-2">
            <button type="submit" class="btn btn-warning btn-sm">Update</button>
        </div>
        <div class="form-group col-xs-2">
            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
        </div>
      </div>
    </form>
<hr />
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>