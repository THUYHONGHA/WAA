/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Hashtable;
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
@WebServlet(urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key").toString();
        String firstName = request.getParameter("firstName").toString();
        String lastName = request.getParameter("lastName").toString();

        if (key != null && firstName != null && lastName != null) {
            HttpSession session = request.getSession();
            try {
                Integer intKey = Integer.parseInt(key);
                Hashtable<Integer, Person> listPerson = (Hashtable<Integer, Person>) session.getAttribute("listPerson");
                Person person = new Person(firstName, lastName);
                if (listPerson == null) {
                    listPerson = new Hashtable<Integer, Person>();
                    session.setAttribute("listPerson", listPerson);
                }
                listPerson.put(intKey, person);
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
