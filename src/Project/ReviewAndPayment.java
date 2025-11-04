
package Project;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class ReviewAndPayment extends javax.swing.JFrame {
   private String currentUsername;
    private DefaultTableModel model;
    private double totalAmount = 0;

    public ReviewAndPayment(String username) {
        this.currentUsername = username;
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadReviewData();

    }
        private void loadReviewData() {
        totalAmount = 0;
        model.setRowCount(0); // Clear previous table rows

        try {
            File carsFile = new File("Salesman/" + currentUsername + "/Cars.json");
            if (!carsFile.exists()) {
                JOptionPane.showMessageDialog(this, "No car data found.");
                return;
            }

            // Read and parse JSON
            BufferedReader reader = new BufferedReader(new FileReader(carsFile));
            Car[] carArray = new Gson().fromJson(reader, Car[].class);
            reader.close();

            if (carArray != null) {
                for (Car car : carArray) {
                    if ("Sold".equalsIgnoreCase(car.getStatus())) {
                        int carID = car.getCarID();
                        double price = car.getPrice();
                        String customerUsername = car.getCustomerUsername();

                        String feedback = "-";
                        File feedbackFile = new File("Salesman/" + currentUsername + "/Feedback/" + carID + ".json");

                        if (feedbackFile.exists()) {
                            BufferedReader fbReader = new BufferedReader(new FileReader(feedbackFile));
                            FeedbackData fb = new Gson().fromJson(fbReader, FeedbackData.class);
                            fbReader.close();

                            if (fb != null && fb.getFeedback() != null) {
                                feedback = fb.getFeedback();
                            }
                        }

                        
                        model.addRow(new Object[]{customerUsername, price, feedback, carID});

                        totalAmount += price;
                    }
                }
            }

           
            jLabel1.setText("Total Earnings: RM " + String.format("%.2f", totalAmount));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading review data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Amount", "Feedback", "CarID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 1200, 720));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Feedback & Amount");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 980));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1340, 980));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         new SalesmanProfile(currentUsername).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed


    public static void main(String args[]) {
    SessionStorage.setLoggedInUsername("salesman1");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String username = SessionStorage.getLoggedInUsername();
                new ReviewAndPayment(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
