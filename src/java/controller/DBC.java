/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.Arrays;
import model.Food;
/**
 *
 * @author SC244
 */
public class DBC {
       public boolean insertNewFood(Food food) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/unteku",
                    "root", "12341234");

            Statement statement;
            statement = connection.createStatement();

            // สร้าง String nutrient ที่มีค่าสารอาหารต่าง ๆ คั่นด้วย ;
            String nutrient = "";
            int nl = food.getNutrient().length;
            
            // วนลูปสร้างแค่ food.getNutrient().length ลบ 1 เพื่อไม่ให้มี ; ปิดท้าย String
            for(int i=0; i < nl - 1; i++){
                nutrient = nutrient + food.getNutrient()[i] + ";";
            }
            // เพิ่มค่า nutrient ตำแหน่งสุดท้ายเข้าไป
            nutrient = nutrient + food.getNutrient()[nl-1];
            
            String query = "INSERT INTO food "
                    + "(Name, Type,Toping, SweetLevel, Price) "
                    + "VALUES('"
                    + food.getName() + "','"
                    + food.getType() + "','"
                    + nutrient + "','"
                    + food.getSpicy() + "',"
                    + food.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;

    }

    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
    public void testRetrieve() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/unteku",
                    "root", "12341234");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select name from food");
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name").trim();
                System.out.println(" name : " + name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
 public Food getFood(String name) {
        
        Food food = new Food();        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/unteku",
                    "root", "12341234");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            String query = "select * from food where name='" + name + "'";
            System.out.println(">>>>>>>>>> query=" + query);            
            
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                food.setName(resultSet.getString("Name").trim());
                food.setType(resultSet.getString("Type").trim());
                food.setSpicy(resultSet.getString("SweetLevel").trim());
                food.setPrice(resultSet.getInt("Price"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
        return food;
    }

}
