package NXTBot;

public class MotorControl {

    public MotorControl(double acceleration, double wheelDiameter) {
        A = new SingleMotor(acceleration, wheelDiameter);
        B = new SingleMotor(acceleration, wheelDiameter);
    }
    
    public SingleMotor A;
    public SingleMotor B;
}