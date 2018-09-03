/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.custom.DriverBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.DriverDAO;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.entity.Driver;


public class DriverBOImpl implements DriverBO {
    private DriverDAO driverDAO;

    public DriverBOImpl() {
        this.driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.DRIVER);
    }
    
    

    @Override
    public boolean saveDriver(DriverDTO driver) throws Exception {
         return driverDAO.save(new Driver(driver.getNic(),
                 driver.getName(),
                 driver.getAddress(),
                 driver.getContactNo(),
                 driver.getDrivingLicenceNo()));
    }

    @Override
    public boolean updateDriver(DriverDTO driver) throws Exception {
        return driverDAO.update(new  Driver(driver.getNic(), 
                driver.getName(),
                driver.getAddress(),
                driver.getContactNo(),
                driver.getDrivingLicenceNo()));
    }

    @Override
    public boolean deleteDriver(String id) throws Exception {
        return driverDAO.delete(id);
    }

    @Override
    public DriverDTO findByID(String id) throws Exception {
        Driver driver= driverDAO.find(id);
        DriverDTO driverDTO= new DriverDTO(driver.getNic(),
                driver.getName(),
                driver.getAddress(),
                driver.getContactNo(),
                driver.getDrivingLicenceNo());
        
        return driverDTO;
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() throws Exception {
            ArrayList<Driver> allDrivers= driverDAO.getAll();
            ArrayList<DriverDTO> dtos= new ArrayList<>();
            
            for(Driver driver : allDrivers){
                DriverDTO driverDTO= new DriverDTO(driver.getNic(), driver.getName(), driver.getAddress(), driver.getContactNo(), driver.getDrivingLicenceNo());
                dtos.add(driverDTO);
            }
            return dtos;

    }

    @Override
    public ArrayList<DriverDTO> getDriverID() throws Exception {
        ArrayList<Driver> allDrivers = driverDAO.getAll();
          ArrayList<DriverDTO> ids = new ArrayList<>();
           for (Driver driver : allDrivers) {
             String nic = driver.getNic();
            DriverDTO driverDTO= new DriverDTO(nic);
            ids.add(driverDTO);
        }
           return ids;
    }
    
}
