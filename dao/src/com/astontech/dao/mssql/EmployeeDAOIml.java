package com.astontech.dao.mssql;

import com.astontech.bo.Employee;
import com.astontech.dao.IEmployeeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOIml extends MSSQL implements IEmployeeDAO {

    @Override
    public Employee getEmployeeById(int employeeId) {

        Connect();
        Employee employee = null;

        try {
            String storedProcedure = "exec dbo.usp_GetEmployee ?,?";
            CallableStatement cStmt = connection .prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, employeeId);
            ResultSet resultSet = cStmt.executeQuery();

            if(resultSet.next()) {
                employee = hydrateObject(resultSet);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {

        Connect();
        List<Employee> employeeList = new ArrayList<>();

        try {
            String storedProcedure = "exec dbo.usp_GetEmployee ?,?";
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);

            ResultSet resultSet = cStmt.executeQuery();

            while(resultSet.next()) {
                employeeList.add(hydrateObject(resultSet));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return employeeList;
    }

    @Override
    public int insertPerson(Employee employee) {
        return 0;
    }

    @Override
    public boolean updatePerson(Employee employee) {
        return false;
    }

    @Override
    public boolean deletePerson(int EmployeeId) {
        return false;
    }

    private static Employee hydrateObject(ResultSet rs) throws SQLException {

        Employee employee = new Employee();
        employee.setHireDate(rs.getDate(1));

        return employee;
    }
}
