<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/end-html.jsp" %>


<h1>Ваши данные</h1>


 <table class="table">
 <thead>
 <tr>
 <th>Логин</th>
 <th>Имя</th>
 <th>Ник</th>
 <th>Телефон</th>
 </tr>
 </thead>
 <tbody>
 <tr>
 <td>
     ${user.login}
     </td>
 <td>
          ${user.name}
          </td>
 <td>
          ${user.nick}
          </td>
 <td>
          ${user.telephone}
          </td>
 </tr>
 </tbody>
 </table>



   <h1>Ваши объявления</h1>


      <table class="table">
       <thead>
       <tr>
       <th>Процессор</th>
       <th>Видиокарта</th>
       <th>Материнская плата</th>
       <th>ОЗУ</th>
       <th>Блок питания</th>
       <th>Жесткий диск</th>
       </tr>
       </thead>
       <tbody>
 <tr>
 <c:forEach items="${ads}" var="ad">
     <div class="row">

         <td>
             ${ad.processor}
             </td>
         <td>
                  ${ad.video_card}
                  </td>
         <td>
                  ${ad.motherboard}
                  </td>
         <td>
                  ${ad.ram}
                  </td>
         <td>
                  ${ad.power_supply}
                  </td>
          <td>
                  ${ad.HDD}
                  </td>
         </tr>
     </div>
 <br>
 </c:forEach>
 </tr>
  </tbody>
  </table>


<center>
    <br><br>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>





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