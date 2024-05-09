/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.mainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trieu.lq.Categories.CategoriesDAO;
import trieu.lq.Categories.CategoriesDTO;
import trieulq.Mobile.MobileDAO;
import trieulq.Mobile.MobileDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "AddMobileServlet", urlPatterns = {"/AddMobileServlet"})
public class AddMobileServlet extends HttpServlet {

    private final String ERROR = "admin.jsp";
    private final String SUCCESSFUL = "addMobile.jsp";

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
               
        String url = ERROR;
        String mobileID = request.getParameter("txtMobileID");
        String mobileName = request.getParameter("txtMobileName");
        String quantity_raw = request.getParameter("txtMobileQuan");
        String price_raw = request.getParameter("txtMobileprice");
        String yearOfProduction_raw = request.getParameter("txtMobileDate");
        String describe = request.getParameter("txtMobiledes");
        String notsale_raw = request.getParameter("txtMobilesale");
        int quantity , yearOfProduct;
        float price;
        boolean notSale;
        
        MobileDAO mbd= new MobileDAO();
        try {
            quantity = Integer.parseInt(quantity_raw);
            price = Float.parseFloat(price_raw);
            yearOfProduct = Integer.parseInt(yearOfProduction_raw);
            notSale = Boolean.parseBoolean(notsale_raw);
            MobileDTO m = mbd.getAllMobileByID(mobileID);
            if(m == null){
                MobileDTO mNew = new MobileDTO(mobileID, mobileName, quantity, price, yearOfProduct, describe,notSale );
               mbd.InsertMobile(mNew);
               response.sendRedirect(ERROR);
            }else{
                request.setAttribute("ERROR", mobileID + " existed!!");
                request.getRequestDispatcher(SUCCESSFUL).forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
