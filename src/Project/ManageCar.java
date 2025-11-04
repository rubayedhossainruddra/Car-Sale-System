    
package Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManageCar extends javax.swing.JFrame {
  private List<Car> carList = new ArrayList<>();
    
    public ManageCar() {
        initComponents();
        loadCarData();
        
         jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) {
                // Get values from table
                String brand = jTable1.getValueAt(selectedRow, 1).toString();
                String model = jTable1.getValueAt(selectedRow, 2).toString();
                String year = jTable1.getValueAt(selectedRow, 3).toString();
                String type = jTable1.getValueAt(selectedRow, 4).toString();
                String fuel = jTable1.getValueAt(selectedRow, 5).toString();
                String transmission = jTable1.getValueAt(selectedRow, 6).toString();
                String condition = jTable1.getValueAt(selectedRow, 7).toString();
                String color = jTable1.getValueAt(selectedRow, 8).toString();
                String status = jTable1.getValueAt(selectedRow, 9).toString();
                String price = jTable1.getValueAt(selectedRow, 10).toString();

                // Set text fields
                jTextField1.setText(model);
                jTextField2.setText(year);
                jTextField3.setText(color);
                jTextField4.setText(price);

                // Set combo boxes
                jComboBox1.setSelectedItem(brand);
                jComboBox2.setSelectedItem(type);
                jComboBox3.setSelectedItem(fuel);
                jComboBox4.setSelectedItem(transmission);
                jComboBox5.setSelectedItem(condition);
                jComboBox6.setSelectedItem(status);
            }
        }
    });
    }

  private void loadCarData() {
     try {
        File file = new File("Cars.json");
        List<Car> carList = new ArrayList<>();

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            java.lang.reflect.Type listType = new TypeToken<List<Car>>() {}.getType();
            carList = new Gson().fromJson(reader, listType);
            reader.close();
        }

        if (carList == null) carList = new ArrayList<>();

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"CarID", "Brand", "Model", "Year", "Type", "Fuel", "Transmission", "Condition",
                         "Color", "Status", "Price", "Customer", "Payment", "Email", "Phone", "IC"}, 0);

        for (Car car : carList) {
            model.addRow(new Object[]{
                car.getCarID(), car.getBrand(), car.getModel(), car.getYear(), car.getType(),
                car.getFuel(), car.getTransmission(), car.getCondition(), car.getColor(),
                car.getStatus(), car.getPrice(), car.getCustomerUsername(), car.getPayment(),
                car.getEmail(), car.getPhone(), car.getIc()
            });
        }

        jTable1.setModel(model);
        model.fireTableDataChanged();
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to load cars: " + e.getMessage());
    }
  }

  private int getNextCarID() {
        int maxID = 0;
        for (Car car : carList) {
            if (car.getCarID() > maxID) {
                maxID = car.getCarID();
            }
        }
        return maxID + 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CarID", "Brand", "Model", "Year", "Type", "Fuel", "Transmission", "Condition", "Color", "Status", "Price", "Customer", "Payment", "Email", "Phone", "IC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1310, 380));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 360, 60));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Honda", "Nissan", "Ford", "Chevrolet", "BMW", "Mercedes-Benz", "Audi", "Hyundai", "Kia", "Volkswagen", "Mazda", "Subaru", "Lexus", "Mitsubishi", "BYD", "Proton", "Tesla", "Suzuki", "Peugeot", "Renault", "Volvo" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 300, 40));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "Hatchback", "SUV", "Coupe", "Convertible", "Wagon", "Pickup Truck", "Van", "Minivan", "Crossover", "Sports Car", "Luxury Car", "Electric Car", "Hybrid Car", "Off-Road", "Compact", "Microcar", "Roadster", "Limousine", "Jeep" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, 300, 40));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petrol", "Diesel", "Electric", "Hybrid", "CNG", "LPG" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 870, 300, 40));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatic", "CVT", "Dual-Clutch" }));
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 300, 40));

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Used", "Reconditioned" }));
        getContentPane().add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, 300, 40));

        jComboBox6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Sold", "Reserved" }));
        getContentPane().add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 300, 40));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 700, 360, 60));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 760, 360, 60));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 860, 360, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 180, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 610, 180, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 680, 180, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 750, 180, 60));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 167, 61));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Year");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 680, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 770, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fuel");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 850, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Transmission");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Condition");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 590, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Status");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(640, 740, 40, 20);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Price");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(640, 840, 34, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Manage Car");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 30, 329, 44);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Model");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(250, 590, 60, 20);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Brand");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(270, 510, 41, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 970));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Color");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 740, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 840, -1, -1));

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
        String brand = jComboBox1.getSelectedItem().toString();
        String model = jTextField1.getText().trim();
        int year = Integer.parseInt(jTextField2.getText().trim());
        String type = jComboBox2.getSelectedItem().toString();
        String fuel = jComboBox3.getSelectedItem().toString();
        String transmission = jComboBox4.getSelectedItem().toString();
        String condition = jComboBox5.getSelectedItem().toString();
        String status = jComboBox6.getSelectedItem().toString();
        String color = jTextField3.getText().trim();
        double price = Double.parseDouble(jTextField4.getText().trim());

        // Load existing cars
        File file = new File("Cars.json");
        List<Car> carList = new ArrayList<>();

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            java.lang.reflect.Type listType = new TypeToken<List<Car>>() {}.getType();
            carList = new Gson().fromJson(reader, listType);
            reader.close();
        }

        if (carList == null) carList = new ArrayList<>();

        // Auto-generate CarID
        int nextCarID = carList.isEmpty() ? 1 : carList.get(carList.size() - 1).getCarID() + 1;

        Car newCar = new Car(nextCarID, brand, model, year, type, fuel, transmission, condition, color, status, price,
                "", "", "", "", "", "");

        carList.add(newCar);

        // Save back to file
        FileWriter writer = new FileWriter("Cars.json");
        new Gson().toJson(carList, writer);
        writer.close();

        JOptionPane.showMessageDialog(this, "Car added successfully!");
        loadCarData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding car: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Select a row to update.");
    return;
}

