package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayCusServlet", urlPatterns = {"","/display_cus"})
public class DisplayCusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Từ Phước Thịnh","1998-07-15","Quảng ngãi",
                "hihi.jpg"));
        customerList.add(new Customer("Từ Phước T","1990-11-15","Quảng nam ",
                "nhau.jpg"));
        customerList.add(new Customer("Từ Phước A","1991-01-20","Quảng ninh",
                "tamthac.jpg"));
        customerList.add(new Customer("Từ Phước B","1998-09-29","Quảng bình",
                "tienbip.jpg"));
        request.setAttribute("displayCus",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
