/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Obstacles;

import java.awt.Graphics2D;

/**
 *
 * @author rey z
 */
public class Pylon extends Structure {

    public Pylon(int x, int y, double direction) {
        super();
        bound.x = x;
        bound.y = y;
        bound.width = bound.height = 20;
        this.direction = direction;
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawString("(" + getX() + ", " + getY() + ")", bound.x, bound.y - 5);
        g.rotate(direction, getX() + getWidth()/2, getY() + getHeight()/2);
        g.draw(bound);
        g.rotate(-direction, getX() + getWidth()/2, getY() + getHeight()/2);
    }
}
