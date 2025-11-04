
package Project;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class SalesmenRecord extends javax.swing.JFrame {

    private String currentUsername;
    private DefaultTableModel model;

    public SalesmenRecord(String username) {
        this.currentUsername = username;
        initComponents();
        model = (DefaultTableModel) jTable1.getModel(); 
        loadSoldCars(); 
    }

    private void loadSoldCars() {
        model.setRowCount(0); // Clear table data first

        try {
            File carsFile = new File("Salesman/" + currentUsername + "/Cars.json");
            if (!carsFile.exists()) {
                JOptionPane.showMessageDialog(this, "Cars.json file not found.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(carsFile));
            Car[] carArray = new Gson().fromJson(reader, Car[].class);
            reader.close();

            if (carArray == null || carArray.length == 0) {
                JOptionPane.showMessageDialog(this, "No cars found.");
                return;
            }

            for (Car car : carArray) {
                if ("Sold".equalsIgnoreCase(car.getStatus())) {
                    model.addRow(new Object[]{
                            car.getCarID(),
                            car.getBrand(),
                            car.getModel(),
                            car.getYear(),
                            car.getType(),
                            car.getFuel(),
                            car.getTransmission(),
                            car.getCondition(),
                            car.getColor(),
                            car.getStatus(),
                            String.format("RM %.2f", car.getPrice())
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading car data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CarID", "Brand", "Model", "Year", "Type", "Fuel", "Transmission", "Condition", "Color", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1270, 750));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Sales Record");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, 970));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        SalesmanProfile salesmanProfile = new SalesmanProfile(currentUsername);
        salesmanProfile.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

            SessionStorage.setLoggedInUsername("username");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesmenRecord(SessionStorage.getLoggedInUsername()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
