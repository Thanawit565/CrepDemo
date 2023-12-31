import model.Food;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wasana Ngaogate
 */
@WebServlet(urlPatterns = {"/AddNewFood"})
public class AddNewFood extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String foodName = request.getParameter("foodName");
        String foodType = request.getParameter("foodType");
        String nutrient[] = request.getParameterValues("nutrient");
        String spicy = request.getParameter("spicy");
        int price = Integer.parseInt(request.getParameter("price"));
        out.println("Name:<br/> " + foodName + "<br/>");
        out.println("Type: " + foodType + "<br/>");
        out.print("toping: ");
        for(String n : nutrient){
            out.print(n + " ");
        }
        out.println("<br/>" + spicy + " Price " + price + " bath");
        out.println("<br/><a href='index.html'>home</a>");
        
        Food food = new Food();
        food.setName(foodName);
        food.setType(foodType);
        food.setNutrient(nutrient);
        food.setSpicy(spicy);
        food.setPrice(price);
        HttpSession session = request.getSession();
        session.setAttribute("food", food);
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
