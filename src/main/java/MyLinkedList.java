import java.util.Optional;

public class MyLinkedList {
    private int size;

    class Node{
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
        Node currentNext = head;
        currentNext = currentNext.next;
        int count = 0;
        for (MyLinkedList.Node x = head; x != null; ) {
            MyLinkedList.Node next = x.next;
            if(index-1 == count) {
                x.next = currentNext.next;
                size--;
                break;
            } else if(index == 0){
                head = currentNext;
                size--;
                break;
            }
            currentNext = currentNext.next;
            x = next;
            count++;
        }
    }

    public void clear() {
        for (MyLinkedList.Node x = head; x != null; ) {
            MyLinkedList.Node next = x.next;
            x.prev = null;
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
        Node current = head;
        int count = 0;
        while(true){
            if(count == index){
                return (E) current.data;
            } else {
                current = current.next;
                count++;
            }
        }
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

        sList.remove(3);
        sList.display();

        System.out.println(sList.size());
        System.out.println(Optional.ofNullable(sList.get(0)));

        sList.clear();
        sList.display();

    }
}
