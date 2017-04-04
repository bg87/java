package com.astontech.dao.mssql;

import com.astontech.bo.Person;
import com.astontech.dao.IPersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOIml extends MSSQL implements IPersonDAO {

    @Override
    public Person getPersonById(int personId) {

        Connect();
        Person person = null;

        try {
            String sp = "exec dbo.usp_GetPerson ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = hydrateObject(rs);
                System.out.println(person);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {

        Connect();
        List<Person> personList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetPerson ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                // populate new person object and add to personList
                personList.add(hydrateObject(rs));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        Connect();
        int id = 0;

//        values( @Title,
//                @FirstName,
//                @MiddleName,
//                @LastName,
//                @DisplayFirstName,
//                @BirthDate,
//                @SSN,
//                @Gender);

        try {
            String sp = "exec dbo.usp_ExecutePerson ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getDisplayFirstName());
            cStmt.setDate(8, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setString(9, person.getSSN());
            cStmt.setString(10, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return id;
    }

    @Override
    public boolean updatePerson(Person person) {

        Connect();
        int id = 0;

//        values( @Title,
//                @FirstName,
//                @MiddleName,
//                @LastName,
//                @DisplayFirstName,
//                @BirthDate,
//                @SSN,
//                @Gender);

        try {
            String sp = "exec dbo.usp_ExecutePerson ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, person.getPersonId());
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getDisplayFirstName());
            cStmt.setDate(8, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setString(9, person.getSSN());
            cStmt.setString(10, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return id > 0;
    }

    @Override
    public boolean deletePerson(int personId) {

        Connect();
        int id = 0;

        try {
            String sp = "exec dbo.usp_ExecutePerson ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, personId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setString(7, "");
            cStmt.setDate(8, new java.sql.Date(0));
            cStmt.setString(9, "");
            cStmt.setString(10, "");

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return id > 0;
    }

    private static Person hydrateObject(ResultSet rs) throws SQLException {

        Person person = new Person();

//        a.PersonId,
//        a.Title,
//        a.FirstName,
//        a.MiddleName,
//        a.LastName,
//        a.SSN,
//        a.Gender

        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setMiddleName(rs.getString(4));
        person.setLastName(rs.getString(5));
        person.setSSN(rs.getString(6));
        person.setGender(rs.getString(7));

        return person;
    }

}
