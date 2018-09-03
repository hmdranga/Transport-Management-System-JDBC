/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.ijse.tpmgt.business.BOFactory;
import lk.ijse.tpmgt.business.custom.ExpenceDetailBO;
import lk.ijse.tpmgt.business.custom.VehicleBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.SuperDAO;
import lk.ijse.tpmgt.dao.custom.ExpenceDetailDAO;
import lk.ijse.tpmgt.dto.ExpenceDetailDTO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.entity.ExpenceDetail;
import lk.ijse.tpmgt.entity.ExpenceDetail_PK;


public class ExpenceDetailBOImpl implements ExpenceDetailBO {
    private ExpenceDetailDAO expenceDetailDAO;

    public ExpenceDetailBOImpl() {
        this.expenceDetailDAO = (ExpenceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.EXPENCEDETAIL);
        
    }
    
    @Override
    public boolean saveExpenceDetail(ExpenceDetailDTO expenceDetail) throws Exception {
        return  expenceDetailDAO.save(new ExpenceDetail(expenceDetail.getRegNo(),
                expenceDetail.getExId(),
                expenceDetail.getDate(),
                expenceDetail.getAmount(),
                expenceDetail.getDescription()));
    }

    @Override
    public boolean updateExpenceDetail(ExpenceDetailDTO expenceDetail) throws Exception {
        return expenceDetailDAO.update(new ExpenceDetail(expenceDetail.getRegNo(),
                expenceDetail.getExId(),
                expenceDetail.getDate(),
                expenceDetail.getAmount(),
                expenceDetail.getDescription()));
        
    }

    @Override
    public boolean deleteExpenceDetail(ExpenceDetailDTO expenceDetailDTO) throws Exception {
      
        return expenceDetailDAO.delete(new ExpenceDetail_PK(expenceDetailDTO.getRegNo(), expenceDetailDTO.getExId()));
    }

    @Override
    public ExpenceDetailDTO findByID(ExpenceDetailDTO expenceDetailDTO) throws Exception {
      ExpenceDetail expenceDetail = expenceDetailDAO.find(new ExpenceDetail_PK(expenceDetailDTO.getRegNo(), expenceDetailDTO.getExId()));
      ExpenceDetailDTO expenceDetailDTO1= new ExpenceDetailDTO(expenceDetail.getExpenceDetail_pk().getRegNo(),
              expenceDetail.getExpenceDetail_pk().getExId(),
              expenceDetail.getDate(),
              expenceDetail.getAmount(),expenceDetail.getDescription());
        return expenceDetailDTO1;
    }

    @Override
    public ArrayList<ExpenceDetailDTO> getAllExpenceDetail() throws Exception {
        ArrayList<ExpenceDetail> allExpenceDetails=expenceDetailDAO.getAll();
        ArrayList<ExpenceDetailDTO> dtos = new ArrayList<>();
        for (ExpenceDetail expenceDetail : allExpenceDetails) {
            ExpenceDetailDTO expenceDetailDTO=new ExpenceDetailDTO(expenceDetail.getExpenceDetail_pk().getRegNo(),
                    expenceDetail.getExpenceDetail_pk().getExId(),
                    expenceDetail.getDate(),
                    expenceDetail.getAmount(),
                    expenceDetail.getDescription());
            dtos.add(expenceDetailDTO);
            
        }
        return dtos;
       
    }

    @Override
    public ArrayList<VehicleDTO> getVehicleID() throws Exception {
        VehicleBO vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLE);
        return vehicleBO.getVehicleID();
    }
    
}
