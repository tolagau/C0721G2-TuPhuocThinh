package repository.impl;

import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Employee;
import bean.employee.Position;
import repository.BaseRepository;
import repository.IEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.GetInfoEmployeeSQL.*;


public class EmployeeRepository implements IEmployee {


    @Override
    public List<Employee> selectAllEmployee() {

        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        Position position = new Position();
        EducationDegree degree = new EducationDegree();
        Division division = new Division();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee;");
            while (resultSet.next()) {
                for (Position positions : selectPosition()) {
                    if (positions.getId() == resultSet.getInt("position_id"))
                        position = positions;
                }
                for (Division division1 : selectDivision()) {
                    if (division1.getId() == resultSet.getInt("division_id"))
                        division = division1;
                }
                for (EducationDegree degree1 : selectEducationDegree()) {
                    if (degree1.getId() == resultSet.getInt("education_degree_id"))
                        degree = degree1;
                }
                int id = resultSet.getInt("employee_id");
                System.out.println(id);
                employee.setId(id);
                employee.setName(resultSet.getString("employee_name"));
                employee.setBirthDay(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setPosition(position);
                employee.setEducationDegree(degree);
                employee.setDivision(division);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployee(int id) {
        List<Employee> employeeList = selectAllEmployee();
        Employee employee = null;
        for (Employee employee1 : employeeList) {
            if (employee1.getId() == id) {
                employee = employee1;
            }
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("insert into employee " +
                    "values(?,?,?,?,?,?,?,?,?,?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, String.valueOf(employee.getSalary()));
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, String.valueOf(employee.getPosition()));
            preparedStatement.setString(9, String.valueOf(employee.getEducationDegree()));
            preparedStatement.setString(10, String.valueOf(employee.getDivision()));
            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement
                    ("update employee\n" +
                            "set employee_name = ?, employee_birthday = ?, employee_id_card = ?, " +
                            "employee_salary = ?, employee_phone = ?, \n" +
                            "employee_email = ?, employee_address =?, position_id = ?, " +
                            "education_degree_id = ?, division_id = ?\n" +
                            "where employee_id = ?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, String.valueOf(employee.getSalary()));
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, String.valueOf(employee.getPosition()));
            preparedStatement.setString(9, String.valueOf(employee.getEducationDegree()));
            preparedStatement.setString(10, String.valueOf(employee.getDivision()));
            preparedStatement.setString(11, String.valueOf(employee.getId()));
            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(
                    "delete from employee where employee_id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<Employee> searchEmployee(String employeeName) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(
                    "select * from employee where employee_name = ?");
            preparedStatement.setString(1, employeeName);

            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            Position position = null;
            EducationDegree degree = null;
            Division division = null;
            while (resultSet.next()) {
                for (Position positions : selectPosition()) {
                    if (positions.getId() == resultSet.getInt("position_id"))
                        position = positions;
                }
                for (Division division1 : selectDivision()) {
                    if (division1.getId() == resultSet.getInt("division_id"))
                        division = division1;
                }
                for (EducationDegree degree1 : selectEducationDegree()) {
                    if (degree1.getId() == resultSet.getInt("education_degree_id"))
                        degree = degree1;
                }
                employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setBirthDay(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setPosition(position);
                employee.setEducationDegree(degree);
                employee.setDivision(division);
                employeeList.add(employee);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
