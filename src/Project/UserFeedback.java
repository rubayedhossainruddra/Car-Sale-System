
package Project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class UserFeedback extends javax.swing.JFrame {

    private String currentUsername;
    
    public UserFeedback(String username) {
        this.currentUsername = username;
        initComponents();
        loadPurchasedCars();
        loadFeedback();
    }

 private void loadPurchasedCars() {
        try {
            File file = new File("Users/" + currentUsername + "/PurchasedCars.json");
            List<CarDataSummary> purchasedList = new ArrayList<>();

            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                TypeToken<List<CarDataSummary>> token = new TypeToken<List<CarDataSummary>>() {};
                purchasedList = new Gson().fromJson(reader, token.getType());
                reader.close();
            }

            DefaultTableModel model = new DefaultTableModel(
                new String[]{"CarID", "Feedback"}, 0
            );

            for (CarDataSummary car : purchasedList) {
                if ("Sold".equalsIgnoreCase(car.getStatus())) {
                    model.addRow(new Object[]{car.getCarID(), ""});
                }
            }

            jTable1.setModel(model);
            model.fireTableDataChanged();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading purchased cars: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadFeedback() {
        try {
            File file = new File("Users/" + currentUsername + "/Feedback.json");
            if (!file.exists()) return;

            TypeToken<List<FeedbackData>> token = new TypeToken<List<FeedbackData>>() {};
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<FeedbackData> feedbackList = new Gson().fromJson(reader, token.getType());
            reader.close();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                int tableCarID = (int) model.getValueAt(i, 0);
                for (FeedbackData fb : feedbackList) {
                    if (fb.getCarID() == tableCarID) {
                        model.setValueAt(fb.getFeedback(), i, 1);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading feedback: " + e.getMessage());
        }
    }

   private void saveFeedback() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a car to give feedback.");
        return;
    }

    String feedbackText = jTextPane1.getText().trim();
    if (feedbackText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter feedback before submitting.");
        return;
    }

    int carID = (int) jTable1.getValueAt(selectedRow, 0);

    File feedbackFile = new File("Users/" + currentUsername + "/Feedback.json");
    List<FeedbackData> feedbackList = new ArrayList<>();

    try {
        if (feedbackFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(feedbackFile));
            FeedbackData[] feedbackArray = new Gson().fromJson(reader, FeedbackData[].class);
            reader.close();
            if (feedbackArray != null) {
                feedbackList = new ArrayList<>(Arrays.asList(feedbackArray));
            }
        }

        boolean updated = false;
        for (FeedbackData fd : feedbackList) {
            if (fd.getCarID() == carID) {
                fd.setFeedback(feedbackText);
                updated = true;
                break;
            }
        }

        if (!updated) {
            feedbackList.add(new FeedbackData(carID, feedbackText));
        }

        FileWriter writer = new FileWriter(feedbackFile);
        new Gson().toJson(feedbackList, writer);
        writer.close();


        String salesmanUsername = getSalesmanUsernameByCarID(carID);
        if (!salesmanUsername.isEmpty()) {
            File feedbackFolder = new File("Salesman/" + salesmanUsername + "/Feedback");
            if (!feedbackFolder.exists()) {
                feedbackFolder.mkdirs();
            }

            File salesmanFeedbackFile = new File(feedbackFolder, carID + ".json");
            FeedbackData feedbackObject = new FeedbackData(carID, feedbackText);
            FileWriter salesmanWriter = new FileWriter(salesmanFeedbackFile);
            new Gson().toJson(feedbackObject, salesmanWriter);
            salesmanWriter.close();
        }

        jTable1.setValueAt(feedbackText, selectedRow, 1);
        jTextPane1.setText("");

        JOptionPane.showMessageDialog(this, "Feedback saved successfully!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error saving feedback: " + e.getMessage());
        e.printStackTrace();
    }
   }
   private String getSalesmanUsernameByCarID(int carID) {
    try {
        File carsFile = new File("Cars.json");
        if (carsFile.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(carsFile));
            Car[] carArray = new Gson().fromJson(br, Car[].class);
            br.close();

            if (carArray != null) {
                for (Car car : carArray) {
                    if (car.getCarID() == carID) {
                        String salesman = car.getSalesmanUsername();
                        return (salesman != null) ? salesman : "";
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "";
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CarID", "Feedback"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1200, 570));

        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, 610, 180));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 780, 150, 60));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Feedback");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 300, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Write your feedback");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 720, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1350, 970));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         saveFeedback();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new UserProfile().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String username = "";
                new UserCars(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
