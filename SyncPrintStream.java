import java.io.OutputStream;
import java.io.PrintStream;

public class SyncPrintStream extends PrintStream {
    public SyncPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public synchronized void print(boolean b) {
        super.print(b);
    }

    @Override
    public synchronized void print(char c) {
        super.print(c);
    }

    @Override
    public synchronized void print(int i) {
        super.print(i);
    }

    @Override
    public synchronized void print(long l) {
        super.print(l);
    }

    @Override
    public synchronized void print(float f) {
        super.print(f);
    }

    @Override
    public synchronized void print(double d) {
        super.print(d);
    }

    @Override
    public synchronized void print(char[] s) {
        super.print(s);
    }

    @Override
    public synchronized void print(String s) {
        super.print(s);
    }

    @Override
    public synchronized void print(Object obj) {
        super.print(obj);
    }

    @Override
    public synchronized void println() {
        super.println();
    }

    @Override
    public synchronized void println(boolean x) {
        super.println(x);
    }

    @Override
    public synchronized void println(char x) {
        super.println(x);
    }

    @Override
    public synchronized void println(int x) {
        super.println(x);
    }

    @Override
    public synchronized void println(long x) {
        super.println(x);
    }

    @Override
    public synchronized void println(float x) {
        super.println(x);
    }

    @Override
    public synchronized void println(double x) {
        super.println(x);
    }

    @Override
    public synchronized void println(char[] x) {
        super.println(x);
    }

    @Override
    public synchronized void println(String x) {
        super.println(x);
    }

    @Override
    public synchronized void println(Object x) {
        super.println(x);
    }
}
