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
public class CategoryItem {
    private final int categoryid;
    private final int itemid;
    private int itemQuantity;
    private int addedBy; //id
    private Date addedOn;
    private int updatedBy; //id
    private Date updatedOn;
    private boolean removed;
            
    public CategoryItem(int CategoryID, int ItemID, int quantity, int AddedBy,
            Date AddedOn, int UpdatedBy, Date UpdatedOn){
        this.categoryid = CategoryID;
        this.itemid = ItemID;
        this.itemQuantity = quantity;
        this.addedBy = AddedBy;
        this.addedOn = AddedOn;
        this.updatedBy = UpdatedBy;
        this.updatedOn = UpdatedOn;
    }
    
    //GETTERS
    public int getCategoryID(){
        return categoryid;
    }
    
    public int getItemID(){
        return itemid;
    }
    
    public int getItemQuantity(){
        return itemQuantity;
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
    public void setQuantity(int quantity){
        this.itemQuantity = quantity;
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
