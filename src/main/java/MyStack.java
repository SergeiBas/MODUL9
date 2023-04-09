public class MyStack<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element) {
            this.data = element;
        }
    }

    public void push(E element) {
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

    public E remove(int index) {
        Node<E> x = getNodeByIndex(index);

        final E element = x.data;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (index == 0) {
            if (size > 1) {
                first = first.next;
                first.prev = null;
            } else {
                first = last = null;
            }
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        size--;
        return element;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) last.data;
    }

    public E pop() {
        Node<E> lastToRem = last;
        if (size > 1) {
            last = last.prev;
            last.next = null;
        } else {
            first = last = null;
        }
        size--;
        return (E) lastToRem.data;
    }
    private Node<E> getNodeByIndex(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}