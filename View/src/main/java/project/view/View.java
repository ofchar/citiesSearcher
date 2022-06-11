/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.view;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import project.model.City;
import project.model.CityController;
import project.model.exceptions.ModelException;

/**
 *
 * @author mat28
 */
public class View extends javax.swing.JFrame {

    private CityController cityController;
    private City currentCity;

    /**
     * Creates new form MainView
     */
    public View() {
        try {
            this.cityController = new CityController();
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        
        JTableHeader header = jTable2.getTableHeader();
        
        header.setForeground(new java.awt.Color(229, 151, 252));
        header.setBackground(new java.awt.Color(10, 10, 10));
        header.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        jRadioButton1.setText("jRadioButton1");

        jMenuItem6.setText("jMenuItem6");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(69, 69, 69));

        jList1.setBackground(new java.awt.Color(10, 10, 10));
        jList1.setForeground(new java.awt.Color(229, 151, 252));
        jList1.setSelectionBackground(new java.awt.Color(219, 117, 250));
        jList1.setVerifyInputWhenFocusTarget(false);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setBackground(new java.awt.Color(10, 10, 10));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 151, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cities");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jTable2.setBackground(new java.awt.Color(10, 10, 10));
        jTable2.setForeground(new java.awt.Color(229, 151, 252));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(21, 0, 37));
        jButton1.setForeground(new java.awt.Color(229, 151, 252));
        jButton1.setText("delete selected");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 21, 37));
        jButton2.setForeground(new java.awt.Color(229, 151, 252));
        jButton2.setText("add new");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(10, 10, 10));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 151, 252));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("City");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        jMenuBar1.setBackground(new java.awt.Color(10, 10, 10));
        jMenuBar1.setForeground(new java.awt.Color(229, 151, 252));
        jMenuBar1.setOpaque(true);

        jMenu1.setText("XML");

        jMenuItem1.setText("open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("validate");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("xpath");

        jMenuItem3.setText("cities by name");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("cities of countries");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("cities by min population");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setText("cities by climate");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("all capitals");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem16.setText("by timezone");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem17.setText("by min altitude");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuItem18.setText("cities by first language");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("transformations");

        jMenuItem10.setText("flags");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem9.setText("cities of country");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem11.setText("5 most populous");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("monuments of city");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("cities by language");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("capital of country");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("cities by area and population");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem19.setText("twin cities of city");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkValidation() {
        try {
            if (!cityController.validateDocument()) {
                JOptionPane.showMessageDialog(this,
                        "oh no, document is incorrect :(((((",
                        "failure :(",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadXML(List<City> cities) {
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() {
                return cities.size();
            }

            public String getElementAt(int i) {
                return cities.get(i).getName() + " -- " + cities.get(i).getCountry();
            }
        });
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            this.loadXML(cityController.index());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (evt.getValueIsAdjusting() || jList1.getSelectedValue() == null) {
            return;
        }

        try {
            City city = cityController.get(jList1.getSelectedValue().split(" -- ")[0]);

            this.currentCity = city;

            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {"name", city.getName()},
                        {"country", city.getCountry()},
                        {"isCapital", city.isCapital()},
                        {"countryFlag", city.getCountryFlag()},
                        {"area", city.getArea()},
                        {"inhabitants", city.getInhabitants()},
                        {"density", city.getPopulationDensity()},
                        {"postalCode", city.getPostalCode()},
                        {"mayor", city.getMayor()},
                        {"latitude", city.getLatitude()},
                        {"longitude", city.getLongitude()},
                        {"altitude", city.getAltitude()},
                        {"climate", city.getClimate()},
                        {"timezone", city.getTimezone()},
                        {"website", city.getWebsite()},
                        {"demonym", city.getDemonym()},
                        {"phoneNumber", city.getPhoneNumber()},},
                    new String[]{
                        "name", "value"
                    }
            ));
        } catch (ModelException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        if (!jTable2.isEditing() && jTable2.getEditingRow() != -1) {
            String propertyName = jTable2.getValueAt(jTable2.getEditingRow(), 0).toString();
            String newValue = jTable2.getValueAt(jTable2.getEditingRow(), 1).toString();

            try {
                cityController.update(currentCity.getName(), propertyName, newValue);
                
                checkValidation();
                
                this.loadXML(cityController.index());
            } catch (ModelException ex) {
                JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTable2PropertyChange

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            if (cityController.validateDocument()) {
                JOptionPane.showMessageDialog(this,
                        "document is correct :)",
                        "success!!!!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "oh no, document is incorrect :(((((",
                        "failure :(",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (currentCity == null) {
            JOptionPane.showMessageDialog(this,
                    "do you think thats funny?",
                    "hey.",
                    JOptionPane.QUESTION_MESSAGE);
            return;
        }

        try {
            cityController.delete(currentCity.getName());

            currentCity = null;
            
            checkValidation();

            this.loadXML(cityController.index());
        } catch (ModelException ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JTextField nameField = new JTextField(5);
        JTextField countryField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("country:"));
        myPanel.add(countryField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "what city?", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                cityController.create(nameField.getText(), countryField.getText());

                this.loadXML(cityController.index());
                
                checkValidation();

            } catch (ModelException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String m = JOptionPane.showInputDialog("enter name");

        try {
            this.loadXML(cityController.getCitiesByName(m));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String m = JOptionPane.showInputDialog("enter name");

        try {
            this.loadXML(cityController.getCitiesOfCountry(m));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String m = JOptionPane.showInputDialog("enter population");

        try {
            this.loadXML(cityController.getCitiesByMinPopulation(Integer.parseInt(m)));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        String m = JOptionPane.showInputDialog("enter climate");

        try {
            this.loadXML(cityController.getCitiesByClimate(m));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            this.loadXML(cityController.getCapitals());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        JTextField firstField = new JTextField(5);
        JTextField secondField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Filename:"));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Country:"));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "waaaat", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cityController.performXQuery(firstField.getText() + ".txt", "..//resources//transformation//citiesCountry.xql", 2, secondField.getText());
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        String m = JOptionPane.showInputDialog("enter filename");
        
        cityController.performXQuery(m + ".html", "..//resources//transformation//flags.xql", 1);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        String m = JOptionPane.showInputDialog("enter filename");

        cityController.transform(m + ".xml", "..//resources//transformation//mostPopCities.xsl");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        JTextField firstField = new JTextField(5);
        JTextField secondField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Filename:"));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("City:"));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "waaaat", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cityController.performXQuery(firstField.getText() + ".html", "..//resources//transformation//monuments.xql", 1, secondField.getText());
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        JTextField firstField = new JTextField(5);
        JTextField secondField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Filename:"));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(15)); 
        myPanel.add(new JLabel("language:"));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "waaaat", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cityController.performXQuery(firstField.getText() + ".html", "..//resources//transformation//cityByLanguage.xql", 1, secondField.getText());
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        JTextField firstField = new JTextField(5);
        JTextField secondField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Filename:"));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(15)); 
        myPanel.add(new JLabel("country:"));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "waaaat", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cityController.performXQuery(firstField.getText() + ".xml", "..//resources//transformation//capitalOfCountry.xql", 3, secondField.getText());
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        String m = JOptionPane.showInputDialog("enter filename");

        cityController.performXQuery(m + ".html", "..//resources//transformation//citiesAreaPopulation.xql", 1);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        String m = JOptionPane.showInputDialog("enter timezone");

        try {
            this.loadXML(cityController.getCitiesByTimezone(m));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        String m = JOptionPane.showInputDialog("enter altitude");

        try {
            this.loadXML(cityController.getCitiesByMinAltitude(Integer.parseInt(m)));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        String m = JOptionPane.showInputDialog("enter language");

        try {
            this.loadXML(cityController.getCitiesByFirstLanguage(m));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        "oh no :((( an error occured :(((",
                        "error :(((",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        JTextField firstField = new JTextField(5);
        JTextField secondField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Filename:"));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(15)); 
        myPanel.add(new JLabel("city:"));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "waaaat", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cityController.performXQuery(firstField.getText() + ".html", "..//resources//transformation//twincitiesOfCity.xql", 1, secondField.getText());
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
