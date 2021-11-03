package util;

import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Position;
import repository.BaseRepository;
import repository.impl.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetInfoEmployeeSQL {


    public static List<Position> selectPosition() {
        List<Position> positionList = new ArrayList<>();

        try {
            Statement statement = BaseRepository.connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select *\n" +
                    "from `position`");

            Position position = null;

            while (resultSet.next()) {

                position = new Position();
                position.setId(resultSet.getInt("position_id"));
                position.setName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public static List<EducationDegree> selectEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * \n" +
                    "from education_degree;");

            EducationDegree educationDegree = null;
            while (resultSet.next()) {
                educationDegree = new EducationDegree();
                educationDegree.setId(resultSet.getInt("education_degree_id"));
                educationDegree.setName(resultSet.getString("education_degree_name"));
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }

    public static List<Division> selectDivision() {
        List<Division> divisionList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * \n" +
                    "from division;");
            Division divisions = null;
            while (resultSet.next()) {
                divisions = new Division();
                divisions.setId(resultSet.getInt("division_id"));
                divisions.setName(resultSet.getString("division_name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }

}
