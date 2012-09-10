package NXTBot;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
 * NXT robot class
 * March 24, 2011
 *
 * TwoWheelNXT is a robot that:
 * Keeps tracks of:
 * - positions of two wheels
 * - direction
 * - distance between two wheels
 * - name, model
 * Able to:
 * - update speed of each wheel
 * - update position based on speed
 * - paint itself on canvas based on position
 * Must:
 * - handle keyboard command
 */
public abstract class TwoWheelNXT implements Commandable {

    public TwoWheelNXT(double x, double y, double angle) {
        this.axisLength = WIDTH;
        Motor = new MotorControl(ACCELERATION, WHEEL_DIAMETER);
        Motor.A.setTargetSpeed(0);
        Motor.B.setTargetSpeed(0);

        bound = new Rectangle((int) axisLength, (int) axisLength);
        bound.x = -(int)axisLength/2;
        direction = 0;

        posAX = x - axisLength/2*Math.sin(angle);
        posAY = y - axisLength/2*Math.cos(angle);
        //System.out.println(posAX + ", " + posAY);
        posBX = x + axisLength/2*Math.sin(angle);
        posBY = y + axisLength/2*Math.cos(angle);
        //System.out.println(posBX + ", " + posBY);
        direction = -angle;
        
        centerX = (posAX + posBX) / 2;
        centerY = (posAY + posBY) / 2;
        distanceTraveled = 0;

        name = "insertname";
        model = "insertmodel";
    }

    /**
     * The next four methods
     * @return positions of robot
     */
    public double getAX() {
        return posAX;
    }

    public double getAY() {
        return posAY;
    }

    public double getBX() {
        return posBX;
    }

    public double getBY() {
        return posBY;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getASpeed() {
        return Motor.A.getSpeed();
    }

    public double getBSpeed() {
        return Motor.B.getSpeed();
    }

    public double getATargetSpeed() {
        return Motor.A.getTargetSpeed();
    }

    public double getBTargetSpeed() {
        return Motor.B.getTargetSpeed();
    }

    public double getAMaxSpeed() {
        return Motor.A.getMaxSpeed();
    }

    public double getBMaxSpeed() {
        return Motor.B.getMaxSpeed();
    }

    public double getDistanceTravelled() {
        return distanceTraveled;
    }

    /**
     * @return direction
     */
    public double getDegreeDirection() {
        return Math.toDegrees(direction);
    }

    public double getDirection() {
        return direction;
    }

    /**
     * @return distance between two wheels.
     */
    public double getWidth() {
        return axisLength;
    }

    public Rectangle getBound() {
        return bound;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Update speed of each motor.
     */
    private void updateSpeed(long deltaTime) {
        Motor.A.updateSpeed(deltaTime);
        Motor.B.updateSpeed(deltaTime);
        //System.out.println(System.currentTimeMillis() + ": ");
        //System.out.println("A: " + Motor.A.getSpeed() + " / " + Motor.A.getTargetSpeed() + "(" + Motor.A.getActualTargetSpeed() +")");
        //System.out.println("B: " + Motor.B.getSpeed() + " / " + Motor.B.getTargetSpeed() + "(" + Motor.B.getActualTargetSpeed() +")");
    }

    /**
     * Updates the position based on the speed of each motor.
     */
    private void updatePosition(long deltaTime) {
        double aSpeed, bSpeed;
        aSpeed = Motor.A.getActualSpeed() * deltaTime/1000.0;
        bSpeed = Motor.B.getActualSpeed() * deltaTime/1000.0;
        double d = aSpeed - bSpeed;
        int limit = 200;
        for (int i = 0; i < limit; i++) {
            posAX += (aSpeed / limit * Math.cos(direction));
            posAY += (aSpeed / limit * Math.sin(direction));
            posBX += (bSpeed / limit * Math.cos(direction));
            posBY += (bSpeed / limit * Math.sin(direction));
            direction += (d / limit) / axisLength;
        }
        direction %= (2 * PI);
        double newCenterX = (posAX + posBX) / 2;
        double newCenterY = (posAY + posBY) / 2;
        double deltaX = newCenterX - centerX;
        double deltaY = newCenterY - centerY;
        distanceTraveled += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        centerX = newCenterX;
        centerY = newCenterY;        
        double length = Math.sqrt((posAX - posBX) * (posAX - posBX) + (posAY - posBY) * (posAY - posBY));
        //System.out.println("centerX: " + centerX + " centerY: " + centerY + " - length:" + length);
    }

    public void update(long deltaTime) {
        updateSpeed(deltaTime);
        updatePosition(deltaTime);
    }

    /**
     * Paints the robot on screen
     * @param g
     */
    public void paint(Graphics2D g) {        
        g.draw(new Line2D.Double(posAX, posAY, posBX, posBY));
        g.translate(posAX, posAY);
        g.rotate(direction);
        // draw robot
        g.draw(bound);
        // label wheel A
        g.rotate(Math.PI/2);
        g.drawString("A", -10, 0);
        // label wheel B
        g.translate(axisLength, 0);
        g.drawString("B", 2, 0);
        // draw labels
        g.translate(-axisLength + (axisLength - name.length())/4, axisLength/2);
        g.drawString(name, (int)(getWidth()/2 - name.length()/2*7), 10);
        g.drawString(model, (int)(getWidth()/2 - model.length()/2*7), 22);
    }

    /**
     * Handle keyboard input
     * @param command
     */
    public abstract void handleCommand(int command);
    
    protected double posAX, posAY, posBX, posBY, centerX, centerY;
    protected double axisLength;
    protected double direction;
    protected double distanceTraveled;
    protected String name, model;
    protected Rectangle bound;
    protected MotorControl Motor;
    
    private static final double PI = Math.PI;
    public static final double WHEEL_DIAMETER = 2;
    public static final double WIDTH = 15;
    public static final double ACCELERATION = 10;

}