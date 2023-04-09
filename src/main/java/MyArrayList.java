import java.util.Arrays;

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
        Object[] arr = new Object[myList.length-1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == index) continue;
            else {
                arr[count] = myList[i];
                count++;
            }
        }
        myList = Arrays.copyOf(arr, arr.length);
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

}