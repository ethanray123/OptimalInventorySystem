
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
        addItem_save2 = new javax.swing.JButton();
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
                .addContainerGap(350, Short.MAX_VALUE)
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
                .addGroup(additems_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemtype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addItem_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout additemsLayout = new javax.swing.GroupLayout(additems);
        additems.setLayout(additemsLayout);
        additemsLayout.setHorizontalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, additemsLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        additemsLayout.setVerticalGroup(
            additemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additemsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(additems_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        itemsTab.addTab("ADD ITEMS", additems);

        updateitems.setBackground(new java.awt.Color(5, 32, 33));

        additems_form2.setBackground(new java.awt.Color(15, 74, 74));

        jLabel26.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel27.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel28.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
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

        jLabel29.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ITEM QUANTITY");

        addItem_save2.setBackground(new java.awt.Color(0, 204, 51));
        addItem_save2.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addItem_save2.setForeground(new java.awt.Color(255, 255, 255));
        addItem_save2.setText("SAVE");
        addItem_save2.setBorder(null);
        addItem_save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItem_save2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additems_form2Layout = new javax.swing.GroupLayout(additems_form2);
        additems_form2.setLayout(additems_form2Layout);
        additems_form2Layout.setHorizontalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addItem_save2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addComponent(addItem_save2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout updateitemsLayout = new javax.swing.GroupLayout(updateitems);
        updateitems.setLayout(updateitemsLayout);
        updateitemsLayout.setHorizontalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateitemsLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        updateitemsLayout.setVerticalGroup(
            updateitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateitemsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(additems_form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        itemsTab.addTab("UPDATE ITEMS", updateitems);

        jScrollPane1.setViewportView(itemsTab);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsLayout.createSequentialGroup()
                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(itemsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        right_sidebar.add(items);
        items.setBounds(0, 0, 800, 710);

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
        addJob_save.setBorder(null);
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
        updateJob_save.setBorder(null);
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
        right_sidebar.setBounds(250, 80, 800, 710);

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
        left_sidebar.setBounds(0, 80, 250, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
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

    private void addItem_save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItem_save2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addItem_save2ActionPerformed

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
    private javax.swing.JButton addItem_save1;
    private javax.swing.JButton addItem_save2;
    private javax.swing.JButton addItem_save3;
    private javax.swing.JButton addJob_save;
    private javax.swing.JTextField addedby;
    private javax.swing.JTextField addeddate;
    private javax.swing.JPanel additems;
    private javax.swing.JPanel additems1;
    private javax.swing.JPanel additems2;
    private javax.swing.JPanel additems_form;
    private javax.swing.JPanel additems_form1;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form3;
    private javax.swing.JPanel additems_form4;
    private javax.swing.JPanel additems_form5;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_side_label2;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JTextField itemmetric;
    private javax.swing.JTextField itemmetric1;
    private javax.swing.JTextField itemmetric2;
    private javax.swing.JTextField itemmetric3;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemname1;
    private javax.swing.JTextField itemname2;
    private javax.swing.JTextField itemname3;
    private javax.swing.JTextField itemqty;
    private javax.swing.JTextField itemqty1;
    private javax.swing.JTextField itemqty2;
    private javax.swing.JTextField itemqty3;
    private javax.swing.JPanel items;
    private javax.swing.JTabbedPane itemsTab;
    private javax.swing.JTabbedPane itemsTab1;
    private javax.swing.JTable itemsTable;
    private javax.swing.JPanel items_side;
    private javax.swing.JLabel items_side_label;
    private javax.swing.JLabel items_up_label;
    private javax.swing.JTextField itemtype;
    private javax.swing.JTextField itemtype1;
    private javax.swing.JTextField itemtype2;
    private javax.swing.JTextField itemtype3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton updateJob_save;
    private javax.swing.JTextField updatedby;
    private javax.swing.JTextField updateddate;
    private javax.swing.JPanel updateitems;
    private javax.swing.JPanel updateitems1;
    private javax.swing.JPanel upper_dashboard_panel;
    private javax.swing.JPanel upper_items_panel;
    private javax.swing.JPanel upper_jobs_panel;
    private javax.swing.JLabel userimg;
    private javax.swing.JPanel whole;
    // End of variables declaration//GEN-END:variables
}
