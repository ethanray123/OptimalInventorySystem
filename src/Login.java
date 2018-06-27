
import java.awt.Color;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        username.setBackground(new Color(0, 0, 0, 64));
        password.setBackground(new Color(0, 0, 0, 64));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username_icon = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password_icon = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(940, 618));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 618));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPTIMAL INVENTORY SYSTEM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 80, 350, 60);

        username_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem-development\\img\\profile.png")); // NOI18N
        jPanel1.add(username_icon);
        username_icon.setBounds(80, 210, 30, 50);

        username.setBackground(new java.awt.Color(238, 238, 238));
        username.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 101, 102), 2, true));
        username.setOpaque(false);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username);
        username.setBounds(70, 210, 360, 50);

        password_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem-development\\img\\key.png")); // NOI18N
        jPanel1.add(password_icon);
        password_icon.setBounds(80, 300, 24, 50);

        password.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 101, 102), 2, true));
        password.setOpaque(false);
        jPanel1.add(password);
        password.setBounds(70, 300, 360, 50);

        login.setBackground(new java.awt.Color(155, 75, 77));
        login.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
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

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hazel Cavite\\Documents\\NetBeansProjects\\Optimal Inventory System\\OptimalInventorySystem-development\\img\\27037619-geometric-wallpapers.png")); // NOI18N
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

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginMouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password_icon;
    private javax.swing.JTextField username;
    private javax.swing.JLabel username_icon;
    // End of variables declaration//GEN-END:variables
}
