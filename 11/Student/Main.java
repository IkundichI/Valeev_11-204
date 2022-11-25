package Student;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/Student/students.txt");
        File file2 = new File("src/Student/courses.txt");
        File file3 = new File("src/Student/courses_students.txt");
        List<Student> list = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<String[]> cs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file); //Чтение студентов
            Scanner cousreScanner = new Scanner(file2); //Чтение студетнов
            Scanner sc = new Scanner(file3); // Кому-что
            while (cousreScanner.hasNextLine()) {
                String [] ar1 = (cousreScanner.nextLine().split(","));
                courses.add(new Course(ar1[0], ar1[1]));
            }
            while (sc.hasNextLine()) {
                String [] ar2 = (sc.nextLine().split(","));
                cs.add(ar2);
            }
            while (scanner.hasNextLine()) {
                String [] ar = (scanner.nextLine().split(","));
                List<Course> courses1 = new ArrayList<>();
                for (int i = 0; i < cs.size(); i++) {
                    if (cs.get(i)[1].equals(ar[0])) {
                        for (int j = 0; j < courses.size(); j++) {
                            if (cs.get(i)[0].equals(courses.get(j).course)) {
                                courses1.add(courses.get(j));
                            }
                        }
                    }
                }
                list.add(new Student(ar[0], Integer.parseInt(ar[1]), Integer.parseInt(ar[2]), ar[3], Integer.parseInt(ar[4]), courses1));
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
