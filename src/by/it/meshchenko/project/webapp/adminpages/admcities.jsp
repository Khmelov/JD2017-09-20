<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Cities</h3>
</div>
<form class="edit-city-0" role="form" action="do?command=admcities" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-4">
        <input type="text" id="name" name="name" class="form-control input-sm" />
    </div>
    <div class="form-group col-xs-3">
        <select id="countryId" name="countryId" class="form-control input-sm">
            <c:forEach items="${admCitiesView.countries}" var="country">
                <option value="${country.id}">
                        ${country.name}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-xs-2">
        <button type="submit" id="create" name="create" value="create" class="btn btn-success btn-sm">Create</button>
    </div>
  </div>
</form>
<hr />
<c:forEach items="${admCitiesView.cities}" var="city">
    <form class="edit-city-${city.id}" role="form" action="do?command=admcities" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${city.id}" class="form-control input-sm" title="ID" disabled/>
          <input type="hidden" id="id" name="id" value="${city.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="name" name="name" value="${city.name}" class="form-control input-sm" />
        </div>
        <div class="form-group col-xs-3">
            <select id="countryId" name="countryId" class="form-control input-sm">
                <c:forEach items="${admCitiesView.countries}" var="country">
                    <option value="${country.id}" ${country.id == city.countryId ? "selected" : ""}>
                            ${country.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-xs-3">
            <button type="submit" id="update" name="update" value="update" class="btn btn-warning btn-sm">Update</button>
            <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
        </div>
      </div>
    </form>
<hr />
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>