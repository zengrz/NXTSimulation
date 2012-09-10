/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

/**
 *
 * @author rey
 */
public class Display extends java.awt.Canvas {

    public Display(int width, int height, Simulation owner) {
        setSize(width, height);
        setBackground(Color.black);
        sim = owner;
    }

    public void render() {
        if (buffer == null) {
            createBufferStrategy(2);
            buffer = getBufferStrategy();
        }
        if (getGraphics() != null) {
            Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
            g.clearRect(0, 0, getWidth(), getHeight());
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            sim.paint(g);
            g.dispose();
            buffer.show();
        }
    }

    private BufferStrategy buffer;
    private Simulation sim;
}