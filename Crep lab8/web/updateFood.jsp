<%-- 
    Document   : updateFood
    Created on : Jan 21, 2019, 7:50:23 PM
    Author     : Wasana Ngaogate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Food" %>

<h2>update orders</h2>

<%
    Food food = (Food) session.getAttribute("food");
    out.println("data: " + food.getName() + ", " + food.getType());
    for(String n : food.getNutrient()){
        out.print(n + " ");
    }
    out.println(food.getSpicy() + "," + food.getPrice() + "<br/>");
%>

<form action="AddNewFood">
    <table>
        <tr><td>Name::</td>
            <td><input type="text" name="foodName" value="<%= food.getName() %>"></td>
        <tr><td>Type:</td>
            <td>
                <select name="foodType">
                   <option value="smoothies">smoothies</option>
                    <option value="cold">cold</option>
                    <option value="hot">hot</option>    
                </select>
            </td>
        </tr>
         <tr><td>toping:</td>
            <td>
                 <td>
                <input type="checkbox" name="nutrient" value="Drink Pearls">Drink Pearls
                <input type="checkbox" name="nutrient" value="Jellys">Jelly<br>
                <input type="checkbox" name="nutrient" value="Creams">Creams
                <input type="checkbox" name="nutrient" value="Yogurts">Yogurt<br>
            </td>
        </tr>
        <tr><td>Sweetlevels:</td>
            <td>
                <input type="radio" name="None Sweet" value="None Sweet">
                <input type="radio" name="spicy" value="Sweet">Sweet
                <input type="radio" name="spicy" value="very Sweet">very Sweet
            </td>
        </tr>
        <tr><td>sett:</td><td><input type="text" name="price" value="<%= food.getPrice() %>"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="addnewdrinks"></td></tr>
    </table>
</form>
        
<% session.removeAttribute("food"); %>