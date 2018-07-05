package optimalinventorysystem;


import Entities.Job;
import MySQL.CRUD;
import MySQL.Connect;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static optimalinventorysystem.Login.admin;

public class Home extends javax.swing.JFrame {
    
    // 5,32,33      -- darkest
    // 15, 74, 74   -- middle
    // 8, 40, 41    -- lightest
    public Home() throws SQLException{
        initComponents();
        dashboard();
        Show_JobsTable();
        addedby.setText("" + admin);
        updatedby.setText("" + admin);
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
        jobs.setVisible(false);
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
        jobs.setVisible(false);
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
        jobs.setVisible(true);
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
        jobs.setVisible(false);
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
        jobs.setVisible(false);
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
                job = new Job(rs.getInt("job_id"), rs.getInt("category_id"),
                    rs.getString("added_by"), rs.getDate("added_date"),
                    rs.getString("updated_by"), rs.getDate("updated_date"));
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
        Object[] row = new Object[6];
        for(Job j : list){
            row[0] = j.getID();
            row[1] = j.getCatID();
            row[2] = j.getAddedBy();
            row[3] = j.getAddedOn();
            row[4] = j.getUpdatedBy();
            row[5] = j.getUpdatedOn();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whole = new javax.swing.JPanel();
        right_sidebar = new javax.swing.JPanel();
        jobs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jobsTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jobsTab = new javax.swing.JTabbedPane();
        additems2 = new javax.swing.JPanel();
        additems_form4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jobcat = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        addJob_save = new javax.swing.JButton();
        addedby = new javax.swing.JTextField();
        updateitems1 = new javax.swing.JPanel();
        additems_form5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jobcat1 = new javax.swing.JComboBox<>();
        updatedby = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        updateJob_save = new javax.swing.JButton();
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
        dashboard_side_label2 = new javax.swing.JLabel();
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

        jobs.setBackground(new java.awt.Color(5, 32, 33));

        jobsTable.setAutoCreateRowSorter(true);
        jobsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JOB ID", "JOB CATEGORY", "ADDED BY", "DATE ADDED", "UPDATED BY", "DATE UPDATED"
            }
        ));
        jScrollPane5.setViewportView(jobsTable);

        additems2.setBackground(new java.awt.Color(5, 32, 33));

        additems_form4.setBackground(new java.awt.Color(15, 74, 74));

        jLabel11.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JOB CATEGORY");

        jobcat.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Cleaning", "Carpet Cleaning", "Upholstery Cleaning" }));

        jLabel40.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ADDED BY");

        addJob_save.setBackground(new java.awt.Color(0, 204, 51));
        addJob_save.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addJob_save.setForeground(new java.awt.Color(255, 255, 255));
        addJob_save.setText("SAVE");
        addJob_save.setBorder(null);
        addJob_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addJob_saveMouseClicked(evt);
            }
        });

        addedby.setBackground(new java.awt.Color(15, 74, 74));
        addedby.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addedby.setForeground(new java.awt.Color(255, 255, 255));
        addedby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addedby.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addedby.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout additems_form4Layout = new javax.swing.GroupLayout(additems_form4);
        additems_form4.setLayout(additems_form4Layout);
        additems_form4Layout.setHorizontalGroup(
            additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jobcat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        additems_form4Layout.setVerticalGroup(
            additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout additems2Layout = new javax.swing.GroupLayout(additems2);
        additems2.setLayout(additems2Layout);
        additems2Layout.setHorizontalGroup(
            additems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems2Layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(additems_form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
        );
        additems2Layout.setVerticalGroup(
            additems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems2Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(additems_form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jobsTab.addTab("ADD ITEMS", additems2);

        updateitems1.setBackground(new java.awt.Color(5, 32, 33));

        additems_form5.setBackground(new java.awt.Color(15, 74, 74));

        jLabel41.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("JOB CATEGORY");

        jobcat1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Cleaning", "Carpet Cleaning", "Upholstery Cleaning" }));

        updatedby.setEditable(false);
        updatedby.setBackground(new java.awt.Color(15, 74, 74));
        updatedby.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updatedby.setForeground(new java.awt.Color(255, 255, 255));
        updatedby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        updatedby.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        updatedby.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel44.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("UPDATED BY");

        updateJob_save.setBackground(new java.awt.Color(0, 204, 51));
        updateJob_save.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updateJob_save.setForeground(new java.awt.Color(255, 255, 255));
        updateJob_save.setText("SAVE");
        updateJob_save.setBorder(null);

        javax.swing.GroupLayout additems_form5Layout = new javax.swing.GroupLayout(additems_form5);
        additems_form5.setLayout(additems_form5Layout);
        additems_form5Layout.setHorizontalGroup(
            additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jobcat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updatedby, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        additems_form5Layout.setVerticalGroup(
            additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_form5Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jobcat1)
                            .addComponent(updatedby, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout updateitems1Layout = new javax.swing.GroupLayout(updateitems1);
        updateitems1.setLayout(updateitems1Layout);
        updateitems1Layout.setHorizontalGroup(
            updateitems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitems1Layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addComponent(additems_form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        updateitems1Layout.setVerticalGroup(
            updateitems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitems1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(additems_form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jobsTab.addTab("UPDATE ITEMS", updateitems1);

        jScrollPane7.setViewportView(jobsTab);

        javax.swing.GroupLayout jobsLayout = new javax.swing.GroupLayout(jobs);
        jobs.setLayout(jobsLayout);
        jobsLayout.setHorizontalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jobsLayout.setVerticalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        right_sidebar.add(jobs);
        jobs.setBounds(0, 0, 1250, 720);

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

        dashboard_side_label2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        dashboard_side_label2.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_side_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_side_label2.setText("ADMIN");
        left_sidebar.add(dashboard_side_label2);
        dashboard_side_label2.setBounds(10, 160, 230, 40);

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

    private void addJob_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addJob_saveMouseClicked
        String category = (String) jobcat.getSelectedItem();
        String addBy = addedby.getText();
        int catID = 0;

        if("".equals(jobcat)){
            JOptionPane.showMessageDialog(null, "Fields required!");
        }else{
            try{
                Connection con = Connect.getConnection();
                Date now = new Date();
                java.sql.Date sqlDate = new java.sql.Date(now.getTime());
                catID = CRUD.getCleaningCatID(con, category);
                int user = CRUD.getUserID(con, admin);
                CRUD.insertJob(con, catID, user);
                JOptionPane.showMessageDialog(null, "Job has been successfully inserted!");
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_addJob_saveMouseClicked

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
    private javax.swing.JButton addJob_save;
    private javax.swing.JTextField addedby;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems1;
    private javax.swing.JPanel additems2;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel additems_form1;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form3;
    private javax.swing.JPanel additems_form4;
    private javax.swing.JPanel additems_form5;
    private javax.swing.JPanel categories;
    private javax.swing.JPanel categories_side;
    private javax.swing.JLabel categories_side_label;
    private javax.swing.JLabel categories_up_label;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_side_label2;
    private javax.swing.JLabel dashboard_up_label;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JComboBox<String> jobcat;
    private javax.swing.JComboBox<String> jobcat1;
    private javax.swing.JPanel jobs;
    private javax.swing.JTabbedPane jobsTab;
    private javax.swing.JTable jobsTable;
    private javax.swing.JPanel jobs_side;
    private javax.swing.JLabel jobs_side_label;
    private javax.swing.JLabel jobs_up_label;
    private javax.swing.JPanel left_sidebar;
    private javax.swing.JPanel logout_side;
    private javax.swing.JLabel logout_side_label;
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton updateItem_save;
    private javax.swing.JButton updateItem_save1;
    private javax.swing.JButton updateJob_save;
    private javax.swing.JTextField updatedby;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitems1;
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
