package Entities;

import java.util.Date;

/**
 *
 * The class represents the cleaning categories from the database
 * @author Ethan
 * @version 3.00, 6 Jul 2018
 */
public class Category {
    private final int id;
    private String name;
    private final int addedBy; 
    private final Date addedOn;
    private int updatedBy; 
    private Date updatedOn;
//    private boolean removed;
            
    /**
     *
     * @param ID integer that represents the category ID
     * @param Name String that contains the name of the category
     * @param AddedBy integer that holds a user ID of the user who created the category
     * @param AddedOn Date specifying the creation of the category
     * @param UpdatedBy integer that holds a user ID of the user who updated the category
     * @param UpdatedOn Date specifying when the category was updated
     */
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

    /**
     *
     * @return ID of the Category
     */
    public int getID(){
        return id;
    }
    
    /**
     *
     * @return name of the Category
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @return the ID of the user who created the category
     */
    public int getAddedBy(){
        return addedBy;
    }
    
    /**
     *
     * @return the Date of the category creation
     */
    public Date getAddedOn(){
        return addedOn;
    }
    
    /**
     * 
     * @return the ID of the user who updated the category
     */
    public int getUpdatedBy(){
        return updatedBy;
    }
    
    /**
     *
     * @return the Date of the category updating
     */
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
    //SETTERS

    /**
     *
     * @param Name the name to replace the existing category name
     */
    public void setName(String Name){
        this.name = Name;
    }
    
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
