<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Signup" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>SignUp</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text"
                       placeholder="" class="form-control input-md" required=""
                       value="Login">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="" class="form-control input-md"
                       required=""
                       value="Password">
            </div>
        </div>

         <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Name</label>
                    <div class="col-md-4">
                        <input id="name" name="name" type="text"
                               placeholder="" class="form-control input-md" required=""
                               value="Name">
                    </div>
                </div>

                   <div class="form-group">
                                    <label class="col-md-4 control-label" for="nick">Nick</label>
                                    <div class="col-md-4">
                                        <input id="nick" name="nick" type="text"
                                               placeholder="" class="form-control input-md" required=""
                                               value="Nick">
                                    </div>
                                </div>

            <div class="form-group">
                             <label class="col-md-4 control-label" for="telephone">Telephone</label>
                             <div class="col-md-4">
                                 <input id="Telephone" name="Telephone" type="int"
                                        placeholder="" class="form-control input-md" required=""
                                        value=3754477>
                             </div>
                         </div>


             <div class="col-md-4">
         <div class="Country">
           <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
             Country
             <span class="caret"></span>
           </button>
           <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
             <li><a href="#">Russia</a></li>
             <li><a href="#">Ukraine</a></li>
             <li><a href="#">Belarus</a></li>
             <li role="separator" class="divider"></li>
           </ul>
         </div>
         </div>

        <!-- Text input-->

                         <div class="col-md-4">
                          <label class="col-md-4 control-label" for="submit"></label>
                <div class="City">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    City
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#"no</a></li>
                    <li><a href="#">no</a></li>
                    <li><a href="#">no</a></li>
                    <li role="separator" class="divider"></li>
                  </ul>
                </div>
                </div>

      <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-success">Sign Up</button>
                </div>
            </div>


    </fieldset>
</form>

<!-- Text input-->

<p>message=${message}</p>





