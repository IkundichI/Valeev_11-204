import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Test 1
        List<Integer> integers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PartitionService service1 = new PartitionService(integers1, 3);
        long sum1 = service1.countArrayPartitionSum();
        System.out.println(sum1); // Ожидаемый результат: 55


    }
}