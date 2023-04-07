import java.util.LinkedList;

public class MyLinkedList {
    private int size;

    class Node{
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public<E> void add(E data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size+=1;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            size+=1;
        }
    }
    public void remove(int index){

    }

    public void clear() {
        for (MyLinkedList.Node x = head; x != null; ) {
            MyLinkedList.Node next = x.next;
            x.next = null;
            x.data = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public<E> E get(int index){
        E res = null;
        for (int i = 0; i < index; i++) {

        }
        return res;
    }

    public void display() {
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyLinkedList sList = new MyLinkedList();

        sList.add("One");
        sList.add(2);
        sList.add(3);
        sList.add(4);

        sList.display();
        System.out.println(sList.size());

        sList.clear();

        sList.display();

    }
}
