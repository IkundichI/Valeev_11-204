package CarsRace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/CarsRace/cars.txt");
        Car[] k1 = new Car[10000000];
        try {
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                String [] array = (scanner.nextLine().split(" "));
                int [] array_int = new int[array.length];
                for (int i = 0; i < array.length; i++) {
                    array_int[i] = Integer.parseInt(array[i]);
                }
                if (array_int.length == 2) {
                    k1[index] = new CasualCar(array_int[0], array_int[1]);
                }
                if (array_int.length == 3) {
                    k1[index] = new BoostedCar(array_int[0], array_int[1], array_int[2]);
                }
                index++;
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Race.start(k1, 4);
    }
}
