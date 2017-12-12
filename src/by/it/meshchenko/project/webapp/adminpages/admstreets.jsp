<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Streets</h3>
</div>
<form class="edit-street-0" role="form" action="do?command=admstreets" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-4">
        <input type="text" id="name" name="name" class="form-control input-sm" />
    </div>
    <div class="form-group col-xs-3">
        <select id="cityId" name="cityId" class="form-control input-sm">
            <c:forEach items="${admStreetsView.admCitiesView.cities}" var="city">
                <c:forEach items="${admStreetsView.admCitiesView.countries}" var="country">
                    <c:if test="${city.countryId == country.id}" >
                        <option value="${city.id}">
                            ${country.name}, ${city.name}
                        </option>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-xs-2">
        <button type="submit" id="create" name="create" value="create" class="btn btn-success btn-sm">Create</button>
    </div>
  </div>
</form>
<hr />
<c:forEach items="${admStreetsView.streets}" var="street">
    <form class="edit-street-${street.id}" role="form" action="do?command=admstreets" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${street.id}" class="form-control input-sm" title="ID" disabled/>
          <input type="hidden" id="id" name="id" value="${street.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="name" name="name" value="${street.name}" class="form-control input-sm" />
        </div>
        <div class="form-group col-xs-3">
            <select id="cityId" name="cityId" class="form-control input-sm">
                <c:forEach items="${admStreetsView.admCitiesView.cities}" var="city">
                    <c:forEach items="${admStreetsView.admCitiesView.countries}" var="country">
                        <c:if test="${city.countryId == country.id}" >
                            <option value="${city.id}" ${street.cityId == city.id ? "selected" : ""} >
                                ${country.name}, ${city.name}
                            </option>
                        </c:if>
                    </c:forEach>
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