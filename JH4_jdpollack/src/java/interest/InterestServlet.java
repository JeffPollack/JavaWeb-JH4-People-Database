/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import interest.InterestCalculator;
import interest.InterestLoop;

@WebServlet(name = "InterestServlet", urlPatterns = {"/InterestServlet"})
public class InterestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // text fields are assumed to never return null
        String errorMsg = "";

        double interestRate = 0;
        double interestPaid = 0;
        double principal = 0;
        double monthPayment = 0;
        int years = 0;

        try {
            interestRate = Double.parseDouble(request.getParameter("interestRate").trim());
        } catch (NumberFormatException e) {
            errorMsg += " Bad Interest Rate. ";
        }

        try {
            principal = Double.parseDouble(request.getParameter("principal").trim());
        } catch (NumberFormatException e) {
            errorMsg += " Bad Principal. ";
        }

        try {
            monthPayment = Double.parseDouble(request.getParameter("monthPayment").trim());
        } catch (NumberFormatException e) {
            errorMsg += " Bad Monthly Payment. ";
        }

        try {
            years = Integer.parseInt(request.getParameter("years").trim());
        } catch (NumberFormatException e) {
            errorMsg += " Bad Month Count. ";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InterestServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1> Interest Calculations for: </h1>");
            out.println("<h3>interest rate per year = " + interestRate + "</h3>");
            out.println("<h3>starting principal = " + principal + "</h3>");
            out.println("<h3>payment per month = " + monthPayment + "</h3>");
            out.println("<h3>months on mortgage = " + years*12 + "</h3>");

            if (errorMsg.length() > 0) {
                out.println("<h2> Bad User Inputs:</h2>" + errorMsg);
            } else {

                out.println("<table border=\"4\" >");
                out.println("<tr><th>Month Number</th> <th>Principal</th><th>Interest</th></tr>");
                ArrayList<InterestCalculator> intArr
                        = InterestLoop.getInterestArr(interestRate, principal, monthPayment, years);

//                for (int m=1; m < intArr.size(); m++)
//                {
//                    out.println("<tr>");
//                    out.println("<td>"+ m + "</td>");   
//                    InterestCalculator intC = intArr.get(m);
//                    out.println("<td>"+ intC.getNewPrincipal() + "</td>");
//                    out.println("<td>"+ intC.getNewInterest() + "</td>");
//                    out.println("</tr>");
//                }
                for (int y = 1; y < 12 * years; y++) {
                    interestPaid = (principal * interestRate) / (12 * 100);
                    principal = principal + interestPaid - monthPayment;


                    if (principal > monthPayment) {

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
                        out.println("Last Payment = " + String.format("%.2f", (principal + (principal*interestRate)/(12*100))) + "</br>");
                        out.println("This includes interest: " + String.format("%.2f", (principal*interestRate)/(12*100)) + "</br>");
                        out.println("<hr>");
                        break;
                    }
                }
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
