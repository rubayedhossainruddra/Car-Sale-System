
package Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
public class ManageCar1 extends javax.swing.JFrame {
  private List<Car> carList = new ArrayList<>();
  
 private String currentUsername;
    
    public ManageCar1(String username) {
        this.currentUsername = username;
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
        carList = new ArrayList<>();

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            java.lang.reflect.Type listType = new TypeToken<List<Car>>() {}.getType();
            carList = new Gson().fromJson(reader, listType);
            reader.close();
        }

        if (carList == null) carList = new ArrayList<>();

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"CarID", "Brand", "Model", "Year", "Type", "Fuel", "Transmission", "Condition",
                         "Color", "Status", "Price", "Customer", "Payment", "Address", "Email", "Phone", "IC"}, 0);

        for (Car car : carList) {
            model.addRow(new Object[]{
                car.getCarID(), car.getBrand(), car.getModel(), car.getYear(), car.getType(),
                car.getFuel(), car.getTransmission(), car.getCondition(), car.getColor(),
                car.getStatus(), car.getPrice(), car.getCustomerUsername(), car.getPayment(),
                car.getAddress(), car.getEmail(), car.getPhone(), car.getIc()
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
        jLabel4 = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 920, 700));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 360, 50));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Honda", "Nissan", "Ford", "Chevrolet", "BMW", "Mercedes-Benz", "Audi", "Hyundai", "Kia", "Volkswagen", "Mazda", "Subaru", "Lexus", "Mitsubishi", "BYD", "Proton", "Tesla", "Suzuki", "Peugeot", "Renault", "Volvo" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 300, 40));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "Hatchback", "SUV", "Coupe", "Convertible", "Wagon", "Pickup Truck", "Van", "Minivan", "Crossover", "Sports Car", "Luxury Car", "Electric Car", "Hybrid Car", "Off-Road", "Compact", "Microcar", "Roadster", "Limousine", "Jeep" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 300, 40));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petrol", "Diesel", "Electric", "Hybrid", "CNG", "LPG" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 300, 40));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatic", "CVT", "Dual-Clutch" }));
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 420, 300, 40));

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Used", "Reconditioned" }));
        getContentPane().add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 300, 40));

        jComboBox6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Sold", "Reserved" }));
        getContentPane().add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 560, 300, 40));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 360, 60));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 640, 360, 60));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 740, 360, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 51));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 820, 170, 50));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 820, 170, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 51));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 890, 170, 50));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 890, 170, 50));

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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fuel");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Transmission");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Condition");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 470, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Status");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setLayout(null);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(940, 620, 40, 20);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Price");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(940, 720, 34, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Manage Car");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 50, 329, 44);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Brand");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(950, 20, 41, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Model");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(940, 90, 60, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 970));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Color");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 620, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 720, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         new SalesmanProfile(currentUsername).setVisible(true);
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

        Gson gson = new Gson();
        List<Car> carList = new ArrayList<>();

        File globalFile = new File("Cars.json");
        if (globalFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(globalFile));
            Car[] carArray = gson.fromJson(reader, Car[].class);
            reader.close();
            if (carArray != null) {
                for (Car c : carArray) {
                    carList.add(c);
                }
            }
        }

        int nextCarID = carList.isEmpty() ? 1 : carList.get(carList.size() - 1).getCarID() + 1;

        Car newCar = new Car(nextCarID, brand, model, year, type, fuel, transmission, condition, color, status, price, "", "", "", "", "", "");
        newCar.setSalesmanUsername(currentUsername); // ✅ SET SALESMAN

        carList.add(newCar);
        FileWriter writer = new FileWriter(globalFile);
        gson.toJson(carList, writer);
        writer.close();

        File salesmanFile = new File("Salesman/" + currentUsername + "/Cars.json");
        if (!salesmanFile.getParentFile().exists()) {
            salesmanFile.getParentFile().mkdirs();
        }

        List<Car> salesmanCars = new ArrayList<>();
        if (salesmanFile.exists()) {
            BufferedReader reader2 = new BufferedReader(new FileReader(salesmanFile));
            Car[] carArray = gson.fromJson(reader2, Car[].class);
            reader2.close();
            if (carArray != null) {
                for (Car c : carArray) {
                    salesmanCars.add(c);
                }
            }
        }

        salesmanCars.add(newCar);
        FileWriter writer2 = new FileWriter(salesmanFile);
        gson.toJson(salesmanCars, writer2);
        writer2.close();

        JOptionPane.showMessageDialog(this, "Car added successfully!");
        loadCarData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding car: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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

        Gson gson = new Gson();
        List<Car> carList = new ArrayList<>();

        File globalFile = new File("Cars.json");
        if (globalFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(globalFile));
            Car[] carArray = gson.fromJson(reader, Car[].class);
            reader.close();
            if (carArray != null) {
                for (Car c : carArray) {
                    carList.add(c);
                }
            }
        }

        int nextCarID = carList.isEmpty() ? 1 : carList.get(carList.size() - 1).getCarID() + 1;

        Car newCar = new Car(nextCarID, brand, model, year, type, fuel, transmission, condition, color, status, price, "", "", "", "", "", "");
        newCar.setSalesmanUsername(currentUsername); // ✅ SET SALESMAN

        carList.add(newCar);
        FileWriter writer = new FileWriter(globalFile);
        gson.toJson(carList, writer);
        writer.close();

        File salesmanFile = new File("Salesman/" + currentUsername + "/Cars.json");
        if (!salesmanFile.getParentFile().exists()) {
            salesmanFile.getParentFile().mkdirs();
        }

        List<Car> salesmanCars = new ArrayList<>();
        if (salesmanFile.exists()) {
            BufferedReader reader2 = new BufferedReader(new FileReader(salesmanFile));
            Car[] carArray = gson.fromJson(reader2, Car[].class);
            reader2.close();
            if (carArray != null) {
                for (Car c : carArray) {
                    salesmanCars.add(c);
                }
            }
        }

        salesmanCars.add(newCar);
        FileWriter writer2 = new FileWriter(salesmanFile);
        gson.toJson(salesmanCars, writer2);
        writer2.close();

        JOptionPane.showMessageDialog(this, "Car added successfully!");
        loadCarData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding car: " + e.getMessage());
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

        int carID = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        Gson gson = new Gson();

        // === Delete from Global Cars.json
        File globalFile = new File("Cars.json");
        List<Car> carList = new ArrayList<>();

        if (globalFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(globalFile));
            Car[] carArray = gson.fromJson(reader, Car[].class);
            reader.close();
            if (carArray != null) {
                for (Car c : carArray) {
                    carList.add(c);
                }
            }
        }

        carList.removeIf(car -> car.getCarID() == carID);
        FileWriter writer = new FileWriter(globalFile);
        gson.toJson(carList, writer);
        writer.close();

        // === Delete from Salesman/<username>/Cars.json
        File salesmanFile = new File("Salesman/" + currentUsername + "/Cars.json");
        List<Car> salesmanCars = new ArrayList<>();

        if (salesmanFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(salesmanFile));
            Car[] carArray2 = gson.fromJson(reader, Car[].class);
            reader.close();

            if (carArray2 != null) {
                for (Car c : carArray2) {
                    salesmanCars.add(c);
                }
            }

            salesmanCars.removeIf(car -> car.getCarID() == carID);
            FileWriter writer2 = new FileWriter(salesmanFile);
            gson.toJson(salesmanCars, writer2);
            writer2.close();
        }

        JOptionPane.showMessageDialog(this, "Car deleted successfully!");
        loadCarData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error deleting car: " + e.getMessage());
        e.printStackTrace();
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

 
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String username = "";
                new ManageCar1(username).setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
