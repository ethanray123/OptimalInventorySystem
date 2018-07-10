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
            String Adder, Date AddDate, String Updater, Date UpdateDate) {
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
    public String getAddedBy(){
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
    public String getUpdatedBy(){
        return updatedBy;
    }
    
    /**
     *
     * @return
     */
    public Date getUpdatedOn(){
        return updatedOn;
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
    public void setAddedBy(String itemAdder){
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
    public void setUpdatedBy(String itemUpdater){
        this.updatedBy = itemUpdater;
    }
    
    /**
     *
     * @param dateUpdated
     */
    public void setUpdatedOn(Date dateUpdated){
        this.updatedOn = dateUpdated;
    }
    
}
