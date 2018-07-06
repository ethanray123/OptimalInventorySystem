package Entities;

import java.util.Date;

/**
 * 
 * The class represents the category item's information from the database
 * @author Ethan
 * version 3.00, 6 Jul 2018
 */
public class CategoryItem {
    private final int categoryid;
    private final int itemid;
    private int itemQuantity;
    private final int addedBy; 
    private final Date addedOn;
    private int updatedBy; 
    private Date updatedOn;
//    private boolean removed;
            
    /**
     *
     * @param CategoryID Integer representing the ID of the category the item belongs to 
     * @param ItemID Integer representing the ID of the item in the inventory being referred to
     * @param quantity Integer indicating the amount required of the item for the category
     * @param AddedBy integer that holds a user ID of the user who created the category item
     * @param AddedOn Date specifying the creation of the category item
     * @param UpdatedBy integer that holds a user ID of the user who updated the category item
     * @param UpdatedOn Date specifying when the category item was updated
     */
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

    /**
     *
     * @return ID of the category the item belongs to
     */
    public int getCategoryID(){
        return categoryid;
    }
    
    /**
     *
     * @return ID of the item in the inventory being referred to
     */
    public int getItemID(){
        return itemid;
    }
    
    /**
     *
     * @return the amount required of the item for the category
     */
    public int getItemQuantity(){
        return itemQuantity;
    }
    
    /**
     *
     * @return ID of the user who created the category item
     */
    public int getAddedBy(){
        return addedBy;
    }
    
    /**
     *
     * @return Date of category item creation
     */
    public Date getAddedOn(){
        return addedOn;
    }
    
    /**
     *
     * @return ID of the user who updated the category item
     */
    public int getUpdatedBy(){
        return updatedBy;
    }
    
    /**
     *
     * @return Date of category item updating
     */
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
    //SETTERS

    /**
     *
     * @param quantity Integer setting the amount required of the item
     */
    public void setQuantity(int quantity){
        this.itemQuantity = quantity;
    }
    
//    /**
//     *
//     * @param AddedBy
//     */
//    public void setAddedBy(int AddedBy){
//        this.addedBy = AddedBy;
//    }
//    
//    /**
//     *
//     * @param AddedOn
//     */
//    public void setAddedOn(Date AddedOn){
//        this.addedOn = AddedOn;
//    }
    
    /**
     *
     * @param UpdatedBy the ID of the user who recently updated the category
     */
    public void setUpdatedBy(int UpdatedBy){
        this.updatedBy = UpdatedBy;
    }
    
    /**
     *
     * @param UpdatedOn the latest Date the category was updated
     */
    public void setUpdatedOn(Date UpdatedOn){
        this.updatedOn = UpdatedOn;
    }
}
