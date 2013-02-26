/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Obstacles;

import BaseClasses.GameObject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author rey z
 */
public abstract class Structure extends GameObject {

    /**
     * Reference to the parent container.
     */
    protected Structure parent;
    /**
     * Boundary of the object.
     */
    protected Rectangle bound;
    /**
     * Object visibility.
     */
    protected boolean visible;

    /**
     * Object direction
     */
    protected double direction;

    /**
     * Creates a <code>Displayable</code> that is visible with no parent at the coordinate of 0,0.
     */
    public Structure() {
        parent = null;
        visible = true;
        bound = new Rectangle();
        direction = 0;
    }

    /**
     * Set the horizontal position.
     * @param x the horizontal position.
     */
    public void setX(int x) {
        bound.x = x;
    }

    /**
     * Get the horizontal position.
     * @return the horizontal position.
     */
    public final int getX() {
        return bound.x;
    }

    /**
     * Set the vertical position.
     * @param y the veritcal position.
     */
    public void setY(int y) {
        bound.y = y;
    }

    /**
     * Get the vertical position.
     * @return the vertical position
     */
    public final int getY() {
        return bound.y;
    }

    /**
     * Set the position of the object.
     * @param p a <code>Point</code> with x and y coordinates.
     */
    public void setPosition(Point p) {
        bound.setLocation(p);
    }

    /**
     * Set the position of the object.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     */
    public void setPosition(int x, int y) {
        bound.setLocation(x, y);
    }

    /**
     * Get the position of the object.
     * @return the position of the object.
     */
    public final Point getPosition() {
        return new Point(bound.x, bound.y);
    }

    /**
     * Set the width of the object.
     * @param width the width.
     */
    public void setWidth(int width) {
        bound.setSize(width, bound.height);
    }

    /**
     * Get the width of the object.
     * @return the width.
     */
    public final int getWidth() {
        return bound.width;
    }

    /**
     * Set the height of the object.
     * @param height the height.
     */
    public void setHeight(int height) {
        bound.setSize(bound.width, height);
    }

    /**
     * Get the height of the object.
     * @return the height.
     */
    public final int getHeight() {
        return bound.height;
    }

    /**
     * Set the size of the object.
     * @param width the width.
     * @param height the height.
     */
    public void setSize(int width, int height) {
        bound.setSize(width, height);
    }

    /**
     * Get the size of the object.
     * @return the width and height.
     */
    public final Dimension getSize() {
        return bound.getSize();
    }

    /**
     * Set the boundary of the object.
     * @param x the horizontal position.
     * @param y the vertical position.
     * @param width the width.
     * @param height the height.
     */
    public void setBound(int x, int y, int width, int height) {
        bound.setLocation(x, y);
        bound.setSize(width, height);
    }

    public void removeSelf() {
        parent = null;
    }

    /**
     * Get the boundary of the object.
     * @return the boundary of the object.
     */
    public final Rectangle getBound() {
        return bound;
    }

    /**
     * Set the parent container.
     * @param p the parent container.
     */
    public void setParent(Structure p) {
        parent = p;
    }

    /**
     * Get the parent container.
     * @return the parent container.
     */
    public final Structure getParent() {
        return parent;
    }

    /**
     * Set the visibility of the object.
     * @param v the visibility of the object.
     */
    public void setVisible(boolean v) {
        visible = v;
    }

    /**
     * Get if the object will be shown.
     * @return the visibility of the object.
     */
    public final boolean isVisible() {
        return visible;
    }

    /**
     * Renders the object.
     * @param g the <code>Graphics2D</code> object to draw on.
     * @param x the horizontal offset.
     * @param y the vertical offset.
     */
    public abstract void paint(Graphics2D g);
}