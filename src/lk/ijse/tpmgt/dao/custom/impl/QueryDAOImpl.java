/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import lk.ijse.tpmgt.dao.CrudUtil;
import lk.ijse.tpmgt.dao.custom.QueryDAO;
import lk.ijse.tpmgt.db.DBConnection;


public class QueryDAOImpl implements QueryDAO {

    @Override
    public BigDecimal getTotalDistanceForDriver(String startDate, String curdate, String nic) throws Exception {
//             ResultSet rst = CrudUtil.executeQuery("SELECT SUM(END) - SUM(START) AS TOTAL FROM TRIPDETAIL WHERE DATE BETWEEN startDate=? AND curdate=? AND NIC=?", startDate,curdate,nic);
//             BigDecimal totalKM;
//             if(rst.next()){
//            totalKM=new BigDecimal(rst.getDouble("TOTAL"));
//            return totalKM;
//        }else{
//            return new BigDecimal(0);
             
             
        String SQL="SELECT SUM(END) - SUM(START) AS TOTAL FROM TRIPDETAIL WHERE DATE BETWEEN '"+startDate+"' AND '"+curdate+"' AND NIC='"+nic+"'";
        Statement stm=DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        BigDecimal totalKM;
        if(rst.next()){
            totalKM=new BigDecimal(rst.getDouble("TOTAL"));
            return totalKM;
        }else{
            return new BigDecimal(0);
        
    }
    
 
    }   
}
