<%-- 
    Document   : index
    Created on : Sep 29, 2016, 7:18:29 PM
    Author     : Jeff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>JH3 Morg Calc jdpollack</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="interestJSP.jsp">
            Enter the interest rate per year: <input type="text" name="interestRate" size="5"/>
            <p>Enter the starting principal: <input type="text" name="principal" size="10"/></p>
            <p>Enter the payments per month: <input type="text" name="monthPayment" size="10"/></p>
            <p>Enter the number of years in the mortgage: <input type="text" name="years" size="10"/></p>
            <p><input type="submit" value="Print out Interest Calculations"/></p>
        </form>
    </body>
</html>
