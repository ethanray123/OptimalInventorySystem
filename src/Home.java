
import java.awt.Color;

public class Home extends javax.swing.JFrame {
    
    // 5,32,33      -- darkest
    // 15, 74, 74   -- middle
    // 8, 40, 41    -- lightest
    public Home() {
        initComponents();
        dashboard();
    }
    
    public void dashboard()
    {
        //set bg color when sidebar tab clicked
        dashboard_side.setBackground(new Color(15, 74, 74));
        items_side.setBackground(new Color(8, 40, 41));
        jobs_side.setBackground(new Color(8, 40, 41));
        
        // hide and show right side jPanels
        dashboard.setVisible(true);
        itemsTab.setVisible(false);
        jobsTab.setVisible(false);
        
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
        itemsTab.setVisible(true);
        dashboard.setVisible(false);
        jobsTab.setVisible(false);
        
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
        jobsTab.setVisible(true);
        dashboard.setVisible(false);
        itemsTab.setVisible(false);
        
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
        itemsTab = new javax.swing.JTabbedPane();
        viewitems = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewItemsTable = new javax.swing.JTable();
        additems = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        updateItem_save = new javax.swing.JButton();
        updateitems_form = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        itemname1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        itemmetric1 = new javax.swing.JTextField();
        itemtype1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        itemqty1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jobsTab = new javax.swing.JTabbedPane();
        viewjobs = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addjobs = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        addjobs_form = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        itemcat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addeddate = new javax.swing.JTextField();
        addedby = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        addJob_save = new javax.swing.JButton();
        updatejobs = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        addjobs_form1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        itemcat1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        addeddate1 = new javax.swing.JTextField();
        addedby1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
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
        dashboard_side_label2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        whole.setBackground(new java.awt.Color(255, 255, 255));
        whole.setLayout(null);

        right_sidebar.setBackground(new java.awt.Color(5, 32, 33));
        right_sidebar.setLayout(null);

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
                .addGap(0, 290, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(dashboard_label, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );

        right_sidebar.add(dashboard);
        dashboard.setBounds(0, 0, 800, 660);

        viewitems.setBackground(new java.awt.Color(5, 32, 33));

        jLabel1.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIEW ITEMS");

        viewItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "QUANTITY", "METRIC", "TYPE"
            }
        ));
        jScrollPane1.setViewportView(viewItemsTable);

        javax.swing.GroupLayout viewitemsLayout = new javax.swing.GroupLayout(viewitems);
        viewitems.setLayout(viewitemsLayout);
        viewitemsLayout.setHorizontalGroup(
            viewitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewitemsLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(viewitemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewitemsLayout.setVerticalGroup(
            viewitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewitemsLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        itemsTab.addTab("VIEW ITEMS", viewitems);

        additems.setBackground(new java.awt.Color(5, 32, 33));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADD ITEMS");

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

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ITEM QUANTITY");

        javax.swing.GroupLayout additems_formLayout = new javax.swing.GroupLayout(additems_form);
        additems_form.setLayout(additems_formLayout);
        additems_formLayout.setHorizontalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(itemmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(itemtype, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        additems_formLayout.setVerticalGroup(
            additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_formLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        addItem_save.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItem_save.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save.setText("SAVE");
        addItem_save.setBorder(null);
        addItem_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItem_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additemsLayout = new javax.swing.GroupLayout(additems);
        additems.setLayout(additemsLayout);
        additemsLayout.setHorizontalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additemsLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        additemsLayout.setVerticalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEMS", additems);

        updateitems.setBackground(new java.awt.Color(5, 32, 33));

        updateItem_save.setBackground(new java.awt.Color(0, 204, 51));
        updateItem_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        updateItem_save.setForeground(new java.awt.Color(255, 255, 255));
        updateItem_save.setText("SAVE");
        updateItem_save.setBorder(null);
        updateItem_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItem_saveActionPerformed(evt);
            }
        });

        updateitems_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel7.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel9.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel10.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ITEM QUANTITY");

        javax.swing.GroupLayout updateitems_formLayout = new javax.swing.GroupLayout(updateitems_form);
        updateitems_form.setLayout(updateitems_formLayout);
        updateitems_formLayout.setHorizontalGroup(
            updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitems_formLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(itemmetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemname1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(itemtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        updateitems_formLayout.setVerticalGroup(
            updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitems_formLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemname1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateitems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jLabel11.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADD ITEMS");

        javax.swing.GroupLayout updateitemsLayout = new javax.swing.GroupLayout(updateitems);
        updateitems.setLayout(updateitemsLayout);
        updateitemsLayout.setHorizontalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitemsLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateitems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        updateitemsLayout.setVerticalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(updateitems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(updateItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        itemsTab.addTab("UPDATE ITEMS", updateitems);

        right_sidebar.add(itemsTab);
        itemsTab.setBounds(0, 0, 800, 660);

        viewjobs.setBackground(new java.awt.Color(5, 32, 33));

        jLabel12.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("VIEW JOBS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JOB ID", "JOB CATEGORY"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout viewjobsLayout = new javax.swing.GroupLayout(viewjobs);
        viewjobs.setLayout(viewjobsLayout);
        viewjobsLayout.setHorizontalGroup(
            viewjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewjobsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(viewjobsLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewjobsLayout.setVerticalGroup(
            viewjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewjobsLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jobsTab.addTab("VIEW JOBS", viewjobs);

        addjobs.setBackground(new java.awt.Color(5, 32, 33));

        jLabel13.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ADD JOBS");

        addjobs_form.setBackground(new java.awt.Color(15, 74, 74));

        jLabel14.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ITEM CATEGORY");

        itemcat.setBackground(new java.awt.Color(15, 74, 74));
        itemcat.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemcat.setForeground(new java.awt.Color(255, 255, 255));
        itemcat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemcat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemcat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemcat.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ADDED DATE");

        addeddate.setEditable(false);
        addeddate.setBackground(new java.awt.Color(15, 74, 74));
        addeddate.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addeddate.setForeground(new java.awt.Color(255, 255, 255));
        addeddate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addeddate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addeddate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addeddate.setOpaque(false);

        addedby.setEditable(false);
        addedby.setBackground(new java.awt.Color(15, 74, 74));
        addedby.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addedby.setForeground(new java.awt.Color(255, 255, 255));
        addedby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addedby.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addedby.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addedby.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ADDED BY");

        javax.swing.GroupLayout addjobs_formLayout = new javax.swing.GroupLayout(addjobs_form);
        addjobs_form.setLayout(addjobs_formLayout);
        addjobs_formLayout.setHorizontalGroup(
            addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjobs_formLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addeddate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemcat, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        addjobs_formLayout.setVerticalGroup(
            addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjobs_formLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addjobs_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addeddate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        addJob_save.setBackground(new java.awt.Color(0, 204, 51));
        addJob_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addJob_save.setForeground(new java.awt.Color(255, 255, 255));
        addJob_save.setText("SAVE");
        addJob_save.setBorder(null);
        addJob_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJob_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addjobsLayout = new javax.swing.GroupLayout(addjobs);
        addjobs.setLayout(addjobsLayout);
        addjobsLayout.setHorizontalGroup(
            addjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addjobsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addjobsLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(addjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addjobs_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        addjobsLayout.setVerticalGroup(
            addjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjobsLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(addjobs_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(addJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jobsTab.addTab("ADD JOB", addjobs);

        updatejobs.setBackground(new java.awt.Color(5, 32, 33));

        jLabel16.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("UPDATE JOBS");

        addjobs_form1.setBackground(new java.awt.Color(15, 74, 74));

        jLabel18.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ITEM CATEGORY");

        itemcat1.setBackground(new java.awt.Color(15, 74, 74));
        itemcat1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        itemcat1.setForeground(new java.awt.Color(255, 255, 255));
        itemcat1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemcat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        itemcat1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemcat1.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ADDED DATE");

        addeddate1.setEditable(false);
        addeddate1.setBackground(new java.awt.Color(15, 74, 74));
        addeddate1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addeddate1.setForeground(new java.awt.Color(255, 255, 255));
        addeddate1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addeddate1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addeddate1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addeddate1.setOpaque(false);

        addedby1.setEditable(false);
        addedby1.setBackground(new java.awt.Color(15, 74, 74));
        addedby1.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        addedby1.setForeground(new java.awt.Color(255, 255, 255));
        addedby1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addedby1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        addedby1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addedby1.setOpaque(false);

        jLabel20.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ADDED BY");

        javax.swing.GroupLayout addjobs_form1Layout = new javax.swing.GroupLayout(addjobs_form1);
        addjobs_form1.setLayout(addjobs_form1Layout);
        addjobs_form1Layout.setHorizontalGroup(
            addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjobs_form1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addeddate1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemcat1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addedby1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        addjobs_form1Layout.setVerticalGroup(
            addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjobs_form1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addjobs_form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemcat1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addedby1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addeddate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        updateJob_save.setBackground(new java.awt.Color(0, 204, 51));
        updateJob_save.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        updateJob_save.setForeground(new java.awt.Color(255, 255, 255));
        updateJob_save.setText("SAVE");
        updateJob_save.setBorder(null);
        updateJob_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJob_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updatejobsLayout = new javax.swing.GroupLayout(updatejobs);
        updatejobs.setLayout(updatejobsLayout);
        updatejobsLayout.setHorizontalGroup(
            updatejobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatejobsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(updatejobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatejobsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(updatejobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addjobs_form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGap(12, 12, 12))
        );
        updatejobsLayout.setVerticalGroup(
            updatejobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatejobsLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(addjobs_form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(updateJob_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jobsTab.addTab("UPDATE JOB", updatejobs);

        right_sidebar.add(jobsTab);
        jobsTab.setBounds(0, 0, 800, 660);

        whole.add(right_sidebar);
        right_sidebar.setBounds(250, 80, 800, 660);

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
        upper_dashboard_panel.setBounds(0, 0, 1050, 80);

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
        upper_items_panel.setBounds(0, 0, 1050, 80);

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

        userimg.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem-development\\img\\team.png")); // NOI18N
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
        dashboard_side.setBounds(0, 280, 250, 60);

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
        items_side.setBounds(0, 340, 250, 60);

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
                .addComponent(jobs_side_label, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_sidebar.add(jobs_side);
        jobs_side.setBounds(0, 400, 250, 60);

        dashboard_side_label2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        dashboard_side_label2.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_side_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard_side_label2.setText("ADMIN");
        left_sidebar.add(dashboard_side_label2);
        dashboard_side_label2.setBounds(10, 160, 230, 40);

        whole.add(left_sidebar);
        left_sidebar.setBounds(0, 80, 250, 660);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_addItem_saveActionPerformed

    private void updateItem_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItem_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateItem_saveActionPerformed

    private void addJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addJob_saveActionPerformed

    private void updateJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateJob_saveActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem_save;
    private javax.swing.JButton addJob_save;
    private javax.swing.JTextField addedby;
    private javax.swing.JTextField addedby1;
    private javax.swing.JTextField addeddate;
    private javax.swing.JTextField addeddate1;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel addjobs;
    private javax.swing.JPanel addjobs_form;
    private javax.swing.JPanel addjobs_form1;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_side_label2;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JTextField itemcat;
    private javax.swing.JTextField itemcat1;
    private javax.swing.JTextField itemmetric;
    private javax.swing.JTextField itemmetric1;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemname1;
    private javax.swing.JTextField itemqty;
    private javax.swing.JTextField itemqty1;
    private javax.swing.JTabbedPane itemsTab;
    private javax.swing.JPanel items_side;
    private javax.swing.JLabel items_side_label;
    private javax.swing.JLabel items_up_label;
    private javax.swing.JTextField itemtype;
    private javax.swing.JTextField itemtype1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane jobsTab;
    private javax.swing.JPanel jobs_side;
    private javax.swing.JLabel jobs_side_label;
    private javax.swing.JLabel jobs_up_label;
    private javax.swing.JPanel left_sidebar;
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton updateItem_save;
    private javax.swing.JButton updateJob_save;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitems_form;
    private javax.swing.JPanel updatejobs;
    private javax.swing.JPanel upper_dashboard_panel;
    private javax.swing.JPanel upper_items_panel;
    private javax.swing.JPanel upper_jobs_panel;
    private javax.swing.JLabel userimg;
    private javax.swing.JTable viewItemsTable;
    private javax.swing.JPanel viewitems;
    private javax.swing.JPanel viewjobs;
    private javax.swing.JPanel whole;
    // End of variables declaration//GEN-END:variables
}
