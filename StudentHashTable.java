public class StudentHashTable {

    private class HashNode {
        String key;
        Student value;
        HashNode next;

        HashNode(String key, Student value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int CAPACITY = 11;
    private HashNode[] buckets = new HashNode[CAPACITY];

    private int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % CAPACITY;
        }
        return hash;
    }

    public void put(String studentID, Student student) {
        String key = studentID.toLowerCase();
        int index = hashFunction(key);

        HashNode current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = student;
                return;
            }
            current = current.next;
        }

        HashNode newNode = new HashNode(key, student);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public Student get(String studentID) {
        String key = studentID.toLowerCase();
        HashNode current = buckets[hashFunction(key)];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean remove(String studentID) {
        String key = studentID.toLowerCase();
        int index = hashFunction(key);

        HashNode current = buckets[index];
        HashNode previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}