<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/_begin.jsp" %>

<!-- Page Content -->
<div class="container mycontainer">
	<div class="tab-content">
		<span class="pageName">Sign In</span>
		<span>or&nbsp;<a href="do?command=register"> register</a></span>
		<br />
		<br />

			<form class="form-horizontal" role="form" action="do?command=signin" method="post">
				<div class="form-group">
					<label for="inputEmail" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-4">
						<input type="email" class="form-control" id="inputEmail"
						    name="email" placeholder="Email" value="admin@admin.com"
						    pattern="[A-Za-z_0-9]{2,31}@[A-Za-z_]{2,6}\.[A-Za-z_]{3,5}">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="inputPassword"
						    name="password" placeholder="Password" value="123456789"
						    pattern="[A-Za-z_0-9]{6,31}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button type="submit" class="btn btn-default">Sign In</button>
					</div>
				</div>
			</form>
		    <br />
		    <br />
		    <br />
		    <p class="text-info">В форме введены данные зарегистрированного email, role='admin'<br />
		        Введите email:admin1@admin.com --> Message: 'Account is not registered' <br />
		        Введите email:admin@admin.com, password:1234567 --> Message: 'Incorrect password' <br />
		        Введите email:manager@manager.com, password:123456789 --> зарегистрированный email, role='manager' <br />
		        Введите email:user1@gmail.com, password:123456789 --> зарегистрированный email, role='user' <br />
		    </p>
	</div>
</div>
<!-- /.container -->
<%@ include file="include/_end.jsp" %>