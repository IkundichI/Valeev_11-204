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

        // Test 2
        List<Integer> integers2 = List.of(10, 20, 30, 40, 50);
        PartitionService service2 = new PartitionService(integers2, 2);
        long sum2 = service2.countArrayPartitionSum();
        System.out.println(sum2); // Ожидаемый результат: 150

        // Test 3
        List<Integer> integers3 = List.of(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000);
        PartitionService service3 = new PartitionService(integers3, 4);
        long sum3 = service3.countArrayPartitionSum();
        System.out.println(sum3); // Ожидаемый результат: 5500

    }
}