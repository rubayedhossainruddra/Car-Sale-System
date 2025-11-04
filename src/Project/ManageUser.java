
package Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;

public class ManageUser extends javax.swing.JFrame {
  private final String USER_DIR = "Users";
    private DefaultTableModel model;

   
    public ManageUser() {
       initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadUsers();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);  // Handle the click event
            }
        });
    }
    
    

   private void loadUsers() {
        model.setRowCount(0); // clear table
        File baseDir = new File(USER_DIR);
        if (baseDir.exists() && baseDir.isDirectory()) {
            File[] userDirs = baseDir.listFiles();
            if (userDirs != null) {
                for (File userDir : userDirs) {
                    File infoFile = new File(userDir, "info.json");
                    if (infoFile.exists()) {
                        try (Reader reader = new FileReader(infoFile)) {
                            Gson gson = new Gson();
                            User user = gson.fromJson(reader, User.class);
                            model.addRow(new Object[]{
                                    user.getName(), user.getEmail(), user.getPhone(),
                                    user.getGender(), user.getIc(), user.getUsername(),
                                    user.getPassword(), user.getStatus()
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 380, 50));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 380, 50));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 380, 50));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, 380, 50));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 380, 50));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 250, 50));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 380, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 810, 150, 50));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 810, 150, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 880, 150, 50));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Rejected" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 290, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 880, 150, 50));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Email", "Phone", "Gender", "IC", "Username", "Password", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 136, 740, 680));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 110, 40));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 350, 40));

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Manage Customer");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 20, 328, 44);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(880, 80, 41, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email Address");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(880, 160, 101, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(880, 240, 106, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(920, 340, 51, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("IC Number");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(860, 430, 78, 20);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(860, 520, 71, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(860, 630, 67, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(910, 710, 43, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1350, 980));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        AdminDashboard admindashboard = new AdminDashboard();
        admindashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String name = jTextField1.getText();
        String email = jTextField2.getText();
        String phone = jTextField3.getText();
        String gender = Objects.requireNonNull(jComboBox1.getSelectedItem()).toString();
        String ic = jTextField4.getText();
        String username = jTextField5.getText();
        String password = new String(jPasswordField1.getPassword());

        User user = new User(name, email, phone, gender, ic, username, password, "Approved");
        UserDataManager.saveUser(user);

        JOptionPane.showMessageDialog(this, "User added successfully.");
        loadUsers();
        clearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String username = model.getValueAt(selectedRow, 5).toString();

            // Get updated values from fields
            String name = jTextField1.getText();
            String email = jTextField2.getText();
            String phone = jTextField3.getText();
            String gender = Objects.requireNonNull(jComboBox1.getSelectedItem()).toString();
            String ic = jTextField4.getText();
            String password = new String(jPasswordField1.getPassword());
            String status = Objects.requireNonNull(jComboBox2.getSelectedItem()).toString();

            User user = new User(name, email, phone, gender, ic, username, password, status);
            UserDataManager.saveUser(user);

            JOptionPane.showMessageDialog(this, "User updated successfully.");
            loadUsers();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user from the table.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String username = model.getValueAt(selectedRow, 5).toString();
            File userDir = new File(USER_DIR + "/" + username);
            if (userDir.exists()) {
                deleteDirectory(userDir);
                JOptionPane.showMessageDialog(this, "User deleted.");
                loadUsers();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        jComboBox2.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton4ActionPerformed
private void deleteDirectory(File dir) {
        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        dir.delete();
    }

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = jTable1.getSelectedRow();  // Get the selected row index

    if (selectedRow != -1) {
        // Populate the text fields and combo boxes with the selected row's data
        jTextField1.setText(jTable1.getValueAt(selectedRow, 0).toString());  // Name
        jTextField2.setText(jTable1.getValueAt(selectedRow, 1).toString());  // Email
        jTextField3.setText(jTable1.getValueAt(selectedRow, 2).toString());  // Phone
        jComboBox1.setSelectedItem(jTable1.getValueAt(selectedRow, 3).toString());  // Gender
        jTextField4.setText(jTable1.getValueAt(selectedRow, 4).toString());  // IC
        jTextField5.setText(jTable1.getValueAt(selectedRow, 5).toString());  // Username
        jPasswordField1.setText(jTable1.getValueAt(selectedRow, 6).toString());  // Password
        jComboBox2.setSelectedItem(jTable1.getValueAt(selectedRow, 7).toString());  // Status
    }
}

private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    String searchQuery = jTextField6.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        File salesmanDir = new File("Users");
        Gson gson = new Gson();

        for (File folder : salesmanDir.listFiles()) {
            if (folder.isDirectory()) {
                try {
                    File infoFile = new File(folder, "info.json");
                    if (infoFile.exists()) {
                        FileReader reader = new FileReader(infoFile);
                        User u = gson.fromJson(reader, User.class);
                        reader.close();

                        if (u.getName().toLowerCase().contains(searchQuery)) {
                            model.addRow(new Object[]{
                                u.getName(),
                                u.getEmail(),
                                u.getPhone(),
                                u.getIc(),
                                u.getGender(),
                                u.getUsername(),
                                u.getPassword(),
                                u.getStatus()
                            });
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error reading customer data.");
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        loadUserToTable();
        jTextField6.setText("");                              
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

     private void loadUserToTable() {
    File userDir = new File("Users");
    if (!userDir.exists()) {
        return;
    }

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    Gson gson = new Gson();

    for (File folder : userDir.listFiles()) {
        if (folder.isDirectory()) {
            try {
                File infoFile = new File(folder, "info.json");
                if (infoFile.exists()) {
                    FileReader reader = new FileReader(infoFile);
                    User u = gson.fromJson(reader, User.class);
                        reader.close();

                        model.addRow(new Object[]{
                            u.getName(),
                            u.getEmail(),
                            u.getPhone(),
                            u.getIc(),
                            u.getGender(),
                            u.getUsername(),
                            u.getPassword(),
                            u.getStatus()
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading user data.");
            }
        }
    }
}
     
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
