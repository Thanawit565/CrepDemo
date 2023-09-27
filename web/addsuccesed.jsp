
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Food" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>AddSuccesed</h1>
        <%
            Food  food = (Food) session.getAttribute("food");
        %>
        Name: <%=food.getName()%><br/>
        Type: <%= food.getType() %><br/>
        Topping: <%= food.getNutrient() %><br/>
        Sauce:<%= food.getSpicy() %><br/>
        Price:<%= food.getPrice() %><br/>
        <a href="updateFood.jsp">แก้ไข</a>
        <a href="index.html">กลับ</a>
    </body>
</html>
