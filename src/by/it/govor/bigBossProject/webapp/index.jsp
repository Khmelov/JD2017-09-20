<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="page-header">
    <h1>Все объявления</h1>





 </table>
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



<%@ include file="include/end-html.jsp" %>