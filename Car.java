/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class Car implements Runnable {

    private final Semaphore semaphore;
    private final SystemTimer systemTimer;
    private int millisecondsToWash;

    public Car(SystemTimer systemTimer, Semaphore semaphore, double secondsToWash) {
        this.semaphore = semaphore;
        this.millisecondsToWash = (int) (secondsToWash * 1000);
        this.systemTimer = systemTimer;
    }

    @Override
    public void run() {
        try {
            printMessage("start wait to wash");
            semaphore.Wait();
            printMessage("Start Wash");
            Thread.sleep(millisecondsToWash);
            printMessage("End Wash");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(String message) {
        System.out.println("time from start: " + systemTimer.currentSeconds() + "\n"
                + message + "\n"
                + "Car ID: " + Thread.currentThread().getId());
    }
}
