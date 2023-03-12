package hw3.firstTask;

public class Main {
    public static void main(String[] args) {
        int [] array = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
        OddNumberIterator iterator = new OddNumberIterator(array);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
