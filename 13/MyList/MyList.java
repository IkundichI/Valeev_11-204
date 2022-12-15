package MyList;


import java.util.Arrays;

public class MyList {
    private String[] strings = new String[5];
    private int lastFreeIndex = 0;

    private void sdvigatel() {
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                count++;
            }
        }
        String[] strings1 = new String[count];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                strings1[k] = strings[i];
                k++;
            }
        }
        strings = strings1;
    }

    public boolean add(String s){
        if (lastFreeIndex+1>=strings.length){
            String[] newArray = new String[strings.length+5];
            strings = newArray;
        }
        strings[lastFreeIndex] = s;
        lastFreeIndex++;
        return true;
    }

    public String get(int index){
        return strings[index];
    }

    private void copyArrays(String[] source, String[] target){
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    public int size(){
        sdvigatel();
        return strings.length;
    }

    public boolean addAll(MyList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
        }
        return true;
    }

    public void clear() {
        strings = new String[10];
        sdvigatel();
    }

    public boolean contains(String s) {
        for (int i = 0; i < size(); i++) {
            if (strings[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        sdvigatel();
        for (int i = 0; i < size(); i++) {
            if (strings[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(String s) {
        for (int i = 0; i < size(); i++) {
            if (strings[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public String remove(int index) {
        String [] massivchik = new String[size()-1];
        int k = 0;
        String save = strings[index];
        for (int i = 0; i < size(); i++) {
            if (i != index) {
                massivchik[k] = strings[i];
                k++;
            }
        }
        strings = massivchik;
        sdvigatel();
        return save;
    }

    public boolean containsAll(MyList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            boolean ans = false;
            for (int j = 0; j < size(); j++) {
                if (strings[j].equals(otherList.get(i))) {
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

    public boolean remove(String s) {
        int k = indexOf(s);
        if (k != -1) {
            remove(k);
            return true;
        }
        return false;
    }

    public boolean removeAll(MyList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (strings[j] != null && otherList.get(i) != null && strings[j].equals(otherList.get(i))) {
                    strings[j] = null;
                }
            }

        }
        sdvigatel();
        return true;
    }

    @Override
    public String toString() {
        sdvigatel();
        return Arrays.toString(strings);
    }
}
