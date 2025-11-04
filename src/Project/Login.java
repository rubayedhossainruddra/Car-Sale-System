
package Project;

import com.google.gson.Gson;
import java.io.*;
import javax.swing.*;
import java.io.File;
import java.io.FileReader;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

  private void handleSalesmanLogin(String username, String password, String folderName) {
        File salesmanDir = new File("Salesman/" + folderName);
        File credentialsFile = new File(salesmanDir, "credentials.json");

        if (credentialsFile.exists()) {
            try {
                Gson gson = new Gson();
                FileReader reader = new FileReader(credentialsFile);
                String[] credentials = gson.fromJson(reader, String[].class);
                reader.close();

                if (credentials != null && credentials.length >= 2) {
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        new SalesmanProfile(username).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid credentials.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials format.");
                }

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading credentials.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Salesman not found.");
        }
    }

    private void handleAdminLogin(String username, String password) {
        if (username.equals("Admin") && password.equals("Admin1234")) {
            JOptionPane.showMessageDialog(this, "Admin login successful!");
            new AdminDashboard().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin credentials.");
        }
    }

    private void handleUserLogin(String username, String password, String folderName) {
        File userDir = new File("Users/" + folderName);
        File credentialsFile = new File(userDir, "credentials.json");
        
        if (credentialsFile.exists()) {
            try {
            // Proceed to read the credentials
            Gson gson = new Gson();
            FileReader reader = new FileReader(credentialsFile);
            UserCredentials credentials = gson.fromJson(reader, UserCredentials.class);
            reader.close();

            // Check if credentials match
            if (credentials.getUsername().equals(username)
                    && credentials.getPassword().equals(password)
                    && credentials.getStatus().equalsIgnoreCase("Approved")) {

                JOptionPane.showMessageDialog(this, "Login successful as User!");

                // Set username in session
                UserSession.setUsername(username);

                // Open UserProfile and close the current Login window
                UserProfile userProfile = new UserProfile();
                userProfile.setVisible(true);  // Show UserProfile window
                dispose();  // Close the login window

            } else {
                JOptionPane.showMessageDialog(this, "Account not approved.");
            }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error during login: " + e.getMessage());
            }
        }else {
            JOptionPane.showMessageDialog(this, "Users not found.");
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log In");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 170, 60));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 480, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Use for Admin Login: Username = Admin Pass = Admin1234");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, 70));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 480, 50));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Register as User");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 120, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Choose Type");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Salesman", "User" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 244, 53));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 170, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/padlock.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 40, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/user (1).png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bgc.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1190, -480, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/BGS.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-374, 0, 3400, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-18, -14, 1020, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String userType = jComboBox1.getSelectedItem().toString();
    String username = jTextField1.getText().trim();
    String password = new String(jPasswordField1.getPassword()).trim();

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both username and password.");
        return;
    }

    // Convert to lowercase to maintain consistent folder naming
    String folderName = username.toLowerCase();

    switch (userType) {
        case "Salesman":
            handleSalesmanLogin(username, password, folderName);
            break;
        case "Admin":
            handleAdminLogin(username, password);
            break;
        case "User":
            handleUserLogin(username, password, folderName);
            break;
        default:
            JOptionPane.showMessageDialog(this, "Invalid user type selected.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Signup signup = new Signup(); 
        signup.setVisible(true);       
        dispose();           
    }//GEN-LAST:event_jButton2ActionPerformed

    
       
      public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
