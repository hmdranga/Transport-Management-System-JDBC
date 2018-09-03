/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.entity;

/**
 *
 * @author A C E R
 */
public class ExpenceType {
    
    private String exId;
    private String type;

    public ExpenceType() {
    }

    public ExpenceType(String exId, String type) {
        this.exId = exId;
        this.type = type;
    }
    
    
    /**
     * @return the exId
     */
    public String getExId() {
        return exId;
    }

    /**
     * @param exId the exId to set
     */
    public void setExId(String exId) {
        this.exId = exId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ExpenceType{" + "exId=" + exId + ", type=" + type + '}';
    }
  
}
