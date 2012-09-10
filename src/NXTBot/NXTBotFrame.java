package NXTBot;

public class NXTBotFrame extends TwoWheelNXT {

    public NXTBotFrame(double x, double y, double angle) {
        // to make speed up the program, change to a wheelDiameter (a constant in TwoWheelNXT)
        super(x, y, angle); // (center X, center Y, angle)
        spdChange = 90;
        name = "mutiny";
        model = "FGP-Alpha";
    }

    public void handleCommand(int command) {
        // up = 1, right  = 2, down = 4, left = 8
        // find the sum of the keys pressed and command the robot accordingly
        switch (command) {
            case 1:
                moveForward();
                doSumOne();
                break;
            case 2:
                doSumTwo();
                turnRight();
                break;
            case 3:
                doSumThree();
                break;
            case 4:
                doSumFour();
                //stop();
                //moveBackward();
                slow();
                break;
            case 5:
                doSumFive();
                break;
            case 6:
                doSumSix();
                break;
            case 7:
                doSumSeven();
                break;
            case 8:
                doSumEight();
                turnLeft();
                break;
            case 9:
                doSumNine();
                break;
            case 10:
                doSumTen();
                break;
            case 11:
                doSumEleven();
                break;
            case 12:
                doSumTwelve();
                break;
            case 13:
                doSumThirteen();
                break;
            case 14:
                doSumFourteen();
                break;
            case 15:
                doSumFifteen();
                break;
        }
    }

    private void turnRight() {
        Motor.A.setTargetSpeed(Motor.A.getTargetSpeed() + spdChange);
        Motor.A.forward();
    }

    private void turnLeft() {
        Motor.B.setTargetSpeed(Motor.B.getTargetSpeed() + spdChange);
        Motor.B.forward();
    }

    private void moveForward() {
        Motor.A.setTargetSpeed(Motor.A.getTargetSpeed() + spdChange);
        Motor.A.forward();
        Motor.B.setTargetSpeed(Motor.B.getTargetSpeed() + spdChange);
        Motor.B.forward();
    }

    private void slow() {
        Motor.A.setTargetSpeed(Motor.A.getTargetSpeed() - spdChange);
        Motor.B.setTargetSpeed(Motor.B.getTargetSpeed() - spdChange);
    }

    private void stop() {
        Motor.A.stop();
        Motor.B.stop();
    }

    private void moveBackward() {
        Motor.A.backward();
        Motor.B.backward();
    }

    /** TODO: Create your own methods. */
    
    // Try: move at "speed" while rotate at "angle"
    private void moveRotate(double speed, double angle) {
    }
    
    private double spdChange;

    public void doSumOne() {
    }

    public void doSumTwo() {
    }

    public void doSumThree() {
    }

    public void doSumFour() {
    }

    public void doSumFive() {
    }

    public void doSumSix() {
    }

    public void doSumSeven() {
    }

    public void doSumEight() {
    }

    public void doSumNine() {
    }

    public void doSumTen() {
    }

    public void doSumEleven() {
    }

    public void doSumTwelve() {
    }

    public void doSumThirteen() {
    }

    public void doSumFourteen() {
    }

    public void doSumFifteen() {
    }
}