package optimalinventorysystem;

import Hash.HashPassword;
import MySQL.CRUD;
import MySQL.Connect;
import java.awt.HeadlessException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.Color;


public class Login extends javax.swing.JFrame {
    public static String admin;

    public Login() {
        initComponents();
        usernameField.setBackground(new Color(0, 0, 0, 64));
        passwordField.setBackground(new Color(0, 0, 0, 64));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username_icon = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        password_icon = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(940, 618));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 618));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Don't have an account yet?");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 440, 360, 30);

        jLabel1.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPTIMAL INVENTORY SYSTEM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 80, 370, 60);

        username_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem\\img\\profile.png")); // NOI18N
        jPanel1.add(username_icon);
        username_icon.setBounds(80, 210, 30, 50);

        usernameField.setBackground(new java.awt.Color(238, 238, 238));
        usernameField.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 101, 102), 2, true));
        usernameField.setOpaque(false);
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usernameField);
        usernameField.setBounds(70, 210, 360, 50);

        password_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem\\img\\key.png")); // NOI18N
        jPanel1.add(password_icon);
        password_icon.setBounds(80, 300, 24, 50);

        passwordField.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 101, 102), 2, true));
        passwordField.setOpaque(false);
        jPanel1.add(passwordField);
        passwordField.setBounds(70, 300, 360, 50);

        login.setBackground(new java.awt.Color(155, 75, 77));
        login.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN");
        login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 75, 77), 2, true));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(70, 380, 360, 50);

        background.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem\\img\\27037619-geometric-wallpapers.png")); // NOI18N
        background.setText("Don't have an account?");
        jPanel1.add(background);
        background.setBounds(0, 0, 1000, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        String username = usernameField.getText();
        String password = passwordField.getText();
        admin = username;
        if("".equals(username))
        JOptionPane.showMessageDialog(null, "Username is required!");
        else if("".equals(password))
        JOptionPane.showMessageDialog(null, "Password is required!");
        else{
            try{
                Connection con = Connect.getConnection();
                if(CRUD.checkUserExists(con,username)){
                    ResultSet rs = CRUD.selectUserPassword(con, username);
                    rs.next();
                    String retrievePassword = rs.getString("password");
                    if((HashPassword.hashPassword(password)).equals(retrievePassword)){
                        Home h = new Home();
                        h.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Username and Password did not match any account");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Username and Password did not match any account");
                }
            }catch(HeadlessException | NoSuchAlgorithmException | SQLException e){
                JOptionPane.showMessageDialog(null, "Username and Password did not match any account");
            }
        }
    }//GEN-LAST:event_loginMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel password_icon;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel username_icon;
    // End of variables declaration//GEN-END:variables
}
