/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

import java.util.Random;
import java.util.Scanner;

public class main {

    private static Random rnd;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.setOut(new SyncPrintStream(System.out));

        System.out.print("Enter num of wash stations: ");
        var washStations = scanner.nextInt();
        System.out.print("Enter car interval (approximately 1.5): ");
        var carInterval = scanner.nextDouble();
        System.out.print("Enter car wash interval (approximately 3): ");
        var carWashInterval = scanner.nextDouble();
        System.out.print("Total runtime: ");
        var totalRuntime = getPoisson(scanner.nextDouble());
    }

    public static double getPoisson(double seconds) {
        return Math.abs(Math.log(rnd.nextDouble()))*seconds;
    }
}
