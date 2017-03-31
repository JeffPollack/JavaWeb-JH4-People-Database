/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneliners;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oneliners.OneLinerUtil;

/**
 *
 * @author Jeff
 */
public class OneLinerServlet extends HttpServlet {

    String onelinerFile = "";
    String filePath = "";
    String fullFilePath = "";
    int nextLine = 0;

    public void init() {
        ServletConfig sc = getServletConfig();
        ServletContext sctx = getServletContext();
        onelinerFile = sc.getInitParameter("onelinerFile");
        filePath = sc.getInitParameter("filePath");

        System.out.println("onelinerFile=" + onelinerFile);
        System.out.println("filePath=" + filePath);

        String pathSeparator = System.getProperty("file.separator");

        if (filePath == null) {
            filePath = "";
        } else {
            filePath = filePath.trim();
        }

        if (onelinerFile == null) {
            onelinerFile = "GuestFileDefaultName.txt";
        }

        if (filePath.length() == 0) {
            fullFilePath = sctx.getRealPath("/WEB-INF/") + pathSeparator + onelinerFile;
            System.out.println("fullFilePath=" + onelinerFile); // Checking value
        } else {
            //fullFilePath = System.getProperty("user.home")+"/" + filePath + "/" + onelinerFile;
            fullFilePath = System.getProperty("user.home") + pathSeparator + filePath + pathSeparator + onelinerFile;
        }
        System.out.println("fullFilePath=" + fullFilePath);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        OneLinerUtil list = new OneLinerUtil(fullFilePath);
        ArrayList<String> list = (new OneLinerUtil(fullFilePath)).getLine();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OneLinerServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if (nextLine >= list.size()) {
                nextLine = 0;
                out.println(list.get(nextLine++));
            } else {
                out.println(list.get(nextLine++));
            }
            out.println("<form action=\"OneLinerServlet\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"next\" value=\"Next Line\"/>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    private void writeForm(PrintWriter out) {

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
