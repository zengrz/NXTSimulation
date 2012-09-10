/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulation;

import NXTBot.NXTBotFrame;
import Obstacles.Drawable;
import Obstacles.Pylon;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rey
 */
public class SimpleSimulation extends Simulation implements SimulationConstants {

    public SimpleSimulation() {
        super();
        frame = new SimulationFrame(this);
        frame.add(display);
    }

    /**
     * Initializing
     */
    @Override
    public void init() {
        keyMulti = new MultiKeyListener();
        display.addKeyListener(keyMulti);
        mouseListnr = new SimpleMouseListener(display);
        display.addMouseListener(mouseListnr);
        display.addMouseMotionListener(mouseListnr);
        camX = camY = 0;
        stepcount = 0;
        // initialize bots
        obstacles = new ArrayList<Drawable>();
        // initialize obstacles, from file
        initMap();
    }

    private void initMap() {
        // read file in format: object, x, y (0 <= x <= COMPOUND_WIDTH, 0 <= Y <= COMPOUND_HEIGHT)
        try {
            BufferedReader fin = new BufferedReader(new FileReader(MAP_FILE));
            int linenum = 0;
            while (true) {
                linenum++;
                String linein = fin.readLine();
                if (linein == null) break;
                initObject(linein, linenum);
            }
            fin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initObject(String linein, int linenum) {
        String[] objline = linein.split("\\s");
        if (objline[0].equals("pylon")) {
            if (objline.length != 4) {
                System.err.println(linenum + ": Wrong number of arguments at line.");
            } else {
                try {
                    Pylon pylon = new Pylon(Integer.parseInt(objline[1]), Integer.parseInt(objline[2]), Double.parseDouble(objline[3]));
                    obstacles.add(pylon);
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            }
        } if (objline[0].equals("robot")) {
            if (objline.length != 4) {
                System.err.println(linenum + ": Wrong number of arguments at line.");
            } else if (bot != null) {
                System.err.println(linenum + ": Robot already exist.");
            } else {
                try {
                    bot = new NXTBotFrame(Integer.parseInt(objline[1]), Integer.parseInt(objline[2]), Double.parseDouble(objline[3]));
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Updating
     */
    @Override
    public void update() {        
        updateVariables();
        if (stepcount%(getMaxFPS()/frame.getKPSValue()) == 0) processKeys();
        updateNXT();
    }

    private void processKeys() {
        int sendThis = 0;
        ArrayList<Integer> keys = (ArrayList<Integer>)keyMulti.getKeys().clone();
        for (int k : keys) {
            switch (k) {
                case KeyEvent.VK_LEFT: sendThis += 8; break;
                case KeyEvent.VK_RIGHT: sendThis += 2; break;
                case KeyEvent.VK_UP: sendThis += 1; break;
                case KeyEvent.VK_DOWN: sendThis += 4; break;
            }
            if (mode == FREE_VIEW) {
                double effectiveScroll = DELTA_SCROLL * scaleFactor;
                switch (k) {
                    case KeyEvent.VK_NUMPAD8: camY += effectiveScroll; break;
                    case KeyEvent.VK_NUMPAD2: camY -= effectiveScroll; break;
                    case KeyEvent.VK_NUMPAD4: camX += effectiveScroll; break;
                    case KeyEvent.VK_NUMPAD6: camX -= effectiveScroll; break;
                }
            }
        }
        bot.handleCommand(sendThis);
    }

    private void updateVariables() {
        setFPS(frame.getFPSValue());
        scaleFactor = frame.getScaleFactor();
        mode = frame.getMode();        
        frame.setMouseCoordinates((int)(mouseListnr.getX()*scaleFactor - camX), (int)(mouseListnr.getY()*scaleFactor - camY));
        stepcount++;
    }

    private void updateNXT() {        
        bot.update(tmr.delta());
    }

    /**
     * Painting
     * @param g
     */
    @Override
    public void paint(Graphics2D g) {
        // initialize for drawing
        if (frame.showMap()) {drawMap(g);}
        g.setColor(Color.yellow);
        displayMSG(g);
        // draw gadgets
        if (frame.showCompass()) {drawCompass(g);}
        if (frame.showSpeed()) {drawSpeedBars(g);}
        // initialize transform
        AffineTransform af = g.getTransform();
        af.scale(scaleFactor, scaleFactor);
        // update mode
        if (mode == FREE_VIEW) {
            af.translate(camX, camY);
        } else if (mode == CENTER) {
            camX = display.getWidth()/2 / scaleFactor - bot.getCenterX();
            camY = display.getHeight()/2 / scaleFactor - bot.getCenterY();
            af.translate(camX, camY);
        } else if (mode == FIRST_PERSON) {
            camX = display.getWidth()/2 / scaleFactor - bot.getCenterX();
            camY = display.getHeight()/2 / scaleFactor - bot.getCenterY();
            af.translate(camX, camY);
            af.rotate(-bot.getDirection() - Math.PI/2, bot.getCenterX(), bot.getCenterY());
        }
        g.setTransform(af);
        // draw grid
        if (frame.showGrid()) {drawGrid(g);}
        // draw panel compound
        g.setColor(Color.yellow);
        g.drawRect(0, 0, COMPOUND_WIDTH, COMPOUND_HEIGHT);
        // draw main objects
        for (Drawable d: obstacles) {
            d.paint(g);
        }
        bot.paint(g);
        g.setTransform(af);
    }

    /**
     * Draw helper
     */
    private void drawGrid(Graphics2D g) {
        g.setColor(Color.green);
        float alpha = .3f;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        for (int i = -COMPOUND_WIDTH / GRID_SIZE; i < COMPOUND_WIDTH * 2 / GRID_SIZE + 1; i++) {
            g.drawLine(i * GRID_SIZE, -COMPOUND_HEIGHT, i * GRID_SIZE, COMPOUND_HEIGHT * 2);
        }
        for (int i = -COMPOUND_HEIGHT / GRID_SIZE; i < COMPOUND_HEIGHT * 2 / GRID_SIZE + 1; i++) {
            g.drawLine(-COMPOUND_WIDTH, i * GRID_SIZE, COMPOUND_WIDTH * 2, i * GRID_SIZE);
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
        g.drawString("Approx. Direction: " + (int) dir, centerX - 40, centerY + verticalAxisLength + 30);
        // show center coordinate of bot
        g.drawString("Bot center: (" + Math.round(bot.getCenterX()) + ", " + Math.round(bot.getCenterY()) + ")", centerX - 40, centerY + verticalAxisLength + 45);
        // set rotation for first person mode
        if (mode == FIRST_PERSON) {
            g.rotate(-(bot.getDirection() + Math.PI / 2), centerX, centerY);
        }
        // draw compass with lots of math
        g.setColor(Color.yellow);
        g.drawLine(centerX, centerY - verticalAxisLength, centerX, centerY + verticalAxisLength);
        g.drawLine(centerX - horizontalAxisLength, centerY, centerX + horizontalAxisLength, centerY);
        int[] xPoints = {centerX - horizontalAxisLength / 2, centerX + horizontalAxisLength / 2, centerX};
        int[] yPoints = {centerY - verticalAxisLength, centerY - verticalAxisLength, centerY - verticalAxisLength - 5};
        g.drawPolygon(xPoints, yPoints, 3);
        g.drawString("N", centerX - 5, centerY - 40);
        // set rotation back for drawing
        if (mode == FIRST_PERSON) {
            g.rotate(bot.getDirection() + Math.PI / 2, centerX, centerY);
        }
    }

    private void drawSpeedBars(Graphics2D g) {
        // set up position variables
        int maxHeight = display.getHeight() / 3;
        int width = 10;
        int centerY = display.getHeight() / 2 + 75;
        int centerXLeft = 900;
        int centerXRight = centerXLeft + 2 * width;
        int AHeight, BHeight, ATHeight, BTHeight;
        // draw labels
        g.drawString("A", centerXLeft - width / 2, centerY - maxHeight - 10);
        g.drawString("B", centerXRight - width / 2, centerY - maxHeight - 10);
        g.drawString("Speed", (centerXLeft + centerXRight) / 2 - 20, centerY - maxHeight - 30);
        g.drawRect(centerXLeft - width, centerY - maxHeight, width * 4, maxHeight * 2);
        g.drawLine(centerXLeft - width, centerY, centerXLeft + width * 3, centerY);
        g.drawLine(centerXLeft + width, centerY - maxHeight, centerXLeft + width, centerY + maxHeight);
        // draw speed bars awkwardly, just because it works
        AHeight = (int) (bot.getASpeed() / bot.getAMaxSpeed() * maxHeight);
        BHeight = (int) (bot.getBSpeed() / bot.getBMaxSpeed() * maxHeight);
        ATHeight = (int) (bot.getATargetSpeed() / bot.getAMaxSpeed() * maxHeight);
        BTHeight = (int) (bot.getBTargetSpeed() / bot.getBMaxSpeed() * maxHeight);
        if (AHeight > 0) {
            g.fillRect(centerXLeft - width / 2, centerY - AHeight, width, AHeight);
        } else {
            g.fillRect(centerXLeft - width / 2, centerY, width, -AHeight);
        }
        if (BHeight > 0) {
            g.fillRect(centerXRight - width / 2, centerY - BHeight, width, BHeight);
        } else {
            g.fillRect(centerXRight - width / 2, centerY, width, -BHeight);
        }
        if (ATHeight > 0) {
            g.drawRect(centerXLeft - width / 2, centerY - ATHeight, width, ATHeight);
        } else {
            g.drawRect(centerXLeft - width / 2, centerY, width, -ATHeight);
        }
        if (BTHeight > 0) {
            g.drawRect(centerXRight - width / 2, centerY - BTHeight, width, BTHeight);
        } else {
            g.drawRect(centerXRight - width / 2, centerY, width, -BTHeight);
        }
    }

    private void drawMap(Graphics2D g) {
        double mapScale = 0.167;
        int mapWidth = (int)(COMPOUND_WIDTH * mapScale);
        int mapHeight = (int)(COMPOUND_HEIGHT * mapScale);
        // get the compatible image for drawing
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();
        BufferedImage mapImg = config.createCompatibleImage(mapWidth, mapHeight, Transparency.TRANSLUCENT);
        // initialize for drawing
        Graphics2D tempg = (Graphics2D) mapImg.getGraphics();
        float alpha = .3f;
        tempg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        tempg.setColor(Color.green);
        // draw background
        tempg.fillRect(0, 0, mapWidth, mapHeight);
        // draw objects
        tempg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        tempg.setColor(Color.red);
        for (Drawable d : obstacles) {
            tempg.fillRect((int)(d.getX() * mapScale), (int)(d.getY() * mapScale), (int)(d.getWidth() * mapScale), (int)(d.getHeight() * mapScale));
        }
        tempg.setColor(Color.white);
        tempg.fillRect((int)(bot.getAX() * mapScale), (int)(bot.getAY() * mapScale), (int)(bot.getBound().width * mapScale), (int)(bot.getBound().height * mapScale));
        // draw map
        g.drawImage(mapImg, MAP_MARGIN, display.getHeight() - MAP_MARGIN - mapHeight, mapWidth, mapHeight, null);
        g.setColor(Color.white);
        // draw border
        g.drawRect(MAP_MARGIN, display.getHeight() - MAP_MARGIN - mapHeight, mapWidth, mapHeight);
    }

    private void displayMSG(Graphics2D g) {
        // show FPS
        g.drawString("FPS: " + getFPS() + " / " + getMaxFPS(), INFO_MARGIN, 15);
        // show scale
        g.drawString("Scale factor: " + scaleFactor, INFO_MARGIN, 30);
        // show time elapsed
        g.drawString("Time passed: " + tmr.getElapsedTime() / 1000, INFO_MARGIN, 45);
        // show KPS
        g.drawString("KPS: " + frame.getKPSValue(), INFO_MARGIN, 60);
        // show step count
        g.drawString("Step Count: " + stepcount, INFO_MARGIN, 75);
        // show distance travelled
        g.drawString("Distn Trvld(cm): " + bot.getDistanceTravelled(), INFO_MARGIN, 90);
        // show instruction
        if (mode == FREE_VIEW) {
            String instr = "Free-view mode: Use \"8\", \"4\", \"6\", \"2\" to move camera.";
            g.drawString(instr, display.getWidth() / 2 - instr.length() / 2 * 6, 15);
        }
        // show warning
        if (bot.getCenterX() < 0 || bot.getCenterY() < 0 || bot.getCenterX() > COMPOUND_WIDTH || bot.getCenterY() > COMPOUND_HEIGHT) {
            String warning = "WARNING: " + bot.getModel() + " (\"" + bot.getName() + "\") is out of bound.";
            g.drawString(warning, display.getWidth() / 2 - warning.length() / 2 * 6, display.getHeight() - MAP_MARGIN - 15);
        }
    }

    /**
     * Miscellaneous class methods
     */

    public void resetCamera() {
        camX = camY = 0;
    }

    public void centerCamera() {
        camX = display.getWidth()/2/scaleFactor - bot.getCenterX();
        camY = display.getHeight()/2/scaleFactor - bot.getCenterY();
    }

    public void setCamera(double x, double y) {
        camX = x;
        camY = y;
    }

    public double getCamX() {
        return camX;
    }

    public double getCamY() {
        return camY;
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void requestFocus() {
        display.requestFocus();
    }

    private int mode;
    private double camX, camY;
    private int stepcount;
    private double scaleFactor;

    private NXTBotFrame bot;
    private ArrayList<Drawable> obstacles;
    private MultiKeyListener keyMulti;
    private SimpleMouseListener mouseListnr;
    private SimulationFrame frame;

}