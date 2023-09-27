import java.util.List;

public class CountThread extends Thread {
    private List<Integer> integers;
    private long sum;

    public CountThread(List<Integer> integers) {
        this.integers = integers;
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        sum = 0;
        //System.out.println("Thread " + getName() + " started");
        for (Integer integer : integers) {
            sum += integer;
        }
        //sleep(1000);
        //System.out.println("Thread " + getName() + " finished");
    }

    public long getSum() {
        return sum;
    }
}