<%-- 
    Document   : Viewcard
    Created on : Apr 14, 2024, 11:59:22 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page import="trieulq.Mobile.MobileDTO"%>
<%@page import="trieulq.Mobile.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Product inside the cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mobile ID</th> 
                    <th>Description</th> 
                    <th>Price</th>
                    <th>Mobile Name</th>
                    <th>Quantity</th>
                    <th>Update</th>
                    <th>Remove</th>         
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (MobileDTO p : cart.getCart().values()) {
                        total += p.getPrice() * p.getQuantity();
                %>


            <form action="MainController" method="POST">
                <tr>

                    <td><%= count++%></td>
                    <td> 
                        <input type="text" name="mobileId" value="<%= p.getId()%>" readonly=""/>
                    </td>
                    <td><%= p.getDescribe()%></td>                    
                    <td><%= p.getPrice()%>$</td>
                    <td><%= p.getName()%></td>  
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" required=""/>
                    </td>
                    <td>    
                        <input type="submit" name="action" value="Change"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                </tr>
            </form>

        </tbody>
        <%
            }
        %>
    </table>
    <h1>Total:<%=total%> $  </h1> 
    <%
        }
    %>

    </br>

    <a href="user.jsp">Add more</a>

    <% if (session.getAttribute("SUCCESS_MSG") != null) {%>
    <p style="color:green;"><%= session.getAttribute("SUCCESS_MSG")%></p>
    <% session.removeAttribute("SUCCESS_MSG"); %>
    <% } %>
    <% if (session.getAttribute("ERROR_MSG") != null) {%>
    <p style="color:red;"><%= session.getAttribute("ERROR_MSG")%></p>
    <% session.removeAttribute("ERROR_MSG"); %>
    <% }%>


</body>
</html>
