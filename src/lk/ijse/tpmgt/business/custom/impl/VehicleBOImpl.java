/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.custom.VehicleBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.VehicleDAO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.entity.Vehicle;


public class VehicleBOImpl implements VehicleBO {
    private VehicleDAO vehicleDAO;

    public VehicleBOImpl() {
        this.vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.VEHICLE);
    }
    
    @Override
    public boolean saveVehicle(VehicleDTO vehicle) throws Exception {
        return vehicleDAO.save(new Vehicle(vehicle.getRegNo(), vehicle.getBrand(), vehicle.getColour(), vehicle.getBoughtDate()));
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicle) throws Exception {
        return vehicleDAO.update(new Vehicle(vehicle.getRegNo(), vehicle.getBrand(), vehicle.getColour(), vehicle.getBoughtDate()));

    }

    @Override
    public boolean deleteVehicle(String id) throws Exception {
        return vehicleDAO.delete(id);

    }

    @Override
    public VehicleDTO findByID(String id) throws Exception {
        
        Vehicle vehicle=vehicleDAO.find(id);
        VehicleDTO vehicleDTO= new VehicleDTO(vehicle.getRegNo(),
                vehicle.getBrand(),
                vehicle.getColour(),
                vehicle.getBoughtDate());        
       return vehicleDTO;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws Exception {
        ArrayList<Vehicle> allVehicles = vehicleDAO.getAll();
        ArrayList<VehicleDTO> dtos = new ArrayList<>();
        
        for (Vehicle vehicle : allVehicles) {
            VehicleDTO vehicleDTO= new VehicleDTO(vehicle.getRegNo(),
                    vehicle.getBrand(),
                    vehicle.getColour(),
                    vehicle.getBoughtDate());
            dtos.add(vehicleDTO);
        }
        return dtos;
        
    }

    @Override
    public ArrayList<VehicleDTO> getVehicleID() throws Exception {
         ArrayList<Vehicle> allVehicles = vehicleDAO.getAll();
          ArrayList<VehicleDTO> ids = new ArrayList<>();
           for (Vehicle vehicle : allVehicles) {
             String regNo = vehicle.getRegNo();
            VehicleDTO vehicleDTO= new VehicleDTO(regNo);
            ids.add(vehicleDTO);
        }
           return ids;
    }
    
    
    
}
