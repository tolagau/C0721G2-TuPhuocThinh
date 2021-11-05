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
import java.sql.SQLException;
import java.util.List;

import static util.GetInfoEmployeeSQL.*;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    static IEmployee employeeRepository = new EmployeeRepository();
    static GetInfoEmployeeSQL getInfoEmployeeSQL = new GetInfoEmployeeSQL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionEmployee = request.getParameter("actionEmployee");
        if (actionEmployee == null) {
            actionEmployee = "";
        }
        switch (actionEmployee) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;

//            case "search":
//                break;
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
                try {
                    showCreate(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "update":
                try {
                    showUpdate(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                showListEmployee(request, response);
                break;
        }
        // }
    }

    public static void showListEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employeeList = employeeRepository.selectAllEmployee();

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    public void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        List<Position> positions = getInfoEmployeeSQL.selectPosition();
        request.setAttribute("postitions", positions);

        List<Division> divisionList = getInfoEmployeeSQL.selectDivision();
        request.setAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = getInfoEmployeeSQL.selectEducationDegree();
        request.setAttribute("eduList", educationDegreeList);
        System.out.println(educationDegreeList.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //int id = Integer.parseInt(request.getParameter("id"));
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
        Employee listAdd = new Employee(name, birth, idCard, salary, phone, email, address, new Position(idPos),
                new EducationDegree(idEdu), new Division(idDiv));
        employeeRepository.insertEmployee(listAdd);
        request.setAttribute("message", "Đã thêm thành công");
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);

    }

    public void showUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Position> positionList = getInfoEmployeeSQL.selectPosition();
        request.setAttribute("postitions", positionList);

        List<Division> divisionList = getInfoEmployeeSQL.selectDivision();
        request.setAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = getInfoEmployeeSQL.selectEducationDegree();
        request.setAttribute("eduList", educationDegreeList);

        Employee employee = employeeRepository.selectEmployee(id);
        request.setAttribute("employee", employee);

        request.getRequestDispatcher("employee/update.jsp").forward(request, response);

    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response)
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
        Employee listAdd = new Employee(id, name, birth, idCard, salary, phone, email, address, new Position(idPos),
                new EducationDegree(idEdu), new Division(idDiv));

        employeeRepository.updateEmployee(listAdd);
        request.setAttribute("message", "Đã cập nhập thành công");
        request.getRequestDispatcher("employee/update.jsp").forward(request, response);
    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        employeeRepository.deleteEmployee(id);

        showListEmployee(request, response);


    }

    public void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String employeeName = request.getParameter("employeeName");

        List<Employee> employeeList = employeeRepository.searchEmployee(employeeName);

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }
}


