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
    private String addedBy;
    private Date addedOn;
    private String updatedBy;
    private Date updatedOn;
    private boolean removed;
    
    public Item(int ID, String Itemname, int Quantity, String Metric, int Type,
            String Adder, Date AddDate, String Updater, Date UpdateDate, boolean Removed){
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

    public Item(int aInt, String string, int aInt0, String string0, int aInt1, String string1, java.sql.Date date, String string2, java.sql.Date date0, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public void setAddedBy(String itemAdder){
        this.addedBy = itemAdder;
    }
    
    public void setAddedOn(Date dateAdded){
        this.addedOn = dateAdded;
    }
    
    public void setUpdatedBy(String itemUpdater){
        this.updatedBy = itemUpdater;
    }
    
    public void setUpdatedOn(Date dateUpdated){
        this.updatedOn = dateUpdated;
    }
    
    public void setRemoved(boolean removeBool){
        this.removed = removeBool;
    }
}
