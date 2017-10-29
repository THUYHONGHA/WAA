/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hong Ha
 */
@WebServlet(urlPatterns = {"/GuessNumber"})
public class GuessNumber extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        String inputNumber = request.getParameter("inputNumber");
        Random rd = new Random();
        Integer randomNumber = rd.nextInt(9) + 1;

        if (inputNumber == null) {
            out.println("<html>");
            out.println("<body>");
            out.println("<form action = GuessNumber>");
            out.println("Please guess a number: ");
            out.println("<input type=number name=inputNumber>");
            out.println("<input type=submit value='Submit'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            try {
                Integer guessNum = Integer.parseInt(inputNumber);
                if (guessNum == randomNumber) {
                    out.println("Correct, Congratulations!");
                    out.close();
                }
                if (guessNum < randomNumber) {
                    out.println("Too low, try again!");
                    out.close();
                } else {
                    out.println("Too high, try again!");
                    out.close();
                }
            } catch (NumberFormatException e) {
                out.println("Please enter a valid number!");
                out.close();
            }
        }

    }

}
