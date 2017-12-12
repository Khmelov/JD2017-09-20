<%@ include file="../include/_adminbegin.jsp" %>
<div class="row">
    <h3>Rooms</h3>
</div>
<c:forEach items="${admRoomsView.shoppingCentersView}" var="shoppingCenterView">
    <c:forEach items="${shoppingCenterView.roomViews}" var="roomView">
        <form class="edit-room-roomView.room.id" role="form" action="do?command=admrooms" method="post">
            <div class="row">
                <div class="form-group col-xs-1">
                  <input type="text" id="id" name="id" value="${roomView.room.id}" class="form-control input-sm" title="ID" disabled />
                  <input type="hidden" id="id" name="id" value="${roomView.room.id}" class="form-control input-sm" title="ID" />
                </div>
                <div class="form-group col-xs-2">
                    <input type="text" id="name" name="name" value="${roomView.room.name}" title="name" class="form-control input-sm"  disabled/>
                </div>
                <div class="form-group col-xs-1">
                    <input type="text" id="square" name="square" value="${roomView.room.square}" title="square" class="form-control input-sm"  disabled/>
                </div>
                <div class="form-group col-xs-4">
                    <input type="text" id="address" name="address" value="${shoppingCenterView.address}" title="address" class="form-control input-sm"  disabled/>
                </div>
                <div class="form-group col-xs-2">
                    <input type="text" id="startLease" name="startLease" value="${roomView.leaseRoom.dateStartLease}" title="startLease" class="form-control input-sm"  disabled/>
                </div>
                <div class="form-group col-xs-2">
                    <input type="text" id="stopLease" name="stopLease" value="${roomView.leaseRoom.dateStopLease}" title="stopLease" class="form-control input-sm"  disabled/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-3">
                    <button type="submit" id="delete" name="delete" value="delete" class="btn btn-danger btn-sm">Delete</button>
                </div>
            </div>
        </form>
<hr />
    </c:forEach>
</c:forEach>
<%@ include file="../include/_adminend.jsp" %>