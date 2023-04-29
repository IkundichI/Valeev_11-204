import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new MyMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.remove(2));
        System.out.println("Значения: ");
        map.values().forEach(System.out::println);
        System.out.println("Ключи: ");
        map.keySet().forEach(System.out::println);
        map.clear();
        map.put(1, "ONE");
        System.out.println("Entry: ");
        map.entrySet().forEach(System.out::println);
        map.put(1, "TWO");
        System.out.println("Entry: ");
        map.entrySet().forEach(System.out::println);
        System.out.println(map.isEmpty());
    }
}