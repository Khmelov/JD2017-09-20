<%@ include file="../include/_managerbegin.jsp" %>
<div class="row">
    <h3>Rooms</h3>
</div>
<form class="edit-room-0" role="form" action="do?command=managrooms" method="post">
  <div class="row">
    <div class="form-group col-xs-1">
      <input type="hidden" id="id" name="id" value="0" class="form-control input-sm" title="ID" />
    </div>
    <div class="form-group col-xs-2">
        <input type="text" id="name" name="name" title="name" class="form-control input-sm"  />
    </div>
    <div class="form-group col-xs-2">
        <input type="text" id="square" name="square" title="square" class="form-control input-sm"  />
    </div>
    <div class="form-group col-xs-2">
        <input type="text" id="price" name="price" title="price" class="form-control input-sm"  />
    </div>
  </div>
  <div class="row">
    <div class="form-group col-xs-5">
        <select id="shoppingCenterId" name="shoppingCenterId" title="shoppingCenter" class="form-control input-sm">
            <c:forEach items="${ListShoppingCenterFull}" var="shoppingCenterFull" >
                <option value="${shoppingCenterFull.shoppingCenter.id}">
                    ${shoppingCenterFull.country.name}, ${shoppingCenterFull.city.name}, ${shoppingCenterFull.shoppingCenter.name}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-xs-offset-4 col-xs-3">
        <button type="submit" id="create" name="create" value="create" class="btn btn-success btn-sm">Create</button>
    </div>
  </div>
</form>
<hr />
<c:forEach items="${ListManagRoomView}" var="managRoomView">
    <form class="edit-room-managRoomView.room.id" role="form" action="do?command=managrooms" method="post">
      <div class="row">
        <div class="form-group col-xs-1">
          <input type="text" id="id" name="id" value="${managRoomView.room.id}" class="form-control input-sm" title="ID" disable />
          <input type="hidden" id="id" name="id" value="${managRoomView.room.id}" class="form-control input-sm" title="ID" />
          <input type="hidden" id="leaseId" name="leaseId" value="${managRoomView.leaseRoom.id}" class="form-control input-sm" title="ID" />
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="name" name="name" value="${managRoomView.room.name}" title="name" class="form-control input-sm"  />
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="square" name="square" value="${managRoomView.room.square}" title="square" class="form-control input-sm"  />
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="price" name="price" value="${managRoomView.leaseRoom.price}" title="price" class="form-control input-sm"  />
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="startLease" name="startLease" value="${managRoomView.leaseRoom.dateStartLease}" title="startLease" class="form-control input-sm"  disabled/>
        </div>
        <div class="form-group col-xs-2">
            <input type="text" id="stopLease" name="stopLease" value="${managRoomView.leaseRoom.dateStopLease}" title="stopLease" class="form-control input-sm"  disabled/>
        </div>
      </div>
      <div class="row">
        <div class="form-group col-xs-5">
            <select id="shoppingCenterId" name="shoppingCenterId" title="shoppingCenter" class="form-control input-sm">
                <c:forEach items="${ListShoppingCenterFull}" var="shoppingCenterFull" >
                    <option
                        value="${shoppingCenterFull.shoppingCenter.id}"
                        ${managRoomView.room.shoppingCenterId ==  shoppingCenterFull.shoppingCenter.id ? "selected" : ""}
                    >${shoppingCenterFull.country.name}, ${shoppingCenterFull.city.name}, ${shoppingCenterFull.shoppingCenter.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-xs-7">
            <button type="submit" id="update" name="update" value="update" class="btn btn-warning btn-sm">Update</button>
            <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
            <c:if test="${managRoomView.leaseRoom.dateStartLease == null}" >
                <button type="submit" id="btnstartLease" name="btnstartLease" value="btnstartLease" class="btn btn-info btn-sm">StartLease</button>
            </c:if>
            <button type="submit" id="btnstopLease" name="btnstopLease" value="btnstopLease" class="btn btn-danger btn-sm">StopLease</button>
        </div>
      </div>
    </form>
    <hr />
</c:forEach>
<%@ include file="../include/_managerend.jsp" %>