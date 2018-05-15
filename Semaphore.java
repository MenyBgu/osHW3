/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class Semaphore {
    private final int MAX_AVAIL;
    private int availNow;

    public Semaphore(int tickets) {
        availNow = MAX_AVAIL = tickets;
    }

    public synchronized void Signal() {
        availNow++;
        if (availNow > MAX_AVAIL)
            availNow = MAX_AVAIL;
        notifyAll();
    }

    public synchronized void Wait() {
        while (availNow <= 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        availNow--;
    }
}
