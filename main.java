/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {

    private static final Object locker = new Object();
    private static Random rnd = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static int sumOfCars = 0;
    private static long sumCarWashTime = 0;

    public static void main(String[] args) {
        try {
            System.setOut(new SyncPrintStream(System.out));
            System.setErr(new SyncPrintStream(System.err));

            System.out.print("Enter num of wash stations: ");
            var washStations = scanner.nextInt();
            System.out.print("Enter car interval (approximately 1.5): ");
            var carInterval = scanner.nextDouble();
            System.out.print("Enter car wash interval (approximately 3): ");
            var carWashInterval = scanner.nextDouble();
            System.out.print("Total runtime (approximately 30): ");
            var totalRuntime = getPoisson(scanner.nextDouble());
            System.err.println("Possion for runtime is: " + totalRuntime);

            var semaphore = new Semaphore(washStations);
            var cars = new ArrayList<Thread>();
            var systemTimer = new SystemTimer();
            while (systemTimer.currentSeconds() < totalRuntime) {
                var thread = new Thread(new Car(systemTimer, semaphore, getPoissonAsMilliseconds(carWashInterval),
                        (t, washTime) -> {
                            synchronized (locker) {
                                sumOfCars++;
                                sumCarWashTime += washTime;
                                cars.remove(t);
                            }
                        }));
                thread.start();
                cars.add(thread);
                Thread.sleep((long) getPoissonAsMilliseconds(carInterval));
            }

            System.err.println("Time Up " + systemTimer.currentSeconds());

            while (!cars.isEmpty()) {
                cars.get(0).join();
            }
            System.out.println(sumOfCars + " Cars washed.\n" +
                    "Average " + ((sumCarWashTime / 1000000000) / sumOfCars) + " Seconds per car.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static double getPoissonAsMilliseconds(double seconds) {
        return getPoisson(seconds)  * 1000;
    }
    public static double getPoisson(double seconds){return Math.abs(Math.log(rnd.nextDouble())) * seconds;}
}
