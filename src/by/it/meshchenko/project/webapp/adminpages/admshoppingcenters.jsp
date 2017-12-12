<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>ShoppingCenters</h3>
</div>
<form class="edit-shoppingCenter-0" role="form" action="do?command=admshoppingcenters" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-3">
        <input type="text" id="name" name="name" title="name" class="form-control input-sm"  />
    </div>
    <div class="form-group col-xs-6">
        <select id="addressId" name="addressId" class="form-control input-sm">
            <c:forEach items="${admShoppingCentersView.admAddressesView.addresses}" var="address" >
                <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.streets}" var="street" >
                    <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.admCitiesView.cities}" var="city" >
                        <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.admCitiesView.countries}" var="country" >
                            <c:if test="${address.streetId == street.id && street.cityId == city.id && city.countryId == country.id}" >
                                <option value="${address.id}">
                                    ${country.name}, ${city.name}, ${street.name}, ${address.buildingNumberStr}
                                </option>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </select>
    </div>
  </div>
  <div class="row">
    <div class="form-group col-xs-2">
        <input type="text" id="lat" name="lat" title="lat" class="form-control input-sm"  />
    </div>
    <div class="form-group col-xs-2">
        <input type="text" id="lng" name="lng" title="lng" class="form-control input-sm" />
    </div>
    <div class="form-group col-xs-offset-5 col-xs-3">
        <button type="submit" id="create" name="create" value="create" class="btn btn-success btn-sm">Create</button>
    </div>
  </div>
  <div class="row">
    <div class="form-group col-xs-8">
        <textarea id="description" name="description" title="description" class="form-control input-sm" rows="3"></textarea>
    </div>
  </div>
</form>
<hr />
<c:forEach items="${admShoppingCentersView.shoppingCenters}" var="shoppingCenter">
    <form class="edit-shoppingCenter-shoppingCenter.id" role="form" action="do?command=admshoppingcenters" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${shoppingCenter.id}" class="form-control input-sm" title="ID" disabled />
          <input type="hidden" id="id" name="id" value="${shoppingCenter.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-3">
            <input type="text" id="name" name="name" value="${shoppingCenter.name}" title="name" class="form-control input-sm"  />
        </div>
        <div class="form-group col-xs-6">
            <select id="addressId" name="addressId" class="form-control input-sm">
                <c:forEach items="${admShoppingCentersView.admAddressesView.addresses}" var="address">
                    <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.streets}" var="street">
                        <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.admCitiesView.cities}" var="city">
                            <c:forEach items="${admShoppingCentersView.admAddressesView.admStreetsView.admCitiesView.countries}" var="country">
                                <c:if test="${address.streetId == street.id && street.cityId == city.id && city.countryId == country.id}" >
                                    <option value="${address.id}" ${shoppingCenter.addressId == address.id ? "selected" : ""} >
                                        ${country.name}, ${city.name}, ${street.name}, ${address.buildingNumberStr}
                                    </option>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </select>
        </div>
      </div>
      <div class="row">
        <div class="form-group col-xs-2">
            <input type="text" id="lat" name="lat" value="${shoppingCenter.lat}" title="lat" class="form-control input-sm"  />
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="lng" name="lng" value="${shoppingCenter.lng}" title="lng" class="form-control input-sm" />
        </div>
        <div class="form-group col-xs-offset-5 col-xs-3">
            <button type="submit" id="update" name="update" value="update" class="btn btn-warning btn-sm">Update</button>
            <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
        </div>
      </div>
      <div class="row">
        <div class="form-group col-xs-8">
            <textarea id="description" name="description" title="description" class="form-control input-sm" rows="3">${shoppingCenter.description}</textarea>
        </div>
      </div>
    </form>
<hr />
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>