package StarterFiles_Obsolete;


import java.awt.event.*;

public class SimulationFrame extends javax.swing.JFrame {

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    TwoWheelNXT bot = new JanetkaBot();
    TimingThread TT;
    long lastTime;
    int TIMEDELAY = 200;

    /** Creates new form SimulationFrame */
    public SimulationFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonActive = new java.awt.Button();
        buttonStop = new java.awt.Button();
        label1 = new java.awt.Label();

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

        buttonActive.setLabel("Active");
        buttonActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActiveActionPerformed(evt);
            }
        });

        buttonStop.setLabel("Stop");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        label1.setText("label1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(buttonStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(492, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println("form pressed");
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            left = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (keyCode == KeyEvent.VK_UP) {
            up = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            down = true;
        }
        showKeys();
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        System.out.println("form rel");
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
        showKeys();
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void buttonActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActiveActionPerformed
        this.setFocusable(true);
        this.requestFocus();
        //start the thread to ask this Frame to updateNXT every so often...
        /////add in time interval from slider
        if ((TT != null) && (TT.isAlive())) {
            System.out.println("Already running loop!");
            return;
        }

        lastTime = System.currentTimeMillis();
        TT = new TimingThread(this, TIMEDELAY);
        TT.start();

    }//GEN-LAST:event_buttonActiveActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        TT.active = false;
        TT = null;
    }//GEN-LAST:event_buttonStopActionPerformed

    public void updateAll() {
        //do any variable 
        updateVariables();
        updateScreen();
        updateNXT();
    }

    //return the change in time since last deltaTime() call...
    public long deltaTime() {
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - lastTime;
        lastTime = currentTime;
        return deltaTime;
    }

    //read the key states and send as one command
    //This is now sent to the TwoWheelNXT handleCommand method where
    //students start their code...
    public void updateNXT() {

        int sendThis = 0;
        if (up) {
            sendThis = sendThis + 1;
        }
        if (right) {
            sendThis = sendThis + 2;
        }
        if (down) {
            sendThis = sendThis + 4;
        }
        if (left) {
            sendThis = sendThis + 8;
        }
        bot.handleCommand(sendThis);
    }

    //this method will take the current values in the TwoWheelNXT and
    //update&calculate the new speeds, positions, angles, rotations, etc.
    public void updateVariables() {
        System.out.println("Time passed --> " + deltaTime());
        label1.setText(Double.toString(bot.Motor.A.getSpeed()));
        //label1.setText("");

    }

    //this method will draw the robot on the screen at the appropriate position
    //and angle since the last time interval.
    public void updateScreen() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SimulationFrame().setVisible(true);
            }
        });
    }

    public void showKeys() {
        System.out.println(left + " " + right + " " + up + " " + down);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonActive;
    private java.awt.Button buttonStop;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
