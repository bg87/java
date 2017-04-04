package com.astontech.dao.mssql;

import com.astontech.bo.VehicleMake;
import com.astontech.dao.IVehicleMakeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOIml extends MSSQL implements IVehicleMakeDAO {

    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {

        Connect();
        VehicleMake vehicleMake = null;

        try {
            String sp = "exec dbo.usp_GetVehicleMake ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicleMake = hydrateObject(rs);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {

        Connect();
        List<VehicleMake> vehicleMakeList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetVehicleMake ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                vehicleMakeList.add(hydrateObject(rs));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicleMakeList;
    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        return 0;
    }

    @Override
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        return false;
    }

    @Override
    public boolean deleteVehicleMake(int VechicleMakeId) {
        return false;
    }

    private static VehicleMake hydrateObject(ResultSet rs) throws SQLException {

        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName(rs.getString(1));

        return vehicleMake;
    }
}
