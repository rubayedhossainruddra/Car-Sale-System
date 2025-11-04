
package Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;
import java.lang.reflect.Type;

public class UserCars extends javax.swing.JFrame {
  private List<Car> carList = new ArrayList<>();
    private String currentUsername;

    
    public UserCars(String username) {
      this.currentUsername = username;
        initComponents();
        loadCarData();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // You can handle row selection here if needed
            }
        });
}
private void loadCarData() {
        try {
            File file = new File("Cars.json");
            carList = new ArrayList<>();

            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                Car[] carsArray = new Gson().fromJson(reader, Car[].class);
                carList = Arrays.asList(carsArray);
                reader.close();
            }

            if (carList == null) carList = new ArrayList<>();

            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"CarID", "Brand", "Model", "Year", "Type", "Fuel", "Transmission",
                            "Condition", "Color", "Status", "Price"}, 0);

            for (Car car : carList) {
                if ("available".equalsIgnoreCase(car.getStatus())) {
                    model.addRow(new Object[]{
                            car.getCarID(), car.getBrand(), car.getModel(), car.getYear(), car.getType(),
                            car.getFuel(), car.getTransmission(), car.getCondition(), car.getColor(),
                            car.getStatus(), car.getPrice()
                    });
                }
            }

            jTable1.setModel(model);
            model.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load cars: " + e.getMessage());
        }
    }

    private void handlePurchaseOrBooking(String paymentStatus) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a car.");
            return;
        }

        try {
            int carID = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());

            // Load user info
            File userInfoFile = new File("Users/" + currentUsername + "/info.json");
            if (!userInfoFile.exists()) {
                JOptionPane.showMessageDialog(this, "User info file missing.");
                return;
            }

            BufferedReader userReader = new BufferedReader(new FileReader(userInfoFile));
            User user = new Gson().fromJson(userReader, User.class);
            userReader.close();

            // Update Cars.json
            File file = new File("Cars.json");
            List<Car> updatedCarList = new ArrayList<>();
            Car selectedCarData = null;

            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                TypeToken<List<Car>> carListToken = new TypeToken<List<Car>>() {};
                updatedCarList = new Gson().fromJson(reader, carListToken.getType());
                reader.close();
            }

            boolean found = false;
            for (Car car : updatedCarList) {
                if (car.getCarID() == carID) {
                    car.setCustomerUsername(user.getName());
                    car.setPayment(paymentStatus);
                    car.setEmail(user.getEmail());
                    car.setPhone(user.getPhone());
                    car.setIc(user.getIc());
                    car.setStatus(paymentStatus.equals("Done") ? "Sold" : "Reserved");

                    selectedCarData = car;
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Car not found.");
                return;
            }

            // Save updated Cars.json
            FileWriter writer = new FileWriter(file);
            new Gson().toJson(updatedCarList, writer);
            writer.close();

            // ✅ Update Salesman/<salesman_username>/Cars.json if applicable
            if (selectedCarData.getSalesmanUsername() != null && !selectedCarData.getSalesmanUsername().isEmpty()) {
                String salesmanFilePath = "Salesman/" + selectedCarData.getSalesmanUsername() + "/Cars.json";
                File salesmanFile = new File(salesmanFilePath);

                List<Car> salesmanCars = new ArrayList<>();
                if (salesmanFile.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(salesmanFile));
                    Car[] carArray = new Gson().fromJson(reader, Car[].class);
                    reader.close();

                    if (carArray != null) {
                        salesmanCars = new ArrayList<>(Arrays.asList(carArray));
                    }
                }

                for (Car car : salesmanCars) {
                    if (car.getCarID() == carID) {
                        car.setCustomerUsername(user.getName());
                        car.setPayment(paymentStatus);
                        car.setEmail(user.getEmail());
                        car.setPhone(user.getPhone());
                        car.setIc(user.getIc());
                        car.setStatus(paymentStatus.equals("Done") ? "Sold" : "Reserved");
                        break;
                    }
                }

                FileWriter writer2 = new FileWriter(salesmanFile);
                new Gson().toJson(salesmanCars, writer2);
                writer2.close();
            }

            // Save to user's PurchasedCars.json
            File purchaseFile = new File("Users/" + currentUsername + "/PurchasedCars.json");
            List<CarDataSummary> purchaseHistory = new ArrayList<>();

            if (purchaseFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(purchaseFile));
                TypeToken<List<CarDataSummary>> summaryToken = new TypeToken<List<CarDataSummary>>() {};
                purchaseHistory = new Gson().fromJson(reader, summaryToken.getType());
                reader.close();
            }

            CarDataSummary summary = new CarDataSummary(
                    selectedCarData.getCarID(),
                    selectedCarData.getBrand(),
                    selectedCarData.getModel(),
                    selectedCarData.getYear(),
                    selectedCarData.getType(),
                    selectedCarData.getFuel(),
                    selectedCarData.getTransmission(),
                    selectedCarData.getCondition(),
                    selectedCarData.getColor(),
                    selectedCarData.getStatus(),
                    selectedCarData.getPrice()
            );

            purchaseHistory.add(summary);

            FileWriter purchaseWriter = new FileWriter(purchaseFile);
            new Gson().toJson(purchaseHistory, purchaseWriter);
            purchaseWriter.close();

            JOptionPane.showMessageDialog(this, (paymentStatus.equals("Done") ? "Purchase" : "Booking") + " completed!");
            loadCarData();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1250, 700));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Available Car");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(90, 50, 329, 44);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 153, 0));
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(460, 860, 210, 70);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 102));
        jButton2.setText("Buy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(730, 860, 210, 70);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(20, 860, 167, 61);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 970));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        handlePurchaseOrBooking("Pending");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       handlePurchaseOrBooking("Done"); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new UserProfile().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed
    
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
            String username = ""; // set username after login
            new UserCars(username).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
