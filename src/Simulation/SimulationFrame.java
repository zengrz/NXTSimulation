package Simulation;

public class SimulationFrame extends javax.swing.JFrame {

    public SimulationFrame(SimpleSimulation simthread) {
        this.simthread = simthread;
        initComponents();
        setFocusable(true);
        setResizable(false);
        setSize(SimulationConstants.COMPOUND_WIDTH, SimulationConstants.COMPOUND_HEIGHT / 3 * 2);
        setTitle("Janetka bot Simulation 2.5 BETA for CS 2011 - (April 11, 2011)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        coordinatesLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        focusButton = new javax.swing.JButton();
        activeButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        gridChcekBox = new javax.swing.JCheckBox();
        compassCheckBox = new javax.swing.JCheckBox();
        SpeedCheckBox = new javax.swing.JCheckBox();
        mapCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        scaleSlider = new javax.swing.JSlider();
        scaleLbl = new javax.swing.JLabel();
        fpsLbl = new javax.swing.JLabel();
        kpsSlider = new javax.swing.JSlider();
        kpsLbl = new javax.swing.JLabel();
        fpsSlider = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        perspecCombo = new javax.swing.JComboBox();
        perspecLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        optionMI = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMI = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setFocusTraversalPolicyProvider(true);
        setName("bgFrame");
        setPreferredSize(new java.awt.Dimension(960, 640));
        setResizable(false);

        coordinatesLbl.setText("Mouse coordinates: (0, 0)");

        focusButton.setLabel("Request Focus");
        focusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                focusButtonActionPerformed(evt);
            }
        });

        activeButton.setText("Start");
        activeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(focusButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(focusButton)
                    .addComponent(activeButton)
                    .addComponent(stopButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridChcekBox.setText("Show Grid");

        compassCheckBox.setText("Show Compass");

        SpeedCheckBox.setText("Show Speed");

        mapCheckBox.setText("Show Map");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gridChcekBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compassCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpeedCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mapCheckBox)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridChcekBox)
                    .addComponent(compassCheckBox)
                    .addComponent(SpeedCheckBox)
                    .addComponent(mapCheckBox))
                .addContainerGap())
        );

        scaleSlider.setMaximum(10);
        scaleSlider.setMinimum(-5);
        scaleSlider.setValue(0);
        scaleSlider.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scaleSliderPropertyChange(evt);
            }
        });

        scaleLbl.setText("Scale Control:");

        fpsLbl.setText("FPS Control:");

        kpsSlider.setMaximum(25);
        kpsSlider.setValue(5);

        kpsLbl.setText("KPS Control:");

        fpsSlider.setMaximum(50);
        fpsSlider.setMinimum(10);
        fpsSlider.setValue(30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scaleLbl)
                            .addGap(4, 4, 4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(fpsLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kpsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scaleSlider, 0, 0, Short.MAX_VALUE)
                    .addComponent(kpsSlider, 0, 0, Short.MAX_VALUE)
                    .addComponent(fpsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kpsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kpsLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fpsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fpsLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scaleLbl)
                    .addComponent(scaleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        perspecCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Free-view", "Center", "First Person" }));
        perspecCombo.setEnabled(false);

        perspecLbl.setText("Perspective:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perspecLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perspecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perspecLbl)
                    .addComponent(perspecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jMenu1.setText("File");

        optionMI.setLabel("Options");
        optionMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMIActionPerformed(evt);
            }
        });
        jMenu1.add(optionMI);
        jMenu1.add(jSeparator2);

        exitMI.setLabel("Exit");
        jMenu1.add(exitMI);
        exitMI.getAccessibleContext().setAccessibleName("Exit");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(coordinatesLbl))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(497, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(coordinatesLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeButtonActionPerformed
        if (simthread != null) {
            if (!simthread.isRunning()) {
                simthread.start();
                perspecCombo.setEnabled(true);
                simthread.resetCamera();
                simthread.requestFocus();
            }
        }
    }//GEN-LAST:event_activeButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if (simthread != null) {
            if (simthread.isRunning()) {
                simthread.stop();
            }
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void focusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_focusButtonActionPerformed
        simthread.requestFocus();
    }//GEN-LAST:event_focusButtonActionPerformed

    private void scaleSliderPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scaleSliderPropertyChange
        simthread.setCamera(simthread.getCamX()*simthread.getScaleFactor(), simthread.getCamY()*simthread.getScaleFactor());
    }//GEN-LAST:event_scaleSliderPropertyChange

    private void optionMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionMIActionPerformed

    public int getFPSValue() {
        return fpsSlider.getValue();
    }

    public int getKPSValue() {
        return kpsSlider.getValue() + 5;
    }

    public double getScaleFactor() {
        return (1 + scaleSlider.getValue() / 10.0);
    }

    public boolean showMap() {
        return mapCheckBox.isSelected();
    }

    public boolean showCompass() {
        return compassCheckBox.isSelected();
    }

    public boolean showSpeed() {
        return SpeedCheckBox.isSelected();
    }

    public boolean showGrid() {
        return gridChcekBox.isSelected();
    }

    public int getMode() {
        return perspecCombo.getSelectedIndex();
    }

    public void setMouseCoordinates(int x, int y) {
        coordinatesLbl.setText("Mouse Coordinates: (" + x + ", " + y + ")");
    }
    
    private SimpleSimulation simthread;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox SpeedCheckBox;
    private javax.swing.JButton activeButton;
    private javax.swing.JCheckBox compassCheckBox;
    private javax.swing.JLabel coordinatesLbl;
    private javax.swing.JMenuItem exitMI;
    private javax.swing.JButton focusButton;
    private javax.swing.JLabel fpsLbl;
    private javax.swing.JSlider fpsSlider;
    private javax.swing.JCheckBox gridChcekBox;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel kpsLbl;
    private javax.swing.JSlider kpsSlider;
    private javax.swing.JCheckBox mapCheckBox;
    private javax.swing.JMenuItem optionMI;
    private javax.swing.JComboBox perspecCombo;
    private javax.swing.JLabel perspecLbl;
    private javax.swing.JLabel scaleLbl;
    private javax.swing.JSlider scaleSlider;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}