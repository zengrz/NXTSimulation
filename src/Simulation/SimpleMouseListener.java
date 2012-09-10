/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author rey
 */
public class SimpleMouseListener implements MouseListener, MouseMotionListener {

    public SimpleMouseListener(Display parent) {
        x = y = 0;
        this.parent = parent;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        parent.requestFocus();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {        
        parent.requestFocus();
    }

    public void mouseExited(MouseEvent e) {
        parent.requestFocus();
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset() {
        x = y = 0;
    }

    private int x, y;
    private Display parent;

}