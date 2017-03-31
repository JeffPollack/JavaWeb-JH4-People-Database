<%-- 
    Document   : OneLinerJSP
    Created on : Sep 29, 2016, 7:44:43 PM
    Author     : Jeff
--%>
<%@page import="oneliners.*" %>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%!
    String fullFilePath = "";
    int nextLine = 0;

    public void jspInit() {
        fullFilePath = OneLinerInit.init(getServletConfig(), getServletContext());
    }
%>
<%
    ArrayList<String> list = (new OneLinerUtil(fullFilePath)).getLine();
%>

<html>
    <head>
        <title>JSP OneLiner</title>
    </head>
    <body>
        <%
            if (nextLine >= list.size()) {
                nextLine = 0;
                out.println(list.get(nextLine++));
            } else {
                out.println(list.get(nextLine++));
            }
        %>
        <form action="OneLinerJSP.jsp">
            <input type="submit" name="next" value="Next Line">
        </form>

    </body>
</html>



