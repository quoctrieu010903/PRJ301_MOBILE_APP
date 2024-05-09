/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.mainController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class MainController extends HttpServlet {

    private final String LOGIN = "Login";
    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String LOGOUT = "Logout";
    private final String LOGOUT_CONTROLLER = "LogoutServlet";
    private final String SEARCH ="Search";
    private final String SEARCH_CONTROLLER = "SearchServlet";
    private final String UPDATE = "Update";
    private final String UPDATE_CONTROLLE = "UpdateController";
    private final String ADDMOBILE="AddNewMobile";
    private final String ADDMOBILE_CONTRROLER = "AddMobileServlet";
    private final String DELETEMOBILE ="delete";
    private final String DELETE_CONTROLLER = "DeleteMobileservlet";
    private final String SEARCHPRICE="SearchRangePrice";
    private final String SEARCH_RANGEPRICE_CONTROLLER = "SearchRangePriceServlet";
    private final String ADDTOCART = "Add to Cart";
    private final String ADDTOCART_CONTROLLER = "AddToCartServlet";
    private final String ChangeQuantity = "Change";
    private final String ChangQuantityInCard="ChangeQuantityServlet";
    private final String removeItems = "Remove";
    private final String removeItemsInCart= "RemoveItemsServlet";
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
        String url = LOGIN_PAGE;
        try {
            String button = request.getParameter("action");
            if (button == null) {
                url = LOGIN_PAGE;
            } else if (LOGIN.equals(button)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(button)) {
                url = LOGOUT_CONTROLLER;
            } else if (SEARCH.equals(button)) {
                url = SEARCH_CONTROLLER;
            } else if (UPDATE.equals(button)) {
                url = UPDATE_CONTROLLE;
            } else if (ADDMOBILE.equals(button)) {
                url = ADDMOBILE_CONTRROLER;
            } else if (DELETEMOBILE.equals(button)) {
                url = DELETE_CONTROLLER;
            } else if (SEARCHPRICE.equals(button)) {
                url = SEARCH_RANGEPRICE_CONTROLLER;
            }else if (ADDTOCART.equals(button)) {
                url = ADDTOCART_CONTROLLER;  
            }else if(ChangeQuantity.equals(button)){
                url = ChangQuantityInCard;
            }else if(removeItems.equals(button)){
                url = removeItemsInCart;
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
