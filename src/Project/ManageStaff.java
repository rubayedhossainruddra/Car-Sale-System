
package Project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ManageStaff extends javax.swing.JFrame {
        private DefaultTableModel model;
        private String selectedIC = null;
    
    public ManageStaff() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadStaffData();
    

jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            int row = jTable1.getSelectedRow();
            if (row != -1) {
                jTextField1.setText(model.getValueAt(row, 0).toString()); // Name
                jTextField2.setText(model.getValueAt(row, 1).toString()); // Phone
                jTextField3.setText(model.getValueAt(row, 2).toString()); // Email
                jComboBox1.setSelectedItem(model.getValueAt(row, 3).toString()); // Gender
                jTextField4.setText(model.getValueAt(row, 4).toString()); // IC
                jComboBox2.setSelectedItem(model.getValueAt(row, 5).toString()); // Role

                selectedIC = model.getValueAt(row, 4).toString(); // for update/delete
            }
        }
    }
});
}
    private void loadStaffData() {
    model.setRowCount(0); // Clear existing
    File folder = new File("Staffs");
    if (!folder.exists()) folder.mkdirs();

    File[] files = folder.listFiles();
    Gson gson = new Gson();
    for (File file : files) {
        try (FileReader reader = new FileReader(file)) {
            Staff s = gson.fromJson(reader, Staff.class);
            model.addRow(new Object[] {
                s.getName(), s.getPhone(), s.getEmail(),
                s.getGender(), s.getIc(), s.getRole()
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Email", "Phone", "Gender", "IC", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 887, 660));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 380, 58));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 840, 150, 56));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 840, 150, 56));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 750, 150, 56));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 750, 150, 56));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HR", "Sales Manager", "IT", "Multimedia", "Accounts", "Vehicle Technecian" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 650, 200, 52));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 560, 380, 58));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 460, 200, 52));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, 380, 58));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 380, 58));

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 40));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 350, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 110, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Manage Staff");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email Address");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 440, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Role");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 680, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IC Number");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, -1, -1));

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
     try {
        Staff s = new Staff();
        s.setName(jTextField1.getText());
        s.setPhone(jTextField2.getText());
        s.setEmail(jTextField3.getText());
        s.setGender(jComboBox1.getSelectedItem().toString());
        s.setIc(jTextField4.getText());
        s.setRole(jComboBox2.getSelectedItem().toString());

        File dir = new File("Staffs");
        if (!dir.exists()) dir.mkdirs();

        File file = new File(dir, s.getIc() + ".json");
        if (file.exists()) {
            JOptionPane.showMessageDialog(this, "Staff already exists.");
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(s, writer);
        }

        loadStaffData();
        clearFields();
        JOptionPane.showMessageDialog(this, "Staff added successfully.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving staff.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     if (selectedIC == null) {
        JOptionPane.showMessageDialog(this, "Select a staff to update.");
        return;
    }

    File file = new File("Staffs/" + selectedIC + ".json");
    if (!file.exists()) {
        JOptionPane.showMessageDialog(this, "Staff not found.");
        return;
    }

    Staff s = new Staff();
    s.setName(jTextField1.getText());
    s.setPhone(jTextField2.getText());
    s.setEmail(jTextField3.getText());
    s.setGender(jComboBox1.getSelectedItem().toString());
    s.setIc(jTextField4.getText());
    s.setRole(jComboBox2.getSelectedItem().toString());

    // Delete old file if IC changed
    if (!selectedIC.equals(s.getIc())) {
        file.delete();
    }

    File newFile = new File("Staffs/" + s.getIc() + ".json");

    try (FileWriter writer = new FileWriter(newFile)) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(s, writer);
    } catch (Exception e) {
        e.printStackTrace();
    }

    loadStaffData();
    clearFields();
    JOptionPane.showMessageDialog(this, "Staff updated.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    if (selectedIC == null) {
        JOptionPane.showMessageDialog(this, "Select a staff to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        File file = new File("Staffs/" + selectedIC + ".json");
        if (file.exists()) file.delete();

        loadStaffData();
        clearFields();
        JOptionPane.showMessageDialog(this, "Staff deleted.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearFields();      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
String searchQuery = jTextField6.getText().trim().toLowerCase();
    
    // If the search field is empty, prompt the user
    if (searchQuery.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a name to search.");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear the current table

    File staffDir = new File("Staffs");
    if (!staffDir.exists()) {
        JOptionPane.showMessageDialog(this, "Staffs folder not found.");
        return;
    }

    Gson gson = new Gson();

    for (File file : staffDir.listFiles()) {
        if (file.isFile() && file.getName().endsWith(".json")) {
            try (FileReader reader = new FileReader(file)) {
                Staff s = gson.fromJson(reader, Staff.class);

                // Match name with search query (case-insensitive)
                if (s.getName().toLowerCase().contains(searchQuery)) {
                    model.addRow(new Object[]{
                        s.getName(),
                        s.getPhone(),
                        s.getEmail(),
                        s.getGender(),
                        s.getIc(),
                        s.getRole()
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading staff file: " + file.getName());
            }
        }
    }

    // If no match found
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No staff found matching: " + searchQuery);
    
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField6.setText("");
         loadStaffData(); 
    }//GEN-LAST:event_jButton6ActionPerformed

    
    private void clearFields() {
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jComboBox1.setSelectedIndex(0);
    jTextField4.setText("");
    jComboBox2.setSelectedIndex(0);
    selectedIC = null;
}
    
    
    private void deleteDirectory(File dir) {
    File[] files = dir.listFiles();
    if (files != null) {
        for (File file : files) {
            deleteDirectory(file); 
        }
    }
    dir.delete(); 
}
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            jTextField1.setText(jTable1.getValueAt(selectedRow, 0).toString());
            jTextField2.setText(jTable1.getValueAt(selectedRow, 1).toString());
            jTextField3.setText(jTable1.getValueAt(selectedRow, 2).toString());
            jComboBox1.setSelectedItem(jTable1.getValueAt(selectedRow, 3).toString());
            jTextField4.setText(jTable1.getValueAt(selectedRow, 4).toString());
            jComboBox2.setSelectedItem(jTable1.getValueAt(selectedRow, 5).toString());
        }
    }
    
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStaff().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
