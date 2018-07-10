package optimalinventorysystem;

import Entities.Category;
import Entities.CategoryItem;
import Entities.Item;
import Entities.ItemType;
import Entities.User;
import Entities.Job;
import Entities.JobItem;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JDialog;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Hash.HashPassword;
import MySQL.CRUD;
import MySQL.Connect;
import static MySQL.CRUD.AddDeductItemQty;
import static MySQL.CRUD.getJobItem_ItemID;
import java.awt.event.ActionEvent;
import static optimalinventorysystem.Login.userid;
import static java.lang.Integer.parseInt;

/**
 *
 * @author TeamBangan
 */
public class Home extends javax.swing.JFrame {
    int userEditID = -1;
    int categoryEditID = -1;
    int categoryItemEditID = -1;
    public static int JobIDFromTable, JobItemsIDFromTable, JobItems_ItemIDFromTable = 0;
    public static int selectrow;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    // 5,32,33      -- darkest
    // 15, 74, 74   -- middle
    // 8, 40, 41    -- lightest
    public Home() throws SQLException{
        initComponents();
        
        try{
            Connection con = Connect.getConnection();
            String username = CRUD.selectUsername(con,userid);
            adminName.setText(username);
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        dashboard();
        Show_CategoriesTable();
        Show_UsersTable();
        Show_JobsTable();
        Show_JobItemsTable();
        addCleaningJobToCombobox();
        addJobItemNameToCombobox();
        addJobNameToCombobox();
        dashboard();
        initializeItemTypeNameList();
        ShowItemsTable();
        showItemTypeTable();
    }
    
    /**
     *
     */
    public void dashboard()
    {
        //set bg color when sidebar tab clicked
        dashboard_side.setBackground(new Color(15, 74, 74));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        categories_side.setBackground(new Color(8, 40, 41));
        users_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        dashboard.setVisible(true);
        items.setVisible(false);
        jobsPanel.setVisible(false);
        categories.setVisible(false);
        users.setVisible(false);
        
        // hide and show upper part jPanels
        upper_dashboard_panel.setVisible(true);
        upper_items_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
        upper_categories_panel.setVisible(false);
        upper_users_panel.setVisible(false);
    }
    
    /**
     *
     */
    public void items_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        items_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        categories_side.setBackground(new Color(8, 40, 41));
        users_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        items.setVisible(true);
        dashboard.setVisible(false);
        jobsPanel.setVisible(false);
        categories.setVisible(false);
        users.setVisible(false);
        
        // hide and show upper part jPanels
        upper_items_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
        upper_categories_panel.setVisible(false);
        upper_users_panel.setVisible(false);
    }
    
    /**
     *
     */
    public void jobs_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        jobs_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        categories_side.setBackground(new Color(8, 40, 41));
        users_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        jobsPanel.setVisible(true);
        dashboard.setVisible(false);
        items.setVisible(false);
        categories.setVisible(false);
        users.setVisible(false);
        
