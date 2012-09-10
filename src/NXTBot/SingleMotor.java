package NXTBot;

/**
 * Single motor class
 * March 24, 2011
 *
 * SingleMotor is a motor that:
 * Keeps tracks of:
 * - speed, target speed
 * - acceleration, deceleration
 * - states
 * - Wheel diameter
 * Able to:
 * - update speed
 * - update state: forward/backward/stop
 *
 * Actual speed is speed in radian based on wheel circumference.
 * Speed is in degree based on wheel circumference.
 */
public class SingleMotor {

    public SingleMotor(double acceleration, double wheelDiameter) {
        this.acceleration = acceleration;
        this.deceleration = acceleration;
        this.wheelDiameter = wheelDiameter;
        speed = motorSpeed = 0;
        targetSpeed = targetSpeedInput = 0;
        speedMax = MAX_SPEED;
        state = State.STOP;
    }

    public void setTargetSpeed(double spd) {
        if (spd >= -MAX_SPEED && spd <= MAX_SPEED) {
            targetSpeedInput = Math.PI * wheelDiameter * spd/360.0;
        } else {
            System.err.println("Speed must be between " + -MAX_SPEED + " and " + MAX_SPEED + ".");
        }
    }

    public void setSpeed(double spd) {
        setTargetSpeed(spd);
    }

    public double getActualSpeed() {
        return speed;
    }

    public double getActualTargetSpeed() {
        return targetSpeed;
    }

    public double getSpeed() {
        return (speed * 360.0) / (Math.PI * wheelDiameter);
    }

    public double getTargetSpeed() {
        return (targetSpeed * 360.0) / (Math.PI * wheelDiameter);
    }

    public double getMaxSpeed() {
        return speedMax;
    }

    /**
     * IMPORTANT: THIS METHOD WILL LOOP.
     * Updates the speed of motor based on its state. (ie forward/backward)
     * Speed needs to be handled based on its state since
     * acceleration/deceleration is a function of both state(+/- speed) and target speed.
     * Flow:
     * update state
     * if speed is positive
     *  if speed is more positive than target speed
     *    apply deceleration
     *  if speed is less positive than target speed
     *    apply acceleration
     * if speed is negative
     *   if speed is more negative than target speed
     *     apply deceleration
     *   if speed is less negative than target speed
     *     apply acceleration
     */
    public void updateSpeed(long delta) {
        double deltaSpdAdd = delta/1000.0 * acceleration;
        double deltaSpdMinus = delta/1000.0 * deceleration;
        switch(state) {
            case FORWARD: targetSpeed = targetSpeedInput; break;
            case BACKWARD: targetSpeed = -targetSpeedInput; break;
            case STOP: targetSpeed = 0; break;
        }

        if (motorSpeed > 0) {
            if (motorSpeed > targetSpeed) {
                if ((motorSpeed - targetSpeed) > deltaSpdMinus) {
                    motorSpeed -= deltaSpdMinus;
                } else {
                    motorSpeed = targetSpeed;
                }
            } else if (motorSpeed < targetSpeed) {
                if ((targetSpeed - motorSpeed) > deltaSpdAdd) {
                    motorSpeed += deltaSpdAdd;
                } else {
                    motorSpeed = targetSpeed;
                }
            }
        } else if (motorSpeed < 0) {
            if (motorSpeed > targetSpeed) {
                if ((motorSpeed - targetSpeed) > deltaSpdAdd) {
                    motorSpeed -= deltaSpdAdd;
                } else {
                    motorSpeed = targetSpeed;
                }
            } else if (motorSpeed < targetSpeed) {
                if ((targetSpeed - motorSpeed) > deltaSpdMinus) {
                    motorSpeed += deltaSpdMinus;
                } else {
                    motorSpeed = targetSpeed;
                }
            }
        } else { // speed == 0
            if (motorSpeed > targetSpeed) {
                motorSpeed -= deltaSpdMinus;
            } else if (motorSpeed < targetSpeed) {
                motorSpeed += deltaSpdAdd;
            }
        }

        speed = (state == State.FLOAT) ? 0 : motorSpeed;
    }

    public void forward() {
        prevstate = state;
        state = State.FORWARD;
    }

    public void backward() {
        prevstate = state;
        state = State.BACKWARD;
    }

    public void stop() {
        prevstate = state;
        state = State.STOP;
    }

    public void flt() {
        prevstate = state;
        state = State.FLOAT;
    }

    public void reverseDirection() {
        if (isMoving()) targetSpeed = -targetSpeed;
    }

    public boolean isMoving() {
        if (Math.abs(speed) > 0) return true;
        return false;
    }

    private double speed, motorSpeed, targetSpeed, targetSpeedInput, speedMax;
    private double acceleration, deceleration;
    private double wheelDiameter;
    private State state, prevstate;
    
    private enum State {
        FORWARD, BACKWARD, STOP, FLOAT
    }

    private static final double MAX_SPEED = 900;
}