/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hong Ha
 */
@WebServlet(urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null && password == null) {
            out.println("<html>");
            out.println("<body>");
            out.println("<form method=GET action=LogonServlet>");
            out.println("Username=<input type=text name=username> <br>");
            out.println("Password=<input type=password name=password>");
            out.println("<input type=submit value='Logon'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            if (username.equals("user") && password.equals("pass")) {
                out.println("<html>");
                out.println("<body>");
                out.println("<H1> Welcome " + username +"</H1>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            } else {
                out.println("<html>");
                out.println("<body>");
                out.println("Wrong user name or password. Please try again!");
                out.println("<form method=GET action=LogonServlet>");
                out.println("Username=<input type=text name=username> <br>");
                out.println("Password=<input type=password name=password>");
                out.println("<input type=submit value='Logon'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }
        }

    }

}
