package com.astontech.dao.mssql;

import com.astontech.bo.VehicleModel;
import com.astontech.dao.IVehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModelDAOIml extends MSSQL implements IVehicleModelDAO {

    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {

        Connect();
        VehicleModel vehicleModel = null;

        try {
            String sp = "exec dbo.usp_GetVehicleModel ?,?";
            CallableStatement cStmt = connection .prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicleModel = hydrateObject(rs);
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicleModel;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {

        Connect();
        List<VehicleModel> vehicleModelList = new ArrayList<>();

        try {
            String sp = "exec dbo.usp_GetVehicleModel ?,?";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                vehicleModelList.add(hydrateObject(rs));
            }

        } catch(SQLException ex) {
            logger.error(ex);
        }

        return vehicleModelList;
    }

    @Override
    public int insertVehicleModel(IVehicleModelDAO vehicleModel) {
        return 0;
    }

    @Override
    public boolean updateVehicleModel(IVehicleModelDAO vehicleModel) {
        return true;
    }

    @Override
    public boolean deleteVehicleModel(int VehicleModelId) {
        return false;
    }

    private static VehicleModel hydrateObject(ResultSet rs) throws SQLException {

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelName(rs.getString(1));

        return vehicleModel;
    }

}
