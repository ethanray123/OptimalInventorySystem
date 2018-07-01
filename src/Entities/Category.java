/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Ethan
 */
public class Category {
    private final int id;
    private String name;
    private int addedBy; //id
    private Date addedOn;
    private int updatedBy; //id
    private Date updatedOn;
    private boolean removed;
            
    public Category(int ID, String Name, int AddedBy,
            Date AddedOn, int UpdatedBy, Date UpdatedOn){
        this.id = ID;
        this.name = Name;
        this.addedBy = AddedBy;
        this.addedOn = AddedOn;
        this.updatedBy = UpdatedBy;
        this.updatedOn = UpdatedOn;
    }
    
    //GETTERS
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
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
    
    //SETTERS
    public void setName(String Name){
        this.name = Name;
    }
    
    public void setAddedBy(int AddedBy){
        this.addedBy = AddedBy;
    }
    
    public void setAddedOn(Date AddedOn){
        this.addedOn = AddedOn;
    }
    
    public void setUpdatedBy(int UpdatedBy){
        this.updatedBy = UpdatedBy;
    }
    
    public void setUpdatedOn(Date UpdatedOn){
        this.updatedOn = UpdatedOn;
    }
}
