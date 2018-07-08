package optimalinventorysystem;

import Entities.Job;
import Entities.JobItem;
import MySQL.CRUD;
import static MySQL.CRUD.AddDeductItemQty;
import static MySQL.CRUD.getJobItem_ItemID;
import MySQL.Connect;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static optimalinventorysystem.Login.userid;

public class Home extends javax.swing.JFrame {
    public static int JobIDFromTable, JobItemsIDFromTable, JobItems_ItemIDFromTable = 0;
    public static int selectrow;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    // 5,32,33      -- darkest
    // 15, 74, 74   -- middle
    // 8, 40, 41    -- lightest
    public Home() throws SQLException{
        initComponents();
        dashboard();
        Show_JobsTable();
        Show_JobItemsTable();
        addCleaningJobToCombobox();
        addJobItemNameToCombobox();
        addJobNameToCombobox();
        try{
            Connection con = Connect.getConnection();
            String username = CRUD.selectUsername(con,userid);
            adminName.setText(username);
        }catch(HeadlessException e){
            System.out.println(e);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
    
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
    
    public void jobs_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        jobs_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        categories.setBackground(new Color(8, 40, 41));
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
    
    public void categories_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        categories.setBackground(new Color(15, 74, 74));
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
    
    public void users_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        users_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        categories.setBackground(new Color(8, 40, 41));
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whole = new javax.swing.JPanel();
        right_sidebar = new javax.swing.JPanel();
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
        jScrollPane6 = new javax.swing.JScrollPane();
        jobItemsTable = new javax.swing.JTable();
        crud_jobItems = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        addJobItem = new javax.swing.JButton();
        updateJobItem = new javax.swing.JButton();
        deleteJobItem = new javax.swing.JButton();
        jobitemqty = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jobitemcombobox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jobcombobox = new javax.swing.JComboBox<>();
        dashboard = new javax.swing.JPanel();
        dashboard_label = new javax.swing.JLabel();
        items = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTab = new javax.swing.JTabbedPane();
        additems = new javax.swing.JPanel();
        additems_form = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        itemmetric = new javax.swing.JTextField();
        itemtype = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        itemqty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addItem_save = new javax.swing.JButton();
        updateitems = new javax.swing.JPanel();
        additems_form2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        itemname3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        itemmetric3 = new javax.swing.JTextField();
        itemtype3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        itemqty3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        updateItem_save = new javax.swing.JButton();
        categories = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemsTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTab1 = new javax.swing.JTabbedPane();
        additems1 = new javax.swing.JPanel();
        additems_form1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        itemname1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        itemmetric1 = new javax.swing.JTextField();
        itemtype1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        itemqty1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addItem_save1 = new javax.swing.JButton();
        updateitems2 = new javax.swing.JPanel();
        additems_form3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        itemname4 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        itemmetric4 = new javax.swing.JTextField();
        itemtype4 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        itemqty4 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        updateItem_save1 = new javax.swing.JButton();
        users = new javax.swing.JPanel();
        left_sidebar = new javax.swing.JPanel();
        userimg = new javax.swing.JLabel();
        dashboard_side = new javax.swing.JPanel();
        dashboard_side_label = new javax.swing.JLabel();
        items_side = new javax.swing.JPanel();
        items_side_label = new javax.swing.JLabel();
        jobs_side = new javax.swing.JPanel();
        jobs_side_label = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        categories_side = new javax.swing.JPanel();
        categories_side_label = new javax.swing.JLabel();
        users_side = new javax.swing.JPanel();
        users_side_label = new javax.swing.JLabel();
        logout_side = new javax.swing.JPanel();
        logout_side_label = new javax.swing.JLabel();
        upper_categories_panel = new javax.swing.JPanel();
        categories_up_label = new javax.swing.JLabel();
        upper_dashboard_panel = new javax.swing.JPanel();
        dashboard_up_label = new javax.swing.JLabel();
        upper_items_panel = new javax.swing.JPanel();
        items_up_label = new javax.swing.JLabel();
        upper_jobs_panel = new javax.swing.JPanel();
        jobs_up_label = new javax.swing.JLabel();
        upper_users_panel = new javax.swing.JPanel();
        users_up_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        whole.setBackground(new java.awt.Color(255, 255, 255));
        whole.setPreferredSize(new java.awt.Dimension(1500, 800));
        whole.setLayout(null);

        right_sidebar.setBackground(new java.awt.Color(5, 32, 33));
        right_sidebar.setPreferredSize(new java.awt.Dimension(1500, 800));
        right_sidebar.setLayout(null);

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
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addContainerGap(53, Short.MAX_VALUE))
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
        jScrollPane6.setViewportView(jobItemsTable);

        crud_jobItems.setBackground(new java.awt.Color(15, 74, 74));

        jLabel12.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ITEM QUANTITY");

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

        jLabel13.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ITEM NAME");

        jobitemcombobox.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobitemcombobox.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("JOB NAME");

        jobcombobox.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcombobox.setToolTipText("");

        javax.swing.GroupLayout crud_jobItemsLayout = new javax.swing.GroupLayout(crud_jobItems);
        crud_jobItems.setLayout(crud_jobItemsLayout);
        crud_jobItemsLayout.setHorizontalGroup(
            crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jobcombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobitemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jobitemcombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        crud_jobItemsLayout.setVerticalGroup(
            crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_jobItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(crud_jobItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_jobItemsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobitemcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobitemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crud_jobItemsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteJobItem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );

        javax.swing.GroupLayout job_itemsLayout = new javax.swing.GroupLayout(job_items);
        job_items.setLayout(job_itemsLayout);
        job_itemsLayout.setHorizontalGroup(
            job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(job_itemsLayout.createSequentialGroup()
                .addGroup(job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(job_itemsLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(job_itemsLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(crud_jobItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        job_itemsLayout.setVerticalGroup(
            job_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(job_itemsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crud_jobItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
        jobsPanel.setBounds(0, 0, 1660, 726);

        dashboard.setBackground(new java.awt.Color(5, 32, 33));

        dashboard_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label.setText("THIS IS DASHBOARD");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );

        right_sidebar.add(dashboard);
        dashboard.setBounds(0, 0, 800, 710);

        items.setBackground(new java.awt.Color(5, 32, 33));

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "ITEM QUANTITY", "ITEM METRIC", "ITEM TYPE"
            }
        ));
        jScrollPane3.setViewportView(itemsTable);

        additems.setBackground(new java.awt.Color(5, 32, 33));

        additems_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ITEM METRIC");

        itemmetric.setBackground(new java.awt.Color(15, 74, 74));
        itemmetric.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemmetric.setForeground(new java.awt.Color(255, 255, 255));
        itemmetric.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemmetric.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemmetric.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemmetric.setOpaque(false);

        itemtype.setBackground(new java.awt.Color(15, 74, 74));
        itemtype.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtype.setForeground(new java.awt.Color(255, 255, 255));
        itemtype.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtype.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtype.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtype.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ITEM TYPE");

        itemqty.setBackground(new java.awt.Color(15, 74, 74));
        itemqty.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty.setForeground(new java.awt.Color(255, 255, 255));
        itemqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ITEM QUANTITY");

        addItem_save.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addItem_save.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save.setText("SAVE");
        addItem_save.setBorder(null);

        javax.swing.GroupLayout additems_formLayout = new javax.swing.GroupLayout(additems_form);
        additems_form.setLayout(additems_formLayout);
        additems_formLayout.setHorizontalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_formLayout.createSequentialGroup()
                        .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemtype, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additemsLayout = new javax.swing.GroupLayout(additems);
        additems.setLayout(additemsLayout);
        additemsLayout.setHorizontalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        additemsLayout.setVerticalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEMS", additems);

        updateitems.setBackground(new java.awt.Color(5, 32, 33));

        additems_form2.setBackground(new java.awt.Color(15, 74, 74));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ITEM NAME");

        itemname3.setBackground(new java.awt.Color(15, 74, 74));
        itemname3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemname3.setForeground(new java.awt.Color(255, 255, 255));
        itemname3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemname3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemname3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemname3.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("ITEM METRIC");

        itemmetric3.setBackground(new java.awt.Color(15, 74, 74));
        itemmetric3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemmetric3.setForeground(new java.awt.Color(255, 255, 255));
        itemmetric3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemmetric3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemmetric3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemmetric3.setOpaque(false);

        itemtype3.setBackground(new java.awt.Color(15, 74, 74));
        itemtype3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtype3.setForeground(new java.awt.Color(255, 255, 255));
        itemtype3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtype3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtype3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtype3.setOpaque(false);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("ITEM TYPE");

        itemqty3.setBackground(new java.awt.Color(15, 74, 74));
        itemqty3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty3.setForeground(new java.awt.Color(255, 255, 255));
        itemqty3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty3.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ITEM QUANTITY");

        updateItem_save.setBackground(new java.awt.Color(0, 204, 51));
        updateItem_save.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateItem_save.setForeground(new java.awt.Color(255, 255, 255));
        updateItem_save.setText("SAVE");
        updateItem_save.setBorder(null);

        javax.swing.GroupLayout additems_form2Layout = new javax.swing.GroupLayout(additems_form2);
        additems_form2.setLayout(additems_form2Layout);
        additems_form2Layout.setHorizontalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemname3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemmetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemtype3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        additems_form2Layout.setVerticalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemname3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout updateitemsLayout = new javax.swing.GroupLayout(updateitems);
        updateitems.setLayout(updateitemsLayout);
        updateitemsLayout.setHorizontalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        updateitemsLayout.setVerticalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        itemsTab.addTab("UPDATE ITEMS", updateitems);

        jScrollPane1.setViewportView(itemsTab);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(itemsLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        right_sidebar.add(items);
        items.setBounds(0, 0, 1250, 710);

        categories.setBackground(new java.awt.Color(5, 32, 33));

        itemsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "ITEM QUANTITY", "ITEM METRIC", "ITEM TYPE"
            }
        ));
        jScrollPane4.setViewportView(itemsTable1);

        additems1.setBackground(new java.awt.Color(5, 32, 33));

        additems_form1.setBackground(new java.awt.Color(15, 74, 74));

        jLabel7.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ITEM NAME");

        itemname1.setBackground(new java.awt.Color(15, 74, 74));
        itemname1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemname1.setForeground(new java.awt.Color(255, 255, 255));
        itemname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemname1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemname1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemname1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ITEM METRIC");

        itemmetric1.setBackground(new java.awt.Color(15, 74, 74));
        itemmetric1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemmetric1.setForeground(new java.awt.Color(255, 255, 255));
        itemmetric1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemmetric1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemmetric1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemmetric1.setOpaque(false);

        itemtype1.setBackground(new java.awt.Color(15, 74, 74));
        itemtype1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtype1.setForeground(new java.awt.Color(255, 255, 255));
        itemtype1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtype1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtype1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtype1.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ITEM TYPE");

        itemqty1.setBackground(new java.awt.Color(15, 74, 74));
        itemqty1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty1.setForeground(new java.awt.Color(255, 255, 255));
        itemqty1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty1.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ITEM QUANTITY");

        addItem_save1.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addItem_save1.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save1.setText("SAVE");
        addItem_save1.setBorder(null);

        javax.swing.GroupLayout additems_form1Layout = new javax.swing.GroupLayout(additems_form1);
        additems_form1.setLayout(additems_form1Layout);
        additems_form1Layout.setHorizontalGroup(
            additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addItem_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_form1Layout.createSequentialGroup()
                        .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemname1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemmetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        additems_form1Layout.setVerticalGroup(
            additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemname1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addItem_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additems1Layout = new javax.swing.GroupLayout(additems1);
        additems1.setLayout(additems1Layout);
        additems1Layout.setHorizontalGroup(
            additems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems1Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(additems_form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        additems1Layout.setVerticalGroup(
            additems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(additems_form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        itemsTab1.addTab("ADD ITEMS", additems1);

        updateitems2.setBackground(new java.awt.Color(5, 32, 33));

        additems_form3.setBackground(new java.awt.Color(15, 74, 74));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ITEM NAME");

        itemname4.setBackground(new java.awt.Color(15, 74, 74));
        itemname4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemname4.setForeground(new java.awt.Color(255, 255, 255));
        itemname4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemname4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemname4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemname4.setOpaque(false);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("ITEM METRIC");

        itemmetric4.setBackground(new java.awt.Color(15, 74, 74));
        itemmetric4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemmetric4.setForeground(new java.awt.Color(255, 255, 255));
        itemmetric4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemmetric4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemmetric4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemmetric4.setOpaque(false);

        itemtype4.setBackground(new java.awt.Color(15, 74, 74));
        itemtype4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtype4.setForeground(new java.awt.Color(255, 255, 255));
        itemtype4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtype4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtype4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtype4.setOpaque(false);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("ITEM TYPE");

        itemqty4.setBackground(new java.awt.Color(15, 74, 74));
        itemqty4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemqty4.setForeground(new java.awt.Color(255, 255, 255));
        itemqty4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemqty4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemqty4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemqty4.setOpaque(false);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ITEM QUANTITY");

        updateItem_save1.setBackground(new java.awt.Color(0, 204, 51));
        updateItem_save1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateItem_save1.setForeground(new java.awt.Color(255, 255, 255));
        updateItem_save1.setText("SAVE");
        updateItem_save1.setBorder(null);

        javax.swing.GroupLayout additems_form3Layout = new javax.swing.GroupLayout(additems_form3);
        additems_form3.setLayout(additems_form3Layout);
        additems_form3Layout.setHorizontalGroup(
            additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateItem_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_form3Layout.createSequentialGroup()
                        .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemname4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemmetric4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemtype4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        additems_form3Layout.setVerticalGroup(
            additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemname4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form3Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemqty4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateItem_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout updateitems2Layout = new javax.swing.GroupLayout(updateitems2);
        updateitems2.setLayout(updateitems2Layout);
        updateitems2Layout.setHorizontalGroup(
            updateitems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitems2Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        updateitems2Layout.setVerticalGroup(
            updateitems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitems2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        itemsTab1.addTab("UPDATE ITEMS", updateitems2);

        jScrollPane2.setViewportView(itemsTab1);

        javax.swing.GroupLayout categoriesLayout = new javax.swing.GroupLayout(categories);
        categories.setLayout(categoriesLayout);
        categoriesLayout.setHorizontalGroup(
            categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(categoriesLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        categoriesLayout.setVerticalGroup(
            categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        right_sidebar.add(categories);
        categories.setBounds(0, 0, 1250, 710);

        users.setBackground(new java.awt.Color(5, 32, 33));

        javax.swing.GroupLayout usersLayout = new javax.swing.GroupLayout(users);
        users.setLayout(usersLayout);
        usersLayout.setHorizontalGroup(
            usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        usersLayout.setVerticalGroup(
            usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        right_sidebar.add(users);
        users.setBounds(0, 0, 1250, 720);

        whole.add(right_sidebar);
        right_sidebar.setBounds(250, 80, 1250, 720);

        left_sidebar.setBackground(new java.awt.Color(8, 40, 41));
        left_sidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        left_sidebar.setLayout(null);

        userimg.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem\\img\\team.png")); // NOI18N
        left_sidebar.add(userimg);
        userimg.setBounds(73, 56, 100, 110);

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
                .addComponent(dashboard_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(dashboard_side);
        dashboard_side.setBounds(0, 274, 250, 60);

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
                .addComponent(items_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(items_side);
        items_side.setBounds(0, 330, 250, 60);

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
                .addComponent(jobs_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(jobs_side);
        jobs_side.setBounds(0, 390, 250, 60);

        adminName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        left_sidebar.add(adminName);
        adminName.setBounds(10, 160, 230, 40);

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
                .addComponent(categories_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        categories_sideLayout.setVerticalGroup(
            categories_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categories_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categories_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(categories_side);
        categories_side.setBounds(0, 450, 250, 60);

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
                .addComponent(users_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        users_sideLayout.setVerticalGroup(
            users_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(users_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(users_side);
        users_side.setBounds(0, 510, 250, 60);

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
                .addComponent(logout_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(logout_side);
        logout_side.setBounds(0, 570, 250, 60);

        whole.add(left_sidebar);
        left_sidebar.setBounds(0, 80, 250, 720);

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
        upper_categories_panel.setBounds(0, 0, 1500, 80);

        upper_dashboard_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_dashboard_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_dashboard_panel.setLayout(null);

        dashboard_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_up_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_up_label.setText("OPTIMAL  /  DASHBOARD");
        upper_dashboard_panel.add(dashboard_up_label);
        dashboard_up_label.setBounds(30, 10, 220, 60);

        whole.add(upper_dashboard_panel);
        upper_dashboard_panel.setBounds(0, 0, 1500, 80);

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
        upper_items_panel.setBounds(0, 0, 1500, 80);

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
        upper_jobs_panel.setBounds(0, 0, 1500, 80);

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
        upper_users_panel.setBounds(0, 0, 1500, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void categories_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categories_sideMouseClicked
        categories_sideBar_onclick();
    }//GEN-LAST:event_categories_sideMouseClicked

    private void users_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_sideMouseClicked
        users_sideBar_onclick();
    }//GEN-LAST:event_users_sideMouseClicked

    private void logout_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_sideMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_sideMouseClicked

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
            if("".equals(itemqty) && "".equals(itemname) && "".equals(jobname)){
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
    private javax.swing.JButton addItem_save;
    private javax.swing.JButton addItem_save1;
    private javax.swing.JButton addJob;
    private javax.swing.JButton addJobItem;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems1;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel additems_form1;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form3;
    private javax.swing.JLabel adminName;
    private javax.swing.JPanel categories;
    private javax.swing.JPanel categories_side;
    private javax.swing.JLabel categories_side_label;
    private javax.swing.JLabel categories_up_label;
    private javax.swing.JPanel crud_jobItems;
    private javax.swing.JPanel crud_jobs;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JButton deleteJob;
    private javax.swing.JButton deleteJobItem;
    private javax.swing.JTextField itemmetric;
    private javax.swing.JTextField itemmetric1;
    private javax.swing.JTextField itemmetric3;
    private javax.swing.JTextField itemmetric4;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemname1;
    private javax.swing.JTextField itemname3;
    private javax.swing.JTextField itemname4;
    private javax.swing.JTextField itemqty;
    private javax.swing.JTextField itemqty1;
    private javax.swing.JTextField itemqty3;
    private javax.swing.JTextField itemqty4;
    private javax.swing.JPanel items;
    private javax.swing.JTabbedPane itemsTab;
    private javax.swing.JTabbedPane itemsTab1;
    private javax.swing.JTable itemsTable;
    private javax.swing.JTable itemsTable1;
    private javax.swing.JPanel items_side;
    private javax.swing.JLabel items_side_label;
    private javax.swing.JLabel items_up_label;
    private javax.swing.JTextField itemtype;
    private javax.swing.JTextField itemtype1;
    private javax.swing.JTextField itemtype3;
    private javax.swing.JTextField itemtype4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
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
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton updateItem_save;
    private javax.swing.JButton updateItem_save1;
    private javax.swing.JButton updateJob;
    private javax.swing.JButton updateJobItem;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitems2;
    private javax.swing.JPanel upper_categories_panel;
    private javax.swing.JPanel upper_dashboard_panel;
    private javax.swing.JPanel upper_items_panel;
    private javax.swing.JPanel upper_jobs_panel;
    private javax.swing.JPanel upper_users_panel;
    private javax.swing.JLabel userimg;
    private javax.swing.JPanel users;
    private javax.swing.JPanel users_side;
    private javax.swing.JLabel users_side_label;
    private javax.swing.JLabel users_up_label;
    private javax.swing.JPanel whole;
    // End of variables declaration//GEN-END:variables
}
