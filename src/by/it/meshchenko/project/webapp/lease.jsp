<%@ include file="include/_begin.jsp" %>
<div class="container mycontainer">
    <div class="tab-content">
        <ul class="nav navbar-left nav-stacked" style="min-width: 330px;">
          <c:forEach var="lv" items="${leaseview}" >
            <li>
                <a href='do?command=shoppingcenter&id=<c:out value="${lv.shoppingCenter.id}" />'>
                    <c:out value="${lv.address}" />&nbsp;&nbsp;&nbsp;
                    Shopping Center &nbsp;
                    <c:out value="${lv.shoppingCenter.name}" />
                    <span class="badge pull-right">
                        <c:out value="${lv.count}" />
                    </span>
                </a>
            </li>
          </c:forEach>
        </ul>
    </div>
</div>
<!-- /.container -->
<%@ include file="include/_end.jsp" %>