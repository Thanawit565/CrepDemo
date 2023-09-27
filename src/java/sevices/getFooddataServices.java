/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sevices;

import controller.DBC;
import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Food;
import org.json.JSONObject;

/**
 *
 * @author SC244
 */
@WebServlet(name = "getFooddataServices", urlPatterns = {"/getFooddataServices"})
public class getFooddataServices extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     response.setCharacterEncoding("UTF-8");
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/untekucoffe/getFooddataServices/".length());        
       
        name = URLDecoder.decode( name, "UTF-8" );
        System.out.println(">>>>>>>>>>getFooddataServices: name=" + name);
        
        // retrieve food from MySQL: table food
        DBC  dbConnection = new DBC();
//        String name = "ยำหมูยอ"; 
        Food food = dbConnection.getFood(name);

        if (food != null) {
            String json = "{\n";
            json += "\"Name\": " + JSONObject.quote(food.getName()) + ",\n";
            json += "\"Type\": " + JSONObject.quote(food.getType()) + ",\n";
            json += "\"SweetLevel\": " + JSONObject.quote(food.getSpicy()) + "\n";
            json += "\"Price\": " + JSONObject.quote(Integer.toString(food.getPrice())) + "\n";
            json += "}";
            // ERROR: java.io.CharConversionException: Not an ISO 8859-1 character:
//            response.getOutputStream().println(json);
            // ต้องใช้ response.getWriter()
            response.getWriter().print(json);
        } else {
//            response.getOutputStream().println("{}");
            response.getWriter().print("");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
