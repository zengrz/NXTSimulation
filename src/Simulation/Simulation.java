/**
 * Main engine/loop that runs the game.
 */
package Simulation;

import java.awt.Graphics2D;

public abstract class Simulation implements Runnable {

    public Simulation() {
        fps = 0;
        maxFPS = 30;
        fpsPeriod = (1000 / maxFPS);
        tmr = new Timer();
        display = new Display(SimulationConstants.COMPOUND_WIDTH, SimulationConstants.COMPOUND_HEIGHT/2, this);
        init();
    }

    @Override
    public void run() {        
        long st, bt, dt, sleep, overSleep;
        dt = sleep = overSleep = 0;
        int frames = 0;
        st = bt = System.currentTimeMillis();        
        while (!Thread.interrupted()) {
            bt = System.currentTimeMillis();
            overSleep = (bt - dt) - sleep;

            // do engine's things
            update();
            display.render();
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
        thread = new Thread(this);
        thread.start();
        tmr.start();
        setState(STARTED);
    }

    public void stop() {
        thread.interrupt();
        thread = null;
        tmr.stop();
        setState(STOPPED);
    }

    /**
     * Managing states
     */

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public boolean isRunning() {
        return (state == STARTED);
    }

    /**
     * FPS
     */

    public int getFPS() {
        return fps;
    }

    public int getMaxFPS() {
        return maxFPS;
    }

    public void setFPS(int fps) {
        maxFPS = fps;
        fpsPeriod = (1000 / maxFPS);
    }

    /**
     * Initialize game variables.
     */
    public abstract void init();

    /**
     * Update game variables.
     */
    public abstract void update();

    /**
     * Renders the game.
     * @param g the <code>Graphics2D</code> object to draw to.
     */
    public abstract void paint(Graphics2D g);

    /** Private instance variables. */    
    private Thread thread;
    protected int state;
    protected int fps;
    protected int maxFPS;
    private int fpsPeriod;
    protected Display display;
    protected Timer tmr;
    // TODO: add different constant game states
    /**
     * The main game loops is in progress.
     */
    public static final int STARTED = 1;
    /**
     * The main game loop has been stopped.
     */
    public static final int STOPPED = 0;
}
