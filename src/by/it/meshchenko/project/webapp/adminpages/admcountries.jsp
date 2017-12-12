<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Countries</h3>
</div>
<form class="edit-country-0" role="form" action="do?command=admcountries" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-4">
        <input type="text" id="name" name="name" class="form-control input-sm" />
    </div>
    <div class="form-group col-xs-2">
        <button type="submit" id="create" name="create" value="create" class="btn btn-success btn-sm">Create</button>
    </div>
  </div>
</form>
<hr />
<c:forEach items="${admCountryView}" var="country">
    <form class="edit-country-${country.id}" role="form" action="do?command=admcountries" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${country.id}" class="form-control input-sm" title="ID" disabled/>
          <input type="hidden" id="id" name="id" value="${country.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-4">
            <input type="text" id="name" name="name" value="${country.name}" class="form-control input-sm" />
        </div>
        <div class="form-group col-xs-2">
            <button type="submit" id="update" name="update" value="update" class="btn btn-warning btn-sm">Update</button>
        </div>
        <div class="form-group col-xs-2">
            <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
        </div>
      </div>
    </form>
<hr />
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>