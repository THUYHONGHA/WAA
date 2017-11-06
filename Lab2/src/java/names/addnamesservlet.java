/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hong Ha
 */
@WebServlet(name = "addnamesservlet", urlPatterns = {"/addnamesservlet"})
public class addnamesservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        Integer key = 0;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if (request.getParameter("key").equals("")) {
            out.println("Please input a key to add a new item. ");
            out.close();
        } else {
            if (firstName.equals("") || lastName.equals("")) {
                out.println("Please enter both first name and last name field. ");
                out.close();
            } else {
                key = Integer.parseInt(request.getParameter("key"));
                HttpSession session = request.getSession();
                List<Person> personList = (List<Person>) session.getAttribute("person");
                if (personList == null) {
                    personList = new ArrayList<>();
                    session.setAttribute("person", personList);
                }

                personList.add(new Person(key, firstName, lastName));

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Add names servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("</br>");

                out.println("<div>");
                out.println("<form method=POST action=allnamesservlet>");
                out.println("<input type=submit value='Show all names' />");
                out.println("</form>");
                out.println("</div>");
                out.println("</br>");

                out.println("<div>");
                out.println("<form method=GET action=addnamesservlet>");
                out.println("<span>Key=</span><input type=number name=key />");
                out.println("<span>First Name=</span><input type=text name=firstName />");
                out.println("<span>Last Name=</span><input type=text name=lastName />");
                out.println("<input type=submit value=Add />");
                out.println("</form>");
                out.println("</div>");

                out.println("<div>");
                out.println("<form method=GET action=removenamesservlet>");
                out.println("<span>Key=</span><input type=number name=key />");
                out.println("<input type=submit value=Remove />");
                out.println("</form>");
                out.println("</div>");

                out.println("</body>");
                out.println("</html>");

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
