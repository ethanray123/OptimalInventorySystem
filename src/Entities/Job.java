
package Entities;

import java.util.Date;

/**
 *
 * @author Hazel Cavite
 */
public class Job {
    private final int job_id;
    private final int category_id;
    private String added_by;
    private Date added_date;
    private String updated_by;
    private Date updated_date;
    
    public Job(int ID, int catID, String Adder, Date AddDate, String Updater, 
        Date UpdateDate){
        this.job_id = ID;
        this.category_id = catID;
        this.added_by = Adder;
        this.added_date = AddDate;
        this.updated_by = Updater;
        this.updated_date = UpdateDate;
    }

    public Job(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //GETTERS
    public int getID(){
        return job_id;
    }
    
    public int getCatID(){
        return category_id;
    }
    
    public String getAddedBy(){
        return added_by;
    }
    
    public Date getAddedOn(){
        return added_date;
    }
    
    public String getUpdatedBy(){
        return updated_by;
    }
    
    public Date getUpdatedOn(){
        return updated_date;
    }
    
    //SETTERS
    public void setAddedBy(String jobAdder){
        this.added_by = jobAdder;
    }
    
    public void setAddedOn(Date dateAdded){
        this.added_date = dateAdded;
    }
    
    public void setUpdatedBy(String jobUpdater){
        this.updated_by = jobUpdater;
    }
    
    public void setUpdatedOn(Date dateUpdated){
        this.updated_date = dateUpdated;
    }
}
