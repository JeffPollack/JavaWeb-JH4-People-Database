
<%@page import= "interest.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     double interestRate = 0;
    double interestPaid = 0;
    double principal = 0;
    double monthPayment = 0;
    int years = 0;
    
    // Assumed that no bad info is put into the HTML form.
    interestRate = Double.parseDouble(request.getParameter("interestRate").trim());
    principal = Double.parseDouble(request.getParameter("principal").trim());
    monthPayment = Double.parseDouble(request.getParameter("monthPayment").trim());
    years = Integer.parseInt(request.getParameter("years").trim());


%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JH3 JSP Page</title>
    </head>
    <body>
        <h1>Interest Calculation for:</h1>
        <h3>interest rate per year = <% out.println(interestRate); %></h3>
        <h3>starting principal = <% out.println(principal); %></h3>
        <h3>payment per month = <% out.println(monthPayment); %></h3>
        <h3>months on mortgage = <% out.println(years*12); %></h3>
        <table border="4">
            <tr>
                <th>Month Number</th>
                <th>Principal</th>
                <th>Interest</th>
            </tr>
            <%                
                for (int y = 1; y < 12 * years; y++) {
                    interestPaid = (principal * interestRate) / (12 * 100);
                    principal = principal + interestPaid - monthPayment;

                    if (principal > monthPayment && y < 12*years-1) {

                        out.println("<tr>");
                        out.println("<td>" + y + "</td>");
                        out.println("<td>" + String.format("%.2f", principal) + "</td>");
                        out.println("<td>" + String.format("%.2f", interestPaid) + "</td>");
                        out.println("</tr>");
                    } else {
                        out.println("<tr>");
                        out.println("<td>" + y + "</td>");
                        out.println("<td>" + String.format("%.2f", principal) + "</td>");
                        out.println("<td>" + String.format("%.2f", interestPaid) + "</td>");
                        out.println("</tr>");
                        out.println("</table></br>");
                        out.println("Last Payment = " + String.format("%.2f", (principal + (principal * interestRate) / (12 * 100))) + "</br>");
                        out.println("This includes interest: " + String.format("%.2f", (principal * interestRate) / (12 * 100)) + "</br>");
                        out.println("<hr>");
                        break;
                    }
                }
            %>
        </table>
    </body>
</html>