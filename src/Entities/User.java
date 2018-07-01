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
    private int addedBy; //id
    private Date addedOn;
    private int updatedBy; //id
    private Date updatedOn;
    private boolean removed;
    
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
    public int getID(){
        return id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getFullname(){
        return fullname;
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
    public void setUsername(String newusername){
        this.username = newusername;
    }
    
    public void setPassword(String hashpass){
        this.password = hashpass;
    }
    
    public void setFullname(String name){
        this.fullname = name;
    }
    
    public void setAddedBy(int Admin){
        this.addedBy = Admin;
    }
    
    public void setAddedOn(){
        this.addedOn = new Date();
    }
    
    public void setUpdatedBy(int Admin){
        this.updatedBy = Admin;
    }
    
    public void setUpdatedOn(){
        this.updatedOn = new Date();
    }
}
