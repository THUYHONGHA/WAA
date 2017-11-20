/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.Hashtable;
import java.util.Set;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/RemoveServlet"})
public class RemoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key").toString();
        if (key != null) {
            HttpSession session = request.getSession();
            try {
                Integer intKey = Integer.parseInt(key);
                Hashtable<Integer, Person> listPerson = (Hashtable<Integer, Person>) session.getAttribute("listPerson");
                listPerson.remove(intKey);
                request.setAttribute("listPerson", listPerson);
            } catch (NumberFormatException e) {

            }

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("NameList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
