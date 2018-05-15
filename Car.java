/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class Car implements Runnable {

    private final Semaphore semaphore;
    private long threadNum;

    public Car(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        threadNum = Thread.currentThread().getId();
        System.out.println("Car num " + threadNum + " start wait to wash");
        semaphore.Wait();
    }
}
