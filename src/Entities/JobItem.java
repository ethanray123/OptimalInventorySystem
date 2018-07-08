/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;

/**
 *
 * @author Hazel Cavite
 */
public class JobItem {
    private int jobitem_id;
    private int item_id;
    private int item_qty;
    private int job_id;
    private String added_by;
    private Timestamp added_date;
    private String updated_by;
    private Timestamp updated_date;
    private int removedVal;
    
    public JobItem(int jobItemID, int ID, int qty, int jobID, String Adder, Timestamp AddDate, String Updater, 
        Timestamp UpdateDate){
        this.jobitem_id = jobItemID;
        this.item_id = ID;
        this.item_qty = qty;
        this.job_id = jobID;
        this.added_by = Adder;
        this.added_date = AddDate;
        this.updated_by = Updater;
        this.updated_date = UpdateDate;
    }
    public JobItem(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //GETTERS
    public int getID()
    {
        return this.jobitem_id;
    }
    
    public int getItemID(){
        return this.item_id;
    }
    
    public int getQty(){
        return this.item_qty;
    }
    
    public int getJobID(){
        return this.job_id;
    }
    
    public String getAddedBy(){
        return this.added_by;
    }
    
    public Timestamp getAddedOn(){
        return this.added_date;
    }
    
    public String getUpdatedBy(){
        return this.updated_by;
    }
    
    public Timestamp getUpdatedOn(){
        return this.updated_date;
    }
    
    public int getRemoved(){
        return this.removedVal;
    }
    
    //SETTERS
    public void setAddedBy(String jobAdder){
        this.added_by = jobAdder;
    }
    
    public void setAddedOn(Timestamp dateAdded){
        this.added_date = dateAdded;
    }
    
    public void setUpdatedBy(String jobUpdater){
        this.updated_by = jobUpdater;
    }
    
    public void setUpdatedOn(Timestamp dateUpdated){
        this.updated_date = dateUpdated;
    }
    
    public void setRemoved(int removed){
        this.removedVal = removed;
    }
}
