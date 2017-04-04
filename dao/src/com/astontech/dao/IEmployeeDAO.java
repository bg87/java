package com.astontech.dao;

import com.astontech.bo.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public Employee getEmployeeById(int employeeId);

    public List<Employee> getEmployeeList();

    public int insertPerson(Employee employee);

    public boolean updatePerson(Employee employee);

    public boolean deletePerson(int EmployeeId);

}
