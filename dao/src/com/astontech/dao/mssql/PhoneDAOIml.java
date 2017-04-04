package com.astontech.dao.mssql;

import com.astontech.bo.Phone;
import com.astontech.dao.IPhoneDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOIml extends MSSQL implements IPhoneDAO {

    @Override
    public Phone getPhoneById(int phoneId) {

        Connect();
        Phone phone = null;

        try {
            String sp = "exec dbo.usp_GetPhone ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, phoneId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                phone = hydrateObject(rs);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return phone;
    }

    @Override
    public List<Phone> getPhoneList() {

        Connect();
        List<Phone> phoneList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetPhone ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                phoneList.add(hydrateObject(rs));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return phoneList;
    }

    @Override
    public int insertPerson(Phone phone) {
        return 0;
    }

    @Override
    public boolean updatePhone(Phone phone) {
        return false;
    }

    @Override
    public boolean deletePhone(int phoneId) {
        return false;
    }

    private static Phone hydrateObject(ResultSet rs) throws SQLException {

        Phone phone = new Phone();
        phone.setAreaCode(rs.getInt(1));
        phone.setPhoneNumber(rs.getString(2));

        return phone;
    }
}
