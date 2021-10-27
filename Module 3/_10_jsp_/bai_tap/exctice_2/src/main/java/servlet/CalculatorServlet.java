package servlet;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float a = Integer.parseInt(request.getParameter("first-operand"));
        float b = Integer.parseInt(request.getParameter("second-operand"));
        char phep = request.getParameter("operator").charAt(0);
        String result;

        try {
            result = String.valueOf(Calculator.calculate(a, b, phep));
        } catch (RuntimeException exception) {
            result = "Bị sai";
        }
        request.setAttribute("phepTinh",result);
        request.getRequestDispatcher("final.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
