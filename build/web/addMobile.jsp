<%-- 
    Document   : addMobile
    Created on : Apr 9, 2024, 8:57:48 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add_Mobile</title>
    </head>
    <body>
    <center>
        <h1>Add new a Mobile</h1>
        <h3 style="color: red">${requestScope.ERROR}</h3>
        <form action="MainController" method="post" >
            mobileID : <input type="text" name="txtMobileID" value="" /><br/>
            mobileName : <input type="text" name="txtMobileName" value="" /><br/>
            quantity : <input type="number" name="txtMobileQuan" value="" /><br/>
            price : <input type="number" name="txtMobileprice" value="" /><br/>
            yearOfProduction : <input type="number" name="txtMobileDate" value="" /><br/>
            describe : <input type="text" name="txtMobiledes" value="" /><br/>
            notsale : <input type="number" name="txtMobilesale" value="" /><br/>
            <input type="submit" value="AddNewMobile" name="action" />
        </form>
    </center>

</body>
</html>
