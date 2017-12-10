<%@ include file="include/_begin.jsp" %>
<div class="container mycontainer">
    <div class="tab-content">
        <div class="container resetdb">
		    <center>
			    <br><br><br><br><br><br>
            	<form class="form" role="form" action="do?command=resetdb" method="post">
            	    <!-- Form Name -->
                    <legend>Reset and Init Database</legend>
                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submit">DEBUG FUNCTION: Click for reset (full cleaning) the database</label>
                        <div class="col-md-4">
                            <button id="submit" name="submit" class="btn btn-danger">Reset DB</button>
                        </div>
                    </div>
            	</form>
            </center>
        </div>
    </div>
</div>
<!-- /.container -->
<%@ include file="include/_end.jsp" %>