<%@ include file="include/_begin.jsp" %>
<div class="container mycontainer">
    <div class="tab-content">
        <p><c:out value="${shoppingCenterView.shoppingCenter.name}" /><br />
            <c:out value="${shoppingCenterView.address}" />
        </p>
        <p>
            <table class="table table-hover">
                <tr>
                    <td><c:out value="Room Name" /></td>
                    <td><c:out value="Room Square, m2" /></td>
                    <td><c:out value="Name landlord" /></td>
                    <td><c:out value="Phone landlord" /></td>
                    <td><c:out value="Price, $" /></td>
                </tr>
                <c:forEach var="roomview" items="${shoppingCenterView.roomViews}" >
                    <tr>
                        <td><c:out value="${roomview.room.name}" /></td>
                        <td><c:out value="${roomview.room.square}" /></td>
                        <td><c:out value="${roomview.user.name}" /></td>
                        <td><c:out value="${roomview.user.phoneNumber}" /></td>
                        <td><c:out value="${roomview.leaseRoom.price}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </p>
    </div>
</div>
<!-- /.container -->
<%@ include file="include/_end.jsp" %>