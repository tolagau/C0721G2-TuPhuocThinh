package controller;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.impl.CustomerRepository;
import util.GetinfoCustomerTypeSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {


    private static CustomerRepository customerRepository = new CustomerRepository();
    private static GetinfoCustomerTypeSQL getinfoCustomerTypeSQL = new GetinfoCustomerTypeSQL();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                try {
                    update(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                showList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerRepository.deleteCustomer(id);
        showList(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<CustomerType> customerTypeList = getinfoCustomerTypeSQL.selectAll();
        request.setAttribute("typeList",customerTypeList);


        Customer customer = customerRepository.selectCustomer(id);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("customer/update.jsp").forward(request,response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idType = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer listAdd = new Customer(id,new CustomerType(idType),name,birth,gender,idCard,phone,email,address);

        customerRepository.updateCustomer(listAdd);
        showList(request,response);

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {

        List<CustomerType> customerTypeList = getinfoCustomerTypeSQL.selectAll();
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerRepository.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idType = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer listAdd = new Customer(new CustomerType(idType),name,birth,gender,idCard,phone,email,address);
        customerRepository.insertCustomer(listAdd);
        request.setAttribute("message", "Đã thêm thành công");
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }
}
