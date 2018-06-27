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
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String addedBy; //username
    private Date addedOn;
    private String updatedBy; //username
    private Date updatedOn;
    private boolean removed;
    
    User(int ID, String Fullname, String Username, String Password, String Admin){
        this.id = ID;
        this.fullname = Fullname;
        this.username = Username;
        this.password = Password;
        this.addedBy = Admin;
    }
    
    //GETTERS
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getFullName(){
        return fullname;
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
    
    public void setAddedBy(String Admin){
        this.addedBy = Admin;
    }
    
    public void setAddedOn(){
        this.addedOn = new Date();
    }
    
    public void setUpdatedBy(String Admin){
        this.updatedBy = Admin;
    }
    
    public void setUpdatedOn(){
        this.updatedOn = new Date();
    }
}
