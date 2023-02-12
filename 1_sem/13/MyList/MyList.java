package MyList;

import java.util.Arrays;

public class MyList {
    private String[] strochecka = new String[5];
    private int lastFreeIndex = 0;

    public boolean add(String s) {
        if (lastFreeIndex + 1 >= strochecka.length) {
            String[] newArray = new String[strochecka.length + 5];
            copyArrays(strochecka, newArray);
            strochecka = newArray;
        }
        strochecka[lastFreeIndex] = s;
        lastFreeIndex++;
        return true;
    }

    public String get(int index) {
        return strochecka[index];
    }

    private void copyArrays(String[] source, String[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    public int size() {
        if (lastFreeIndex == 0) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if(strochecka[i] != null){
                    count++;
                }
            }
            return count;
        }
        return lastFreeIndex;
    }

    boolean addAll(MyList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            if (lastFreeIndex + 1 >= strochecka.length) {
                String[] newArray = new String[strochecka.length + 10];
                copyArrays(strochecka, newArray);
                strochecka = newArray;
            }
            strochecka[lastFreeIndex] = otherList.get(i);
            lastFreeIndex++;
        }
        return true;
    }

    void clear() {
        String[] newArray = new String[10];
        strochecka = newArray;
        lastFreeIndex = 0;
    }

    boolean contains(String s) {
        for (int i = 0; i < size(); i++) {
            if (strochecka[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    boolean containsAll(MyList otherList) {
        if (otherList.strochecka.length > strochecka.length) {
            return false;
        }
        boolean ans;
        for (int i = 0; i < otherList.size(); i++) {
            ans = false;
            for (int j = 0; j < strochecka.length; j++) {
                if (otherList.get(i).equals(get(j))) {
                    ans = true;
                    break;
                }
            }
            if (ans == false) {
                return false;
            }
        }
        return true;
    }

    boolean isEmpty() {
        return lastFreeIndex == 0;
    }

    int indexOf(String s) {
        for (int i = 0; i < size(); i++) {
            if (strochecka[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    String remove(int index) {
        String returnString = strochecka[index];
        strochecka[index] = null;
        String tmp;
        for (int i = index; i < size(); ++i) {
            tmp = strochecka[i];
            strochecka[i] = strochecka[i + 1];
            strochecka[i + 1] = tmp;
        }
        lastFreeIndex--;
        return returnString;
    }

    boolean remove(String s) {
        for (int i = 0; i < strochecka.length; i++) {
            if (strochecka[i].equals(s)) {
                remove(i);
                break;
            }
        }
        return true;
    }

    boolean removeAll(MyList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (get(j).equals(otherList.get(i))) {
                    remove(j);
                }
            }
        }
        return true;
    }

    public boolean equals(MyList otherList) {
        if (size() != otherList.size()) {
            return false;
        } else {
            for (int i = 0; i < size(); i++) {
                if (get(i) != otherList.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public String toString() {
        String[] newArray = new String[lastFreeIndex];
        for (int i = 0; i < lastFreeIndex; i++) {
            newArray[i] = strochecka[i];
        }
        return Arrays.toString(newArray);
    }

}