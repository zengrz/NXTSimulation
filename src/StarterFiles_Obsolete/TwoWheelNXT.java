package StarterFiles_Obsolete;


public class TwoWheelNXT {

    public MotorControl Motor;

    public TwoWheelNXT() {
        Motor = new MotorControl();
        Motor.A.setSpeed(0);
        Motor.B.setSpeed(0);
    }

    public void handleCommand(int command) {
    }
}
