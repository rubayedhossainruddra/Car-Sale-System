
package Project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class SalesAndAmount extends javax.swing.JFrame {

    private DefaultTableModel model;
    private double totalAmount;
    
    public SalesAndAmount() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadSoldCarsAndAmount(); 
    }

    private void loadSoldCarsAndAmount() {
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear previous table content
    double totalAmount = 0;

    try {
        File file = new File("Cars.json");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Cars.json file not found.");
            return;
        }

        
        BufferedReader reader = new BufferedReader(new FileReader(file));


        java.lang.reflect.Type listType = new com.google.gson.reflect.TypeToken<List<Car>>() {}.getType();
        List<Car> carList = new com.google.gson.Gson().fromJson(reader, listType);
        reader.close();

        if (carList == null || carList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No car data available.");
            return;
        }

  
        for (Car car : carList) {
            if ("Sold".equalsIgnoreCase(car.getStatus())) {
                // Add to table
                model.addRow(new Object[]{
                    car.getCarID(),
                    car.getBrand(),
                    car.getModel(),
                    car.getYear(),
                    String.format("RM %.2f", car.getPrice())
                });


                totalAmount += car.getPrice();
            }
        }

 
        jLabel1.setText("Total Amount: RM " + String.format("%.2f", totalAmount));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading cars: " + e.getMessage());
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CarID", "Brand", "Model", "Year", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 1250, 670));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 470, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 255, 255));
        jLabel16.setText("Sales & Amount");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(30, 30, 329, 44);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 970));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        AdminDashboard admindashboard = new AdminDashboard();
        admindashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesAndAmount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
