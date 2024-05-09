/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.mainController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Mobile.CartDTO;
import trieulq.Mobile.MobileDAO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "ChangeQuantityServlet", urlPatterns = {"/ChangeQuantityServlet"})
public class ChangeQuantityServlet extends HttpServlet {

    private static final String ERROR = "Viewcard.jsp";
    private static final String SUCCESS = "Viewcard.jsp";

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
        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("CART");
        String mobileId = request.getParameter("mobileId");
        String url = ERROR;
        int newQuantity;
        try {
            newQuantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
            session.setAttribute("ERROR_MSG", "Invalid quantity.");
            url = ERROR;
            return;
        }

        if (cart == null) {
            session.setAttribute("ERROR_MSG", "Cart is empty.");
            url = ERROR;
            return;
        }
        MobileDAO dao = new MobileDAO();
        try {
            int availableQuantity = dao.getAvailableQuantity(mobileId);
            if (availableQuantity < 0) {

                throw new Exception("Database error or product not found.");
            }

            if (availableQuantity >= newQuantity) {
                if (cart.change(mobileId, newQuantity)) {
                    session.setAttribute("SUCCESS_MSG", "Cart updated successfully.");
                } else {

                    session.setAttribute("ERROR_MSG", "Failed to update cart. Product may not exist.");
                }
            } else {
                session.setAttribute("ERROR_MSG", "Not enough stock available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("ERROR_MSG", "Error updating cart: " + e.getMessage());
        }finally{
        response.sendRedirect(url);
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
