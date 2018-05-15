public class SystemTimer {
    final long startTime = System.nanoTime();


    public int currentSeconds() {
        return (int) (System.nanoTime() - startTime / 1000000000);
    }
}
