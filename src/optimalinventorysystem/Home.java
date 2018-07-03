package optimalinventorysystem;


import Entities.Category;
import Entities.User;
import Hash.HashPassword;
import MySQL.CRUD;
import MySQL.Connect;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static optimalinventorysystem.Login.userid;

public class Home extends javax.swing.JFrame {
    int userEditID = -1;
    int categoryEditID = -1;
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
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        dashboard();
        Show_CategoriesTable();
        Show_UsersTable();
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
        categories_side.setBackground(new Color(8, 40, 41));
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
        categories_side.setBackground(new Color(15, 74, 74));
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
        categories_side.setBackground(new Color(8, 40, 41));
        
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
    
    public ArrayList<User> getUserList()
    {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectUsersInfo(con);
            User user;
            while(rs.next())
            {
                user = new User(rs.getInt("user_id"),rs.getString("username"),
                        rs.getString("full_name"),rs.getInt("added_by"),
                        rs.getDate("added_date"),rs.getInt("updated_by"),
                        rs.getDate("updated_date"));
                userList.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userList;
    }
    
    //show data in table
    
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
    
    public ArrayList<Category> getCategoryList()
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        Connection con = Connect.getConnection();
        
        try{
            ResultSet rs = CRUD.selectCategoriesInfo(con);
            Category category;
            while(rs.next())
            {
                category = new Category(rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getInt("added_by"),
                        rs.getDate("added_date"),rs.getInt("updated_by"),
                        rs.getDate("updated_date"));
                categoryList.add(category);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
    
    //show data in table
    
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
        }
    }

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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whole = new javax.swing.JPanel();
        right_sidebar = new javax.swing.JPanel();
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
        addCategoryItemBtn = new javax.swing.JButton();
        itemDropdown = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        removeCategoryItemBtn = new javax.swing.JButton();
        categoryEditLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        removeCategoryItemBtn1 = new javax.swing.JButton();
        categoryItemEditLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        dashboard = new javax.swing.JPanel();
        dashboard_label = new javax.swing.JLabel();
        dashboard_label1 = new javax.swing.JLabel();
        dashboard_label4 = new javax.swing.JLabel();
        dashboard_label5 = new javax.swing.JLabel();
        dashboard_label6 = new javax.swing.JLabel();
        items = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
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
        whole.setLayout(null);

        right_sidebar.setBackground(new java.awt.Color(5, 32, 33));
        right_sidebar.setLayout(null);

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

        categories.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 820, 350));

        categoryItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity"
            }
        ));
        jScrollPane6.setViewportView(categoryItemTable);
        if (categoryItemTable.getColumnModel().getColumnCount() > 0) {
            categoryItemTable.getColumnModel().getColumn(0).setResizable(false);
            categoryItemTable.getColumnModel().getColumn(1).setResizable(false);
            categoryItemTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        categories.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 390, 350));

        additems_form1.setBackground(new java.awt.Color(15, 74, 74));
        additems_form1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryNameField.setBackground(new java.awt.Color(15, 74, 74));
        categoryNameField.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        categoryNameField.setForeground(new java.awt.Color(255, 255, 255));
        categoryNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        categoryNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        categoryNameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        categoryNameField.setOpaque(false);
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

        categoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        additems_form1.add(categoryDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, 41));
        additems_form1.add(itemQuantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 42, 41));

        addCategoryItemBtn.setBackground(new java.awt.Color(0, 204, 51));
        addCategoryItemBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        addCategoryItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addCategoryItemBtn.setText("ADD");
        addCategoryItemBtn.setBorder(null);
        addCategoryItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryItemBtnActionPerformed(evt);
            }
        });
        additems_form1.add(addCategoryItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 127, 42));

        itemDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        removeCategoryItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryItemBtnActionPerformed(evt);
            }
        });
        additems_form1.add(removeCategoryItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 127, 42));

        categoryEditLabel.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryEditLabel.setForeground(new java.awt.Color(255, 255, 255));
        categoryEditLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoryEditLabel.setText("Category:");
        additems_form1.add(categoryEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 260, 28));

        jLabel8.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CATEGORY NAME");
        additems_form1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 28));

        removeCategoryItemBtn1.setBackground(new java.awt.Color(236, 82, 82));
        removeCategoryItemBtn1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        removeCategoryItemBtn1.setForeground(new java.awt.Color(255, 255, 255));
        removeCategoryItemBtn1.setText("REMOVE");
        removeCategoryItemBtn1.setBorder(null);
        removeCategoryItemBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryItemBtn1ActionPerformed(evt);
            }
        });
        additems_form1.add(removeCategoryItemBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 127, 42));

        categoryItemEditLabel.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        categoryItemEditLabel.setForeground(new java.awt.Color(255, 255, 255));
        categoryItemEditLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoryItemEditLabel.setText("Category Item:");
        additems_form1.add(categoryItemEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 260, 28));

        categories.add(additems_form1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 1220, 250));

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
        categories.setBounds(0, 0, 1260, 720);

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
        userEditLabel.setText("User:");
        additems_form8.add(userEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 260, 28));

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
        additems_form8.add(saveEditUserInfoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 127, 42));

        passwordField.setBackground(new java.awt.Color(15, 74, 74));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        additems_form8.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 40));

        newPasswordField.setBackground(new java.awt.Color(15, 74, 74));
        newPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        newPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        additems_form8.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 40));

        fullnameField.setBackground(new java.awt.Color(15, 74, 74));
        fullnameField.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        fullnameField.setForeground(new java.awt.Color(255, 255, 255));
        fullnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullnameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        fullnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fullnameField.setOpaque(false);
        additems_form8.add(fullnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 260, 40));

        users.add(additems_form8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 900, 260));

        right_sidebar.add(users);
        users.setBounds(0, 0, 1260, 710);

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

        items.setBackground(new java.awt.Color(5, 32, 33));
        items.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "ITEM QUANTITY", "ITEM METRIC", "ITEM TYPE"
            }
        ));
        jScrollPane3.setViewportView(itemsTable);

        items.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 890, 680));

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
                    .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemmetric3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemname3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemtype3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        additems_form2Layout.setVerticalGroup(
            additems_form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additems_form2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemname3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemmetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemtype3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addItem_save2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        items.add(additems_form2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 480));

        right_sidebar.add(items);
        items.setBounds(0, 0, 1260, 710);

        jobs.setBackground(new java.awt.Color(5, 32, 33));

        jobsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JOB ID", "JOB CATEGORY", "ADDED / UPDATED BY", "ADDED / UPDATED DATE"
            }
        ));
        jScrollPane5.setViewportView(jobsTable);
        if (jobsTable.getColumnModel().getColumnCount() > 0) {
            jobsTable.getColumnModel().getColumn(0).setResizable(false);
            jobsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            jobsTable.getColumnModel().getColumn(1).setResizable(false);
            jobsTable.getColumnModel().getColumn(2).setResizable(false);
            jobsTable.getColumnModel().getColumn(3).setResizable(false);
            jobsTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

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
        right_sidebar.setBounds(250, 80, 1260, 720);

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
        dashboard_side.setBounds(0, 280, 250, 62);

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
        items_side.setBounds(0, 340, 250, 62);

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
        logout_side.setBounds(0, 580, 250, 60);

        whole.add(left_sidebar);
        left_sidebar.setBounds(0, 80, 250, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1506, Short.MAX_VALUE)
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

    private void addItem_save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItem_save2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addItem_save2ActionPerformed

    private void addJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addJob_saveActionPerformed

    private void updateJob_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJob_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateJob_saveActionPerformed

    private void saveEditUserInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditUserInfoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveEditUserInfoBtnActionPerformed

    private void addEditCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditCategoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEditCategoryBtnActionPerformed

    private void addCategoryItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCategoryItemBtnActionPerformed

    private void removeCategoryItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCategoryItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeCategoryItemBtnActionPerformed

    private void categories_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categories_sideMouseClicked
        categories_sideBar_onclick();
    }//GEN-LAST:event_categories_sideMouseClicked

    private void users_sideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_sideMouseClicked
        users_sideBar_onclick();
    }//GEN-LAST:event_users_sideMouseClicked

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
                userEditLabel.setText(rs.getString("username"));
                if(fullname.equals(rs.getString("full_name")) &&
                        username.equals(rs.getString("username")) &&
                        password.equals(rsuipw.getString("password")))
                    JOptionPane.showMessageDialog(null, "No Changes Detected");
                else{
                    if(!password.equals(rsuipw.getString("password"))){
                        JOptionPane.showMessageDialog(null, "Invalid Password");
                    }
                    boolean edited = false;
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
                    if(password.equals(rsuipw.getString("password"))){
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
                    if(edited == true){
                        fullnameField.setText("");
                        usernameField.setText("");
                        passwordField.setText("");
                        newPasswordField.setText("");
                        userEditLabel.setText("User: ");
                        DefaultTableModel model = (DefaultTableModel)usersTable.getModel(); 
                        int row = usersTable.getSelectedRow();
                        model.setValueAt(fullname, row, 2);
                        model.setValueAt(username, row, 1);
                        model.setValueAt(userid, row, 5);
                        model.setValueAt(new Date(), row, 6);
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
                            User u = new User(
                                rs.getInt("user_id"),
                                rs.getString("username"),
                                rs.getString("full_name"),
                                rs.getInt("added_by"),
                                rs.getDate("added_date"),
                                rs.getInt("updated_by"),
                                rs.getDate("updated_date")
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
//            String categoryName = categoryNameField.getText();
//            
//            try {
//                Connection con = Connect.getConnection();
//                ResultSet rs = CRUD.selectCategoryInfo(con,categoryEditID);
//                rs.next();
//                ResultSet rsci = CRUD.selectCategoryID(con, rs.getString("category_name"));
//                rsci.next();
//                userEditLabel.setText(rs.getString("username"));
//                if(categoryName.equals(categoryNameField.getText()))
//                    JOptionPane.showMessageDialog(null, "No Changes Detected");
//                else{
//                    if("".equals(updatedCategoryName)){
//                        JOptionPane.showMessageDialog(null, "Updated Category Name is required!");
//                        categoryEditID = - 1;
//                    }else{
//                        categoryNameField.setText("");
//                        updatedCategoryNameField.setText("");
//                        DefaultTableModel model = (DefaultTableModel)usersTable.getModel(); 
//                        int row = categoriesTable.getSelectedRow();
//                        System.out.println("row "+row+" has been updated with a name of "+updatedCategoryName);
//                        model.setValueAt(updatedCategoryName, row, 1);
//                        model.setValueAt(userid, row, 4);
//                        model.setValueAt(dateFormat.format(new Date()), row, 5);
//                        
//                        categoryEditID = - 1;
//                        JOptionPane.showMessageDialog(null, "Category Name has been successfully updated");
//                    }
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }else{
            //add user
//            String categoryName = categoryNameField.getText();
//
//            if("".equals(categoryName))
//                JOptionPane.showMessageDialog(null, "Category name is required!");
//            else{
//                try{
//                if(!"".equals(updatedCategoryNameField.getText()))
//                    JOptionPane.showMessageDialog(null, "Click on the category to edit. TEMP");
//                else{
//                    Connection con = Connect.getConnection();
//                    if(!CRUD.checkCategoryExists(con,categoryName)){
//                        CRUD.insertCleaningCategory(con,categoryName,userid);
//                        JOptionPane.showMessageDialog(null, "Category has been successfully created!");
//                        ResultSet rs = CRUD.selectCategoryInfoUsingCategoryName(con, categoryName);
//                        rs.next();
//                        Category c = new Category(
//                            rs.getInt("category_id"),
//                            rs.getString("category_name"),
//                            rs.getInt("added_by"),
//                            rs.getDate("added_date"),
//                            rs.getInt("updated_by"),
//                            rs.getDate("updated_date")
//                        );
//                        addRowToCategoriesTable(c);
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Category updated name field should be modified...");
//                    }
//                }
//                }catch(HeadlessException | SQLException e){
//                    System.out.println(e);
//                }
//            }
        }
    }//GEN-LAST:event_addEditCategoryBtnMouseClicked

    private void categoriesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriesTableMouseClicked
        int i = categoriesTable.getSelectedRow();
        System.out.println("selected row is: "+i);
        DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel();
        categoryNameField.setText(model.getValueAt(i,1).toString());
        categoryEditID = (int) model.getValueAt(i, 0);
        System.out.println("selected category_id is: "+categoryEditID);
    }//GEN-LAST:event_categoriesTableMouseClicked

    private void removeCategoryItemBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCategoryItemBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeCategoryItemBtn1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategoryItemBtn;
    private javax.swing.JButton addEditCategoryBtn;
    private javax.swing.JButton addItem_save2;
    private javax.swing.JButton addJob_save;
    private javax.swing.JTextField addedby;
    private javax.swing.JTextField addeddate;
    private javax.swing.JPanel additems2;
    private javax.swing.JPanel additems_form1;
    private javax.swing.JPanel additems_form2;
    private javax.swing.JPanel additems_form4;
    private javax.swing.JPanel additems_form5;
    private javax.swing.JPanel additems_form8;
    private javax.swing.JLabel adminName;
    private javax.swing.JPanel categories;
    private javax.swing.JTable categoriesTable;
    private javax.swing.JPanel categories_side;
    private javax.swing.JLabel categories_side_label;
    private javax.swing.JLabel categories_up_label;
    private javax.swing.JComboBox<String> categoryDropdown;
    private javax.swing.JLabel categoryEditLabel;
    private javax.swing.JLabel categoryItemEditLabel;
    private javax.swing.JTable categoryItemTable;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard_label;
    private javax.swing.JLabel dashboard_label1;
    private javax.swing.JLabel dashboard_label4;
    private javax.swing.JLabel dashboard_label5;
    private javax.swing.JLabel dashboard_label6;
    private javax.swing.JPanel dashboard_side;
    private javax.swing.JLabel dashboard_side_label;
    private javax.swing.JLabel dashboard_up_label;
    private javax.swing.JTextField fullnameField;
    private javax.swing.JComboBox<String> itemDropdown;
    private javax.swing.JSpinner itemQuantitySpinner;
    private javax.swing.JTextField itemmetric3;
    private javax.swing.JTextField itemname3;
    private javax.swing.JTextField itemqty3;
    private javax.swing.JPanel items;
    private javax.swing.JTable itemsTable;
    private javax.swing.JPanel items_side;
    private javax.swing.JLabel items_side_label;
    private javax.swing.JLabel items_up_label;
    private javax.swing.JTextField itemtype3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jobcat;
    private javax.swing.JTextField jobcat1;
    private javax.swing.JPanel jobs;
    private javax.swing.JTabbedPane jobsTab;
    private javax.swing.JTable jobsTable;
    private javax.swing.JPanel jobs_side;
    private javax.swing.JLabel jobs_side_label;
    private javax.swing.JLabel jobs_up_label;
    private javax.swing.JPanel left_sidebar;
    private javax.swing.JPanel logout_side;
    private javax.swing.JLabel logout_side_label;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton removeCategoryItemBtn;
    private javax.swing.JButton removeCategoryItemBtn1;
    private javax.swing.JPanel right_sidebar;
    private javax.swing.JButton saveEditUserInfoBtn;
    private javax.swing.JButton updateJob_save;
    private javax.swing.JTextField updatedby;
    private javax.swing.JTextField updateddate;
    private javax.swing.JPanel updateitems1;
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
