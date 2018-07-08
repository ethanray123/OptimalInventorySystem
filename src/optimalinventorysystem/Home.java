package optimalinventorysystem;

import MySQL.CRUD;
import MySQL.Connect;
import Entities.Item;
import Entities.ItemType;
import java.text.DateFormat;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static optimalinventorysystem.Login.userid;

public class Home extends javax.swing.JFrame {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    // 5,32,33      -- darkest
    // 15, 74, 74   -- middle
    // 8, 40, 41    -- lightest
    public Home() {
        initComponents();     
        
        try{
            Connection con = Connect.getConnection();
            String username = CRUD.selectUsername(con,userid);
            adminName.setText(username);
        }catch(HeadlessException  | SQLException e){
            System.out.println(e);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }     
        dashboard();
        initializeItemTypeNameList();
        ShowItemsTable();
        showItemTypeTable();
    }
    
    public void dashboard()
    {
        //set bg color when sidebar tab clicked
        dashboard_side.setBackground(new Color(15, 74, 74));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        dashboard.setVisible(true);
        items.setVisible(false);
        jobs.setVisible(false);
        
        // hide and show upper part jPanels
        upper_dashboard_panel.setVisible(true);
        upper_items_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
    }
    
    public void items_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        items_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        items.setVisible(true);
        dashboard.setVisible(false);
        jobs.setVisible(false);
        
