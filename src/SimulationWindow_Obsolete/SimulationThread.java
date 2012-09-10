package SimulationWindow_Obsolete;

/*
 * This class, when running, will send the current keyboard state via the
 * frame to the TwoWheelNXT for processing.
 * That's it!
 */
public class SimulationThread extends Thread {
    public SimulationThread(SimulationFrame owner) {
        parent = owner;
        fps = 0;
        maxFPS = 30;
        fpsPeriod = (1000 / maxFPS);
    }

    public void run() {
        long st, bt, dt, sleep, overSleep;
        dt = sleep = overSleep = 0;
        int frames = 0;
        st = bt = System.currentTimeMillis();

        while (isActive) {
            bt = System.currentTimeMillis();
            overSleep = (bt - dt) - sleep;

            // do updates
            parent.updateAll();
            // that's it

            dt = System.currentTimeMillis();
            sleep = fpsPeriod - (dt - bt) - overSleep;
            if (sleep <= 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted!");
                break;
            }

            // calculates fps
            frames++;
            if ((bt - st) > fpsPeriod * maxFPS) {
                fps = (int) (frames / ((dt - st) / 1000.0));
                st = dt;
                frames = 0;
            }            
        }
    }

    public void start() {
        super.start();
        isActive = true;
    }

    public void setAcive(boolean a) {
        isActive = a;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getFPS() {
        if (isActive) {
            return fps;
        }
        return 0;
    }

    public void setFPS(int fps) {
        maxFPS = fps;
        fpsPeriod = (1000 / maxFPS);
    }

    private boolean isActive;
    private int fps;
    private int maxFPS, fpsPeriod;
    private SimulationFrame parent;    
}