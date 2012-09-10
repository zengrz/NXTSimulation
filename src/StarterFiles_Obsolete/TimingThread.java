package StarterFiles_Obsolete;

/*
 * This class, when running, will send the current keyboard state via the
 * frame to the TwoWheelNXT for processing.
 * That's it!
 */

public class TimingThread extends Thread {

    boolean active = true;
    int x = 0;
    SimulationFrame parent;
    int delay;

    public TimingThread(SimulationFrame owner, int delay) {
        this.parent = owner;
        this.delay = delay;
    }

    public void run() {
        try {
            while (active) {
                System.out.println(x);
                x++;
                parent.updateAll();
                sleep(delay);
                if (x == 20) {
                    active = false;
                }
            }
        } catch (InterruptedException e) {
        }

    }
}