        // hide and show upper part jPanels
        upper_jobs_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_items_panel.setVisible(false);
        upper_categories_panel.setVisible(false);
        upper_users_panel.setVisible(false);
    }
    
    /**
     *
     */
    public void categories_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        categories_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        users_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        categories.setVisible(true);
        dashboard.setVisible(false);
        items.setVisible(false);
        jobsPanel.setVisible(false);
        users.setVisible(false);
        
        // hide and show upper part jPanels
        upper_categories_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_items_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
        upper_users_panel.setVisible(false);
        
    }
    
    /**
     *
     */
    public void users_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        users_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        categories_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        users.setVisible(true);
        dashboard.setVisible(false);
        items.setVisible(false);
        jobsPanel.setVisible(false);
        categories.setVisible(false);
        
        // hide and show upper part jPanels
        upper_users_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_items_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
        upper_categories_panel.setVisible(false);
        
    }

    //USER TABLE METHODS
    
    /**
     *
     * @return
     */
    public ArrayList<User> getUserList()
    {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectUsersInfo(con);
            User user;
            while(rs.next())
            {
                String addedBy = CRUD.selectFullname(con, rs.getInt("added_by"));
                String updatedBy = CRUD.selectFullname(con, rs.getInt("updated_by"));
                user = new User(rs.getInt("user_id"),rs.getString("username"),
                        rs.getString("full_name"),addedBy,
                        rs.getTimestamp("added_date"),updatedBy,
                        rs.getTimestamp("updated_date"));
                userList.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    /**
     *
     */
    public void Show_UsersTable()
    {
        ArrayList<User> list = getUserList();
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        Object[] row = new Object[7];
        for(User u : list) {
            row[0] = u.getID();
            row[1] = u.getUsername();
            row[2] = u.getFullname();
            row[3] = u.getAddedBy();
            row[4] = dateFormat.format(u.getAddedOn());
            row[5] = u.getUpdatedBy();
            row[6] = dateFormat.format(u.getUpdatedOn());
            model.addRow(row);
        }
    }

    /**
     *
     * @param u
     */
    public void addRowToUsersTable(User u){
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        Object[] row = new Object[7];
        row[0] = u.getID();
        row[1] = u.getUsername();
        row[2] = u.getFullname();
        row[3] = u.getAddedBy();
        row[4] = dateFormat.format(u.getAddedOn());
        row[5] = u.getUpdatedBy();
        row[6] = dateFormat.format(u.getUpdatedOn());
        model.addRow(row);
    }

    //END OF USER TABLE METHODS
    //CATEGORY TABLE METHODS

    /**
     *
     * @return
     */
    
    public ArrayList<Category> getCategoryList()
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectCategoriesInfo(con);
            Category category;
            while(rs.next())
            {
                String addedby = CRUD.selectFullname(con, rs.getInt("added_by"));
                String updatedby = CRUD.selectFullname(con, rs.getInt("updated_by"));
                category = new Category(rs.getInt("category_id"),
                        rs.getString("category_name"),
                        addedby,
                        rs.getTimestamp("added_date"),
                        updatedby,
                        rs.getTimestamp("updated_date"));
                categoryList.add(category);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    
    /**
     *
     */
    public void Show_CategoriesTable()
    {
        ArrayList<Category> list = getCategoryList();
        DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel();
        Object[] row = new Object[6];
        for(Category c : list) {
            row[0] = c.getID();
            row[1] = c.getName();
            row[2] = c.getAddedBy();
            row[3] = dateFormat.format(c.getAddedOn());
            row[4] = c.getUpdatedBy();
            row[5] = dateFormat.format(c.getUpdatedOn());
            model.addRow(row);
            categoryDropdown.addItem(c.getName());
        }
    }
    
    /**
     *
     * @param c
     */
    public void addRowToCategoriesTable(Category c){
        DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel();
        Object[] row = new Object[6];
        row[0] = c.getID();
        row[1] = c.getName();
        row[2] = c.getAddedBy();
        row[3] = dateFormat.format(c.getAddedOn());
        row[4] = c.getUpdatedBy();
        row[5] = dateFormat.format(c.getUpdatedOn());
        model.addRow(row);
        categoryDropdown.addItem(c.getName());
    }
    
    //END OF CATEGORY TABLE METHODS
    //CATEGORY ITEMS TABLE METHODS

    /**
     *
     * @param catID
     * @return
     */
    
    public ArrayList<CategoryItem> getCategoryItemsList(int catID){
        ArrayList<CategoryItem> categoryItemList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectCategoryItemsInfoUsingCategoryID(con,catID);
            CategoryItem catItem;
            while(rs.next())
            {
                catItem = new CategoryItem(
                    rs.getInt("category_id"),
                    rs.getInt("item_id"),
                    rs.getInt("item_quantity"),
                    rs.getInt("added_by"),
                    rs.getTimestamp("added_date"),
                    rs.getInt("updated_by"),
                    rs.getTimestamp("updated_date"));
                categoryItemList.add(catItem);}
        }catch(SQLException e){
            e.printStackTrace();
        }
        return categoryItemList;
    }

    /**
     *
     */
    public void Show_CategoryItemsTable()
    {
        try {
            DefaultTableModel model = (DefaultTableModel)categoryItemTable.getModel();
            int rowCount = model.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            model.setRowCount(0);
            String catName = (String) categoryDropdown.getSelectedItem();
            Connection con = Connect.getConnection();
            int catID = CRUD.selectCategoryID(con,catName);
            ArrayList<CategoryItem> list = getCategoryItemsList(catID);
            Object[] row = new Object[2];
            for(CategoryItem c : list) {
                row[0] = CRUD.selectItemName(con,c.getItemID());
                row[1] = c.getItemQuantity();
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param c
     */
    public void addRowToCategoryItemsTable(CategoryItem c){
        DefaultTableModel model = (DefaultTableModel)categoryItemTable.getModel();
        Object[] row = new Object[2];
        Connection con = Connect.getConnection();
        try {
            row[0] = CRUD.selectItemName(con,c.getItemID());
            row[1] = c.getItemQuantity();
            model.addRow(row);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Item> getItemList(){
        ArrayList<Item> itemList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectItemsInfo(con);
            Item item;
            while(rs.next())
            {
                String addedBy = CRUD.selectFullName(con, rs.getInt("added_by"));
                String updatedBy = CRUD.selectFullName(con, rs.getInt("updated_by"));
                item = new Item(
                           rs.getInt("item_id"),
                           rs.getString("item_name"),
                           rs.getInt("quantity"),
                           rs.getString("metric"),
                           rs.getInt("type"),
                           addedBy,
                           rs.getTimestamp("added_date"),
                           updatedBy,
                           rs.getTimestamp("updated_date")                       
                   );
                itemList.add(item);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return itemList;
    }
    
    /**
     *
     */
    public void initItemDropdown(){
        ArrayList<Item> list = getItemList();
        System.out.println("Items Available:");
        for(Item c : list) {
            System.out.println(c.getName());
            itemDropdown.addItem(c.getName());
        }
    }
    
    //END OF CATEGORY ITEMS TABLE METHODS
    //JOB TABLE METHODS
    
    public ArrayList<Job> getJobList ()
    {
        ArrayList<Job> jobList = new ArrayList<>();
        Connection con = Connect.getConnection();
        try {
            ResultSet rs = CRUD.selectJobsInfo(con);
            Job job;
            while(rs.next()){
                job = new Job(rs.getInt("job_id"), rs.getString("job_name"),
                    rs.getInt("category_id"), rs.getString("added_by"), 
                    rs.getTimestamp("added_date"), rs.getString("updated_by"),
                    rs.getTimestamp("updated_date"));
                jobList.add(job);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return jobList;
    }
    
    public void Show_JobsTable() throws SQLException
    {
        ArrayList<Job> list = getJobList();
        DefaultTableModel model = (DefaultTableModel) jobsTable.getModel();
        Object[] row = new Object[7];
        for(Job j : list){
            row[0] = j.getID();
            row[1] = j.getName();
            row[2] = j.getCatID();
            row[3] = j.getAddedBy();
            row[4] = dateFormat.format(j.getAddedOn());
            row[5] = j.getUpdatedBy();  
            row[6] = dateFormat.format(j.getUpdatedOn());
            model.addRow(row);
        }
    }
    
    public ArrayList<JobItem> getJobItemList ()
    {
        ArrayList<JobItem> jobItemList = new ArrayList<>();
        Connection con = Connect.getConnection();
        try {
            ResultSet rs = CRUD.selectJobItemsInfo(con);
            JobItem jobItem;
            while(rs.next()){
                jobItem = new JobItem(rs.getInt("jobItem_id"), rs.getInt("item_id"), rs.getInt("item_quantity"), 
                    rs.getInt("job_id"), rs.getString("added_by"), 
                    rs.getTimestamp("added_date"), rs.getString("updated_by"),
                    rs.getTimestamp("updated_date"));
                jobItemList.add(jobItem);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return jobItemList;
    }
    
    public void Show_JobItemsTable() throws SQLException
    {
        ArrayList<JobItem> list = getJobItemList();
        DefaultTableModel model = (DefaultTableModel) jobItemsTable.getModel();
        Object[] row = new Object[8];
        for(JobItem ji : list){
            row[0] = ji.getID();
            row[1] = ji.getItemID();
            row[2] = ji.getQty();
            row[3] = ji.getJobID();
            row[4] = ji.getAddedBy();
            row[5] = dateFormat.format(ji.getAddedOn());
            row[6] = ji.getUpdatedBy();  
            row[7] = dateFormat.format(ji.getUpdatedOn());
            model.addRow(row);
        }
    }
    
    public void addRowToJobsTable(Job j)
    {
        DefaultTableModel model = (DefaultTableModel)jobsTable.getModel();
        Object[] row = new Object[7];
            row[0] = j.getID();
            row[1] = j.getName();
            row[2] = j.getCatID();
            row[3] = j.getAddedBy();
            row[4] = dateFormat.format(j.getAddedOn());
            row[5] = j.getUpdatedBy();  
            row[6] = dateFormat.format(j.getUpdatedOn());
        model.addRow(row);
    }
    
    public void addRowToJobItemsTable(JobItem ji)
    {
        DefaultTableModel model = (DefaultTableModel)jobItemsTable.getModel();
        Object[] row = new Object[8];
        row[0] = ji.getID();
        row[1] = ji.getItemID();
        row[2] = ji.getQty();
        row[3] = ji.getJobID();
        row[4] = ji.getAddedBy();
        row[5] = dateFormat.format(ji.getAddedOn());
        row[6] = ji.getUpdatedBy();  
        row[7] = dateFormat.format(ji.getUpdatedOn());
        model.addRow(row);
    }
    
    public void addCleaningJobToCombobox()
    {
        Connection con = Connect.getConnection();
        try {
            ResultSet rs = CRUD.selectCleaningCategoryNameInfo(con);
            String clean;
            while(rs.next()){
                clean = rs.getString("category_name");
                jobcat.addItem(clean);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addJobItemNameToCombobox()
    {
        Connection con = Connect.getConnection();
        try {
            ResultSet rs = CRUD.selectJobItem_ItemNameInfo(con);
            String name;
            while(rs.next()){
                name = rs.getString("item_name");
                jobitemcombobox.addItem(name);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addJobNameToCombobox()
    {
        Connection con = Connect.getConnection();
        try {
            ResultSet rs = CRUD.selectJobsInfo(con);
            String name;
            while(rs.next()){
                name = rs.getString("job_name");
                jobcombobox.addItem(name);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //END OF JOB TABLE METHODS
    //ITEM TABLE METHODS
    
    public void initializeItemTypeNameList(){
        try {
            Connection con = Connect.getConnection();
            ResultSet rs = CRUD.selectItemNameFromItemType(con);
            while(rs.next()){
                ItemTypeNameList.addItem(rs.getString("type_name"));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowItemsTable(){
        ArrayList<Item> itemList = getItemList();
        DefaultTableModel model = (DefaultTableModel)itemsTable.getModel();
        Object[] row = new Object[9];
        for(Item it : itemList){
            row[0] = it.getID();
            row[1] = it.getName();
            row[2] = it.getQuantity();
            row[3] = it.getMetric();
            row[4] = it.getType();
            row[5] = it.getAddedBy();
            row[6] = dateFormat.format(it.getAddedOn());
            row[7] = it.getUpdatedBy();
            row[8] = dateFormat.format(it.getUpdatedOn());
            model.addRow(row);
        }
    }
    public void addRowtoItemsTable(Item it){
        DefaultTableModel model = (DefaultTableModel)itemsTable.getModel();
        Object[] row = new Object[9];
        row[0] = it.getID();
        row[1] = it.getName();
        row[2] = it.getQuantity();
        row[3] = it.getMetric();
        row[4] = it.getType();
        row[5] = it.getAddedBy();
        row[6] = dateFormat.format(it.getAddedOn());
        row[7] = it.getUpdatedBy();
        row[8] = dateFormat.format(it.getUpdatedOn());
       
        model.addRow(row);
    }    

    //END OF ITEM TABLE METHODS
    //ITEM TYPE TABLE METHODS
    public ArrayList<ItemType> getItemTypeList(){
        ArrayList<ItemType> ItemTypeList = new ArrayList<>();
        Connection con = Connect.getConnection();
        try {
           
            ResultSet rs = CRUD.selectItemTypeInfo(con);       
            ItemType itp;
            while(rs.next()){
                String addedBy = CRUD.selectFullName(con,  rs.getInt("added_by"));
                String updatedBy = CRUD.selectFullName(con,  rs.getInt("updated_by"));
                itp = new ItemType(
                rs.getInt("type_id"),
                rs.getString("type_name"),
                rs.getString("type_details"),
                addedBy,                    
                rs.getTimestamp("added_date"),
                updatedBy,
                rs.getTimestamp("updated_date")  
                 
                );
                ItemTypeList.add(itp);
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemTypeList;
    }
    
    public void showItemTypeTable(){
        ArrayList<ItemType> ItemTypeList = getItemTypeList();
        DefaultTableModel model = (DefaultTableModel)itemTypeTable.getModel();
        Object[] row = new Object[7];
        for(ItemType itp : ItemTypeList){
            row[0] = itp.getID();
            row[1] = itp.getName();
            row[2] = itp.getDetails();
            row[3] = itp.getAddedBy();
            row[4] = dateFormat.format(itp.getAddedOn());
            row[5] = itp.getUpdatedBy();
            row[6] = dateFormat.format(itp.getUpdatedOn());
            model.addRow(row);
        }
    }
    
    public void addRowtoItemTypeTable(ItemType itp){
        DefaultTableModel model = (DefaultTableModel)itemTypeTable.getModel();
        Object[] row = new Object[7];
        row[0] = itp.getID();
        row[1] = itp.getName();
        row[2] = itp.getDetails();
        row[3] = itp.getAddedBy();
        row[4] = dateFormat.format(itp.getAddedOn());
        row[5] = itp.getUpdatedBy();
        row[6] = dateFormat.format(itp.getUpdatedOn());
        model.addRow(row);
    }
    
    //END OF ITEM TYPE TABLE
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whole = new javax.swing.JPanel();
        right_sidebar = new javax.swing.JPanel();
        items = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tables = new javax.swing.JTabbedPane();
        itemsTablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        iTtable = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        itemTypeTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTab = new javax.swing.JTabbedPane();
        additemtype = new javax.swing.JPanel();
        additemtype_form = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        typename = new javax.swing.JTextField();
        itemtypedetails = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        addItemType_save = new javax.swing.JButton();
        updateitemtype_form = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        newtypename = new javax.swing.JTextField();
        itemtypedetails1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        typename3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        updateItemType = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        archiveitemtype_form = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        itemtypedetails2 = new javax.swing.JTextField();
        typename2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        archiveItemType = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        updateitems = new javax.swing.JPanel();
        additems_form2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        itemName2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        itemqty2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        ItemMetricList = new javax.swing.JComboBox<>();
        ItemTypeNameList = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        newitemname = new javax.swing.JTextField();
        Archive = new javax.swing.JButton();
        addItem_save = new javax.swing.JButton();
        archiveitem = new javax.swing.JPanel();
        additems_form3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        itemName3 = new javax.swing.JTextField();
        additems = new javax.swing.JPanel();
        additems_form = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        itemqty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ItemMetricList3 = new javax.swing.JComboBox<>();
        ItemTypeNameList3 = new javax.swing.JComboBox<>();
        dashboard = new javax.swing.JPanel();
        dashboard_label = new javax.swing.JLabel();
        dashboard_label1 = new javax.swing.JLabel();
        dashboard_label4 = new javax.swing.JLabel();
        dashboard_label5 = new javax.swing.JLabel();
        dashboard_label6 = new javax.swing.JLabel();
        jobsPanel = new javax.swing.JPanel();
        jobs_tab = new javax.swing.JTabbedPane();
        jobs = new javax.swing.JPanel();
        crud_jobs = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jobcat = new javax.swing.JComboBox<>();
        addJob = new javax.swing.JButton();
        updateJob = new javax.swing.JButton();
        deleteJob = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jobname = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jobsTable = new javax.swing.JTable();
        job_items = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jobItemsTable = new javax.swing.JTable();
        crud_jobItems = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        addJobItem = new javax.swing.JButton();
        updateJobItem = new javax.swing.JButton();
        deleteJobItem = new javax.swing.JButton();
        jobitemqty = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jobitemcombobox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jobcombobox = new javax.swing.JComboBox<>();
        users = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        additems_form8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        userEditLabel = new javax.swing.JLabel();
        saveEditUserInfoBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        fullnameField = new javax.swing.JTextField();
        clearUserFieldBtn = new javax.swing.JButton();
        removeUserBtn = new javax.swing.JButton();
        categories = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        categoryItemTable = new javax.swing.JTable();
        additems_form1 = new javax.swing.JPanel();
        categoryNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addEditCategoryBtn = new javax.swing.JButton();
        categoryDropdown = new javax.swing.JComboBox<>();
        itemQuantitySpinner = new javax.swing.JSpinner();
        addEditCategoryItemBtn = new javax.swing.JButton();
        itemDropdown = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        removeCategoryItemBtn = new javax.swing.JButton();
        categoryEditLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        removeCategoryBtn = new javax.swing.JButton();
        categoryItemUpdatedDate = new javax.swing.JLabel();
        clearCategoryFieldsBtn = new javax.swing.JButton();
        categoryItemUpdatedBy = new javax.swing.JLabel();
        categoryItemAddedDate = new javax.swing.JLabel();
        categoryItemAddedBy = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        upper_dashboard_panel = new javax.swing.JPanel();
        dashboard_up_label = new javax.swing.JLabel();
        upper_items_panel = new javax.swing.JPanel();
        items_up_label = new javax.swing.JLabel();
        upper_jobs_panel = new javax.swing.JPanel();
        jobs_up_label = new javax.swing.JLabel();
        upper_categories_panel = new javax.swing.JPanel();
        categories_up_label = new javax.swing.JLabel();
        upper_users_panel = new javax.swing.JPanel();
        users_up_label = new javax.swing.JLabel();
        left_sidebar = new javax.swing.JPanel();
        userimg = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        dashboard_side = new javax.swing.JPanel();
        dashboard_side_label = new javax.swing.JLabel();
        items_side = new javax.swing.JPanel();
        items_side_label = new javax.swing.JLabel();
        jobs_side = new javax.swing.JPanel();
        jobs_side_label = new javax.swing.JLabel();
        categories_side = new javax.swing.JPanel();
        categories_side_label = new javax.swing.JLabel();
        users_side = new javax.swing.JPanel();
        users_side_label = new javax.swing.JLabel();
        logout_side = new javax.swing.JPanel();
        logout_side_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        whole.setBackground(new java.awt.Color(255, 255, 255));
        whole.setPreferredSize(new java.awt.Dimension(1500, 800));
        whole.setLayout(null);

        right_sidebar.setBackground(new java.awt.Color(5, 32, 33));
        right_sidebar.setPreferredSize(new java.awt.Dimension(1500, 800));
        right_sidebar.setLayout(null);

        items.setBackground(new java.awt.Color(5, 32, 33));
        items.setPreferredSize(new java.awt.Dimension(1500, 800));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(818, 968));

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "ITEM QUANTITY", "ITEM METRIC", "ITEM TYPE", "ADDED BY", "ADDED DATE", "UPDATED BY", "UPDATED DATE"
            }
        ));
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(itemsTable);

        javax.swing.GroupLayout itemsTablePanelLayout = new javax.swing.GroupLayout(itemsTablePanel);
        itemsTablePanel.setLayout(itemsTablePanelLayout);
        itemsTablePanelLayout.setHorizontalGroup(
            itemsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
        );
        itemsTablePanelLayout.setVerticalGroup(
            itemsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );

        Tables.addTab("Items Table", itemsTablePanel);

        iTtable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TYPE ID", "TYPE NAME", "TYPE DETAILS", "ADDED BY", "ADDED DATE", "UPDATED BY", "UPDATED DATE"
            }
        ));
        itemTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTypeTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(itemTypeTable);

        iTtable.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 300));

        Tables.addTab("Item Type Table", iTtable);

        jScrollPane4.setViewportView(Tables);

        itemsTab.setPreferredSize(new java.awt.Dimension(800, 300));

        additemtype.setBackground(new java.awt.Color(5, 32, 33));
        additemtype.setPreferredSize(new java.awt.Dimension(800, 425));

        additemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel20.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TYPE NAME");

        typename.setBackground(new java.awt.Color(15, 74, 74));
        typename.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        typename.setForeground(new java.awt.Color(255, 255, 255));
        typename.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        typename.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        typename.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        typename.setOpaque(false);

        itemtypedetails.setBackground(new java.awt.Color(15, 74, 74));
        itemtypedetails.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtypedetails.setForeground(new java.awt.Color(255, 255, 255));
        itemtypedetails.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtypedetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtypedetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtypedetails.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("TYPE DETAILS");

        addItemType_save.setBackground(new java.awt.Color(0, 204, 51));
        addItemType_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItemType_save.setForeground(new java.awt.Color(255, 255, 255));
        addItemType_save.setText("ADD");
        addItemType_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemType_saveActionPerformed(evt);
            }
        });

        updateitemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel23.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("TYPE DETAILS");

        newtypename.setBackground(new java.awt.Color(15, 74, 74));
        newtypename.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        newtypename.setForeground(new java.awt.Color(255, 255, 255));
        newtypename.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newtypename.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        newtypename.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newtypename.setOpaque(false);

        itemtypedetails1.setBackground(new java.awt.Color(15, 74, 74));
        itemtypedetails1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtypedetails1.setForeground(new java.awt.Color(255, 255, 255));
        itemtypedetails1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtypedetails1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtypedetails1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtypedetails1.setOpaque(false);

        jLabel24.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("TYPE NAME");

        typename3.setBackground(new java.awt.Color(15, 74, 74));
        typename3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        typename3.setForeground(new java.awt.Color(255, 255, 255));
        typename3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        typename3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        typename3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        typename3.setOpaque(false);

        jLabel22.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("NEW TYPE NAME");

        updateItemType.setBackground(new java.awt.Color(0, 204, 51));
        updateItemType.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        updateItemType.setForeground(new java.awt.Color(255, 255, 255));
        updateItemType.setText("UPDATE");
        updateItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemTypeActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("UPDATE ITEM TYPE");

        archiveitemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel9.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TYPE NAME");

        itemtypedetails2.setBackground(new java.awt.Color(15, 74, 74));
        itemtypedetails2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtypedetails2.setForeground(new java.awt.Color(255, 255, 255));
        itemtypedetails2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtypedetails2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtypedetails2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtypedetails2.setOpaque(false);

        typename2.setBackground(new java.awt.Color(15, 74, 74));
        typename2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        typename2.setForeground(new java.awt.Color(255, 255, 255));
        typename2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        typename2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        typename2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        typename2.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("TYPE DETAILS");

        jLabel34.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("ARCHIVE ITEM TYPE");

        javax.swing.GroupLayout archiveitemtype_formLayout = new javax.swing.GroupLayout(archiveitemtype_form);
        archiveitemtype_form.setLayout(archiveitemtype_formLayout);
        archiveitemtype_formLayout.setHorizontalGroup(
            archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34)
                    .addComponent(itemtypedetails2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(typename2))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        archiveitemtype_formLayout.setVerticalGroup(
            archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemtypedetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typename2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        archiveItemType.setBackground(new java.awt.Color(235, 85, 85));
        archiveItemType.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        archiveItemType.setForeground(new java.awt.Color(255, 255, 255));
        archiveItemType.setText("ARCHIVE");
        archiveItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveItemTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateitemtype_formLayout = new javax.swing.GroupLayout(updateitemtype_form);
        updateitemtype_form.setLayout(updateitemtype_formLayout);
        updateitemtype_formLayout.setHorizontalGroup(
            updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(40, 40, 40))
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(typename3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(newtypename, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel23))
                            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemtypedetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33))
                            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(updateItemType)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(archiveitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(archiveItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(333, 333, 333))
        );
        updateitemtype_formLayout.setVerticalGroup(
            updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addComponent(archiveitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typename3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newtypename, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(6, 6, 6)
                        .addComponent(itemtypedetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateItemType)
                            .addComponent(archiveItemType))
                        .addGap(9, 9, 9))))
        );

        jLabel32.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("ADD ITEM TYPE");

        javax.swing.GroupLayout additemtype_formLayout = new javax.swing.GroupLayout(additemtype_form);
        additemtype_form.setLayout(additemtype_formLayout);
        additemtype_formLayout.setHorizontalGroup(
            additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtype_formLayout.createSequentialGroup()
                .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemtypedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typename, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel21))
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel20))
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(addItemType_save)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(updateitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        additemtype_formLayout.setVerticalGroup(
            additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtype_formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typename, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemtypedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addItemType_save)
                .addContainerGap())
            .addComponent(updateitemtype_form, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout additemtypeLayout = new javax.swing.GroupLayout(additemtype);
        additemtype.setLayout(additemtypeLayout);
        additemtypeLayout.setHorizontalGroup(
            additemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtypeLayout.createSequentialGroup()
                .addComponent(additemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        additemtypeLayout.setVerticalGroup(
            additemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtypeLayout.createSequentialGroup()
                .addComponent(additemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        itemsTab.addTab("ITEM TYPE", additemtype);

        updateitems.setBackground(new java.awt.Color(5, 32, 33));

        additems_form2.setBackground(new java.awt.Color(15, 74, 74));

        jLabel26.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ITEM NAME");

        itemName2.setBackground(new java.awt.Color(15, 74, 74));
        itemName2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemName2.setForeground(new java.awt.Color(255, 255, 255));
        itemName2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemName2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemName2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemName2.setOpaque(false);
        itemName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemName2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("ITEM METRIC");

        jLabel28.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("ITEM TYPE NAME");

        itemqty2.setBackground(new java.awt.Color(15, 74, 74));
        itemqty2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty2.setForeground(new java.awt.Color(255, 255, 255));
        itemqty2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty2.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ITEM QUANTITY");

        Update.setBackground(new java.awt.Color(0, 204, 51));
        Update.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        ItemMetricList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Units", "Pcs", "Sets" }));
        ItemMetricList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemMetricListActionPerformed(evt);
            }
        });

        ItemTypeNameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypeNameListActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("NEW ITEM NAME");

        newitemname.setBackground(new java.awt.Color(15, 74, 74));
        newitemname.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        newitemname.setForeground(new java.awt.Color(255, 255, 255));
        newitemname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newitemname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        newitemname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newitemname.setOpaque(false);
        newitemname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newitemnameActionPerformed(evt);
            }
        });

        Archive.setBackground(new java.awt.Color(235, 85, 85));
        Archive.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        Archive.setForeground(new java.awt.Color(255, 255, 255));
        Archive.setText("ARCHIVE");
        Archive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchiveActionPerformed(evt);
            }
        });

        addItem_save.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItem_save.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save.setText("ADD");
        addItem_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItem_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_form2Layout = new javax.swing.GroupLayout(additems_form2);
        additems_form2.setLayout(additems_form2Layout);
        additems_form2Layout.setHorizontalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ItemMetricList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ItemTypeNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Archive, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(itemName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(newitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        additems_form2Layout.setVerticalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemName2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Archive, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ItemTypeNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemMetricList, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout updateitemsLayout = new javax.swing.GroupLayout(updateitems);
        updateitems.setLayout(updateitemsLayout);
        updateitemsLayout.setHorizontalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 374, Short.MAX_VALUE))
        );
        updateitemsLayout.setVerticalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
        );

        itemsTab.addTab("UPDATE ITEMS", updateitems);

        archiveitem.setBackground(new java.awt.Color(5, 32, 33));

        additems_form3.setBackground(new java.awt.Color(15, 74, 74));

        jLabel30.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ITEM NAME");

        itemName3.setBackground(new java.awt.Color(15, 74, 74));
        itemName3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemName3.setForeground(new java.awt.Color(255, 255, 255));
        itemName3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemName3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemName3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemName3.setOpaque(false);
        itemName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemName3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_form3Layout = new javax.swing.GroupLayout(additems_form3);
        additems_form3.setLayout(additems_form3Layout);
        additems_form3Layout.setHorizontalGroup(
            additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemName3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        additems_form3Layout.setVerticalGroup(
            additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemName3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout archiveitemLayout = new javax.swing.GroupLayout(archiveitem);
        archiveitem.setLayout(archiveitemLayout);
        archiveitemLayout.setHorizontalGroup(
            archiveitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemLayout.createSequentialGroup()
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 648, Short.MAX_VALUE))
        );
        archiveitemLayout.setVerticalGroup(
            archiveitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemLayout.createSequentialGroup()
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        itemsTab.addTab("ARCHIVE ITEMS", archiveitem);

        additems.setBackground(new java.awt.Color(5, 32, 33));

        additems_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ITEM NAME");

        itemname.setBackground(new java.awt.Color(15, 74, 74));
        itemname.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemname.setForeground(new java.awt.Color(255, 255, 255));
        itemname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemname.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ITEM METRIC");

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ITEM TYPE NAME");

        itemqty.setBackground(new java.awt.Color(15, 74, 74));
        itemqty.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty.setForeground(new java.awt.Color(255, 255, 255));
        itemqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ITEM QUANTITY");

        ItemMetricList3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "units", "pcs", "sets" }));
        ItemMetricList3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemMetricList3ActionPerformed(evt);
            }
        });

        ItemTypeNameList3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypeNameList3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_formLayout = new javax.swing.GroupLayout(additems_form);
        additems_form.setLayout(additems_formLayout);
        additems_formLayout.setHorizontalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ItemMetricList3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemname, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ItemTypeNameList3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        additems_formLayout.setVerticalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_formLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_formLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ItemMetricList3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(ItemTypeNameList3))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additemsLayout = new javax.swing.GroupLayout(additems);
        additems.setLayout(additemsLayout);
        additemsLayout.setHorizontalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 648, Short.MAX_VALUE))
        );
        additemsLayout.setVerticalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEMS", additems);

        jScrollPane1.setViewportView(itemsTab);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsLayout.createSequentialGroup()
                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jScrollPane4.getAccessibleContext().setAccessibleName("");

        right_sidebar.add(items);
        items.setBounds(0, 0, 1500, 700);

        dashboard.setBackground(new java.awt.Color(5, 32, 33));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label.setText("USERS");
        dashboard.add(dashboard_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 220, 60));

        dashboard_label1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label1.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label1.setText("WEEKLY REPORT");
        dashboard.add(dashboard_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 60));

        dashboard_label4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label4.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label4.setText("JOBS");
        dashboard.add(dashboard_label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 220, 60));

        dashboard_label5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label5.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label5.setText("ITEMS");
        dashboard.add(dashboard_label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 220, 60));

        dashboard_label6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label6.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label6.setText("CATEGORIES");
        dashboard.add(dashboard_label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 220, 60));

        right_sidebar.add(dashboard);
        dashboard.setBounds(0, 0, 1260, 720);

        jobsPanel.setBackground(new java.awt.Color(5, 32, 33));

        jobs.setBackground(new java.awt.Color(8, 40, 41));

        crud_jobs.setBackground(new java.awt.Color(15, 74, 74));
        crud_jobs.setPreferredSize(new java.awt.Dimension(623, 184));

        jLabel11.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JOB CATEGORY");

        jobcat.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcat.setToolTipText("");

        addJob.setBackground(new java.awt.Color(0, 204, 51));
        addJob.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addJob.setForeground(new java.awt.Color(255, 255, 255));
        addJob.setText("CREATE");
        addJob.setBorder(null);
        addJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addJobMouseClicked(evt);
            }
        });

        updateJob.setBackground(new java.awt.Color(0, 204, 51));
        updateJob.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updateJob.setForeground(new java.awt.Color(255, 255, 255));
        updateJob.setText("UPDATE");
        updateJob.setBorder(null);
        updateJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateJobMouseClicked(evt);
            }
        });

        deleteJob.setBackground(new java.awt.Color(235, 85, 85));
        deleteJob.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        deleteJob.setForeground(new java.awt.Color(255, 255, 255));
        deleteJob.setText("REMOVE");
        deleteJob.setBorder(null);
        deleteJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteJobMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("JOB NAME");

        jobname.setBackground(new java.awt.Color(15, 74, 74));
        jobname.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobname.setForeground(new java.awt.Color(255, 255, 255));
        jobname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jobname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jobname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jobname.setOpaque(false);

        javax.swing.GroupLayout crud_jobsLayout = new javax.swing.GroupLayout(crud_jobs);
        crud_jobs.setLayout(crud_jobsLayout);
        crud_jobsLayout.setHorizontalGroup(
            crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crud_jobsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                        .addComponent(jobcat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jobname, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(57, 57, 57)
                .addGroup(crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateJob, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJob, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        crud_jobsLayout.setVerticalGroup(
            crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_jobsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crud_jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(crud_jobsLayout.createSequentialGroup()
                        .addComponent(addJob, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateJob, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crud_jobsLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jobsTable.setAutoCreateRowSorter(true);
        jobsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JOB ID", "JOB NAME", "JOB CATEGORY", "ADDED BY", "DATE ADDED", "UPDATED BY", "DATE UPDATED"
            }
        ));
        jobsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jobsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobsTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jobsTable);

        javax.swing.GroupLayout jobsLayout = new javax.swing.GroupLayout(jobs);
        jobs.setLayout(jobsLayout);
        jobsLayout.setHorizontalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobsLayout.createSequentialGroup()
                .addGroup(jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jobsLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jobsLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(crud_jobs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jobsLayout.setVerticalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(crud_jobs, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jobs_tab.addTab("JOBS", jobs);

        job_items.setBackground(new java.awt.Color(8, 40, 41));

        jobItemsTable.setAutoCreateRowSorter(true);
        jobItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEM ID", "ITEM QUANTITY", "JOB ID", "ADDED BY", "DATE ADDED", "UPDATED BY", "DATE UPDATED"
            }
        ));
        jobItemsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jobItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobItemsTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jobItemsTable);

        crud_jobItems.setBackground(new java.awt.Color(15, 74, 74));
        crud_jobItems.setPreferredSize(new java.awt.Dimension(623, 270));

        jLabel17.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ITEM QUANTITY");

        addJobItem.setBackground(new java.awt.Color(0, 204, 51));
        addJobItem.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addJobItem.setForeground(new java.awt.Color(255, 255, 255));
        addJobItem.setText("CREATE");
        addJobItem.setBorder(null);
        addJobItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addJobItemMouseClicked(evt);
            }
        });

        updateJobItem.setBackground(new java.awt.Color(0, 204, 51));
        updateJobItem.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updateJobItem.setForeground(new java.awt.Color(255, 255, 255));
        updateJobItem.setText("UPDATE");
        updateJobItem.setBorder(null);
        updateJobItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateJobItemMouseClicked(evt);
            }
        });

        deleteJobItem.setBackground(new java.awt.Color(235, 85, 85));
        deleteJobItem.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        deleteJobItem.setForeground(new java.awt.Color(255, 255, 255));
        deleteJobItem.setText("REMOVE");
        deleteJobItem.setBorder(null);
        deleteJobItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteJobItemMouseClicked(evt);
            }
        });

        jobitemqty.setBackground(new java.awt.Color(15, 74, 74));
        jobitemqty.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobitemqty.setForeground(new java.awt.Color(255, 255, 255));
        jobitemqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jobitemqty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jobitemqty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jobitemqty.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ITEM NAME");

        jobitemcombobox.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobitemcombobox.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("JOB NAME");

        jobcombobox.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcombobox.setToolTipText("");

        javax.swing.GroupLayout crud_jobItemsLayout = new javax.swing.GroupLayout(crud_jobItems);
        crud_jobItems.setLayout(crud_jobItemsLayout);
        crud_jobItemsLayout.setHorizontalGroup(
            crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jobitemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crud_jobItemsLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(jobcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(crud_jobItemsLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel17))
                    .addGroup(crud_jobItemsLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel19))
                    .addGroup(crud_jobItemsLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jobitemcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateJobItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addJobItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteJobItem, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        crud_jobItemsLayout.setVerticalGroup(
            crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(crud_jobItemsLayout.createSequentialGroup()
                        .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                                .addComponent(addJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jobitemcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobitemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jLabel19))
                    .addComponent(deleteJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout job_itemsLayout = new javax.swing.GroupLayout(job_items);
        job_items.setLayout(job_itemsLayout);
        job_itemsLayout.setHorizontalGroup(
            job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(job_itemsLayout.createSequentialGroup()
                .addGroup(job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(job_itemsLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(job_itemsLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(crud_jobItems, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        job_itemsLayout.setVerticalGroup(
            job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(job_itemsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crud_jobItems, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jobs_tab.addTab("JOB ITEMS", job_items);

        javax.swing.GroupLayout jobsPanelLayout = new javax.swing.GroupLayout(jobsPanel);
        jobsPanel.setLayout(jobsPanelLayout);
        jobsPanelLayout.setHorizontalGroup(
            jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobsPanelLayout.createSequentialGroup()
                .addComponent(jobs_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 412, Short.MAX_VALUE))
        );
        jobsPanelLayout.setVerticalGroup(
            jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobsPanelLayout.createSequentialGroup()
                .addComponent(jobs_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        right_sidebar.add(jobsPanel);
        jobsPanel.setBounds(0, 0, 1660, 720);

        users.setBackground(new java.awt.Color(5, 32, 33));
        users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USER ID", "USERNAME", "FULL NAME", "ADDED BY", "DATE ADDED", "UPDATED BY", "DATE UPDATED"
            }
        ));
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            usersTable.getColumnModel().getColumn(1).setResizable(false);
            usersTable.getColumnModel().getColumn(2).setResizable(false);
            usersTable.getColumnModel().getColumn(3).setResizable(false);
            usersTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            usersTable.getColumnModel().getColumn(4).setResizable(false);
            usersTable.getColumnModel().getColumn(5).setResizable(false);
            usersTable.getColumnModel().getColumn(6).setResizable(false);
        }

        users.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1220, 380));

        additems_form8.setBackground(new java.awt.Color(15, 74, 74));
        additems_form8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("USERNAME");
        additems_form8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 28));

        usernameField.setBackground(new java.awt.Color(15, 74, 74));
        usernameField.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        usernameField.setCaretColor(new java.awt.Color(0, 153, 153));
        usernameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usernameField.setOpaque(false);
        additems_form8.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 40));

        jLabel48.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("FULLNAME");
        additems_form8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 260, 28));

        jLabel16.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PASSWORD");
        additems_form8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 260, 28));

        jLabel49.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("NEW PASSWORD");
        additems_form8.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 260, 28));

        userEditLabel.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        userEditLabel.setForeground(new java.awt.Color(255, 255, 255));
        userEditLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form8.add(userEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 300, 28));

        saveEditUserInfoBtn.setBackground(new java.awt.Color(0, 204, 51));
        saveEditUserInfoBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        saveEditUserInfoBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveEditUserInfoBtn.setText("SAVE / EDIT");
        saveEditUserInfoBtn.setBorder(null);
        saveEditUserInfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveEditUserInfoBtnMouseClicked(evt);
            }
        });
        saveEditUserInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditUserInfoBtnActionPerformed(evt);
            }
        });
        additems_form8.add(saveEditUserInfoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 127, 42));

        passwordField.setBackground(new java.awt.Color(15, 74, 74));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        passwordField.setCaretColor(new java.awt.Color(0, 153, 153));
        additems_form8.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 40));

        newPasswordField.setBackground(new java.awt.Color(15, 74, 74));
        newPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        newPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        newPasswordField.setCaretColor(new java.awt.Color(0, 153, 153));
        additems_form8.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 40));

        fullnameField.setBackground(new java.awt.Color(15, 74, 74));
        fullnameField.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        fullnameField.setForeground(new java.awt.Color(255, 255, 255));
        fullnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullnameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        fullnameField.setCaretColor(new java.awt.Color(0, 153, 153));
        fullnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fullnameField.setOpaque(false);
        additems_form8.add(fullnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 260, 40));

        clearUserFieldBtn.setBackground(new java.awt.Color(175, 174, 174));
        clearUserFieldBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        clearUserFieldBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearUserFieldBtn.setText("CLEAR");
        clearUserFieldBtn.setBorder(null);
        clearUserFieldBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearUserFieldBtnMouseClicked(evt);
            }
        });
        clearUserFieldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearUserFieldBtnActionPerformed(evt);
            }
        });
        additems_form8.add(clearUserFieldBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 127, 42));

        removeUserBtn.setBackground(new java.awt.Color(236, 82, 82));
        removeUserBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        removeUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeUserBtn.setText("REMOVE");
        removeUserBtn.setBorder(null);
        removeUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeUserBtnMouseClicked(evt);
            }
        });
        removeUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUserBtnActionPerformed(evt);
            }
        });
        additems_form8.add(removeUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 127, 42));

        users.add(additems_form8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 900, 260));

        right_sidebar.add(users);
        users.setBounds(0, 0, 1250, 720);

        categories.setBackground(new java.awt.Color(5, 32, 33));
        categories.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Added By", "Date Added", "Updated By", "Date Updated"
            }
        ));
        categoriesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriesTableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(categoriesTable);
        if (categoriesTable.getColumnModel().getColumnCount() > 0) {
            categoriesTable.getColumnModel().getColumn(0).setResizable(false);
            categoriesTable.getColumnModel().getColumn(0).setPreferredWidth(2);
            categoriesTable.getColumnModel().getColumn(1).setResizable(false);
            categoriesTable.getColumnModel().getColumn(1).setPreferredWidth(2);
            categoriesTable.getColumnModel().getColumn(2).setResizable(false);
            categoriesTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            categoriesTable.getColumnModel().getColumn(3).setResizable(false);
            categoriesTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            categoriesTable.getColumnModel().getColumn(4).setResizable(false);
            categoriesTable.getColumnModel().getColumn(4).setPreferredWidth(5);
            categoriesTable.getColumnModel().getColumn(5).setResizable(false);
            categoriesTable.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        categories.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 820, 350));

        categoryItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity"
            }
        ));
        categoryItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryItemTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(categoryItemTable);
        if (categoryItemTable.getColumnModel().getColumnCount() > 0) {
            categoryItemTable.getColumnModel().getColumn(0).setResizable(false);
            categoryItemTable.getColumnModel().getColumn(1).setResizable(false);
            categoryItemTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        categories.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 400, 350));

        additems_form1.setBackground(new java.awt.Color(15, 74, 74));
        additems_form1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryNameField.setBackground(new java.awt.Color(15, 74, 74));
        categoryNameField.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        categoryNameField.setForeground(new java.awt.Color(255, 255, 255));
        categoryNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        categoryNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        categoryNameField.setCaretColor(new java.awt.Color(0, 153, 153));
        categoryNameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        categoryNameField.setOpaque(false);
        categoryNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryNameFieldActionPerformed(evt);
            }
        });
        additems_form1.add(categoryNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 59, 260, 40));

        jLabel10.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CATEGORY");
        additems_form1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 260, 28));

        addEditCategoryBtn.setBackground(new java.awt.Color(0, 204, 51));
        addEditCategoryBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addEditCategoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        addEditCategoryBtn.setText("ADD / EDIT");
        addEditCategoryBtn.setBorder(null);
        addEditCategoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEditCategoryBtnMouseClicked(evt);
            }
        });
        addEditCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEditCategoryBtnActionPerformed(evt);
            }
        });
        additems_form1.add(addEditCategoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 127, 42));

        categoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>());
        categoryDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDropdownActionPerformed(evt);
            }
        });
        additems_form1.add(categoryDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, 41));

        itemQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        additems_form1.add(itemQuantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 42, 41));

        addEditCategoryItemBtn.setBackground(new java.awt.Color(0, 204, 51));
        addEditCategoryItemBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addEditCategoryItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addEditCategoryItemBtn.setText("ADD / EDIT");
        addEditCategoryItemBtn.setBorder(null);
        addEditCategoryItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEditCategoryItemBtnMouseClicked(evt);
            }
        });
        addEditCategoryItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEditCategoryItemBtnActionPerformed(evt);
            }
        });
        additems_form1.add(addEditCategoryItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 127, 42));

        itemDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDropdownActionPerformed(evt);
            }
        });
        additems_form1.add(itemDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 260, 41));

        jLabel12.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ITEM");
        additems_form1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, 28));

        removeCategoryItemBtn.setBackground(new java.awt.Color(236, 82, 82));
        removeCategoryItemBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        removeCategoryItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeCategoryItemBtn.setText("REMOVE");
        removeCategoryItemBtn.setBorder(null);
        removeCategoryItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCategoryItemBtnMouseClicked(evt);
            }
        });
        removeCategoryItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryItemBtnActionPerformed(evt);
            }
        });
        additems_form1.add(removeCategoryItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 127, 42));

        categoryEditLabel.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryEditLabel.setForeground(new java.awt.Color(255, 255, 255));
        categoryEditLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form1.add(categoryEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 410, 28));

        jLabel8.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CATEGORY NAME");
        additems_form1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 28));

        removeCategoryBtn.setBackground(new java.awt.Color(236, 82, 82));
        removeCategoryBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        removeCategoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeCategoryBtn.setText("REMOVE");
        removeCategoryBtn.setBorder(null);
        removeCategoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCategoryBtnMouseClicked(evt);
            }
        });
        removeCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryBtnActionPerformed(evt);
            }
        });
        additems_form1.add(removeCategoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 127, 42));

        categoryItemUpdatedDate.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryItemUpdatedDate.setForeground(new java.awt.Color(255, 255, 255));
        categoryItemUpdatedDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form1.add(categoryItemUpdatedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 330, 30));

        clearCategoryFieldsBtn.setBackground(new java.awt.Color(175, 174, 174));
        clearCategoryFieldsBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        clearCategoryFieldsBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearCategoryFieldsBtn.setText("CLEAR");
        clearCategoryFieldsBtn.setBorder(null);
        clearCategoryFieldsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearCategoryFieldsBtnMouseClicked(evt);
            }
        });
        clearCategoryFieldsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCategoryFieldsBtnActionPerformed(evt);
            }
        });
        additems_form1.add(clearCategoryFieldsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 127, 42));

        categoryItemUpdatedBy.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryItemUpdatedBy.setForeground(new java.awt.Color(255, 255, 255));
        categoryItemUpdatedBy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form1.add(categoryItemUpdatedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 330, 30));

        categoryItemAddedDate.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryItemAddedDate.setForeground(new java.awt.Color(255, 255, 255));
        categoryItemAddedDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form1.add(categoryItemAddedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 330, 30));

        categoryItemAddedBy.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryItemAddedBy.setForeground(new java.awt.Color(255, 255, 255));
        categoryItemAddedBy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additems_form1.add(categoryItemAddedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 330, 30));

        categories.add(additems_form1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 1230, 280));

        jLabel7.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("CATEGORY ITEM DETAILS");
        categories.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 260, 28));

        jLabel14.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("CATEGORY DETAILS");
        categories.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 28));

        right_sidebar.add(categories);
        categories.setBounds(0, 0, 1250, 720);

        whole.add(right_sidebar);
        right_sidebar.setBounds(250, 80, 1260, 720);

        upper_dashboard_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_dashboard_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_dashboard_panel.setLayout(null);

        dashboard_up_label.setBackground(new java.awt.Color(5, 32, 33));
        upper_dashboard_panel.add(dashboard_up_label);
        dashboard_up_label.setBounds(0, 0, 1250, 720);

        whole.add(upper_dashboard_panel);
        upper_dashboard_panel.setBounds(0, 0, 1510, 80);

        upper_items_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_items_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_items_panel.setLayout(null);

        items_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        items_up_label.setForeground(new java.awt.Color(255, 255, 255));
        items_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        items_up_label.setText("OPTIMAL  /  ITEMS");
        upper_items_panel.add(items_up_label);
        items_up_label.setBounds(30, 10, 220, 60);

        whole.add(upper_items_panel);
        upper_items_panel.setBounds(0, 0, 1510, 80);

        upper_jobs_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_jobs_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_jobs_panel.setLayout(null);

        jobs_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jobs_up_label.setForeground(new java.awt.Color(255, 255, 255));
        jobs_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jobs_up_label.setText("OPTIMAL  /  JOBS");
        upper_jobs_panel.add(jobs_up_label);
        jobs_up_label.setBounds(30, 10, 220, 60);

        whole.add(upper_jobs_panel);
        upper_jobs_panel.setBounds(0, 0, 1510, 80);

        upper_categories_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_categories_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_categories_panel.setLayout(null);

        categories_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        categories_up_label.setForeground(new java.awt.Color(255, 255, 255));
        categories_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categories_up_label.setText("OPTIMAL  /  CATEGORIES");
        upper_categories_panel.add(categories_up_label);
        categories_up_label.setBounds(30, 10, 220, 60);

        whole.add(upper_categories_panel);
        upper_categories_panel.setBounds(0, 0, 1510, 80);

        upper_users_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_users_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_users_panel.setLayout(null);

        users_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        users_up_label.setForeground(new java.awt.Color(255, 255, 255));
        users_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users_up_label.setText("OPTIMAL  /  USERS");
        upper_users_panel.add(users_up_label);
        users_up_label.setBounds(30, 10, 220, 60);

        whole.add(upper_users_panel);
        upper_users_panel.setBounds(0, 0, 1510, 80);

        left_sidebar.setBackground(new java.awt.Color(8, 40, 41));
        left_sidebar.setLayout(null);

        userimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        left_sidebar.add(userimg);
        userimg.setBounds(73, 56, 100, 110);

        adminName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminName.setText("ADMIN");
        left_sidebar.add(adminName);
        adminName.setBounds(10, 160, 230, 40);

        dashboard_side.setBackground(new java.awt.Color(15, 74, 74));
        dashboard_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_sideMouseClicked(evt);
            }
        });

        dashboard_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        dashboard_side_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_side_label.setText("DASHBOARD");

        javax.swing.GroupLayout dashboard_sideLayout = new javax.swing.GroupLayout(dashboard_side);
        dashboard_side.setLayout(dashboard_sideLayout);
        dashboard_sideLayout.setHorizontalGroup(
            dashboard_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dashboard_sideLayout.setVerticalGroup(
            dashboard_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(dashboard_side);
        dashboard_side.setBounds(0, 280, 250, 58);

        items_side.setBackground(new java.awt.Color(8, 40, 41));
        items_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                items_sideMouseClicked(evt);
            }
        });

        items_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        items_side_label.setForeground(new java.awt.Color(255, 255, 255));
        items_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        items_side_label.setText("ITEMS");

        javax.swing.GroupLayout items_sideLayout = new javax.swing.GroupLayout(items_side);
        items_side.setLayout(items_sideLayout);
        items_sideLayout.setHorizontalGroup(
            items_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(items_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(items_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        items_sideLayout.setVerticalGroup(
            items_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(items_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(items_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(items_side);
        items_side.setBounds(0, 340, 250, 58);

        jobs_side.setBackground(new java.awt.Color(8, 40, 41));
        jobs_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobs_sideMouseClicked(evt);
            }
        });

        jobs_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jobs_side_label.setForeground(new java.awt.Color(255, 255, 255));
        jobs_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jobs_side_label.setText("JOBS");

        javax.swing.GroupLayout jobs_sideLayout = new javax.swing.GroupLayout(jobs_side);
        jobs_side.setLayout(jobs_sideLayout);
        jobs_sideLayout.setHorizontalGroup(
            jobs_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobs_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jobs_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jobs_sideLayout.setVerticalGroup(
            jobs_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobs_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jobs_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(jobs_side);
        jobs_side.setBounds(0, 400, 250, 60);

        categories_side.setBackground(new java.awt.Color(8, 40, 41));
        categories_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categories_sideMouseClicked(evt);
            }
        });

        categories_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        categories_side_label.setForeground(new java.awt.Color(255, 255, 255));
        categories_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categories_side_label.setText("CATEGORIES");

        javax.swing.GroupLayout categories_sideLayout = new javax.swing.GroupLayout(categories_side);
        categories_side.setLayout(categories_sideLayout);
        categories_sideLayout.setHorizontalGroup(
            categories_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categories_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categories_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        categories_sideLayout.setVerticalGroup(
            categories_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categories_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categories_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(categories_side);
        categories_side.setBounds(0, 460, 250, 60);

        users_side.setBackground(new java.awt.Color(8, 40, 41));
        users_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                users_sideMouseClicked(evt);
            }
        });

        users_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        users_side_label.setForeground(new java.awt.Color(255, 255, 255));
        users_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users_side_label.setText("USERS");

        javax.swing.GroupLayout users_sideLayout = new javax.swing.GroupLayout(users_side);
        users_side.setLayout(users_sideLayout);
        users_sideLayout.setHorizontalGroup(
            users_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(users_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        users_sideLayout.setVerticalGroup(
            users_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(users_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(users_side);
        users_side.setBounds(0, 520, 250, 60);

        logout_side.setBackground(new java.awt.Color(8, 40, 41));
        logout_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_sideMouseClicked(evt);
            }
        });

        logout_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        logout_side_label.setForeground(new java.awt.Color(255, 255, 255));
        logout_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout_side_label.setText("LOGOUT");

        javax.swing.GroupLayout logout_sideLayout = new javax.swing.GroupLayout(logout_side);
        logout_side.setLayout(logout_sideLayout);
        logout_sideLayout.setHorizontalGroup(
            logout_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        logout_sideLayout.setVerticalGroup(
            logout_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(logout_side);
        logout_side.setBounds(0, 580, 246, 56);

        whole.add(left_sidebar);
        left_sidebar.setBounds(0, 80, 250, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboard_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_sideMouseClicked
        dashboard();
    }//GEN-LAST:event_dashboard_sideMouseClicked

    private void items_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_items_sideMouseClicked
        items_sideBar_onclick();
    }//GEN-LAST:event_items_sideMouseClicked

    private void addItem_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItem_saveActionPerformed
        
        if(!itemname.getText().isEmpty() && !itemqty.getText().isEmpty()){
            String itemName = itemname.getText();
            int itemQty = Integer.parseInt(itemqty.getText());
            String itemTypeName = ItemTypeNameList3.getSelectedItem().toString();             
            String itemMetric = ItemMetricList3.getSelectedItem().toString();
                  
            try {             
                Connection con = Connect.getConnection();
                ResultSet rs = CRUD.selectTypeIDFromItemType(con, itemTypeName);   
                rs.next();
                int itemTypeID = rs.getInt("type_id");
                if(!CRUD.checkItemExists(con, itemName)){
                   System.out.println("Good, Not Found");                
                   CRUD.insertItem(con, itemName, itemQty, itemTypeID, itemMetric,userid,userid);
                   rs = CRUD.selectItemInfoUsingItemName(con,itemName);
                   rs.next();
                   String addedBy = CRUD.selectFullName(con, userid);
                   String updatedBy = CRUD.selectFullName(con, userid);
                   Item it = new Item(
                           rs.getInt("item_id"),
                           rs.getString("item_name"),
                           rs.getInt("quantity"),
                           rs.getString("metric"),
                           rs.getInt("type"),
                           addedBy,
                           rs.getTimestamp("added_date"),
                           updatedBy,
                           rs.getTimestamp("updated_date")                       
                   );
                   addRowtoItemsTable(it);
                   JOptionPane.showMessageDialog(null, "Item has been successfully added!");
               }else{
                 System.out.println("sad,Found");
                 JOptionPane.showMessageDialog(null, "Item Add Unsuccessful! Item Already Exists!");
               }                
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }else{
            JOptionPane.showMessageDialog(null, "All fields must not be empty");
        }      
    }//GEN-LAST:event_addItem_saveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        if(!itemName2.getText().isEmpty() && !itemqty2.getText().isEmpty() && !newitemname.getText().isEmpty()){
            String itemName = itemName2.getText();
            int itemQty = Integer.parseInt(itemqty2.getText());
            String itemTypeName = ItemTypeNameList.getSelectedItem().toString();          
            String itemMetric = ItemMetricList.getSelectedItem().toString();
            String newItemName = newitemname.getText().toString();
            Connection con = Connect.getConnection();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
                + "you want to Update?","Confirm", dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    if(CRUD.checkItemExists(con, itemName)){                     
                            ResultSet rs = CRUD.selectTypeIDFromItemType(con, itemTypeName);
                            rs.next();
                            int itemTypeID = rs.getInt("type_id");
                            ResultSet rs2 = CRUD.selectItemIDUsingItemName(con,itemName);
                            rs2.next();
                            int itemID = rs2.getInt("item_id");
                            CRUD.updateItem(con, itemID,newItemName, itemQty, itemTypeID, itemMetric, userid);
                            DefaultTableModel model = (DefaultTableModel)itemsTable.getModel(); 
                            int row = itemsTable.getSelectedRow();
                            model.setValueAt(newItemName, row, 1);
                            model.setValueAt(itemQty,row,2);
                            String updatedBy = CRUD.selectFullName(con, userid);
                            model.setValueAt(updatedBy,row,3);
                            model.setValueAt(itemTypeID,row,4);
                            model.setValueAt(dateFormat.format(new Date()),row,8);
                            itemName2.setText("");
                            itemqty2.setText("");
                            newitemname.setText("");
                            ItemMetricList.setSelectedIndex(0);
                            ItemTypeNameList.setSelectedIndex(0);
                            JOptionPane.showMessageDialog(null, "Update Item Successful!");                    
                    }else{
                        JOptionPane.showMessageDialog(null, "Item Does Not Exist!");
                    }
               } catch (SQLException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
               }
            }else{
                JOptionPane.showMessageDialog(null, "Updated Cancelled"); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "All fields must not be empty");
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void addItemType_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemType_saveActionPerformed
        // TODO add your handling code here:
        if(!typename.getText().isEmpty() && !itemtypedetails.getText().isEmpty()){
            try {
                String typeName = typename.getText();               
                String typeDetails = itemtypedetails.getText();
                    
                Connection con = Connect.getConnection();
                if(CRUD.checkItemTypeExists(con, typeName)){
                    JOptionPane.showMessageDialog(null, "Item Type Name already exists!");
                }else{
                    CRUD.insertItemType(con, typeName, typeDetails,userid,userid,0);
                    ResultSet rs = CRUD.selectItemTypeInfoUsingTypeName(con, typeName);
                    rs.next();  
                    String addedBy = CRUD.selectFullName(con, userid);
                    String updatedBy = CRUD.selectFullName(con, userid);
                    ItemType itp = new ItemType(
                        rs.getInt("type_id"),
                        rs.getString("type_name"),
                        rs.getString("type_details"),
                        addedBy,
                        rs.getTimestamp("added_date"),
                        updatedBy,
                        rs.getTimestamp("updated_date")  
                    );
                    addRowtoItemTypeTable(itp);
                    ItemTypeNameList3.addItem(typeName);
                    ItemTypeNameList.addItem(typeName);
                    JOptionPane.showMessageDialog(null, "Successfully Added!");
                    
                }
              
            }catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Input all fields");
        }
    }//GEN-LAST:event_addItemType_saveActionPerformed

    private void ArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchiveActionPerformed
        // TODO add your handling code here:
        if(!itemName3.getText().isEmpty()){
            Connection con = Connect.getConnection();
            try {
                String itemName = itemName3.getText();
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
                    + "you want to archive?","Confirm", dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                                 
                    boolean removed = CRUD.archiveItem(con, itemName);  
                    if(removed){
                        JOptionPane.showMessageDialog(null, "Item Successfully Archived!");
                        TableModel tm = itemsTable.getModel();
                        for(int x = 0; x < tm.getRowCount();x++){
                            Object o = tm.getValueAt(x, 1);                        
                            if(o.equals(itemName)){
                                System.out.println("ey");
                                ((DefaultTableModel)itemsTable.getModel()).removeRow(x);
                                itemName3.setText("");
                                itemsTable.getSelectionModel().clearSelection();
                            }else{
                                System.out.println(itemName);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Item Archive Unsuccessful!");
                    }


                }else{
                     JOptionPane.showMessageDialog(null, "Archive Cancelled!");
                }
            
            } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Field must not be empty.");
        }
    }//GEN-LAST:event_ArchiveActionPerformed

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        // TODO add your handling code here:
        int index=0,x;
        int i = itemsTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)itemsTable.getModel();
        itemname.setText(model.getValueAt(i,1).toString());
        itemName2.setText(model.getValueAt(i,1).toString()); 
        itemName3.setText(model.getValueAt(i,1).toString()); 
        itemqty.setText(model.getValueAt(i, 2).toString());
        itemqty2.setText(model.getValueAt(i, 2).toString());
        //Setting value for ItemMetricList comboBox
        String metric = model.getValueAt(i, 3).toString();
        if(metric.equals("units")){
            index = 0;
        }else if(metric.equals("pcs")){
            index = 1;
        }else{
            index = 2;
        }     
        ItemMetricList.setSelectedIndex(index);
        //End of setting value for ItemMetricList comboBox
        
        //Setting value for ItemTypeNameList comboBox     
        int type = (int) model.getValueAt(i,4);
        for(x=0; x< ItemTypeNameList.getItemCount();x++){
            if(type == x){
                index = x-1;
            }
        }    
        ItemTypeNameList.setSelectedIndex(index);
       //End of setting value for ItemTypeNameList comboBox
    }//GEN-LAST:event_itemsTableMouseClicked

    private void updateItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemTypeActionPerformed
        // TODO add your handling code here:
        if(!typename3.getText().isEmpty() && !itemtypedetails1.getText().isEmpty() && !newtypename.getText().isEmpty()){         
            String typeName = typename3.getText();
            String typeDetails = itemtypedetails1.getText();
            String newTypeName = newtypename.getText();
            Connection con = Connect.getConnection();
            try{
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
                    + "you want to Update?","Confirm", dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                    if(CRUD.checkItemTypeExists(con, typeName)){
                        ResultSet rs = CRUD.selectItemTypeInfoUsingTypeName(con,typeName);
                        rs.next();
                        if(typeName.equals(newTypeName) && typeDetails.equals(rs.getString("type_details"))){
                            JOptionPane.showMessageDialog(null, "No Changes Detected");
                        }else{
                            CRUD.updateItemType(con, typeName, newTypeName,typeDetails, userid);

                            //ResultSet rs = CRUD.selectItemTypeInfoUsingTypeName(con, typeName);
                            rs = CRUD.selectItemTypeInfoUsingTypeName(con, typeName);
                            DefaultTableModel model = (DefaultTableModel)itemTypeTable.getModel(); 
                            int row = itemTypeTable.getSelectedRow();
                            model.setValueAt(newTypeName, row, 1);
                            model.setValueAt(typeDetails,row,2);
                            String updatedBy = CRUD.selectFullName(con, userid);
                            model.setValueAt(updatedBy,row,3);
                            model.setValueAt(dateFormat.format(new Date()),row,6);
                            typename3.setText("");
                            itemtypedetails1.setText("");
                            newtypename.setText("");
                            //Removing item type names from combobox
                            ItemTypeNameList.removeAllItems();
                            //Adding item type name to combobox                   
                            initializeItemTypeNameList();
                            JOptionPane.showMessageDialog(null, "Update Item Type Successful!");
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Item Type Does Not Exist!");
                    }
                       
    
                }else{
                     JOptionPane.showMessageDialog(null, "Update Item Type Cancelled!");
                }
            }catch(SQLException e){
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Fields must not be empty.");
        }
    }//GEN-LAST:event_updateItemTypeActionPerformed

    private void archiveItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveItemTypeActionPerformed
        // TODO add your handling code here:
        if(!typename2.getText().isEmpty() && !itemtypedetails2.getText().isEmpty()){
            String typeName = typename2.getText();
            String typeDetails = itemtypedetails2.getText();
            Connection con = Connect.getConnection();
            try{
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
                    + "you want to Archive?","Confirm", dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                    boolean removed = CRUD.archiveItemType(con, typeName);
                    if(removed){
                        JOptionPane.showMessageDialog(null, "Archive Item Type Successful!");
                         TableModel tm = itemTypeTable.getModel();
                         for(int x = 0; x < tm.getRowCount();x++){
                            Object o = tm.getValueAt(x, 1);                        
                            if(o.equals(typeName)){
                                System.out.println("ey");
                                ((DefaultTableModel)itemTypeTable.getModel()).removeRow(x);
                                typename2.setText("");
                                itemtypedetails2.setText("");
                                itemTypeTable.getSelectionModel().clearSelection();                             
                                ItemTypeNameList.removeItem(typeName);
                            }else{
                                System.out.println(typeName);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Oops! Archive Item Type Unsuccessful!");
                    }
                    


                }else{
                     JOptionPane.showMessageDialog(null, "Archive Cancelled!");
                }
            }catch(SQLException e){
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Fields must not be empty.");
        }
    }//GEN-LAST:event_archiveItemTypeActionPerformed

    private void itemName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemName3ActionPerformed

    private void itemName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemName2ActionPerformed

    private void newitemnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newitemnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newitemnameActionPerformed

    private void ItemMetricListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMetricListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemMetricListActionPerformed

    private void ItemTypeNameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeNameListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeNameListActionPerformed

    private void ItemMetricList3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMetricList3ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ItemMetricList3ActionPerformed

    private void ItemTypeNameList3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeNameList3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeNameList3ActionPerformed

    private void jobs_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobs_sideMouseClicked
        jobs_sideBar_onclick();
    }//GEN-LAST:event_jobs_sideMouseClicked

    private void addJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addJobMouseClicked
        String category = (String) jobcat.getSelectedItem();
        String name = (String) jobname.getText();
        int catID = 0;

        if("".equals(jobcat)){
            JOptionPane.showMessageDialog(null, "Fields required!");
        }else{
            try{
                Connection con = Connect.getConnection();
                catID = CRUD.getCleaningCatID(con, category);
                int jobID = CRUD.insertJobReturnID(con, catID, userid, name);
                ResultSet rs = CRUD.selectJobsInfoUsingID(con, jobID);
                rs.next();
                Job j = new Job(rs.getInt("job_id"), rs.getString("job_name"),
                    rs.getInt("category_id"), rs.getString("added_by"), 
                    rs.getTimestamp("added_date"), rs.getString("updated_by"),
                    rs.getTimestamp("updated_date"));
                addRowToJobsTable(j);
                JOptionPane.showMessageDialog(null, "Job has been successfully inserted!");
                jobcat.setSelectedItem("");
                jobname.setText("");
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_addJobMouseClicked

    private void users_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_sideMouseClicked
        users_sideBar_onclick();
    }//GEN-LAST:event_users_sideMouseClicked

    private void jobsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobsTableMouseClicked
        selectrow = jobsTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jobsTable.getModel();
        int categoryid = (int) model.getValueAt(selectrow,2);
        String jobName = (String) model.getValueAt(selectrow,1);
        Connection con = Connect.getConnection();
        String catName = "";
        try {
            catName = CRUD.getCleaningCatName(con, categoryid);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jobcat.setSelectedItem(catName);
        jobname.setText(jobName);
        JobIDFromTable = (int) model.getValueAt(selectrow,0);
    }//GEN-LAST:event_jobsTableMouseClicked

    private void jobItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobItemsTableMouseClicked
       selectrow = jobItemsTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jobItemsTable.getModel();
        int itemid = (int) model.getValueAt(selectrow,1);
        int qty = (int) model.getValueAt(selectrow,2);
        int jobid = (int) model.getValueAt(selectrow,3);
        Connection con = Connect.getConnection();
        String ItemName, JobName;
        ItemName = JobName = "";
        try {
            ItemName = CRUD.getJobItem_ItemName(con, itemid);
            JobName = CRUD.getJobName(con, jobid);
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jobitemcombobox.setSelectedItem(ItemName);
        jobitemqty.setText(""+qty);
        jobcombobox.setSelectedItem(JobName);
        JobItemsIDFromTable = (int) model.getValueAt(selectrow,0);
        JobItems_ItemIDFromTable = (int) model.getValueAt(selectrow,1);
    }//GEN-LAST:event_jobItemsTableMouseClicked

    private void updateJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateJobMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to update?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                String category_job = (String) jobcat.getSelectedItem();
                Connection con = Connect.getConnection();
                int catID = CRUD.getCleaningCatID(con, category_job);
                int jobid = JobIDFromTable;
                String name = jobname.getText();
                CRUD.updateJob(con, catID, userid, jobid, name);
                ResultSet rs = CRUD.selectJobsInfoUsingID(con, jobid);
                rs.next();

                DefaultTableModel model = (DefaultTableModel) jobsTable.getModel(); 
                for (int i = 0; i < model.getRowCount(); i++) {
                    Object o = model.getValueAt(i, 0);
                    if (o.equals(jobid)) {
                        model.setValueAt(rs.getString("job_name"), i, 1);
                        model.setValueAt(rs.getInt("category_id"), i, 2);
                        model.setValueAt(rs.getString("updated_by"), i, 5);
                        model.setValueAt(dateFormat.format(rs.getTimestamp("updated_date")), i, 6);
                    }
                }
                jobcat.setSelectedItem("");
                JOptionPane.showMessageDialog(null, "Job has been successfully updated!");
                jobcat.setSelectedItem("");
                jobname.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Update cancelled.");
        }
    }//GEN-LAST:event_updateJobMouseClicked

    private void deleteJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteJobMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to remove?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
        
            int jobid = JobIDFromTable;
            Connection con = Connect.getConnection();
            try {
                ResultSet rs = CRUD.selectJobsInfoUsingID(con, jobid);
                if(rs.next()){
                    int id = rs.getInt("job_id");
                    boolean removed = CRUD.archiveJob(con, id);
                    if(removed){
                        DefaultTableModel model = (DefaultTableModel) jobsTable.getModel(); 
                        for (int i = 0; i < model.getRowCount(); i++) {
                            Object o = model.getValueAt(i, 0);
                            if (o.equals(id)) {
                                model.removeRow(i);
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Job successfully archived!");
                        jobcat.setSelectedItem("");
                        jobname.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Archive unsuccessful.");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Archive cancelled.");
        }
    }//GEN-LAST:event_deleteJobMouseClicked

    private void addJobItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addJobItemMouseClicked
        String itemName = (String) jobitemcombobox.getSelectedItem();
        int inputqty = parseInt(jobitemqty.getText());
        String jobName = (String) jobcombobox.getSelectedItem();
        if("".equals(jobitemqty.getText()) && "".equals(itemName) && "".equals(jobName)){
            JOptionPane.showMessageDialog(null, "Fields required!");
        }else{
            try{
                Connection con = Connect.getConnection();
                int itemid = CRUD.getJobItem_ItemID(con, itemName);
                int qty = CRUD.getJobItem_ItemQty(con, itemid);
                
                if(inputqty <= qty){
                    int jobid = CRUD.getJobID(con, jobName);
                    int qtyDiff = CRUD.DeductJobItemQty(con, inputqty, itemid);
                    int jobitemID = CRUD.insertJobItemReturnID(con, itemid, inputqty, jobid, userid);
                    CRUD.UpdateJobItemQty(con, qtyDiff, userid, itemid);
                    
                    ResultSet rs = CRUD.selectJobItemsInfoUsingID(con, jobitemID);
                    rs.next();
                    JobItem JI = new JobItem(rs.getInt("jobItem_id"),
                            rs.getInt("item_id"), rs.getInt("item_quantity"),
                            rs.getInt("job_id"), rs.getString("added_by"), 
                            rs.getTimestamp("added_date"), rs.getString("updated_by"),
                            rs.getTimestamp("updated_date"));
                    addRowToJobItemsTable(JI);
                    jobitemqty.setText("");
                    jobitemcombobox.setSelectedItem("");
                    jobcombobox.setSelectedItem("");
                    JOptionPane.showMessageDialog(null, "Item has been successfully inserted!");
                }else{
                    JOptionPane.showMessageDialog(null, "Quantity inputted is not valid!");
                }
                
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_addJobItemMouseClicked

    private void updateJobItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateJobItemMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to update?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            String itemName = (String) jobitemcombobox.getSelectedItem();
            int inputqty = parseInt(jobitemqty.getText());
            String jobName = (String) jobcombobox.getSelectedItem();
            Connection con = Connect.getConnection();
            if("".equals(jobitemqty.getText()) && "".equals(itemName) && "".equals(jobName)){
                JOptionPane.showMessageDialog(null, "Fields required!");
            }else{
                if(inputqty > 0){
                    try{
                        int jobItemID = JobItemsIDFromTable;
                        int jobid = CRUD.getJobID(con, jobName);
                        int itemID = getJobItem_ItemID(con, itemName);
                        int finalqty = AddDeductItemQty(con, inputqty, jobItemID);
                        CRUD.UpdateItemQty(con, finalqty, userid, itemID);
                        CRUD.UpdateJobItem(con, itemID, inputqty, jobid, userid);

                        ResultSet rs = CRUD.selectJobItemsInfoUsingID(con, jobItemID);
                        rs.next();
                        DefaultTableModel model = (DefaultTableModel) jobItemsTable.getModel();
                        for (int i = 0; i < model.getRowCount(); i++) {
                            Object o = model.getValueAt(i, 0);
                            if (o.equals(jobItemID)) {
                                model.setValueAt(rs.getInt("item_id"), i, 1);
                                model.setValueAt(rs.getInt("item_quantity"), i, 2);
                                model.setValueAt(rs.getInt("job_id"), i, 3);
                                model.setValueAt(rs.getString("updated_by"), i, 6);
                                model.setValueAt(dateFormat.format(rs.getTimestamp("updated_date")), i, 7);
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Item has been successfully updated!");

                    }catch(HeadlessException | SQLException e){
                        System.out.println(e);
                    }
                }else if(inputqty < 0){
                    JOptionPane.showMessageDialog(null, "Quantity cannot be zero!");
                    jobitemqty.setText("");
                    jobitemcombobox.setSelectedItem("");
                    jobcombobox.setSelectedItem("");
                }
                    
            }
        }else{
            JOptionPane.showMessageDialog(null, "Update cancelled.");
        }
    }//GEN-LAST:event_updateJobItemMouseClicked

    private void deleteJobItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteJobItemMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to delete?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){    
            int jobItemID = JobItemsIDFromTable;
            int itemID = JobItems_ItemIDFromTable;
            Connection con = Connect.getConnection();
            try {
                boolean removed = CRUD.archiveJobItem(con, jobItemID, itemID);
                if(removed){
                    DefaultTableModel model = (DefaultTableModel) jobItemsTable.getModel(); 
                    for (int i = 0; i < model.getRowCount(); i++) {
                        Object o = model.getValueAt(i, 0);
                        if (o.equals(jobItemID)) {
                            model.removeRow(i);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Item successfully archived!");
                    jobitemqty.setText("");
                    jobitemcombobox.setSelectedItem("");
                    jobcombobox.setSelectedItem("");
                }else{
                    JOptionPane.showMessageDialog(null, "Archive unsuccessful.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteJobItemMouseClicked

    private void saveEditUserInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditUserInfoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveEditUserInfoBtnActionPerformed

    private void addEditCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditCategoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEditCategoryBtnActionPerformed

    private void addEditCategoryItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditCategoryItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEditCategoryItemBtnActionPerformed

    private void removeCategoryItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCategoryItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeCategoryItemBtnActionPerformed

    private void categories_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categories_sideMouseClicked
        categories_sideBar_onclick();
        initItemDropdown();
    }//GEN-LAST:event_categories_sideMouseClicked

    private void saveEditUserInfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveEditUserInfoBtnMouseClicked
        if(userEditID != -1){
            //update user
            String fullname = fullnameField.getText();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String newpassword = String.valueOf(newPasswordField.getPassword());
            
            try {
                Connection con = Connect.getConnection();
                ResultSet rs = CRUD.selectUserInfo(con,userEditID);
                rs.next();
                ResultSet rsuipw = CRUD.selectUserIDPassword(con, rs.getString("username"));
                rsuipw.next();
                if(fullname.equals(rs.getString("full_name")) &&
                        username.equals(rs.getString("username")) && 
                        newpassword.equals(""))
                    JOptionPane.showMessageDialog(null, "No Changes Detected");
                else{
                    boolean edited = false;
                    if("".equals(fullname))
                        JOptionPane.showMessageDialog(null, "Full Name cannot be blank!");
                    else if("".equals(username))
                        JOptionPane.showMessageDialog(null, "Username cannot be blank!");
                    else if(!"".equals(password) && 
                            !HashPassword.hashPassword(password).equals(
                                    rsuipw.getString("password"))){
                        JOptionPane.showMessageDialog(null, "Invalid Password! "+password);
                    }else{
                        if(!fullname.equals(rs.getString("full_name"))){
                            CRUD.updateFullname(con, username, fullname, userid);
                            edited = true;
                        }
                        if(!username.equals(rs.getString("username"))){
                            if(!CRUD.checkUserExists(con,username)){
                                CRUD.updateUsername(con, rs.getString("username"), username, userid);
                                edited = true;
                            }else{
                                JOptionPane.showMessageDialog(null, "Username already taken...");
                            }
                        }
                        if(HashPassword.hashPassword(password).equals(rsuipw.getString("password"))){
                            if(!newpassword.equals("")) {
                                if(newpassword.length() >= 8){
                                    newpassword=HashPassword.hashPassword(newpassword);
                                    CRUD.updatePassword(con, rs.getString("username"), password, newpassword, userid);
                                    edited = true;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Password must contain at least 8 characters...");
                                }
                            }
                        }
                    }
                    
                    if(edited == true){
                        fullnameField.setText("");
                        usernameField.setText("");
                        passwordField.setText("");
                        newPasswordField.setText("");
                        userEditLabel.setText("");
                        DefaultTableModel model = (DefaultTableModel)usersTable.getModel(); 
                        int row = usersTable.getSelectedRow();
                        model.setValueAt(fullname, row, 2);
                        model.setValueAt(username, row, 1); 
                        String updatedBy = CRUD.selectFullname(con, userid);
                        model.setValueAt(updatedBy, row, 5);
                        model.setValueAt(dateFormat.format(new Date()), row, 6);
                        userEditID = - 1;
                        JOptionPane.showMessageDialog(null, "User has been successfully updated");
                    }
                }
            } catch (NoSuchAlgorithmException | SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //add user
            String fullname = fullnameField.getText();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if("".equals(username))
                JOptionPane.showMessageDialog(null, "Username is required!");
            else if("".equals(fullname))
                JOptionPane.showMessageDialog(null, "Full Name is required!");
            else if("".equals(password))
                JOptionPane.showMessageDialog(null, "Password is required!");
            else{
                try{
                    Connection con = Connect.getConnection();
                    if(!CRUD.checkUserExists(con,username)){
                        if(password.length() >= 8){
                            password=HashPassword.hashPassword(password);
                            CRUD.insertUser(con,fullname,username,password,userid);
                            JOptionPane.showMessageDialog(null, "User has been successfully created!");
                            ResultSet rs = CRUD.selectUserInfoUsingUsername(con, username);
                            rs.next();
                            String addedby = CRUD.selectUsername(con, rs.getInt("added_by"));
                            String updatedby = CRUD.selectUsername(con, rs.getInt("updated_by"));
                            User u = new User(
                                rs.getInt("user_id"),
                                rs.getString("username"),
                                rs.getString("full_name"),
                                addedby,
                                rs.getTimestamp("added_date"),
                                updatedby,
                                rs.getTimestamp("updated_date")
                            );
                            addRowToUsersTable(u);
                        }else{
                            JOptionPane.showMessageDialog(null, "Password must contain at least 8 characters...");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Username already taken...");
                    }
                }catch(HeadlessException | NoSuchAlgorithmException | SQLException e){
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_saveEditUserInfoBtnMouseClicked

    private void logout_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_sideMouseClicked
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_logout_sideMouseClicked

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        int i = usersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        usernameField.setText(model.getValueAt(i,1).toString());
        fullnameField.setText(model.getValueAt(i,2).toString());
        userEditLabel.setText("User: "+model.getValueAt(i,1).toString());
        userEditID = (int) model.getValueAt(i, 0);
    }//GEN-LAST:event_usersTableMouseClicked

    private void addEditCategoryBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEditCategoryBtnMouseClicked
        if(categoryEditID != -1){
            //update category
            String categoryName = categoryNameField.getText();
            
            try {
                Connection con = Connect.getConnection();
                ResultSet rs = CRUD.selectCategoryInfo(con,categoryEditID);
                rs.next();
                if(categoryName.equals(rs.getString("category_name")))
                    JOptionPane.showMessageDialog(null, "No Changes Detected");
                else{
                    if("".equals(categoryName)){
                        JOptionPane.showMessageDialog(null, "Category Name cannot be blank!");
                    }else{
                        CRUD.updateCategoryName(con,categoryEditID,categoryName,userid);
                        categoryNameField.setText("");
                        rs = CRUD.selectCategoryInfo(con,categoryEditID);
                        if(rs.next()){
                            DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel(); 
                            int row = categoriesTable.getSelectedRow();
                            model.setValueAt(categoryName, row, 1);
                            String updatedBy = CRUD.selectFullname(con, userid);
                            model.setValueAt(updatedBy, row, 4);
                            model.setValueAt(dateFormat.format(new Date()), row, 5);
                            categoryEditID = - 1;
                            JOptionPane.showMessageDialog(null, "Category Name has been successfully updated");
                        }else{
                            JOptionPane.showMessageDialog(null, "Null was returned");
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //add category
            String categoryName = categoryNameField.getText();

            if("".equals(categoryName))
                JOptionPane.showMessageDialog(null, "Category name is required!");
            else{
                try{
                    Connection con = Connect.getConnection();
                    if(!CRUD.checkCategoryExists(con,categoryName)){
                        CRUD.insertCleaningCategory(con,categoryName,userid);
                        JOptionPane.showMessageDialog(null, "Category has been successfully created!");
                        ResultSet rs = CRUD.selectCategoryInfoUsingCategoryName(con, categoryName);
                        rs.next();
                        String addedby = CRUD.selectFullname(con, rs.getInt("added_by"));
                        String updatedby = CRUD.selectFullname(con, rs.getInt("updated_by"));
                        Category c = new Category(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            addedby,
                            rs.getTimestamp("added_date"),
                            updatedby,
                            rs.getTimestamp("updated_date")
                        );
                        addRowToCategoriesTable(c);
                    }else{
                        JOptionPane.showMessageDialog(null, "Category updated name field should be modified...");
                    }
                }catch(HeadlessException | SQLException e){
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_addEditCategoryBtnMouseClicked

    private void categoriesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriesTableMouseClicked
        int i = categoriesTable.getSelectedRow();
        System.out.println("selected row is: "+i);
        DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel();
        categoryNameField.setText(model.getValueAt(i,1).toString());
        categoryEditID = (int) model.getValueAt(i, 0);
        categoryEditLabel.setText("Category: "+model.getValueAt(i,1).toString());
        System.out.println("selected category_id is: "+categoryEditID);
        categoryDropdown.setSelectedItem(model.getValueAt(i,1).toString());
        Show_CategoryItemsTable();
    }//GEN-LAST:event_categoriesTableMouseClicked

    private void removeCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCategoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeCategoryBtnActionPerformed

    private void removeCategoryBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCategoryBtnMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to arhive this category?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            String categoryName = categoryNameField.getText();
            Connection con = Connect.getConnection();
            try {
                ResultSet rs = CRUD.selectCategoryInfoUsingCategoryName(con, categoryName);
                if(rs.next()){
                    boolean removed = CRUD.archiveCategory(con, rs.getInt("category_id"));
                    if(removed){
                        JOptionPane.showMessageDialog(null, "Category successfully archived");
                        TableModel tm = categoriesTable.getModel();
                        for (int i = 0; i < tm.getRowCount(); i++) {
                            Object o = tm.getValueAt(i, 1);
                            if (o.equals(categoryNameField.getText())) {
                                ((DefaultTableModel)categoriesTable.getModel()).removeRow(i);
                                categoryNameField.setText("");
                                categoryEditLabel.setText("");
                                categoryItemUpdatedDate.setText("");
                                categoryDropdown.setSelectedIndex(0);
                                itemDropdown.setSelectedIndex(0);
                                itemQuantitySpinner.setValue(0);
                                categoriesTable.getSelectionModel().clearSelection();
                                categoryEditID = - 1;
                            }else{
                                System.out.println((String)o);
                                System.out.println(categoryNameField);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Category remove unsuccessful");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_removeCategoryBtnMouseClicked

    private void clearCategoryFieldsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearCategoryFieldsBtnMouseClicked
        categoryNameField.setText("");
        categoryEditLabel.setText("");
        categoryItemAddedDate.setText("");
        categoryItemAddedBy.setText("");
        categoryItemUpdatedDate.setText("");
        categoryItemUpdatedBy.setText("");
        categoryDropdown.setSelectedIndex(0);
        itemDropdown.setSelectedIndex(0);
        itemQuantitySpinner.setValue(0);
        categoriesTable.getSelectionModel().clearSelection();
        categoryEditID = - 1;
    }//GEN-LAST:event_clearCategoryFieldsBtnMouseClicked

    private void clearCategoryFieldsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCategoryFieldsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearCategoryFieldsBtnActionPerformed

    private void clearUserFieldBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearUserFieldBtnMouseClicked
        usernameField.setText("");
        fullnameField.setText("");
        fullnameField.setText("");
        passwordField.setText("");
        newPasswordField.setText("");
        userEditLabel.setText("");
        usersTable.getSelectionModel().clearSelection();
        userEditID = - 1;
    }//GEN-LAST:event_clearUserFieldBtnMouseClicked

    private void clearUserFieldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearUserFieldBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearUserFieldBtnActionPerformed

    private void removeUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeUserBtnMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to archive this user?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            String username = usernameField.getText();
            Connection con = Connect.getConnection();
            try {
                ResultSet rs = CRUD.selectUserIDPassword(con, username);
                if(rs.next()){
                    boolean removed = CRUD.archiveUser(con, rs.getInt("user_id"));
                    if(removed){
                        JOptionPane.showMessageDialog(null, "User successfully archived");
                        TableModel tm = usersTable.getModel();
                        for (int i = 0; i < tm.getRowCount(); i++) {
                            Object o = tm.getValueAt(i, 1);
                            if (o.equals(usernameField.getText())) {
                                ((DefaultTableModel)usersTable.getModel()).removeRow(i);
                                usernameField.setText("");
                                fullnameField.setText("");
                                passwordField.setText("");
                                newPasswordField.setText("");
                                usersTable.getSelectionModel().clearSelection();
                                userEditID = - 1;
                            }else{
                                System.out.println((String)o);
                                System.out.println(usernameField);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "User remove unsuccessful");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_removeUserBtnMouseClicked

    private void removeUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeUserBtnActionPerformed

    private void addEditCategoryItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEditCategoryItemBtnMouseClicked
        String categoryName = String.valueOf(categoryDropdown.getSelectedItem());
        String itemName = String.valueOf(itemDropdown.getSelectedItem());
        int itemQuantity = (Integer) itemQuantitySpinner.getValue();
        try {
            if(itemQuantity == 0){
                JOptionPane.showMessageDialog(null, "Quantity cannot be equal to zero!");   
            }else{
                Connection con = Connect.getConnection();
                if(categoryEditID == -1)
                    categoryEditID = CRUD.selectCategoryID(con,categoryName);
                int itemID = CRUD.selectItemID(con, itemName);
                ResultSet item = CRUD.selectItemInfo(con,itemID);
                item.next();
                if(item.getInt("quantity") >= itemQuantity){
                    ResultSet catItem = CRUD.selectCategoryItemInfoCategoryIDItemID(con,categoryEditID,itemID);
                    if(catItem.next()){
                        if(catItem.getInt("item_quantity") == itemQuantity)
                            JOptionPane.showMessageDialog(null, "No changes detected");
                        else{
                            CRUD.updateCategoryItemQuantity(con,categoryEditID,itemID,itemQuantity,userid);
                            JOptionPane.showMessageDialog(null, "Category Item has been successfully updated");
                            ResultSet rs = CRUD.selectCategoryItemInfoCategoryIDItemID(con, categoryEditID, itemID);
                            rs.next();
                            
                            DefaultTableModel model = (DefaultTableModel)categoryItemTable.getModel(); 
                            for (int i = 0; i < model.getRowCount(); i++) {
                                Object o = model.getValueAt(i, 0);
                                if (o.equals(itemName)) {
                                    model.setValueAt(itemQuantity, i, 1);
                                    categoryNameField.setText("");
                                    categoryEditLabel.setText("");
                                    categoryItemAddedDate.setText("");
                                    categoryItemAddedBy.setText("");
                                    categoryItemUpdatedDate.setText("");
                                    categoryItemUpdatedBy.setText("");
                                    categoryDropdown.setSelectedIndex(0);
                                    itemDropdown.setSelectedIndex(0);
                                    itemQuantitySpinner.setValue(0);
                                    categoriesTable.getSelectionModel().clearSelection();
                                    categoryEditID = - 1;
                                    categoryItemTable.getSelectionModel().clearSelection();
                                }
                            }                        
                        }
                    }else{
                        CRUD.insertCategoryItem(con,categoryEditID, itemID, itemQuantity, userid);
                        ResultSet rs = CRUD.selectCategoryItemInfoCategoryIDItemID(con, categoryEditID, itemID);
                        rs.next();
                        CategoryItem ci = new CategoryItem(
                                rs.getInt("category_id"),
                                rs.getInt("item_id"),
                                rs.getInt("item_quantity"),
                                rs.getInt("added_by"),
                                rs.getTimestamp("added_date"),
                                rs.getInt("updated_by"),
                                rs.getTimestamp("updated_date")
                        );
                        addRowToCategoryItemsTable(ci);
                        JOptionPane.showMessageDialog(null, "Category Item has been successfully added");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Item Quantity is Insufficient for requirement!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addEditCategoryItemBtnMouseClicked

    private void itemDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDropdownActionPerformed
        try {
            String itemName = String.valueOf(itemDropdown.getSelectedItem());
            Connection con = Connect.getConnection();
            int itemID = CRUD.selectItemID(con, itemName);
            ResultSet item = CRUD.selectItemInfo(con,itemID);
            item.next();
            SpinnerNumberModel model = new SpinnerNumberModel();
            model.setMaximum(item.getInt("quantity"));
            model.setMinimum(0);
            itemQuantitySpinner.setModel(model);            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemDropdownActionPerformed

    private void categoryItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryItemTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)categoryItemTable.getModel();
        int row = categoryItemTable.getSelectedRow();
        String itemName = model.getValueAt(row,0).toString();
        String categoryName = String.valueOf(categoryDropdown.getSelectedItem());
        itemDropdown.setSelectedItem(itemName);
        itemQuantitySpinner.setValue(model.getValueAt(row,1));
        Connection con = Connect.getConnection();
        try {
            if(categoryEditID == -1)
                categoryEditID = CRUD.selectCategoryID(con,categoryName);
            int itemID = CRUD.selectItemID(con, itemName);
            ResultSet rs = CRUD.selectCategoryItemAddedUpdated(con, categoryEditID, itemID);
            if(rs.next()){
                String addedby = CRUD.selectFullname(con, rs.getInt("added_by"));
                String updatedby = CRUD.selectFullname(con, rs.getInt("updated_by"));
                categoryItemAddedDate.setText("created on: "+dateFormat.format(rs.getTimestamp("added_date")));
                categoryItemAddedBy.setText("created by: "+addedby);
                categoryItemUpdatedDate.setText("last updated: "+dateFormat.format(rs.getTimestamp("updated_date")));
                categoryItemUpdatedBy.setText("updated by: "+updatedby);
            }else{
                JOptionPane.showMessageDialog(null, "Null was returned.");
                System.out.println(categoryEditID);
                System.out.println(itemID);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_categoryItemTableMouseClicked

    private void removeCategoryItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCategoryItemBtnMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure "
            + "you want to archive this category item?","Confirm", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            String categoryName = (String) categoryDropdown.getSelectedItem();
            String categoryItemName = (String) itemDropdown.getSelectedItem();
            Connection con = Connect.getConnection();
            try {
                int categoryID = CRUD.selectCategoryID(con, categoryName);
                int itemID = CRUD.selectItemID(con, categoryItemName);
                ResultSet rs = CRUD.selectCategoryItemInfoCategoryIDItemID(con, categoryID, itemID);
                if(rs.next()){
                    boolean removed = CRUD.archiveCategoryItem(con, rs.getInt("category_id"), rs.getInt("item_id"));
                    if(removed){
                        JOptionPane.showMessageDialog(null, "Category successfully archived");
                        TableModel tm = categoryItemTable.getModel();
                        for (int i = 0; i < tm.getRowCount(); i++) {
                            Object o = tm.getValueAt(i, 0);
                            if (o.equals(categoryItemName)) {
                                ((DefaultTableModel)categoryItemTable.getModel()).removeRow(i);
                                categoryDropdown.setSelectedIndex(0);
                                categoryEditLabel.setText("");
                                categoriesTable.getSelectionModel().clearSelection();
                                categoryItemTable.getSelectionModel().clearSelection();
                                categoryEditID = - 1;
                            }else{
                                System.out.println((String)o);
                                System.out.println(categoryItemName);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Category remove unsuccessful");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Category Item not Found");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_removeCategoryItemBtnMouseClicked

    private void categoryDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDropdownActionPerformed
        try {
            String categoryName = String.valueOf(categoryDropdown.getSelectedItem());
            Connection con = Connect.getConnection();
            categoryEditID = CRUD.selectCategoryID(con, categoryName);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_categoryDropdownActionPerformed

    private void itemTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTypeTableMouseClicked
        // TODO add your handling code here:
        int i = itemTypeTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)itemTypeTable.getModel();
        typename3.setText(model.getValueAt(i, 1).toString());
        newtypename.setText(model.getValueAt(i, 1).toString());
        typename2.setText(model.getValueAt(i, 1).toString());
        itemtypedetails1.setText(model.getValueAt(i,2).toString());
        itemtypedetails2.setText(model.getValueAt(i,2).toString());

    }//GEN-LAST:event_itemTypeTableMouseClicked

    private void categoryNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryNameFieldActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Archive;
    private javax.swing.JComboBox<String> ItemMetricList;
    private javax.swing.JComboBox<String> ItemMetricList3;
    private javax.swing.JComboBox<String> ItemTypeNameList;
    private javax.swing.JComboBox<String> ItemTypeNameList3;
    private javax.swing.JTabbedPane Tables;
    private javax.swing.JButton Update;
    private javax.swing.JButton addEditCategoryBtn;
    private javax.swing.JButton addEditCategoryItemBtn;
    private javax.swing.JButton addItemType_save;
    private javax.swing.JButton addItem_save;
    private javax.swing.JButton addJob;
    private javax.swing.JButton addJobItem;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel additems_form1;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form3;
    private javax.swing.JPanel additems_form8;
    private javax.swing.JPanel additemtype;
    private javax.swing.JPanel additemtype_form;
    private javax.swing.JLabel adminName;
    private javax.swing.JButton archiveItemType;
    private javax.swing.JPanel archiveitem;
    private javax.swing.JPanel archiveitemtype_form;
    private javax.swing.JPanel categories;
    private javax.swing.JTable categoriesTable;
    private javax.swing.JPanel categories_side;
    private javax.swing.JLabel categories_side_label;
    private javax.swing.JLabel categories_up_label;
    private javax.swing.JComboBox<String> categoryDropdown;
    private javax.swing.JLabel categoryEditLabel;
    private javax.swing.JLabel categoryItemAddedBy;
    private javax.swing.JLabel categoryItemAddedDate;
    private javax.swing.JTable categoryItemTable;
    private javax.swing.JLabel categoryItemUpdatedBy;
    private javax.swing.JLabel categoryItemUpdatedDate;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JButton clearCategoryFieldsBtn;
    private javax.swing.JButton clearUserFieldBtn;
    private javax.swing.JPanel crud_jobItems;
    private javax.swing.JPanel crud_jobs;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JLabel dashboard_label1;
    private javax.swing.JLabel dashboard_label4;
    private javax.swing.JLabel dashboard_label5;
    private javax.swing.JLabel dashboard_label6;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JButton deleteJob;
    private javax.swing.JButton deleteJobItem;
    private javax.swing.JTextField fullnameField;
    private javax.swing.JPanel iTtable;
    private javax.swing.JComboBox<String> itemDropdown;
    private javax.swing.JTextField itemName2;
    private javax.swing.JTextField itemName3;
    private javax.swing.JSpinner itemQuantitySpinner;
    private javax.swing.JTable itemTypeTable;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemqty;
    private javax.swing.JTextField itemqty2;
    private javax.swing.JPanel items;
    private javax.swing.JTabbedPane itemsTab;
    private javax.swing.JTable itemsTable;
    private javax.swing.JPanel itemsTablePanel;
    private javax.swing.JPanel items_side;
    private javax.swing.JLabel items_side_label;
    private javax.swing.JLabel items_up_label;
    private javax.swing.JTextField itemtypedetails;
    private javax.swing.JTextField itemtypedetails1;
    private javax.swing.JTextField itemtypedetails2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jobItemsTable;
    private javax.swing.JPanel job_items;
    private javax.swing.JComboBox<String> jobcat;
    private javax.swing.JComboBox<String> jobcombobox;
    private javax.swing.JComboBox<String> jobitemcombobox;
    private javax.swing.JTextField jobitemqty;
    private javax.swing.JTextField jobname;
    private javax.swing.JPanel jobs;
    private javax.swing.JPanel jobsPanel;
    private javax.swing.JTable jobsTable;
    private javax.swing.JPanel jobs_side;
    private javax.swing.JLabel jobs_side_label;
    private javax.swing.JTabbedPane jobs_tab;
    private javax.swing.JLabel jobs_up_label;
    private javax.swing.JPanel left_sidebar;
    private javax.swing.JPanel logout_side;
    private javax.swing.JLabel logout_side_label;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField newitemname;
    private javax.swing.JTextField newtypename;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton removeCategoryBtn;
    private javax.swing.JButton removeCategoryItemBtn;
    private javax.swing.JButton removeUserBtn;
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton saveEditUserInfoBtn;
    private javax.swing.JTextField typename;
    private javax.swing.JTextField typename2;
    private javax.swing.JTextField typename3;
    private javax.swing.JButton updateItemType;
    private javax.swing.JButton updateJob;
    private javax.swing.JButton updateJobItem;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitemtype_form;
    private javax.swing.JPanel upper_categories_panel;
    private javax.swing.JPanel upper_dashboard_panel;
    private javax.swing.JPanel upper_items_panel;
    private javax.swing.JPanel upper_jobs_panel;
    private javax.swing.JPanel upper_users_panel;
    private javax.swing.JLabel userEditLabel;
    private javax.swing.JLabel userimg;
    private javax.swing.JTextField usernameField;
    private javax.swing.JPanel users;
    private javax.swing.JTable usersTable;
    private javax.swing.JPanel users_side;
    private javax.swing.JLabel users_side_label;
    private javax.swing.JLabel users_up_label;
    private javax.swing.JPanel whole;
    // End of variables declaration//GEN-END:variables
}
