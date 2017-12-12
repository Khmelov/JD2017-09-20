<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/end-html.jsp" %>


<hr>
${user}
<hr>
${ads}
<hr>

<center>
    <br><br><br><br><br><br>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</center>
<%@ include file="include/end-html.jsp" %>