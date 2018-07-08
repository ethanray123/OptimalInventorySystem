/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author acer
 */
public class ItemType {
    private final int id;   
    private String name;
    private String details;
    private String addedBy;
    private Date addedOn;
    private String updatedBy;
    private Date updatedOn;
    private boolean removed;
    
    public ItemType(int ID,String Name, String Details, String Adder, Date AddDate, String Updater, Date UpdateDate){
        this.id = ID;
        this.name = Name;
        this.details = Details;
        this.addedBy = Adder;
        this.addedOn = AddDate;
        this.updatedBy = Updater;
        this.updatedOn = UpdateDate; 
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDetails(){
        return details;
    }
    public String getAddedBy(){
        return addedBy;
    }
    
    public Date getAddedOn(){
        return addedOn;
    }
    
    public String getUpdatedBy(){
        return updatedBy;
    }
    
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
}
