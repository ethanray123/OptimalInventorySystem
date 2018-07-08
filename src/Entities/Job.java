
package Entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Hazel Cavite
 */
public class Job {
    private final int job_id;
    private String job_name;
    private final int category_id;
    private String added_by;
    private Timestamp added_date;
    private String updated_by;
    private Timestamp updated_date;
    private int removedVal;
    
    public Job(int ID, String name, int catID, String Adder, Timestamp AddDate, String Updater, 
        Timestamp UpdateDate){
        this.job_id = ID;
        this.job_name = name;
        this.category_id = catID;
        this.added_by = Adder;
        this.added_date = AddDate;
        this.updated_by = Updater;
        this.updated_date = UpdateDate;
    }
    
    public Job(int ID, String name, int catID, String Adder, Timestamp AddDate, String Updater, 
        Timestamp UpdateDate, int removed){
        this.job_id = ID;
        this.job_name = name;
        this.category_id = catID;
        this.added_by = Adder;
        this.added_date = AddDate;
        this.updated_by = Updater;
        this.updated_date = UpdateDate;
        this.removedVal = removed;
    }

    public Job(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //GETTERS
    public int getID(){
        return this.job_id;
    }
    
    public String getName(){
        return this.job_name;
    }
    
    public int getCatID(){
        return this.category_id;
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
    public void getName(String name){
        this.job_name = name;
    }
    
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
