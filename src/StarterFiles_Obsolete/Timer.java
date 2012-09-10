package StarterFiles_Obsolete;

public class Timer {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    private long lastTime;

    public Timer() {
        elapsedTime = 0;
        isRunning = false;
    }

    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        startTime = System.currentTimeMillis();
        lastTime = 0;
    }

    public void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
        lastTime = endTime;
    }

    public long getElapsedTime() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            lastTime = endTime;
            elapsedTime = elapsedTime + endTime - startTime;
        }

        return elapsedTime;
    }

    public long delta() {
        long deltaTime = 0;
        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            deltaTime = currentTime - lastTime;
            lastTime = currentTime;
        }
        return deltaTime;
    }
}
