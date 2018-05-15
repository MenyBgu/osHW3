/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class carWashMachine implements Runnable {
    int washMachine;
    double avgInCar;
    double avgWashCar;
    double runTime;
    double time;
    semaphore sema;


    public carWashMachine(int washMachine, double avgInCar, double avgWashCar, double runTime, double time) {
        this.washMachine = washMachine;
        this.avgInCar = avgWashCar;
        this.avgWashCar = avgWashCar;
        this.runTime = runTime;
        this.time = time;
        sema = new semaphore(washMachine);
    }

    public synchronized void add(long time) {
        washMachine++;
        this.time += (System.currentTimeMillis());
    }

    public void run() {

    }
}
