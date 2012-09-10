package SimulationWindow_Obsolete;

import NXTBot.NXTBotFrame;
import Obstacles.*;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SimulationFrame extends javax.swing.JFrame {

    public SimulationFrame() {
        initComponents();
        setFocusable(true);
        setResizable(false);
        setSize(COMPOUND_WIDTH, COMPOUND_HEIGHT/3*2);
        setTitle("Janetka bot Simulation 2.0 BETA for CS 2011 - (April 8, 2011)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
        simthread = new SimulationThread(this);
        panel = new Display(getWidth(), getHeight() / 5 * 4, this);
        add(panel);
        tmr = new Timer();
        up = down = left = right = false;
        // initialize bots
        bot = new NXTBotFrame(200, 200, 0);
        // initialize obstacles
        Pylon pylon = new Pylon(300, 300, 0.6);
        obstacles = new ArrayList<Drawable>();
        obstacles.add(pylon);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fpsSlider = new javax.swing.JSlider();
        activeButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        fpsLbl = new javax.swing.JLabel();
        scaleLbl = new javax.swing.JLabel();
        scaleSlider = new javax.swing.JSlider();
        coordinatesLbl = new javax.swing.JLabel();
        perspecLbl = new javax.swing.JLabel();
        perspecCombo = new javax.swing.JComboBox();
        focusButton = new javax.swing.JButton();
        gridChcekBox = new javax.swing.JCheckBox();
        compassCheckBox = new javax.swing.JCheckBox();
        SpeedCheckBox = new javax.swing.JCheckBox();
        mapCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setFocusTraversalPolicyProvider(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        fpsSlider.setMaximum(50);
        fpsSlider.setMinimum(10);
        fpsSlider.setValue(30);

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

        fpsLbl.setText("FPS Control:");

        scaleLbl.setText("Scale Control:");

        scaleSlider.setMaximum(10);
        scaleSlider.setMinimum(-5);
        scaleSlider.setValue(0);

        coordinatesLbl.setText("Mouse coordinates: (0, 0)");

        perspecLbl.setText("Perspective:");

        perspecCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Free-view", "Center", "First Person" }));
        perspecCombo.setEnabled(false);
        perspecCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perspecComboActionPerformed(evt);
            }
        });

        focusButton.setLabel("Request Focus");
        focusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                focusButtonActionPerformed(evt);
            }
        });

        gridChcekBox.setText("Show Grid");
        gridChcekBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridChcekBoxActionPerformed(evt);
            }
        });

        compassCheckBox.setText("Show Compass");
        compassCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compassCheckBoxActionPerformed(evt);
            }
        });

        SpeedCheckBox.setText("Show Speed");
        SpeedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeedCheckBoxActionPerformed(evt);
            }
        });

        mapCheckBox.setText("Show Map");
        mapCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scaleLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(focusButton)
                        .addGap(18, 18, 18)
                        .addComponent(activeButton)
                        .addGap(18, 18, 18)
                        .addComponent(stopButton)
                        .addGap(49, 49, 49)
                        .addComponent(fpsLbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(gridChcekBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(compassCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpeedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapCheckBox)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scaleSlider, 0, 0, Short.MAX_VALUE)
                            .addComponent(fpsSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(perspecLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(perspecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(287, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                        .addComponent(coordinatesLbl)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(554, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(focusButton)
                        .addComponent(activeButton)
                        .addComponent(stopButton)
                        .addComponent(fpsLbl))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perspecLbl)
                            .addComponent(perspecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fpsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scaleLbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gridChcekBox)
                            .addComponent(compassCheckBox)
                            .addComponent(SpeedCheckBox)
                            .addComponent(mapCheckBox))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scaleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(coordinatesLbl))))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (keyCode == KeyEvent.VK_UP) {
            up = true;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            down = true;
        }

        if (mode == Mode.FREE_VIEW) {
            double effectiveScroll = DELTA_SCROLL * scaleFactor;
            if (keyCode == KeyEvent.VK_NUMPAD8) {
                camY += effectiveScroll;
            } else if (keyCode == KeyEvent.VK_NUMPAD2) {
                camY -= effectiveScroll;
            } else if (keyCode == KeyEvent.VK_NUMPAD4) {
                camX += effectiveScroll;
            } else if (keyCode == KeyEvent.VK_NUMPAD6) {
                camX -= effectiveScroll;
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            left = false;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (keyCode == KeyEvent.VK_UP) {
            up = false;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            down = false;
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
    }//GEN-LAST:event_formKeyTyped

    private void activeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeButtonActionPerformed
        if ((simthread != null) && (simthread.isAlive())) {
            System.out.println("Already running loop!");
            requestFocus();
            return;
        }
        simthread = new SimulationThread(this);
        simthread.start();
        tmr.start();
        perspecCombo.setEnabled(true);
        mode = Mode.FREE_VIEW;
        camX = camY = 0;
        requestFocus();
    }//GEN-LAST:event_activeButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if (simthread != null) {
            simthread.setAcive(false);
            simthread = null;
            tmr.stop();
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void perspecComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perspecComboActionPerformed
        if (perspecCombo.getSelectedIndex() == 0) {
            mode = Mode.FREE_VIEW;
            // adjust camera
            camX = panel.getWidth()/2 - bot.getCenterX();
            camY = panel.getHeight()/2 - bot.getCenterY();
        } else if (perspecCombo.getSelectedIndex() == 1) {
            mode = Mode.CENTER;
        } else if (perspecCombo.getSelectedIndex() == 2) {
            mode = Mode.FIRST_PERSON;
        }
    }//GEN-LAST:event_perspecComboActionPerformed

    private void focusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_focusButtonActionPerformed
        requestFocus();
    }//GEN-LAST:event_focusButtonActionPerformed

    private void gridChcekBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridChcekBoxActionPerformed
        if (gridChcekBox.isSelected()) {
            showGrid = true;
        } else {
            showGrid = false;
        }
    }//GEN-LAST:event_gridChcekBoxActionPerformed

    private void compassCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compassCheckBoxActionPerformed
        if (compassCheckBox.isSelected()) {
            showCompass = true;
        } else {
            showCompass = false;
        }
    }//GEN-LAST:event_compassCheckBoxActionPerformed

    private void SpeedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeedCheckBoxActionPerformed
        if (SpeedCheckBox.isSelected()) {
            showSpeed = true;
        } else {
            showSpeed = false;
        }
    }//GEN-LAST:event_SpeedCheckBoxActionPerformed

    private void mapCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapCheckBoxActionPerformed
        if (mapCheckBox.isSelected()) {
            showMap = true;
        } else {
            showMap = false;
        }
    }//GEN-LAST:event_mapCheckBoxActionPerformed
    /**
     * Update and draw
     */
    public void updateAll() {
        updateVariables();
        updateNXT();
        updateScreen();
    }

    private void updateVariables() {
        simthread.setFPS(fpsSlider.getValue());
        scaleFactor = 1 + scaleSlider.getValue() / 10.0;
    }

    private void updateNXT() {
        int sendThis = 0;
        if (up) {
            sendThis += 1;
        }
        if (right) {
            sendThis += 2;
        }
        if (down) {
            sendThis += 4;
        }
        if (left) {
            sendThis += 8;
        }
        bot.handleCommand(sendThis);
        bot.update(tmr.delta());
    }

    private void updateScreen() {
        panel.render();
    }

    public void paint(Graphics2D g) {        
        // initialize for drawing
        if (showMap) {drawMap(g);}
        g.setColor(Color.yellow);
        displayMSG(g);
        // draw gadgets
        if (showCompass) {drawCompass(g);}
        if (showSpeed) {drawSpeedBars(g);}
        // initialize transform
        AffineTransform af = g.getTransform();
        af.scale(scaleFactor, scaleFactor);
        // update mode
        if (mode == Mode.FREE_VIEW) {            
            af.translate(camX, camY);
        } else if (mode == Mode.CENTER) {
            camX = panel.getWidth()/2 / scaleFactor - bot.getCenterX();
            camY = panel.getHeight()/2 / scaleFactor - bot.getCenterY();
            af.translate(camX, camY);
        } else if (mode == Mode.FIRST_PERSON) {
            camX = panel.getWidth()/2 / scaleFactor - bot.getCenterX();
            camY = panel.getHeight()/2 / scaleFactor - bot.getCenterY();
            af.translate(camX, camY);
            af.rotate(-bot.getDirection() - Math.PI/2, bot.getCenterX(), bot.getCenterY());
        }
        g.setTransform(af);
        // draw grid
        if (showGrid) {drawGrid(g);}        
        // draw panel compound
        g.setColor(Color.yellow);
        g.drawRect(0, 0, COMPOUND_WIDTH, COMPOUND_HEIGHT);
        // draw main objects
        for (Drawable d: obstacles) {
            d.paint(g);
            g.setTransform(af);
        }
        bot.paint(g);
        g.setTransform(af);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationFrame().setVisible(true);
            }
        });
    }

    /**
     * Draw helper
     */

    private void drawGrid(Graphics2D g) {
        g.setColor(Color.green);
        float alpha = .3f;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        double factor = GRID_SIZE * scaleFactor;
        for (int i = -INFINITY / (int)factor; i < INFINITY / factor; i++) {
            g.drawLine(i * (int) factor, -INFINITY, i * (int) factor, INFINITY);
        }
        for (int i = -INFINITY / (int)factor; i < INFINITY / factor; i++) {
            g.drawLine(-INFINITY, i * (int) factor, INFINITY, i * (int) factor);
        }
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
    }

    private void drawCompass(Graphics2D g) {
        // setup position vaiables
        int centerX = 60;
        int centerY = 65;
        int verticalAxisLength = 33;
        int horizontalAxisLength = 10;
        double dir = (bot.getDegreeDirection() >= 0) ? bot.getDegreeDirection() : 360 + bot.getDegreeDirection();
        g.drawString("Approx. Direction: " + (int)dir, centerX - 40, centerY + verticalAxisLength + 30);
        // set rotation for first person mode
        if (mode == Mode.FIRST_PERSON)
            g.rotate(-(bot.getDirection() + Math.PI/2), centerX, centerY);
        // draw compass with lots of math
        g.setColor(Color.yellow);
        g.drawLine(centerX, centerY - verticalAxisLength, centerX, centerY + verticalAxisLength);
        g.drawLine(centerX - horizontalAxisLength, centerY, centerX + horizontalAxisLength, centerY);
        int[] xPoints = {centerX - horizontalAxisLength/2, centerX + horizontalAxisLength/2, centerX};
        int[] yPoints = {centerY - verticalAxisLength, centerY - verticalAxisLength, centerY - verticalAxisLength - 5};
        g.drawPolygon(xPoints, yPoints, 3);
        g.drawString("N", centerX - 5, centerY - 40);
        // set rotation back for drawing
        if (mode == Mode.FIRST_PERSON)
            g.rotate(bot.getDirection() + Math.PI/2, centerX, centerY);
    }

    private void drawSpeedBars(Graphics2D g) {
        // set up position variables
        int maxHeight = panel.getHeight()/3;
        int width = 10;
        int centerY = panel.getHeight()/2;
        int centerXLeft = 900;
        int centerXRight = centerXLeft + 2 * width;
        int AHeight, BHeight;
        // draw labels
        g.drawString("A", centerXLeft - width/2, centerY - maxHeight - 10);
        g.drawString("B", centerXRight - width/2, centerY - maxHeight - 10);
        g.drawString("Speed", (centerXLeft + centerXRight)/2 - 20, centerY - maxHeight - 30);
        g.drawRect(centerXLeft - width, centerY - maxHeight, width * 4, maxHeight * 2);
        g.drawLine(centerXLeft - width, centerY, centerXLeft + width * 3, centerY);
        g.drawLine(centerXLeft + width, centerY - maxHeight, centerXLeft + width, centerY + maxHeight);
        // draw speed bars awkwardly
        AHeight = (int)(bot.getASpeed() / bot.getAMaxSpeed() * maxHeight);
        BHeight = (int)(bot.getBSpeed() / bot.getBMaxSpeed() * maxHeight);
        if (AHeight > 0) {
            g.fillRect(centerXLeft - width/2, centerY - AHeight, width, AHeight);            
        } else {
            g.fillRect(centerXLeft - width/2, centerY, width, -AHeight);
        }
        if (BHeight > 0) {
            g.fillRect(centerXRight - width/2, centerY - BHeight, width, BHeight);
        } else {
            g.fillRect(centerXRight - width/2, centerY, width, -BHeight);
        }
    }

    private void drawMap(Graphics2D g) {
        // get the compatible image for drawing
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();
        BufferedImage mapImg = config.createCompatibleImage(COMPOUND_WIDTH, COMPOUND_HEIGHT, Transparency.TRANSLUCENT);
        // initialize for drawing
        Graphics2D tempg = (Graphics2D) mapImg.getGraphics();
        float alpha = .3f;        
        tempg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        tempg.setColor(Color.green);
        // draw background
        tempg.fillRect(0, 0, COMPOUND_WIDTH, COMPOUND_HEIGHT);
        // draw objects
        tempg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        tempg.setColor(Color.red);
        for (Drawable d: obstacles) {
            tempg.fillRect(d.getX(), d.getY(), d.getWidth(), d.getHeight());
        }
        tempg.setColor(Color.white);
        tempg.fillRect((int)bot.getAX(), (int)bot.getAY(), bot.getBound().width, bot.getBound().height);
        // draw map
        g.drawImage(mapImg, MAP_MARGIN, panel.getHeight() - MAP_MARGIN - panel.getWidth()/6, panel.getWidth()/6, panel.getWidth()/6, null);
        g.setColor(Color.white);
        // draw border
        g.drawRect(MAP_MARGIN, panel.getHeight() - MAP_MARGIN - panel.getWidth()/6, panel.getWidth()/6, panel.getWidth()/6);
    }

    private void displayMSG(Graphics2D g) {
        // show FPS
        g.drawString("FPS: " + simthread.getFPS() + " / " + fpsSlider.getValue(), 850, 15);
        // show scale
        g.drawString("Scale factor: " + scaleFactor, 850, 30);
        // show instruction
        if (mode == Mode.FREE_VIEW) {
            String instr = "Free-view mode: Use \"8\", \"4\", \"6\", \"2\" to move camera.";
            g.drawString(instr, panel.getWidth()/2 - instr.length()/2*6, 15);
        }
        // show warning
        if (bot.getCenterX() < 0 || bot.getCenterY() < 0 || bot.getCenterX() > COMPOUND_WIDTH || bot.getCenterY() > COMPOUND_HEIGHT) {
            String warning = "WARNING: " + bot.getModel() + "-\"" + bot.getName() + "\" is out of bound.";
            g.drawString(warning, panel.getWidth()/2 - warning.length()/2*6 , panel.getHeight() - MAP_MARGIN - 15);
        }
    }

    /**
     * Miscellaneous
     */
    public void setMouseCoordinatesLabel(int x, int y) {
        if (simthread.isActive()) {
            coordinatesLbl.setText("Mouse Coordinates: (" + (int)(x / scaleFactor - camX) + ", " + (int)(y / scaleFactor - camY) + ")");
        }
    }

    private boolean up, down, left, right;
    private boolean showGrid, showCompass, showSpeed, showMap;
    private double camX, camY;
    private double scaleFactor;
    private Mode mode;
    private Timer tmr;
    private SimulationThread simthread;
    private Display panel;
    private NXTBotFrame bot;
    private ArrayList<Drawable> obstacles;

    public enum Mode {
        FREE_VIEW, CENTER, FIRST_PERSON
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox SpeedCheckBox;
    private javax.swing.JButton activeButton;
    private javax.swing.JCheckBox compassCheckBox;
    private javax.swing.JLabel coordinatesLbl;
    private javax.swing.JButton focusButton;
    private javax.swing.JLabel fpsLbl;
    private javax.swing.JSlider fpsSlider;
    private javax.swing.JCheckBox gridChcekBox;
    private javax.swing.JCheckBox mapCheckBox;
    private javax.swing.JComboBox perspecCombo;
    private javax.swing.JLabel perspecLbl;
    private javax.swing.JLabel scaleLbl;
    private javax.swing.JSlider scaleSlider;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    public static final int GRID_SIZE = 40;
    public static final int INFINITY = 3000;
    public static final int DELTA_SCROLL = 10;
    public static final int MAP_MARGIN = 10;
    public static final int COMPOUND_WIDTH = 960; // in real cm
    public static final int COMPOUND_HEIGHT = 960; // in real cm
}