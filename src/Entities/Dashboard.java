/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;

/**
 *
 * @author Hazel Cavite
 */
public class Dashboard {
    private String item_name;
    private int item_qty;
    private String job_name;
    private String cleaning_category;
    private Timestamp lastupdated;
    private String lastupdater;
    
    public Dashboard(String itemName, int qty, String jobName,
        String cCat, Timestamp updatedOn, String updater){
        this.item_name = itemName;
        this.item_qty = qty;
        this.job_name = jobName;
        this.cleaning_category = cCat;
        this.lastupdated = updatedOn;
        this.lastupdater = updater;
    }
    public Dashboard(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //GETTERS
    public String getItemName()
    {
        return this.item_name;
    }
    
    public int getItemQty()
    {
        return this.item_qty;
    }
    
    public String getJobName()
    {
        return this.job_name;
    }
    
    public String getCleaningCategory()
    {
        return this.cleaning_category;
    }
    
    public Timestamp getLastUpdated()
    {
        return this.lastupdated;
    }
    
    public String getLastUpdater()
    {
        return this.lastupdater;
    }
    
    //SETTERS
    public void getItemName(String itemName)
    {
        this.item_name = itemName;
    }
    
    public void getItemQty(int qty)
    {
        this.item_qty = qty;
    }
    
    public void getJobName(String jobName)
    {
        this.job_name = jobName;
    }
    
    public void getCleaningCategory(String cCat)
    {
        this.cleaning_category = cCat;
    }
    
    public void getLastUpdated(Timestamp updatedOn)
    {
        this.lastupdated = updatedOn;
    }
    
    public void getLastUpdater(String updater)
    {
        this.lastupdater = updater;
    }
    
}
