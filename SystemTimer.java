public class SystemTimer {
    final long startTime = System.nanoTime();


    public double currentSeconds() {
        return  ((System.nanoTime() - startTime) / 1000000000);
    }
}
