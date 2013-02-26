/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClasses;

/**
 *
 * @author rey
 */
public class NXTVector {
    
    public NXTVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void update(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    private double x, y;
}
