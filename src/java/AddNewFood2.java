
import controller.DBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Food;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/AddNewFood2"})
public class AddNewFood2 extends HttpServlet {

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

        try {
            HttpSession session = request.getSession();
            Food food = (Food) session.getAttribute("food");

            if (food == null) {
                // get food detail
                String foodName = request.getParameter("foodName");
                String foodType = request.getParameter("foodType");
                String nutrient[] = request.getParameterValues("nutrient");
                String spicy = request.getParameter("spicy");
                int price = Integer.parseInt(request.getParameter("price"));

                food = new Food();
                food.setName(foodName);
                food.setType(foodType);
                food.setNutrient(nutrient);
                food.setSpicy(spicy);
                food.setPrice(price);
                session.setAttribute("food", food);

                // print page "แก้ไข"
                out.println("<html><body>");
                out.println("<form action='AddNewFood2'>");
                out.println("new food is submited.</br>");
                out.println("<input type='submit' value='แก้ไข 1'>");
                out.println("</form></body></html>");
                
            } else {
                out.println("<html><body>");                
                out.println("แก้ไขอาหาร:<br/> ");
                out.println("<form action='AddNewFood2'>");
                out.println("ชื่อ: <input type='text' value='" + food.getName() + "' name='foodName'><br/>");
                out.println("<select name='foodType'>");
                out.println("  <option value=\"กรอบ\">กรอบ</option>");
                out.println("<option value=\"นุ่ม\">นุ่ม</option>");
                out.println("<option value=\"กึ่งกรอบกึ่งนุ่ม\">กึ่งกรอบกึ่งนุ่ม</option> </select></br>");
                out.println("ท็อปปิ่ง: ");
               out.println(" <input type=\"checkbox\" name=\"nutrient\" value=\"กล้วยสด\">กล้วยสด");
                out.println(" <input type=\"checkbox\" name=\"nutrient\" value=\"เยลลี่\">เยลลี่");
                out.println(" <input type=\"checkbox\" name=\"nutrient\" value=\"สตรอเบอรี่\">สตรอเบอรี");
                out.println("<input type=\"checkbox\" name=\"nutrient\" value=\"ช็อคชิฟ\">ช็อคชิฟ</br>");
                out.println("รสเผ็ด:");
                out.println("<input type=\"radio\" name=\"spicy\" value=\"นมข้น\">");
                out.println(" <input type=\"radio\" name=\"spicy\" value=\"คาราเมล\">คาราเมล");
                out.println("    <input type=\"radio\" name=\"spicy\" value=\"ช็อคโกแลต\">ช็อคโกแลต</br>");
                out.println("ราคา:");
                out.println("<input type='text' name='price'></br>");
                out.println("<input type='submit' value='แก้ไข 2'>");
                out.println("</form>");
                out.println("</body></html>");
                session.removeAttribute("food");
            }
               DBC dbConnection = new DBC();
        if(!dbConnection.insertNewFood(food)){
            System.out.println(">>> AddNewFoodMySQL ERROR");
        }
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/addsuccesed.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
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
