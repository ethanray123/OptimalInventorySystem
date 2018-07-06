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
public class User {
    private final int id;
    private String username;
    private String password;
    private String fullname;
    private final int addedBy; 
    private final Date addedOn;
    private int updatedBy; 
    private Date updatedOn;
//    private boolean removed;
    
    /**
     *
     * @param ID
     * @param Username
     * @param Fullname
     * @param Password
     * @param AddedBy
     * @param AddedOn
     * @param UpdatedBy
     * @param UpdatedOn
     */
    public User(int ID, String Username, String Fullname, String Password, int AddedBy,
            Date AddedOn, int UpdatedBy, Date UpdatedOn){
        this.id = ID;
        this.fullname = Fullname;
        this.username = Username;
        this.password = Password;
        this.addedBy = AddedBy;
        this.addedOn = AddedOn;
        this.updatedBy = UpdatedBy;
        this.updatedOn = UpdatedOn;
    }
    
    /**
     *
     * @param ID
     * @param Username
     * @param Fullname
     * @param AddedBy
     * @param AddedOn
     * @param UpdatedBy
     * @param UpdatedOn
     */
    public User(int ID, String Username, String Fullname, int AddedBy,
            Date AddedOn, int UpdatedBy, Date UpdatedOn){
        this.id = ID;
        this.fullname = Fullname;
        this.username = Username;
        this.addedBy = AddedBy;
        this.addedOn = AddedOn;
        this.updatedBy = UpdatedBy;
        this.updatedOn = UpdatedOn;
    }
    
    //GETTERS

    /**
     *
     * @return ID of the user
     */
    public int getID(){
        return id;
    }
    
    /**
     *
     * @return username of the user
     */
    public String getUsername(){
        return username;
    }
    
    /**
     *
     * @return encrypted password of the user
     */
    public String getPassword(){
        return password;
    }
    
    /**
     *
     * @return full name of the user
     */
    public String getFullname(){
        return fullname;
    }
    
    /**
     *
     * @return ID of the administrator who created the user
     */
    public int getAddedBy(){
        return addedBy;
    }
    
    /**
     *
     * @return Date when the user was created
     */
    public Date getAddedOn(){
        return addedOn;
    }
    
    /**
     *
     * @return ID of the administrator who updated the user 
     */
    public int getUpdatedBy(){
        return updatedBy;
    }
    
    /**
     *
     * @return Date when the user was updated
     */
    public Date getUpdatedOn(){
        return updatedOn;
    }
    
    //SETTERS

    /**
     *
     * @param newusername String updates the username of the user
     */
    public void setUsername(String newusername){
        this.username = newusername;
    }
    
    /**
     *
     * @param hashpass String updates the encrypted password of the user
     */
    public void setPassword(String hashpass){
        this.password = hashpass;
    }
    
    /**
     *
     * @param name String that updates the full name of the user
     */
    public void setFullname(String name){
        this.fullname = name;
    }
    
//    /**
//     *
//     * @param Admin
//     */
//    public void setAddedBy(int Admin){
//        this.addedBy = Admin;
//    }
//    
//    /**
//     *
//     */
//    public void setAddedOn(){
//        this.addedOn = new Date();
//    }
    
    /**
     *
     * @param Admin ID of the user who recently updated the user
     */
    public void setUpdatedBy(int Admin){
        this.updatedBy = Admin;
    }
    
    /**
     *
     * @param UpdatedOn the latest Date the user was updated
     */
    public void setUpdatedOn(Date UpdatedOn){
        this.updatedOn = UpdatedOn;
    }
}
