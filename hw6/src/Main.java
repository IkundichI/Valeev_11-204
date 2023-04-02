import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneNumbersPeople = new HashMap<>();
        phoneNumbersPeople.put("Medov", "+7 (800) 555-35-35");
        phoneNumbersPeople.put("Azat", "+7 (888) 678-22-22");
        phoneNumberPrinter(phoneNumbersPeople);
        phoneNumberChecker(phoneNumbersPeople);
        System.out.println(phoneNumbersPeople);
        Map<String, String> phoneNumbersPeople1 = new HashMap<>();
        phoneNumbersPeople1 = swapKeysAndValues(phoneNumbersPeople);
        System.out.println(phoneNumbersPeople1);
    }

    public static void phoneNumberPrinter(Map<String, String> map) {
        for (String valueOfMap : map.values()) {
            System.out.println(valueOfMap);
        }
    }

    public static void phoneNumberChecker(Map<String, String> map) {
        for (String valueOfMap : map.values()) {
            if (valueOfMap.matches("\\+7 \\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}")) {
                System.out.println(valueOfMap + " => верный");
            } else {
                System.out.println(valueOfMap + " => неверный");
            }
        }
    }


    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

}