<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Addresses</h3>
</div>
<form class="edit-address-0" role="form" action="do?command=admaddresses" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-3">
        <input type="text" id="buildingNumberStr" name="buildingNumberStr" class="form-control input-sm" />
    </div>
    <div class="form-group col-xs-6">
        <select id="streetId" name="streetId" class="form-control input-sm">
            <c:forEach items="${admAddressesView.admStreetsView.streets}" var="street">
                <c:forEach items="${admAddressesView.admStreetsView.admCitiesView.cities}" var="city">
                    <c:forEach items="${admAddressesView.admStreetsView.admCitiesView.countries}" var="country">
                        <c:if test="${street.cityId == city.id && city.countryId == country.id}" >
                            <option value="${street.id}">
                                ${country.name}, ${city.name}, ${street.name}
                            </option>
                        </c:if>
                    </c:forEach>
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
<c:forEach items="${admAddressesView.addresses}" var="address">
    <form class="edit-street-${street.id}" role="form" action="do?command=admaddresses" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${address.id}" class="form-control input-sm" title="ID" disabled/>
          <input type="hidden" id="id" name="id" value="${address.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="buildingNumberStr" name="buildingNumberStr" value="${address.buildingNumberStr}" class="form-control input-sm" />
        </div>
        <div class="form-group col-xs-6">
            <select id="streetId" name="streetId" class="form-control input-sm">
                <c:forEach items="${admAddressesView.admStreetsView.streets}" var="street">
                    <c:forEach items="${admAddressesView.admStreetsView.admCitiesView.cities}" var="city">
                        <c:forEach items="${admAddressesView.admStreetsView.admCitiesView.countries}" var="country">
                            <c:if test="${street.cityId == city.id && city.countryId == country.id}" >
                                <option value="${street.id}" ${address.streetId == street.id ? "selected" : ""}>
                                    ${country.name}, ${city.name}, ${street.name}
                                </option>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </select>
        </div>
      </div>
      <div class="row">
        <div class="form-group col-xs-3">
            <button type="submit" id="update" name="update" value="update" class="btn btn-warning btn-sm">Update</button>
            <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
        </div>
      </div>
    </form>
<hr />
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>