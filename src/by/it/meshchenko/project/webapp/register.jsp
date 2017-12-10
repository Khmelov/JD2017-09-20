<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/_begin.jsp" %>
   <!-- Page Content -->
<div class="container mycontainer">
	<div class="tab-content">
		<span class="pageName">Register</span>
		<span>or&nbsp;<a href="do?command=signin" type="button" class="btn btn-link"> Sign In</a></span>
		<br />
		<br />
		<form class="form-horizontal" role="form" action="do?command=register" method="post">
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="inputName"
					    name="name" placeholder="Name" value="Oleg"
					    pattern="[A-Za-zА-Яа-яЁё0-9_]{4,31}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhone" class="col-sm-2 control-label">Phone</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="inputPhone"
					    name="phone" placeholder="Phone" value="+375295303445"
					    pattern="\+?[0-9]{4,15}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="inputEmail"
					    name="email" placeholder="Email"
					    value="admin@admin.com"
					    pattern="([A-Za-z_0-9]{2,31})@([A-Za-z_]{2,9})(\.)([A-Za-z_]{1,5})">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control"
					    id="inputPassword" name="password"
					    value="123456789"
					    placeholder="Password" pattern="[A-Za-z_0-9]{4,31}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="submit" class="btn btn-default">Register</button>
				</div>
			</div>
		</form>
		<br />
        <br />
        <br />
        <p class="text-info">В форме введены данные зарегистрированного email --> Message: 'Account is already exists'<br />
            Введите другой email для регистации <br />
        </p>
	</div>
</div>
<!-- /.container -->
<%@ include file="include/_end.jsp" %>