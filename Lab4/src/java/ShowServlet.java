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
@WebServlet(urlPatterns = {"/ShowServlet"})
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Hashtable<Integer, Person> listPerson = (Hashtable<Integer, Person>) session.getAttribute("listPerson");
        if (listPerson == null) {
            listPerson = new Hashtable<Integer, Person>();
        }
        request.setAttribute("listPerson", listPerson);
        RequestDispatcher dispatcher = request.getRequestDispatcher("NameList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
