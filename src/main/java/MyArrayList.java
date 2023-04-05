import java.util.AbstractList;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList {
    int index;
    Object[] myList;
    public MyArrayList(){
        myList = new Object[10];
    }
    public<E> void add(E element){
        myList = Arrays.copyOf(myList, myList.length);
        myList[index] = element;
        index++;
    }
    public void remove(int index){
        myList = Arrays.copyOf(myList, myList.length-1);
        for (int i = 0; i < myList.length; i++) {
            if(i == index) myList[i] = myList[i];
        }

    }
    public void clear() {
        for (int i = 0; i < myList.length; i++)
            myList[i] = null;
    }
    public int size(){
        return myList.length;
    }
    public Object get(int index){
        return myList[index];
    }
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Hello");
        arrayList.add("Im list");
        arrayList.add("1");
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        arrayList.remove(1);
        System.out.println(arrayList.get(1));
        arrayList.clear();
        System.out.println(arrayList.get(0));
    }
}