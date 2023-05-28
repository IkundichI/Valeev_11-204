import java.util.ArrayList;
import java.util.List;

public class PartitionService {

    private List<Integer> integerList;
    private int partitionSize;

    public PartitionService(List<Integer> integerList, Integer partitionSize) {
        this.integerList = integerList;
        this.partitionSize = partitionSize;
    }

    public long countArrayPartitionSum() throws InterruptedException {
        int totalSize = integerList.size();
        List<CountThread> threads = new ArrayList<>();

        for (int i = 0; i < totalSize; i += partitionSize) {
            int end = Math.min(i + partitionSize, totalSize);
            List<Integer> subList = integerList.subList(i, end);
            //System.out.println(subList);
            CountThread thread = new CountThread(subList);
            thread.start();
            threads.add(thread);
        }

        long sum = 0;
        for (CountThread thread : threads) {
            thread.join();
            sum += thread.getSum();
        }

        return sum;
    }
}