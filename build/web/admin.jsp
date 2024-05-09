<%-- 
    Document   : admin
    Created on : Apr 8, 2024, 2:05:58 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page import="trieulq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Page</title>
    </head>
    <body>
    <center>
        Welcome: <h1>${sessionScope.UserAccount.getFullName()}</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <h1>List Of Mobile </h1>
        <%
            String searchValue = request.getParameter("txtsearch");
        %>
        <h3><a href="admin/addMobile.jsp">Add new Mobile</a></h3>
        <form action="MainController">
            Search<input type="text" name="txtsearch" value="${param.txtsearch}"/>
            <input type="submit" name="action" value="Search"/>    
        </form>
        <c:set value="${param.txtsearch}" var="searchValue"/> 
        <c:if test="${not empty searchValue}">

            <c:set value="${requestScope.RESULT_List}" var="result"/>
            <c:if test="${not empty result}">
                <table border="1" style="width: 70% ; text-align: center; margin-top: 2%" >
                    <thead>
                        <tr>
                            <th>NO.</th>
                            <th>mobileID</th>
                            <th>mobileName</th>
                            <th>Price</th>
                            <th>yearOfProduction</th>
                            <th>Quantity</th>
                            <th>notSale</th>
                            <th>description</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>


                        <c:forEach items="${requestScope.RESULT_List}" var="c" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    ${c.id}
                                    <input type="hidden" name="txtMobileID" value="${c.id}" />
                                </td>

                                <td>${c.name}</td>
                                <td>

                                    <input type="text" name="txtPrice" value="${c.price}" />
                                </td>

                                <td>${c.releaseDate}</td>

                                <td>

                                    <input type="text" name="txtQuantity" value="${c.quantity}" />
                                </td>
                                <td>
                                    <c:if test="${c.notSale == true}">
                                        Sale
                                    </c:if>
                                    <c:if test="${c.notSale == false}">
                                        Not Sale
                                    </c:if>
                                    <input type="hidden" name="txtSale" value="${c.notSale}" />
                                </td>
                                <td>
                                    <input type="text" name="txtDescribe" value="${c.describe}" />
                                </td>

                                <td>    
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="delete"/>
                                        <c:param name="pk" value="${c.name}"/>
                                        <c:param name="lastSearchValue" value="${param.txtsearch}"/>

                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="action"/>
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                </td>

                            </tr>
                        </form>

                    </c:forEach>

                    </tbody>
                </table>
            </c:if>
             
        </c:if>
        <c:if test="${empty RESULT_List}">
            <h2 style="color: red"> No Record is matched!!</h2>
        </c:if>
       
    </center>


</body>
</html>
