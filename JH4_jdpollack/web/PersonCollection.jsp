<%-- 
    Document   : personFrontEnd
    Created on : Oct 15, 2016, 3:05:14 PM
    Author     : Jeff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="people.*" %>
<%
    PersonCollection personCollection = PersonCollection.update(pageContext);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Collection</title>
    </head>
    <body>
        <h1>Person Collection</h1>
        <form action="PersonCollection.jsp">
            <input type="submit" name="action" value="Clear List"/>
        </form>
        <p/>
        <form action="PersonCollection.jsp">
            <input type="text" name="name"/>Name
            <br/><input type="text" name="eyeColor"/>Eye Color
            <br/><input type="text" name="hairColor"/>Hair Color
            <br/><input type="text" name="height"/>Height
            <br/><input type="text" name="weight"/>Weight
            <br/><input type="text" name="wepOfChoice"/>Weapon of Choice
            <br/><input type="submit" name="action" value="add"/>
        </form>
        <hr/>
        <h3><%=personCollection.getErrorMessage()%></h3>
        
        <table border="3">
            <tr>
                <th>Name</th>
                <th>Eye Color</th>
                <th>Hair Color</th>
                <th>Height</th>
                <th>Weight</th>
                <th>Weapon of Choice</th>
            </tr>
            <%
                for (int i=0; i < personCollection.size(); i++){
                    Person person = personCollection.getPerson(i);
            %>
            <tr>
            <form action="PersonCollection.jsp">
                <td><input type="text" name="name" value="<%=person.getName()%>"/></td>
                <td><input type="text" name="eyeColor" value="<%=person.getEyeColor()%>"/></td>
                <td><input type="text" name="hairColor" value="<%=person.getHairColor()%>"/></td>
                <td><input type="text" name="height" value="<%=person.getHeight()%>"/></td>
                <td><input type="text" name="weight" value="<%=person.getWeight()%>"/></td>
                <td><input type="text" name="wepOfChoice" value="<%=person.getWepOfChoice()%>"/></td>
                <td>
                    <input type="submit" name="action" value="remove"/>
                    <input type="submit" name="action" value="update"/>
                    <input type="hidden" name="index" value="<%= i %>"/>
                </td>
            </form>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