        // hide and show upper part jPanels
        upper_items_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_jobs_panel.setVisible(false);
        
    }
    
    public void jobs_sideBar_onclick()
    {
        //set bg color when sidebar tab clicked
        jobs_side.setBackground(new Color(15, 74, 74));
        dashboard_side.setBackground(new Color(8, 40, 41));
        items_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        jobs.setVisible(true);
        dashboard.setVisible(false);
        items.setVisible(false);
        
        // hide and show upper part jPanels
        upper_jobs_panel.setVisible(true);
        upper_dashboard_panel.setVisible(false);
        upper_items_panel.setVisible(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whole = new javax.swing.JPanel();
        right_sidebar = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        dashboard_label = new javax.swing.JLabel();
        items = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tables = new javax.swing.JTabbedPane();
        itemsTablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        iTtable = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemTypeTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTab = new javax.swing.JTabbedPane();
        additemtype = new javax.swing.JPanel();
        additemtype_form = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        typename = new javax.swing.JTextField();
        itemtypedetails = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addItemType_save = new javax.swing.JButton();
        updateitemtype = new javax.swing.JPanel();
        updateitemtype_form = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        newtypename = new javax.swing.JTextField();
        itemtypedetails1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        updateItemType = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        typename3 = new javax.swing.JTextField();
        archiveitemtype = new javax.swing.JPanel();
        archiveitemtype_form = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        typename2 = new javax.swing.JTextField();
        itemtypedetails2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        archiveItemType = new javax.swing.JButton();
        additems = new javax.swing.JPanel();
        additems_form = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        itemqty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addItem_save = new javax.swing.JButton();
        ItemMetricList = new javax.swing.JComboBox<>();
        ItemTypeNameList = new javax.swing.JComboBox<>();
        updateitems = new javax.swing.JPanel();
        additems_form2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        itemName2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        itemqty2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        ItemMetricList2 = new javax.swing.JComboBox<>();
        ItemTypeNameList2 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        newitemname = new javax.swing.JTextField();
        archiveitem = new javax.swing.JPanel();
        additems_form3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        itemName3 = new javax.swing.JTextField();
        Archive = new javax.swing.JButton();
        jobs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jobsTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jobsTab = new javax.swing.JTabbedPane();
        additems2 = new javax.swing.JPanel();
        additems_form4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jobcat = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        addedby = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        addeddate = new javax.swing.JTextField();
        addJob_save = new javax.swing.JButton();
        updateitems1 = new javax.swing.JPanel();
        additems_form5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jobcat1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        updateddate = new javax.swing.JTextField();
        updatedby = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        updateJob_save = new javax.swing.JButton();
        upper_dashboard_panel = new javax.swing.JPanel();
        dashboard_up_label = new javax.swing.JLabel();
        upper_items_panel = new javax.swing.JPanel();
        items_up_label = new javax.swing.JLabel();
        upper_jobs_panel = new javax.swing.JPanel();
        jobs_up_label = new javax.swing.JLabel();
        left_sidebar = new javax.swing.JPanel();
        userimg = new javax.swing.JLabel();
        dashboard_side = new javax.swing.JPanel();
        dashboard_side_label = new javax.swing.JLabel();
        items_side = new javax.swing.JPanel();
        items_side_label = new javax.swing.JLabel();
        jobs_side = new javax.swing.JPanel();
        jobs_side_label = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        category_side = new javax.swing.JPanel();
        category_side_label = new javax.swing.JLabel();
        category_side1 = new javax.swing.JPanel();
        category_side_label1 = new javax.swing.JLabel();
        category_side2 = new javax.swing.JPanel();
        category_side_label2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        whole.setBackground(new java.awt.Color(255, 255, 255));
        whole.setLayout(null);

        right_sidebar.setBackground(new java.awt.Color(5, 32, 33));
        right_sidebar.setPreferredSize(new java.awt.Dimension(1500, 800));
        right_sidebar.setLayout(null);

        dashboard.setBackground(new java.awt.Color(5, 32, 33));
        dashboard.setPreferredSize(new java.awt.Dimension(1500, 800));

        dashboard_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_label.setText("THIS IS DASHBOARD");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(0, 290, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );

        right_sidebar.add(dashboard);
        dashboard.setBounds(0, 0, 800, 710);

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
            .addGroup(itemsTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 666, Short.MAX_VALUE))
        );
        itemsTablePanelLayout.setVerticalGroup(
            itemsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
        );

        Tables.addTab("Items Table", itemsTablePanel);

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
        jScrollPane6.setViewportView(itemTypeTable);

        javax.swing.GroupLayout iTtableLayout = new javax.swing.GroupLayout(iTtable);
        iTtable.setLayout(iTtableLayout);
        iTtableLayout.setHorizontalGroup(
            iTtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iTtableLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 666, Short.MAX_VALUE))
        );
        iTtableLayout.setVerticalGroup(
            iTtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iTtableLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
        );

        Tables.addTab("Item Type Table", iTtable);

        jScrollPane4.setViewportView(Tables);

        additemtype.setBackground(new java.awt.Color(5, 32, 33));

        additemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel7.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TYPE NAME");

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

        jLabel10.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TYPE DETAILS");

        addItemType_save.setBackground(new java.awt.Color(0, 204, 51));
        addItemType_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItemType_save.setForeground(new java.awt.Color(255, 255, 255));
        addItemType_save.setText("SAVE");
        addItemType_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemType_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additemtype_formLayout = new javax.swing.GroupLayout(additemtype_form);
        additemtype_form.setLayout(additemtype_formLayout);
        additemtype_formLayout.setHorizontalGroup(
            additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtype_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addItemType_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typename, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemtypedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        additemtype_formLayout.setVerticalGroup(
            additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtype_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typename, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additemtype_formLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemtypedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addComponent(addItemType_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additemtypeLayout = new javax.swing.GroupLayout(additemtype);
        additemtype.setLayout(additemtypeLayout);
        additemtypeLayout.setHorizontalGroup(
            additemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtypeLayout.createSequentialGroup()
                .addComponent(additemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 896, Short.MAX_VALUE))
        );
        additemtypeLayout.setVerticalGroup(
            additemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemtypeLayout.createSequentialGroup()
                .addComponent(additemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 664, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEM TYPE", additemtype);

        updateitemtype.setBackground(new java.awt.Color(5, 32, 33));

        updateitemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel8.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NEW TYPE NAME");

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

        jLabel12.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TYPE DETAILS");

        updateItemType.setBackground(new java.awt.Color(0, 204, 51));
        updateItemType.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        updateItemType.setForeground(new java.awt.Color(255, 255, 255));
        updateItemType.setText("SAVE");
        updateItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemTypeActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TYPE NAME");

        typename3.setBackground(new java.awt.Color(15, 74, 74));
        typename3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        typename3.setForeground(new java.awt.Color(255, 255, 255));
        typename3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        typename3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        typename3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        typename3.setOpaque(false);

        javax.swing.GroupLayout updateitemtype_formLayout = new javax.swing.GroupLayout(updateitemtype_form);
        updateitemtype_form.setLayout(updateitemtype_formLayout);
        updateitemtype_formLayout.setHorizontalGroup(
            updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateitemtype_formLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(newtypename, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(updateitemtype_formLayout.createSequentialGroup()
                            .addGap(287, 287, 287)
                            .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemtypedetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitemtype_formLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(updateItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateitemtype_formLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(299, Short.MAX_VALUE)))
            .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateitemtype_formLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(typename3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(299, Short.MAX_VALUE)))
        );
        updateitemtype_formLayout.setVerticalGroup(
            updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtype_formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemtypedetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newtypename, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(updateItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateitemtype_formLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(225, Short.MAX_VALUE)))
            .addGroup(updateitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateitemtype_formLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(typename3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(167, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout updateitemtypeLayout = new javax.swing.GroupLayout(updateitemtype);
        updateitemtype.setLayout(updateitemtypeLayout);
        updateitemtypeLayout.setHorizontalGroup(
            updateitemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtypeLayout.createSequentialGroup()
                .addComponent(updateitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 896, Short.MAX_VALUE))
        );
        updateitemtypeLayout.setVerticalGroup(
            updateitemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemtypeLayout.createSequentialGroup()
                .addComponent(updateitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 664, Short.MAX_VALUE))
        );

        itemsTab.addTab("UPDATE ITEM TYPE", updateitemtype);

        archiveitemtype.setBackground(new java.awt.Color(5, 32, 33));

        archiveitemtype_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel9.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TYPE NAME");

        typename2.setBackground(new java.awt.Color(15, 74, 74));
        typename2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        typename2.setForeground(new java.awt.Color(255, 255, 255));
        typename2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        typename2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        typename2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        typename2.setOpaque(false);

        itemtypedetails2.setBackground(new java.awt.Color(15, 74, 74));
        itemtypedetails2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemtypedetails2.setForeground(new java.awt.Color(255, 255, 255));
        itemtypedetails2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemtypedetails2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemtypedetails2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtypedetails2.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TYPE DETAILS");

        archiveItemType.setBackground(new java.awt.Color(0, 204, 51));
        archiveItemType.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        archiveItemType.setForeground(new java.awt.Color(255, 255, 255));
        archiveItemType.setText("ARCHIVE");
        archiveItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveItemTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout archiveitemtype_formLayout = new javax.swing.GroupLayout(archiveitemtype_form);
        archiveitemtype_form.setLayout(archiveitemtype_formLayout);
        archiveitemtype_formLayout.setHorizontalGroup(
            archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(archiveItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                        .addGroup(archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typename2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemtypedetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        archiveitemtype_formLayout.setVerticalGroup(
            archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(archiveitemtype_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typename2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(archiveitemtype_formLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemtypedetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addComponent(archiveItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout archiveitemtypeLayout = new javax.swing.GroupLayout(archiveitemtype);
        archiveitemtype.setLayout(archiveitemtypeLayout);
        archiveitemtypeLayout.setHorizontalGroup(
            archiveitemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtypeLayout.createSequentialGroup()
                .addComponent(archiveitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 896, Short.MAX_VALUE))
        );
        archiveitemtypeLayout.setVerticalGroup(
            archiveitemtypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemtypeLayout.createSequentialGroup()
                .addComponent(archiveitemtype_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 664, Short.MAX_VALUE))
        );

        itemsTab.addTab("ARCHIVE ITEM TYPE", archiveitemtype);

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

        addItem_save.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItem_save.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save.setText("SAVE");
        addItem_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItem_saveActionPerformed(evt);
            }
        });

        ItemMetricList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "units", "pcs", "sets" }));
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

        javax.swing.GroupLayout additems_formLayout = new javax.swing.GroupLayout(additems_form);
        additems_form.setLayout(additems_formLayout);
        additems_formLayout.setHorizontalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ItemMetricList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemname, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(addItem_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ItemTypeNameList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(ItemMetricList, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(ItemTypeNameList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additemsLayout = new javax.swing.GroupLayout(additems);
        additems.setLayout(additemsLayout);
        additemsLayout.setHorizontalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 896, Short.MAX_VALUE))
        );
        additemsLayout.setVerticalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 664, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEMS", additems);

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
        Update.setText("SAVE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        ItemMetricList2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Units", "Pcs", "Sets" }));
        ItemMetricList2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemMetricList2ActionPerformed(evt);
            }
        });

        ItemTypeNameList2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypeNameList2ActionPerformed(evt);
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

        javax.swing.GroupLayout additems_form2Layout = new javax.swing.GroupLayout(additems_form2);
        additems_form2.setLayout(additems_form2Layout);
        additems_form2Layout.setHorizontalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemName2)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(ItemMetricList2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(additems_form2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newitemname))))
                    .addComponent(ItemTypeNameList2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
        );
        additems_form2Layout.setVerticalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemName2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form2Layout.createSequentialGroup()
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ItemMetricList2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(ItemTypeNameList2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout updateitemsLayout = new javax.swing.GroupLayout(updateitems);
        updateitems.setLayout(updateitemsLayout);
        updateitemsLayout.setHorizontalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 622, Short.MAX_VALUE))
        );
        updateitemsLayout.setVerticalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 674, Short.MAX_VALUE))
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

        Archive.setBackground(new java.awt.Color(0, 204, 51));
        Archive.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        Archive.setForeground(new java.awt.Color(255, 255, 255));
        Archive.setText("ARCHIVE");
        Archive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchiveActionPerformed(evt);
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
                .addGap(160, 160, 160)
                .addComponent(Archive, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        additems_form3Layout.setVerticalGroup(
            additems_form3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemName3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(Archive, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout archiveitemLayout = new javax.swing.GroupLayout(archiveitem);
        archiveitem.setLayout(archiveitemLayout);
        archiveitemLayout.setHorizontalGroup(
            archiveitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemLayout.createSequentialGroup()
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 896, Short.MAX_VALUE))
        );
        archiveitemLayout.setVerticalGroup(
            archiveitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archiveitemLayout.createSequentialGroup()
                .addComponent(additems_form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 664, Short.MAX_VALUE))
        );

        itemsTab.addTab("ARCHIVE ITEMS", archiveitem);

        jScrollPane1.setViewportView(itemsTab);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsLayout.createSequentialGroup()
                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane4.getAccessibleContext().setAccessibleName("");

        right_sidebar.add(items);
        items.setBounds(0, 0, 1500, 700);

        jobs.setBackground(new java.awt.Color(5, 32, 33));

        jobsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JOB ID", "JOB CATEGORY", "ADDED / UPDATED BY", "ADDED / UPDATED DATE"
            }
        ));
        jScrollPane5.setViewportView(jobsTable);

        additems2.setBackground(new java.awt.Color(5, 32, 33));

        additems_form4.setBackground(new java.awt.Color(15, 74, 74));

        jLabel11.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JOB CATEGORY");

        jobcat.setBackground(new java.awt.Color(15, 74, 74));
        jobcat.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcat.setForeground(new java.awt.Color(255, 255, 255));
        jobcat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jobcat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jobcat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jobcat.setOpaque(false);

        jLabel40.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ADDED BY");

        addedby.setEditable(false);
        addedby.setBackground(new java.awt.Color(15, 74, 74));
        addedby.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addedby.setForeground(new java.awt.Color(255, 255, 255));
        addedby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addedby.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addedby.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addedby.setOpaque(false);

        jLabel38.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("ADDED DATE");

        addeddate.setEditable(false);
        addeddate.setBackground(new java.awt.Color(15, 74, 74));
        addeddate.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addeddate.setForeground(new java.awt.Color(255, 255, 255));
        addeddate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addeddate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addeddate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addeddate.setOpaque(false);

        addJob_save.setBackground(new java.awt.Color(0, 204, 51));
        addJob_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addJob_save.setForeground(new java.awt.Color(255, 255, 255));
        addJob_save.setText("SAVE");
        addJob_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJob_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_form4Layout = new javax.swing.GroupLayout(additems_form4);
        additems_form4.setLayout(additems_form4Layout);
        additems_form4Layout.setHorizontalGroup(
            additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobcat, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addeddate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        additems_form4Layout.setVerticalGroup(
            additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form4Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jobcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form4Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addeddate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout additems2Layout = new javax.swing.GroupLayout(additems2);
        additems2.setLayout(additems2Layout);
        additems2Layout.setHorizontalGroup(
            additems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems2Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(additems_form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        additems2Layout.setVerticalGroup(
            additems2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(additems_form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jobsTab.addTab("ADD ITEMS", additems2);

        updateitems1.setBackground(new java.awt.Color(5, 32, 33));

        additems_form5.setBackground(new java.awt.Color(15, 74, 74));

        jLabel41.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("JOB CATEGORY");

        jobcat1.setBackground(new java.awt.Color(15, 74, 74));
        jobcat1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jobcat1.setForeground(new java.awt.Color(255, 255, 255));
        jobcat1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jobcat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jobcat1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jobcat1.setOpaque(false);

        jLabel42.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("UPDATED DATE");

        updateddate.setBackground(new java.awt.Color(15, 74, 74));
        updateddate.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updateddate.setForeground(new java.awt.Color(255, 255, 255));
        updateddate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        updateddate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        updateddate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updateddate.setOpaque(false);

        updatedby.setBackground(new java.awt.Color(15, 74, 74));
        updatedby.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        updatedby.setForeground(new java.awt.Color(255, 255, 255));
        updatedby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        updatedby.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        updatedby.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updatedby.setOpaque(false);

        jLabel44.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("UPDATED BY");

        updateJob_save.setBackground(new java.awt.Color(0, 204, 51));
        updateJob_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        updateJob_save.setForeground(new java.awt.Color(255, 255, 255));
        updateJob_save.setText("SAVE");
        updateJob_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJob_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_form5Layout = new javax.swing.GroupLayout(additems_form5);
        additems_form5.setLayout(additems_form5Layout);
        additems_form5Layout.setHorizontalGroup(
            additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobcat1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updatedby, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        additems_form5Layout.setVerticalGroup(
            additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additems_form5Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additems_form5Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jobcat1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(additems_form5Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updatedby, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(additems_form5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout updateitems1Layout = new javax.swing.GroupLayout(updateitems1);
        updateitems1.setLayout(updateitems1Layout);
        updateitems1Layout.setHorizontalGroup(
            updateitems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitems1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(additems_form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        updateitems1Layout.setVerticalGroup(
            updateitems1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitems1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(additems_form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jobsTab.addTab("UPDATE ITEMS", updateitems1);

        jScrollPane7.setViewportView(jobsTab);

        javax.swing.GroupLayout jobsLayout = new javax.swing.GroupLayout(jobs);
        jobs.setLayout(jobsLayout);
        jobsLayout.setHorizontalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobsLayout.createSequentialGroup()
                .addGroup(jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jobsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jobsLayout.setVerticalGroup(
            jobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobsLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        right_sidebar.add(jobs);
        jobs.setBounds(0, 0, 800, 710);

        whole.add(right_sidebar);
        right_sidebar.setBounds(250, 80, 1500, 800);

        upper_dashboard_panel.setBackground(new java.awt.Color(15, 74, 74));
        upper_dashboard_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102)));
        upper_dashboard_panel.setPreferredSize(new java.awt.Dimension(1500, 800));
        upper_dashboard_panel.setLayout(null);

        dashboard_up_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashboard_up_label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_up_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_up_label.setText("OPTIMAL  /  DASHBOARD");
        upper_dashboard_panel.add(dashboard_up_label);
        dashboard_up_label.setBounds(30, 10, 1050, 60);

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
        items_up_label.setBounds(30, 10, 1500, 60);

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
        upper_jobs_panel.setBounds(0, 0, 1050, 80);

        left_sidebar.setBackground(new java.awt.Color(8, 40, 41));
        left_sidebar.setLayout(null);
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
            .addComponent(jobs_side_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        left_sidebar.add(jobs_side);
        jobs_side.setBounds(0, 400, 250, 60);

        adminName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminName.setText("ADMIN");
        left_sidebar.add(adminName);
        adminName.setBounds(10, 160, 230, 40);

        category_side.setBackground(new java.awt.Color(8, 40, 41));
        category_side.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_sideMouseClicked(evt);
            }
        });

        category_side_label.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        category_side_label.setForeground(new java.awt.Color(255, 255, 255));
        category_side_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        category_side_label.setText("CATEGORIES");

        javax.swing.GroupLayout category_sideLayout = new javax.swing.GroupLayout(category_side);
        category_side.setLayout(category_sideLayout);
        category_sideLayout.setHorizontalGroup(
            category_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(category_side_label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        category_sideLayout.setVerticalGroup(
            category_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, category_sideLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(category_side_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        left_sidebar.add(category_side);
        category_side.setBounds(0, 440, 250, 60);

        category_side1.setBackground(new java.awt.Color(8, 40, 41));
        category_side1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_side1MouseClicked(evt);
            }
        });

        category_side_label1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        category_side_label1.setForeground(new java.awt.Color(255, 255, 255));
        category_side_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        category_side_label1.setText("USERS");

        javax.swing.GroupLayout category_side1Layout = new javax.swing.GroupLayout(category_side1);
        category_side1.setLayout(category_side1Layout);
        category_side1Layout.setHorizontalGroup(
            category_side1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(category_side1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(category_side1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(category_side_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        category_side1Layout.setVerticalGroup(
            category_side1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(category_side1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(category_side1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(category_side_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        left_sidebar.add(category_side1);
        category_side1.setBounds(0, 500, 250, 60);

        category_side2.setBackground(new java.awt.Color(8, 40, 41));
        category_side2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_side2MouseClicked(evt);
            }
        });

        category_side_label2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        category_side_label2.setForeground(new java.awt.Color(255, 255, 255));
        category_side_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        category_side_label2.setText("LOGOUT");

        javax.swing.GroupLayout category_side2Layout = new javax.swing.GroupLayout(category_side2);
        category_side2.setLayout(category_side2Layout);
        category_side2Layout.setHorizontalGroup(
            category_side2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(category_side2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(category_side2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(category_side_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        category_side2Layout.setVerticalGroup(
            category_side2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(category_side2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(category_side2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(category_side_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        left_sidebar.add(category_side2);
        category_side2.setBounds(0, 540, 250, 60);

        whole.add(left_sidebar);
        left_sidebar.setBounds(0, 80, 250, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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

    private void addItem_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItem_saveActionPerformed
        
        if(!itemname.getText().isEmpty() && !itemqty.getText().isEmpty()){
            String itemName = itemname.getText();
            int itemQty = Integer.parseInt(itemqty.getText());
            String itemTypeName = ItemTypeNameList.getSelectedItem().toString();             
            String itemMetric = ItemMetricList.getSelectedItem().toString();
                  
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
            String itemTypeName = ItemTypeNameList2.getSelectedItem().toString();          
            String itemMetric = ItemMetricList2.getSelectedItem().toString();
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
                            ItemMetricList2.setSelectedIndex(0);
                            ItemTypeNameList2.setSelectedIndex(0);
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

    private void addJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addJob_saveActionPerformed

    private void updateJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateJob_saveActionPerformed

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
                    ItemTypeNameList.addItem(typeName);
                    ItemTypeNameList2.addItem(typeName);
                    JOptionPane.showMessageDialog(null, "Successfully Added!");
                    
                }
              
            }catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Input all fields");
        }
    }//GEN-LAST:event_addItemType_saveActionPerformed

    private void ItemMetricListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMetricListActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ItemMetricListActionPerformed

    private void ItemTypeNameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeNameListActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ItemTypeNameListActionPerformed

    private void ItemMetricList2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMetricList2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemMetricList2ActionPerformed

    private void ItemTypeNameList2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeNameList2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeNameList2ActionPerformed

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

    private void category_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_sideMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_category_sideMouseClicked

    private void category_side1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_side1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_category_side1MouseClicked

    private void category_side2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_side2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_category_side2MouseClicked

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
        ItemMetricList2.setSelectedIndex(index);
        //End of setting value for ItemMetricList comboBox
        
        //Setting value for ItemTypeNameList comboBox     
        int type = (int) model.getValueAt(i,4);
        for(x=0; x< ItemTypeNameList.getItemCount();x++){
            if(type == x){
                index = x-1;
            }
        }

        ItemTypeNameList.setSelectedIndex(index);
        ItemTypeNameList2.setSelectedIndex(index);
       //End of setting value for ItemTypeNameList comboBox
    }//GEN-LAST:event_itemsTableMouseClicked

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

    private void itemName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemName3ActionPerformed

    private void itemName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemName2ActionPerformed

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
                         CRUD.updateItemType(con, typeName, newTypeName,typeDetails, userid);

                        ResultSet rs = CRUD.selectItemTypeInfoUsingTypeName(con, typeName);

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
                        //Removing item type name from combobox
                       // ItemTypeNameList.removeItem(typeName);
                       // ItemTypeNameList2.removeItem(typeName);
                        //Adding item type name to combobox
                        ItemTypeNameList.removeAllItems();
                        initializeItemTypeNameList();
                        JOptionPane.showMessageDialog(null, "Update Item Type Successful!");
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
                                ItemTypeNameList2.removeItem(typeName);
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

    private void newitemnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newitemnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newitemnameActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    public void initializeItemTypeNameList(){
        try {
            Connection con = Connect.getConnection();
            ResultSet rs = CRUD.selectItemNameFromItemType(con);
            while(rs.next()){
                ItemTypeNameList.addItem(rs.getString("type_name"));
                ItemTypeNameList2.addItem(rs.getString("type_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ITEMS TABLE
    public ArrayList<Item> getItemList(){
        ArrayList<Item> itemList = new ArrayList<>();
        Connection con = Connect.getConnection();
        try{
            ResultSet rs = CRUD.selectItemInfo(con);
            
            Item it;
            while(rs.next()){
                String addedBy = CRUD.selectFullName(con, rs.getInt("added_by"));
                String updatedBy = CRUD.selectFullName(con, rs.getInt("updated_by"));
                it = new Item(
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
                itemList.add(it);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return itemList;
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
    // END OF ITEMS TABLE 
    
    //ITEM TYPE TABLE
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Archive;
    private javax.swing.JComboBox<String> ItemMetricList;
    private javax.swing.JComboBox<String> ItemMetricList2;
    private javax.swing.JComboBox<String> ItemTypeNameList;
    private javax.swing.JComboBox<String> ItemTypeNameList2;
    private javax.swing.JTabbedPane Tables;
    private javax.swing.JButton Update;
    private javax.swing.JButton addItemType_save;
    private javax.swing.JButton addItem_save;
    private javax.swing.JButton addJob_save;
    private javax.swing.JTextField addedby;
    private javax.swing.JTextField addeddate;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems2;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form3;
    private javax.swing.JPanel additems_form4;
    private javax.swing.JPanel additems_form5;
    private javax.swing.JPanel additemtype;
    private javax.swing.JPanel additemtype_form;
    private javax.swing.JLabel adminName;
    private javax.swing.JButton archiveItemType;
    private javax.swing.JPanel archiveitem;
    private javax.swing.JPanel archiveitemtype;
    private javax.swing.JPanel archiveitemtype_form;
    private javax.swing.JPanel category_side;
    private javax.swing.JPanel category_side1;
    private javax.swing.JPanel category_side2;
    private javax.swing.JLabel category_side_label;
    private javax.swing.JLabel category_side_label1;
    private javax.swing.JLabel category_side_label2;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JPanel iTtable;
    private javax.swing.JTextField itemName2;
    private javax.swing.JTextField itemName3;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jobcat;
    private javax.swing.JTextField jobcat1;
    private javax.swing.JPanel jobs;
    private javax.swing.JTabbedPane jobsTab;
    private javax.swing.JTable jobsTable;
    private javax.swing.JPanel jobs_side;
    private javax.swing.JLabel jobs_side_label;
    private javax.swing.JLabel jobs_up_label;
    private javax.swing.JPanel left_sidebar;
    private javax.swing.JTextField newitemname;
    private javax.swing.JTextField newtypename;
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JTextField typename;
    private javax.swing.JTextField typename2;
    private javax.swing.JTextField typename3;
    private javax.swing.JButton updateItemType;
    private javax.swing.JButton updateJob_save;
    private javax.swing.JTextField updatedby;
    private javax.swing.JTextField updateddate;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitems1;
    private javax.swing.JPanel updateitemtype;
    private javax.swing.JPanel updateitemtype_form;
    private javax.swing.JPanel upper_dashboard_panel;
    private javax.swing.JPanel upper_items_panel;
    private javax.swing.JPanel upper_jobs_panel;
    private javax.swing.JLabel userimg;
    private javax.swing.JPanel whole;
    // End of variables declaration//GEN-END:variables
}
