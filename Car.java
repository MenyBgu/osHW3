/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class Car implements Runnable {

    private final Semaphore semaphore;
    private final SystemTimer systemTimer;
    private int millisecondsToWash;
    private CarEndWashListener listener;
    private long startTime;

    public Car(SystemTimer systemTimer, Semaphore semaphore, double secondsToWash, CarEndWashListener listener) {
        this.semaphore = semaphore;
        this.millisecondsToWash = (int) (secondsToWash * 1000);
        this.systemTimer = systemTimer;
        this.listener = listener;
        startTime = System.nanoTime();
    }

    @Override
    public void run() {
        try {
            printMessage("start wait to wash");
            semaphore.Wait();
            printMessage("Start Wash");
            Thread.sleep(millisecondsToWash);
            printMessage("End Wash");
            listener.AsEnd(Thread.currentThread(), System.nanoTime() - startTime);
            semaphore.Signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(String message) {
        System.out.println("time from start: " + systemTimer.currentSeconds() + "\n"
                + message + "\n"
                + "Car ID: " + Thread.currentThread().getId());
    }

    public interface CarEndWashListener{
        void AsEnd(Thread car, long time);
    }
}
