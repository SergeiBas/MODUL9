public class MyHashMap<K, V> {
    public static final int DEFAULT_CAPACITY = 16;
    public static float loadFactor = 0.75f;
    private Node<K, V>[] table;
    private int size;
    private int threshold = (int) (DEFAULT_CAPACITY * loadFactor);
    private int uniqueBuckets;
    class Node<K, V> {
        private Node<K, V> next;
        private int hash;
        private K key;
        private V value;
        public Node(int hash, K key, V value, Node<K, V> next) {
            this.next = next;
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int count = 1;
        int currentHash = hash(key);
        int index = (count * DEFAULT_CAPACITY - 1) & currentHash;
        Node<K, V> newNode = new Node<>(currentHash, key, value, null);

        if (table == null || size == 0) {
            table = new Node[DEFAULT_CAPACITY];
        } else if (uniqueBuckets >= threshold * count) {
            resize();
            count++;
        }

        Node<K, V> bucket;
        if ((bucket = table[index]) == null) {
            table[index] = newNode;
            uniqueBuckets++;
            size++;
        } else {
            if ((bucket.hash == currentHash) && ((bucket.key == key) || ((key != null) && key.equals(bucket.key)))) {
                bucket.value = value;
            } else {
                for (Node<K, V> x = bucket; x != null; x = x.next) {
                    if ((x.hash == currentHash) && ((x.key == key) || ((key != null) && key.equals(x.key)))) {
                        x.value = value;
                    } else if (bucket.next == null) {
                        bucket.next = newNode;
                        size++;
                    }
                }
            }
        }
    }

    private void resize() {
        int countOfResizes = 1;
        Node<K, V>[] newTable = new Node[table.length + DEFAULT_CAPACITY * countOfResizes];
        System.arraycopy(table, 0, newTable, 0, table.length);
        table = newTable;
        countOfResizes++;
    }

    private final int hash(K key) {
        return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    public void remove(K key) {
        for (int i = 0; i < table.length; i++) {
            Node<K, V> bucket = table[i];
            if (bucket != null) {
                if (bucket.next == null) {
                    if ((bucket.hash == hash(key)) && ((bucket.key == key) || (key != null) && key.equals(bucket.key))) {
                        table[i] = null;
                    }
                } else {
                    if ((bucket.hash == hash(key)) && ((bucket.key == key) || (key != null) && key.equals(bucket.key))) {
                        bucket = null;
                    } else {
                        for (Node<K, V> n = bucket; n != null; n = n.next) {
                            if ((n.hash == hash(key)) && ((n.key == key) || (key != null) && key.equals(n.key))) {
                                bucket.next = null;
                            }
                        }
                    }
                }
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        table = new Node[0];
        size = 0;
    }

    public V get(K key) {
        Node<K, V> current = null;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Node<K, V> x = table[i]; x != null; x = x.next) {
                    if ((x.hash == hash(key)) && ((x.key == key) || (key != null) && (key.equals(x.key)))) {
                        current = x;
                        break;
                    }
                }
            }
        }
        return (current != null) ? current.value : null;
    }
}
