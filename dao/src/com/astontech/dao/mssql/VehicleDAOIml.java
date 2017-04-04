package com.astontech.dao.mssql;

import com.astontech.bo.Vehicle;
import com.astontech.dao.IVehicleDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOIml extends MSSQL implements IVehicleDAO {

    @Override
    public Vehicle getVehicleById(int vehicleId) {

        Connect();
        Vehicle vehicle = null;

        try {
            String sp = "exec dbo.usp_Getvehicle ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicle = hydrateObject(rs);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {

        Connect();
        List<Vehicle> vehicleList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetVehicle ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                vehicleList.add(hydrateObject(rs));
            }
        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean deleteVehicle(int VechicleId) {
        return false;
    }

    private static Vehicle hydrateObject(ResultSet rs) throws SQLException {

        Vehicle vehicle = new Vehicle();
        vehicle.setYear(rs.getInt(1));
        vehicle.setVin(rs.getString(3));
        vehicle.setPlate(rs.getString(4));
        vehicle.setColor(rs.getString(5));
        vehicle.setPurchase(rs.getBoolean(6));
        vehicle.setPurchasePrice(rs.getInt(7));

        return vehicle;
    }
}
