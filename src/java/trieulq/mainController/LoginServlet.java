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
import javax.servlet.http.HttpSession;
import trieulq.Mobile.MobileDAO;
import trieulq.Mobile.MobileDTO;
import trieulq.user.UserDAO;
import trieulq.user.UserDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_FAIL = "Login.jsp";
    private static final String ADMIN_Page = "admin.jsp";
    private static final String USER_PAGE = "user.jsp";

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_FAIL;
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            UserDAO dao = new UserDAO();
            UserDTO checkUser = dao.checkLogin(userID, password);
             MobileDAO Mdao = new MobileDAO();
            if (checkUser != null) {
                HttpSession session = request.getSession();
                session.setAttribute("UserAccount", checkUser);
                //Phân quyền 

                String RoleID = checkUser.getRoleID();
                if (RoleID.equals("1") || RoleID.equals("2") ) {
                    url = ADMIN_Page;
                } else if (RoleID.equals("0")) {
                   
                    List<MobileDTO> list = Mdao.getAllMobile();
                    request.setAttribute("MOBILE_LIST", list);
                     
                    url = USER_PAGE;
                } else {
                    request.setAttribute("ERROR", "Your role is not support ");
                }
            } else {
                request.setAttribute("ERROR", "INVALID USERID AND PASSWORD");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