try {
    File file = new File("Cars.json");
    java.lang.reflect.Type listType = new TypeToken<List<Car>>() {}.getType();
    List<Car> carList = new ArrayList<>();

    if (file.exists()) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        carList = new Gson().fromJson(reader, listType);
        reader.close();
    }

    int carID = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
    String updatedStatus = jComboBox6.getSelectedItem().toString(); // Status combobox
    Car updatedCar = null;

    for (Car car : carList) {
        if (car.getCarID() == carID) {
            car.setBrand(jComboBox1.getSelectedItem().toString());
            car.setModel(jTextField1.getText().trim());
            car.setYear(Integer.parseInt(jTextField2.getText().trim()));
            car.setType(jComboBox2.getSelectedItem().toString());
            car.setFuel(jComboBox3.getSelectedItem().toString());
            car.setTransmission(jComboBox4.getSelectedItem().toString());
            car.setCondition(jComboBox5.getSelectedItem().toString());
            car.setStatus(updatedStatus); // <-- Updating status value
            car.setColor(jTextField3.getText().trim());
            car.setPrice(Double.parseDouble(jTextField4.getText().trim()));

            updatedCar = car;
            break;
        }
    }

    // Save updated list to Cars.json
    FileWriter writer = new FileWriter("Cars.json");
    new Gson().toJson(carList, writer);
    writer.close();

    // ===== Step 2: Update status in the user's PurchasedCars.json =====
    if (updatedCar != null && updatedCar.getCustomerUsername() != null && !updatedCar.getCustomerUsername().isEmpty()) {

        String customer = updatedCar.getCustomerUsername();
        File purchasedFile = new File("Users/" + customer + "/PurchasedCars.json");

        if (purchasedFile.exists()) {
            BufferedReader pr = new BufferedReader(new FileReader(purchasedFile));
            TypeToken<List<CarDataSummary>> token = new TypeToken<List<CarDataSummary>>() {};
            List<CarDataSummary> userCars = new Gson().fromJson(pr, token.getType());
            pr.close();

            for (CarDataSummary summary : userCars) {
                if (summary.getCarID() == carID) {
                    summary.setStatus(updatedStatus); // ✅ Sync status with main file
                    break;
                }
            }

            // Write the updated user file
            FileWriter pw = new FileWriter(purchasedFile);
            new Gson().toJson(userCars, pw);
            pw.close();
        }
    }

    JOptionPane.showMessageDialog(this, "Car updated successfully!");
    loadCarData();

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error updating car: " + e.getMessage());
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select a row to delete.");
        return;
    }

    try {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to delete this car?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        File file = new File("Cars.json");
        java.lang.reflect.Type listType = new TypeToken<List<Car>>() {}.getType();
        List<Car> carList = new ArrayList<>();

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            carList = new Gson().fromJson(reader, listType);
            reader.close();
        }

        int carID = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        carList.removeIf(car -> car.getCarID() == carID);

        FileWriter writer = new FileWriter("Cars.json");
        new Gson().toJson(carList, writer);
        writer.close();

        JOptionPane.showMessageDialog(this, "Car deleted successfully!");
        loadCarData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error deleting car: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
