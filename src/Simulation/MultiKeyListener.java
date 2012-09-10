/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * 
 * @author rey
 */
public class MultiKeyListener implements KeyListener {

    private ArrayList<Integer> keyCodes;

    /**
     * Create a new <code>MultiKeyListener</code>
     */
    public MultiKeyListener() {
        keyCodes = new ArrayList();
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if (keyCodes.indexOf(e.getKeyCode()) == -1)
            keyCodes.add(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        int i = keyCodes.indexOf(e.getKeyCode());
        if (i != -1) keyCodes.remove(i);
    }

    /**
     * Return an <code>ArrayList<code> of key codes that are currently being pressed.
     * @return a list of keys being pressed.
     */
    public ArrayList<Integer> getKeys() {
        return keyCodes;
    }

    public void clearKeys() {
        keyCodes.clear();
    }
}