
package Project;

import com.google.gson.Gson;
import java.io.*;
import javax.swing.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.HashMap;
public class UserProfile1 extends javax.swing.JFrame {

    private String username;
    private User currentUser;

    
    public UserProfile1(String username) {
        this.username = username.toLowerCase(); // Ensure folder name format
        initComponents();
        loadUserInfo();
    }

    private void loadUserInfo() {
        try {
            File userInfoFile = new File("Users/" + username + "/info.json");
            if (userInfoFile.exists()) {
                FileReader reader = new FileReader(userInfoFile);
                Gson gson = new Gson();
                currentUser = gson.fromJson(reader, User.class);
                reader.close();

                // Fill fields
                jTextField2.setText(currentUser.getName());
                jTextField3.setText(currentUser.getEmail());
                jTextField4.setText(currentUser.getPhone());
                jComboBox2.setSelectedItem(currentUser.getGender());
                jTextField5.setText(currentUser.getIc());
                jTextField6.setText(currentUser.getUsername());
                jPasswordField2.setText(currentUser.getPassword());
            } else {
                JOptionPane.showMessageDialog(this, "User info not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load user info.");
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 700, 70));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 700, 70));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 700, 70));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 320, 60));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 700, 70));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, 530, 70));

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 750, 530, 70));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 51));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 200, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email Address");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("IC Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gender");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 750, -1, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("User Profile");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 300, 100));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -60, 1350, 1040));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      new UserProfile().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     try {
        String oldUsername = username;
        String newUsername = jTextField6.getText().trim(); // From field
        String newPassword = new String(jPasswordField2.getPassword()).trim();

        // Update currentUser object
        currentUser.setName(jTextField2.getText().trim());
        currentUser.setEmail(jTextField3.getText().trim());
        currentUser.setPhone(jTextField4.getText().trim());
        currentUser.setGender(jComboBox2.getSelectedItem().toString());
        currentUser.setIc(jTextField5.getText().trim());
        currentUser.setUsername(newUsername);
        currentUser.setPassword(newPassword);

        // === 1. Rename folder if username changed ===
        if (!oldUsername.equals(newUsername)) {
            File oldFolder = new File("Users/" + oldUsername);
            File newFolder = new File("Users/" + newUsername);

            if (oldFolder.exists()) {
                boolean success = oldFolder.renameTo(newFolder);
                if (!success) {
                    JOptionPane.showMessageDialog(this, "Failed to rename user folder.");
                    return;
                }
            }

            // Update internal username reference
            username = newUsername;
        }

        // === 2. Update credentials.json ===
        File credentialsFile = new File("credentials.json");
        Gson gson = new Gson();
        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<java.util.Map<String, String>>() {}.getType();
        java.util.Map<String, String> credentials = new java.util.HashMap<>();

        if (credentialsFile.exists()) {
            try (FileReader reader = new FileReader(credentialsFile)) {
                credentials = gson.fromJson(reader, type);
            }
        }

        if (!oldUsername.equals(newUsername)) {

    if (credentials.containsKey(oldUsername)) {
        String password = credentials.get(oldUsername); // Or extract "approved" if it's an object
        credentials.remove(oldUsername);
    }
}
credentials.put(newUsername, newPassword);

        try (FileWriter writer = new FileWriter(credentialsFile)) {
            gson.toJson(credentials, writer);
        }

        // === 3. Save updated user info to correct info.json ===
        FileWriter writer = new FileWriter("Users/" + newUsername + "/info.json");
        gson.toJson(currentUser, writer);
        writer.flush();
        writer.close();

        JOptionPane.showMessageDialog(this, "Profile updated successfully!");

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to update profile.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
