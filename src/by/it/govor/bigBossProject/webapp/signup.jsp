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

           <!-- Select Basic -->
                     <div class="form-group">
                       <label class="col-md-4 control-label" for="LabelCountry">Country</label>
                      <div class="col-md-4">
                       <select id="country" name="country" class="form-control">
                        <option value="Belarus">Belarus</option>
                        <option value="Russia">Russia</option>
                           <option value="Ukraine">Ukraine</option>
                           <option selected value="Belarus">Belarus</option>
                      </select>
                        </div>
                     </div>
                 <!-- Text input-->

            <!-- Select Basic -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="LableCity">City</label>
             <div class="col-md-4">
              <select id="city" name="city" class="form-control">
               <option value="Minsk">Minsk</option>
               <option value="Moscow">Moscow</option>
                  <option value="Kiev">Kiev</option>
                  <option selected value="Minsk">Minsk</option>
             </select>
               </div>
            </div>
        <!-- Text input-->



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







