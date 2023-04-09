import java.util.Arrays;

public class MyQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private class Node<E> {

        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public E peek() {
        return (E) first.data;
    }

    public E poll() {
        Node<E> elementToRemove = first;
        if (size > 1) {
            first = first.next;
            first.prev = null;
        } else {
            first = last = null;
        }
        size--;
        return (E) elementToRemove.data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }
}