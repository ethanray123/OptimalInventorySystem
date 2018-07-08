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
    private int addedBy;
    private Date addedOn;
    private int updatedBy;
    private Date updatedOn;
    private boolean removed;
    
    public ItemType(int ID,String Name, String Details, int Adder, Date AddDate, int Updater, Date UpdateDate){
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
    public int getAddedBy(){
        return addedBy;
    }
    
    public Date getAddedOn(){
        return addedOn;
    }
    
    public int getUpdatedBy(){
        return updatedBy;
    }
    
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
}
