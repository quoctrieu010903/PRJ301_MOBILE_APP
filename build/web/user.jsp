<%-- 
    Document   : user
    Created on : Apr 8, 2024, 2:06:21 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page import="trieulq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping - PAGE</title>
        <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>

        Welcome <h1>${sessionScope.UserAccount.getFullName()}</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController" method="">
            From Price: <input type="text" name="fromPrice" value="${param.fromPrice}"/>
            To Price: <input type="text" name="toPrice" value="${param.toPrice}"/>
            <input type="submit" value="SearchRangePrice" name="action"/>
        </form>

        <c:if test="${not empty requestScope.LIST_MOBILE}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Mobile ID</th>
                        <th>Mobile Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST_MOBILE}" var="c" varStatus="counter">
                        <c:set value="${c.quantity*c.price}" var="subtotal"/>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${c.id}</td>
                            <td>${c.name}</td>
                            <td>${c.price}</td>
                            <td>${c.quantity}</td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="fromPrice" value="${param.fromPrice}"/>
                                    <input type="hidden" name="toPrice" value="${param.toPrice}"/>
                                    <input type="hidden" name="mobileId" value="${c.id}"/>
                                    <input type="hidden" name="mobileName" value="${c.name}"/>
                                    <input type="hidden" name="description" value="${c.describe}"/>
                                    <input type="hidden" name="yearOfProduction" value="${c.releaseDate}"/>
                                    <input type="hidden" name="price" value="${c.price}"/>
                                    <input type="hidden" name="quantity" value="${c.quantity}"/>
                                    <input type="hidden" name="notSale" value="${c.notSale}"/>
                                    <input type="submit" name="action" value="Add to Cart"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>




            </tbody>
        </table>

        <% if (session.getAttribute("MESSAGE") != null) {%>
        <p style="color:red;"><%= session.getAttribute("MESSAGE")%></p>
        <% session.removeAttribute("MESSAGE"); %>
        <% }%>
        <a href="Viewcard.jsp">View Cart </a>


    </body>
</html>
