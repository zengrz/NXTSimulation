package SimulationWindow_Obsolete;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

public class Display extends java.awt.Canvas
        implements MouseMotionListener {

    public Display(int width, int height, SimulationFrame owner) {
        setSize(width, height);
        setBackground(Color.black);
        setIgnoreRepaint(true);
        frm = owner;
        addMouseMotionListener(this);
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
            frm.paint(g);
            g.dispose();
            buffer.show();
        }
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        frm.setMouseCoordinatesLabel(e.getX(), e.getY());
        frm.requestFocus();
    }

    private BufferStrategy buffer;
    private SimulationFrame frm;
}