package com.astontech.dao.mssql;

import com.astontech.bo.Email;
import com.astontech.dao.IEmailDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOIml extends MSSQL implements IEmailDAO {

    @Override
    public Email getEmailById(int emailId) {

        Connect();
        Email email = null;

        try {
            String sp = "exec dbo.usp_GetEmail ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, emailId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                email = hydrateObject(rs);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return email;
    }

    @Override
    public List<Email> getEmailList() {

        Connect();
        List<Email> emailList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetEmail ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                emailList.add(hydrateObject(rs));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return emailList;
    }

    @Override
    public int insertEmail(com.astontech.bo.Email email) {
        return 0;
    }

    @Override
    public boolean updateEmail(com.astontech.bo.Email email) {
        return false;
    }

    @Override
    public boolean deleteEmail(int EmailId) {
        return false;
    }

    private static Email hydrateObject(ResultSet rs) throws SQLException {

        Email email = new Email();
        email.setEmailAddress(rs.getString(1));

        return email;
    }

}