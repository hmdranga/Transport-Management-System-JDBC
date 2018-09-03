/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.custom.TripBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.TripDetailDAO;
import lk.ijse.tpmgt.dto.TripDetailDTO;
import lk.ijse.tpmgt.entity.TripDetail;


public class TripBOImpl implements TripBO {
    private TripDetailDAO tripDetailDAO;

    public TripBOImpl() {
        this.tripDetailDAO = (TripDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.TRIPDETAIL);
    }
    
    

    @Override
    public boolean saveTrip(TripDetailDTO trip) throws Exception {
        return tripDetailDAO.save(new TripDetail(trip.getId(),
                trip.getDate(),
                trip.getStart(),
                trip.getEnd(),
                trip.getRegNo(),
                trip.getNic()));
    }

    @Override
    public boolean updateTrip(TripDetailDTO trip) throws Exception {
        return tripDetailDAO.update(new TripDetail(trip.getId(),
                trip.getDate(),
                trip.getStart(),
                trip.getEnd(),
                trip.getRegNo(),
                trip.getNic()));
    }

    @Override
    public boolean deleteTrip(String id) throws Exception {
        return tripDetailDAO.delete(id);
    }

    @Override
    public TripDetailDTO findByID(String id) throws Exception {
        TripDetail trip = tripDetailDAO.find(id);
        TripDetailDTO tripDetailDTO=new TripDetailDTO(trip.getId(),
                trip.getDate(),
                trip.getStart(),
                trip.getEnd(),
                trip.getRegNo(),
                trip.getNic());
        return tripDetailDTO;
    }

    @Override
    public ArrayList<TripDetailDTO> getAllTrip() throws Exception {
        ArrayList<TripDetail> allTripDetails=tripDetailDAO.getAll();
        ArrayList<TripDetailDTO> tripDetailDTOs=new ArrayList<>();
        for (TripDetail tripDetail : allTripDetails) {
            TripDetailDTO tripDetailDTO=new TripDetailDTO(tripDetail.getId(),
                    tripDetail.getDate(),
                    tripDetail.getStart(),
                    tripDetail.getEnd(),
                    tripDetail.getRegNo(),
                    tripDetail.getNic());
            tripDetailDTOs.add(tripDetailDTO);  
        }
        return tripDetailDTOs;
    }
    
}
