public class MyLinkedList {
    public Node first = null;
    public Node last = null;
    private int size;
    class Node<E>{
        E data;
        Node next;
        Node prev;
        public Node(E data) {
            this.data = data;
        }
    }
    public<E> void add(E data) {
        Node newNode = new Node(data);

        if(first == null) {
            first = newNode;
            last = newNode;
            size+=1;
        }
        else {
            last.next = newNode;
            last = newNode;
            size+=1;
        }
    }
    public void remove(int index){
        Node currentNext = first;
        currentNext = currentNext.next;
        int count = 0;
        for (MyLinkedList.Node x = first; x != null; ) {
            MyLinkedList.Node next = x.next;
            if(index-1 == count) {
                x.next = currentNext.next;
                size--;
                break;
            } else if(index == 0){
                first = currentNext;
                size--;
                break;
            }
            currentNext = currentNext.next;
            x = next;
            count++;
        }
    }

    public void clear() {
        for (MyLinkedList.Node x = first; x != null; ) {
            MyLinkedList.Node next = x.next;
            x.prev = null;
            x.next = null;
            x.data = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public<E> E get(int index){
        Node current = first;
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
}
