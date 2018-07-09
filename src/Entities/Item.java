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
    
    /**
     *
     * @param ID Integer representing the ID of the item
     * @param Itemname String containing the name of the item
     * @param Quantity Integer representing the quantity of the item
     * @param Metric String containing the metric used for quantifying the item
     * @param Type Integer representing the item type of the item
     * @param Adder Integer representing the ID of the administrator who created the item
     * @param AddDate Date when the item was created
     * @param Updater Integer representing the ID of the administrator who most recently updated the item
     * @param UpdateDate Date when the item was created
     * @param Removed 
     */
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

    /**
     *
     * @param ID Integer representing the ID of the item
     * @param Itemname String containing the name of the item
     * @param Quantity Integer representing the quantity of the item
     * @param Metric String containing the metric used for quantifying the item
     * @param Type Integer representing the item type of the item
     * @param Adder Integer representing the ID of the administrator who created the item
     * @param AddDate Date when the item was created
     * @param Updater Integer representing the ID of the administrator who most recently updated the item
     * @param UpdateDate Date when the item was created
     */
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

    /**
     *
     * @return
     */
    public int getID(){
        return id;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @return
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     *
     * @return
     */
    public String getMetric(){
        return metric;
    }
    
    /**
     *
     * @return
     */
    public int getType(){
        return type;
    }
    
    /**
     *
     * @return
     */
    public int getAddedBy(){
        return addedBy;
    }
    
    /**
     *
     * @return
     */
    public Date getAddedOn(){
        return addedOn;
    }
    
    /**
     *
     * @return
     */
    public int getUpdatedBy(){
        return updatedBy;
    }
    
    /**
     *
     * @return
     */
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
    /**
     *
     * @return
     */
    public boolean getRemoved(){
        return removed;
    }
    
    //SETTERS

    /**
     *
     * @param itemName
     */
    public void setName(String itemName){
        this.name = itemName;
    }
    
    /**
     *
     * @param itemQuantity
     */
    public void setQuantity(int itemQuantity){
        this.quantity = itemQuantity;
    }
    
    /**
     *
     * @param itemMetric
     */
    public void setMetric(String itemMetric){
        this.metric = itemMetric;
    }
    
    /**
     *
     * @param itemType
     */
    public void setType(int itemType){
        this.type = itemType;
    }
    
    /**
     *
     * @param itemAdder
     */
    public void setAddedBy(int itemAdder){
        this.addedBy = itemAdder;
    }
    
    /**
     *
     * @param dateAdded
     */
    public void setAddedOn(Date dateAdded){
        this.addedOn = dateAdded;
    }
    
    /**
     *
     * @param itemUpdater
     */
    public void setUpdatedBy(int itemUpdater){
        this.updatedBy = itemUpdater;
    }
    
    /**
     *
     * @param dateUpdated
     */
    public void setUpdatedOn(Date dateUpdated){
        this.updatedOn = dateUpdated;
    }
    
    /**
     *
     * @param removeBool
     */
    public void setRemoved(boolean removeBool){
        this.removed = removeBool;
    }
}
