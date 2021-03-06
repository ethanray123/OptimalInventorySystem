/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalinventorysystem;

import java.sql.Connection;
import Hash.HashPassword;
import MySQL.Connect;
import MySQL.CRUD;
import java.awt.Color;
import java.awt.HeadlessException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static optimalinventorysystem.Login.userid;
/**
 *
 * @author Ethan
 */
public class Register extends javax.swing.JFrame {
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        fullnameField.setBackground(new Color(0, 0, 0, 64));
        usernameField.setBackground(new Color(0, 0, 0, 64));
        passwordField.setBackground(new Color(0, 0, 0, 64));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fullnameField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        fnLabel = new javax.swing.JLabel();
        pwLabel = new javax.swing.JLabel();
        unLabel = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(7, 45, 46));

        jPanel1.setBackground(new java.awt.Color(7, 45, 46));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        fullnameField.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        fullnameField.setForeground(new java.awt.Color(255, 255, 255));
        fullnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullnameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102), 2));
        fullnameField.setOpaque(false);
        jPanel1.add(fullnameField);
        fullnameField.setBounds(90, 170, 260, 40);

        usernameField.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102), 2));
        usernameField.setOpaque(false);
        jPanel1.add(usernameField);
        usernameField.setBounds(90, 260, 260, 40);

        passwordField.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 101, 102), 2));
        passwordField.setOpaque(false);
        jPanel1.add(passwordField);
        passwordField.setBounds(90, 360, 260, 40);

        fnLabel.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        fnLabel.setForeground(new java.awt.Color(255, 255, 255));
        fnLabel.setText("Full Name");
        jPanel1.add(fnLabel);
        fnLabel.setBounds(90, 140, 146, 28);

        pwLabel.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        pwLabel.setForeground(new java.awt.Color(255, 255, 255));
        pwLabel.setText("Password");
        jPanel1.add(pwLabel);
        pwLabel.setBounds(90, 330, 146, 28);

        unLabel.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        unLabel.setForeground(new java.awt.Color(255, 255, 255));
        unLabel.setText("Username");
        jPanel1.add(unLabel);
        unLabel.setBounds(90, 230, 146, 28);

        submitBtn.setBackground(new java.awt.Color(73, 185, 168));
        submitBtn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.setBorder(null);
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });
        jPanel1.add(submitBtn);
        submitBtn.setBounds(90, 440, 260, 50);

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");
        jLabel6.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 40, 309, 58);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/27037619-geometric-wallpapers.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
        String fullname = fullnameField.getText();
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        if("".equals(fullname))
        JOptionPane.showMessageDialog(null, "Full Name is required!");
        else if("".equals(username))
        JOptionPane.showMessageDialog(null, "Username is required!");
        else if("".equals(password))
        JOptionPane.showMessageDialog(null, "Password is required!");
        else{
            try{
                Connection con = Connect.getConnection();
                if(!CRUD.checkUserExists(con,username)){
                    if(password.length() >= 8){
                        password=HashPassword.hashPassword(password);
                        CRUD.insertUser(con,fullname,username,password,-1);
                        JOptionPane.showMessageDialog(null, "User has been successfully created!");
                        ResultSet rs = CRUD.selectUserIDPassword(con, username);
                        rs.next();
                        String retrievePassword = rs.getString("password");
                        System.out.println(HashPassword.hashPassword(password));
                        System.out.println(retrievePassword);
                        userid = rs.getInt("user_id");
                        new Login().setVisible(true);
                        this.dispose();
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
    }//GEN-LAST:event_submitBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Register().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fnLabel;
    private javax.swing.JTextField fullnameField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel pwLabel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel unLabel;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
