<%-- 
    Document   : addNewFood
    Created on : Jan 21, 2019, 7:25:31 PM
    Author     : Wasana Ngaogate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>crep</h2>
<form action="AddNewFood2">
    <table>
        <tr><td>Name:</td><td><input type="text" name="foodName"></td>
        <tr><td>Type:</td>
            <td>
                <select name="foodType">
                    <option value="กรอบ">กรอบ</option>
                    <option value="นุ่ม">นุ่ม</option>
                    <option value="กึ่งกรอบกึ่งนุ่ม">กึ่งกรอบกึ่งนุ่ม</option>  
                </select>
            </td>
        </tr>
        <tr><td>toping:</td>
            <td>
                <input type="checkbox" name="nutrient" value="กล้วยสด">กล้วยสด
                <input type="checkbox" name="nutrient" value="เยลลี่">เยลลี่<br>
                <input type="checkbox" name="nutrient" value="สตรอเบอรี่">สตรอเบอรี่
                <input type="checkbox" name="nutrient" value="ช็อคชิฟ">ช็อคชิฟ<br>
            </td>
        </tr>
        <tr><td>Sauce:</td>
            <td>
                <input type="radio" name="spicy" value="นมข้น">นมข้น
                <input type="radio" name="spicy" value="คาราเมล">คาราเมล
                <input type="radio" name="spicy" value="ช็อคโกแลต">ช็อคโกแลต
            </td>
        </tr>
        <tr><td>sett:</td><td><input type="text" name="price"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="addcrep"></td></tr>
    </table>
</form>