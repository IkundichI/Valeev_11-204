import java.util.List;

public class CountThread extends Thread {
    private List<Integer> integers;
    private long sum;

    public CountThread(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        sum = 0;
        //System.out.println("Thread " + getName() + " started");
        for (Integer integer : integers) {
            sum += integer;
        }
        //System.out.println("Thread " + getName() + " finished");
    }

    public long getSum() {
        return sum;
    }
}