package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/index")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double gia  = Double.parseDouble(request.getParameter("txtGia"));
        double dis = Double.parseDouble(request.getParameter("txtDiscount"));
        double result = gia * dis * 0.01;
        double giatru = gia - result;

        request.setAttribute("resulFromServlet",result);
        request.setAttribute("resulFromServlet1",giatru);
        request.getRequestDispatcher("final.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
