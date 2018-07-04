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
public class Item {
    private final int id;
    private String name;
    private int quantity;
    private String metric;
    private int type;
    private int addedBy;
    private Date addedOn;
    private int updatedBy;
    private Date updatedOn;
    private boolean removed;
    
    public Item(int ID, String Itemname, int Quantity, String Metric, int Type,
            int Adder, Date AddDate, int Updater, Date UpdateDate, boolean Removed){
        this.id = ID;
        this.name = Itemname;
        this.quantity = Quantity;
        this.metric = Metric;
        this.type = Type;
        this.addedBy = Adder;
        this.addedOn = AddDate;
        this.updatedBy = Updater;
        this.updatedOn = UpdateDate;
        this.removed = Removed;
    }

    public Item(int ID, String Itemname, int Quantity, String Metric, int Type,
            int Adder, Date AddDate, int Updater, Date UpdateDate) {
        this.id = ID;
        this.name = Itemname;
        this.quantity = Quantity;
        this.metric = Metric;
        this.type = Type;
        this.addedBy = Adder;
        this.addedOn = AddDate;
        this.updatedBy = Updater;
        this.updatedOn = UpdateDate;
    }
    
    //GETTERS
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getMetric(){
        return metric;
    }
    
    public int getType(){
        return type;
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
    
    public boolean getRemoved(){
        return removed;
    }
    
    //SETTERS
    public void setName(String itemName){
        this.name = itemName;
    }
    
    public void setQuantity(int itemQuantity){
        this.quantity = itemQuantity;
    }
    
    public void setMetric(String itemMetric){
        this.metric = itemMetric;
    }
    
    public void setType(int itemType){
        this.type = itemType;
    }
    
    public void setAddedBy(int itemAdder){
        this.addedBy = itemAdder;
    }
    
    public void setAddedOn(Date dateAdded){
        this.addedOn = dateAdded;
    }
    
    public void setUpdatedBy(int itemUpdater){
        this.updatedBy = itemUpdater;
    }
    
    public void setUpdatedOn(Date dateUpdated){
        this.updatedOn = dateUpdated;
    }
    
    public void setRemoved(boolean removeBool){
        this.removed = removeBool;
    }
}
