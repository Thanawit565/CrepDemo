<%-- 
    Document   : addNewFood
    Created on : Jan 21, 2019, 7:25:31 PM
    Author     : Wasana Ngaogate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>unteku coffe</h2>
<form action="AddNewFood2">
    <table>
        <tr><td>Name:</td><td><input type="text" name="foodName"></td>
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
                <input type="checkbox" name="nutrient" value="Drink Pearls">Drink Pearls
                <input type="checkbox" name="nutrient" value="Jellys">Jelly<br>
                <input type="checkbox" name="nutrient" value="Creams">Creams
                <input type="checkbox" name="nutrient" value="Yogurts">Yogurt<br>
            </td>
        </tr>
        <tr><td>Sweetlevels:</td>
            <td>
                <input type="radio" name="spicy" value="None Sweet">
                <input type="radio" name="spicy" value="Sweet">Sweet
                <input type="radio" name="spicy" value="very Sweet">very Sweet
            </td>
        </tr>
        <tr><td>sett:</td><td><input type="text" name="price"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="addnewdrinks"></td></tr>
    </table>
</form>