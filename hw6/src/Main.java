package hw6.src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneNumbersPeople = new HashMap<>();
        phoneNumbersPeople.put("Azat", "+7 (800) 555-35-35");
        phoneNumbersPeople.put("Timur", "+7 (888) 678-22-22");
        phoneNumbersPeople.put("Marat", "8 800 555 35 35");
        phoneNumberPrinter(phoneNumbersPeople);
        phoneNumberChecker(phoneNumbersPeople);
        Map<String, String> phoneNumbersPeople1 = new HashMap<>();
        phoneNumbersPeople1 = swapKeysAndValues(phoneNumbersPeople);
        System.out.println(phoneNumbersPeople1);
        System.out.println();


        Map<String, Integer> map = new HashMap<>();
        map.put("jj", 12);
        map.put("12", 18);
        map.put("1222", 3);
        map.put("jj22", 12);
        map.put("13", 3422);
        printSumOfNumberInMap(map);
        removeGreaterThanNumber(map, 12);
        printSumOfNumberInMap(map);
        System.out.println();

        Map<String, String> map1 = new HashMap<>();
        map1.put("A", "Azat");
        map1.put("B", "Marat");
        map1.put("C", "Marat");
        map1.put("D", "Azat");
        map1.put("E", "Azat");
        map1.put("F", "Azat");
        printMostFrequentValue(map1);
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

    public static void printSumOfNumberInMap(Map<?, ? extends Number> map) {
        double sum = 0;
        for (Number value : map.values()) {
            sum += value.doubleValue();
        }
        System.out.println("Sum of map values: " + sum);
    }

    public static void removeGreaterThanNumber(Map<String, Integer> map, int number) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() > number) {
                iterator.remove();
            }
        }
    }

    public static void printMostFrequentValue(Map<String, String> map) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String value : map.values()) {
            if (frequencyMap.containsKey(value)) {
                frequencyMap.put(value, frequencyMap.get(value) + 1);
            } else {
                frequencyMap.put(value, 1);
            }
        }
        System.out.println(frequencyMap);

        String mostFrequentValue = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentValue = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        System.out.println("Most frequent value: " + mostFrequentValue);
    }

}