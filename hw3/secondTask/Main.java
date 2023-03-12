package hw3.secondTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ModifiableCollection<Billionare> collection = new ModifiableCollection<>();
        try (Scanner scanner = new Scanner(new File("neww.csv"))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] lineArray = scanner.nextLine().split(";");
                if (lineArray.length > 1) {
                    int rank = (lineArray[0] != null && lineArray[0] != "")  ? Integer.parseInt(lineArray[0]) : 0;
                    String personName = lineArray[1] != null ? lineArray[1] : "";
                    double age = (lineArray[2] != null && lineArray[2] != "") ? Double.parseDouble(lineArray[2]) : 0;
                    int finalWorth = lineArray[3] != null ? Integer.parseInt(lineArray[3]) : 0;
                    String category = lineArray[4] != null ? lineArray[4] : "";
                    String source = lineArray[5] != null ? lineArray[5] : "";
                    String country = lineArray[6] != null ? lineArray[6] : "";
                    String state = lineArray[7] != null ? lineArray[7] : "";
                    String city = lineArray[8] != null ? lineArray[8] : "";
                    String organization = lineArray[9] != null ? lineArray[9] : "";
                    boolean selfMade = lineArray[10] != null ? Boolean.parseBoolean(lineArray[10]) : false;
                    String gender = lineArray[11] != null ? lineArray[11] : "";
                    String birthDate = lineArray[12] != null ? lineArray[12] : "";
                    String title = lineArray[13] != null ? lineArray[13] : "";
                    double philanthropyScore = lineArray[14] != null ? Double.parseDouble(lineArray[14]) : 0;
                    collection.add(new Billionare(rank, personName, age, finalWorth, category, source, country, state,
                            city, organization, selfMade, gender, birthDate, title, philanthropyScore));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        topOrganizationsByPeople(collection);
        //Тест работы remove()
        Iterator<Billionare> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Billionare billionare = iterator.next();
            if (billionare.organization.equals("")) {
                iterator.remove();
            }
        }
        System.out.println("-----");
        topOrganizationsByPeople(collection);
        //Тест removeAll()
        ModifiableCollection<Integer> collection1 = new ModifiableCollection<>();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        collection1.add(4);
        ModifiableCollection<Integer> collection2 = new ModifiableCollection<>();
        collection2.add(3);
        collection2.add(4);
        collection1.removeAll(collection2);
        System.out.println(collection2); //{3, 4}
        System.out.println(collection1); //{1, 2, 3, 4} -> removeAll({3, 4}) -> {1, 2}





    }
    public static void topOrganizationsByPeople(ModifiableCollection<Billionare> collection) {
        ModifiableCollection<Billik> collection1 = new ModifiableCollection<>();
        for (Billionare element : collection) {
            boolean ans = false;
            for (Billik comp: collection1) {
                if (element.organization.equals(comp.company) ) {
                    ans = true;
                    comp.add();
                }
            }
            if (!ans) {
                collection1.add(new Billik(element.organization));
            }
        }
        int count = 0;
        int max = 0;
        for (Billik comp: collection1) {
            if (max < comp.count) {
                max = comp.count;
            }
        }
        while (max != 1) {
            for (Billik compik: collection1) {
                if (compik.count == max) {
                    System.out.println(compik);
                    count++;
                }
                if (count == 5) {
                    break;
                }
            }
            max--;

        }

    }
    public static class Billik {
        String company;
        int count;

        public Billik(String company) {
            this.company = company;
            count = 1;
        }
        public void add() {
            this.count += 1;
        }

        @Override
        public String toString() {
            return "\"" + company + "\"" + " => " + count;
        }
    }
}
