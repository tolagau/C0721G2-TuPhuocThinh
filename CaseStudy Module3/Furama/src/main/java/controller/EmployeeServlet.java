package controller;

import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Employee;
import bean.employee.Position;
import repository.IEmployee;
import repository.impl.EmployeeRepository;
import util.GetInfoEmployeeSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"", "/employee"})
public class EmployeeServlet extends HttpServlet {
    static IEmployee employee = new EmployeeRepository();
    private GetInfoEmployeeSQL call = new GetInfoEmployeeSQL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionEmployee = request.getParameter("actionEmployee");
        if (actionEmployee == null) {
            actionEmployee = "";
        }
        switch (actionEmployee) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String actionEmployee = request.getParameter("actionEmployee");
        if (actionEmployee == null) {
            actionEmployee = "";
        }
        // try {
        switch (actionEmployee) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                showListEmployee(request, response);
                break;
        }
        // }
    }

    public static void showListEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employeeList = employee.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    public void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Position> positions = call.selectPosition();
         request.setAttribute("postitions", positions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    private int id;
//    private String name;
//    private String birthDay;
//    private String idCard;
//    private Double salary;
//    private String phone;
//    private String email;
//    private String address;
//    private Position position;
//    private EducationDegree educationDegree;
//    private Division division;

    public void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPos = Integer.parseInt(request.getParameter("position_id"));
        int idEdu = Integer.parseInt(request.getParameter("education_degree_id"));
        int idDiv = Integer.parseInt(request.getParameter("division_id"));
        Employee employee = new Employee(id, name, birth, idCard, salary, phone, email, address, new Position(idPos),
                new EducationDegree(idEdu), new Division(idDiv));
    }
}
