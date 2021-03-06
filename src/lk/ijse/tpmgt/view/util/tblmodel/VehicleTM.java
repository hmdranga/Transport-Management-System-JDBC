/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.view.util.tblmodel;

import java.util.Date;

/**
 *
 * @author A C E R
 */
public class VehicleTM {
    
    private String regNo;
    private String brand;
    private String colour;
    private Date boughtDate;
   

    public VehicleTM() {
    }

    public VehicleTM(String regNo, String brand, String colour, Date boughtDate) {
        this.regNo = regNo;
        this.brand = brand;
        this.colour = colour;
        this.boughtDate = boughtDate;
    }

    /**
     * @return the regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @param regNo the regNo to set
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }  

    @Override
    public String toString() {
        return "VehicleTM{" + "regNo=" + getRegNo() + ", brand=" + getBrand() + ", colour=" + getColour() + ", boughtDate=" + getBoughtDate() + '}';
    }

    /**
     * @return the boughtDate
     */
    public Date getBoughtDate() {
        return boughtDate;
    }

    /**
     * @param boughtDate the boughtDate to set
     */
    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }
   
    
    
}
