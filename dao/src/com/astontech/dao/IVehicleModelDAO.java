package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

public interface IVehicleModelDAO {

    public VehicleModel getVehicleModelById(int vehicleModelId);

    public List<VehicleModel> getVehicleModelList();

    public int insertVehicleModel(IVehicleModelDAO vehicleModel);

    public boolean updateVehicleModel(IVehicleModelDAO vehicleModel);

    public boolean deleteVehicleModel(int VehicleModelId);

}
