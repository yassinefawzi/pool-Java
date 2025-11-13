public class CircularLinkedList implements LinkedList {
    private Node head;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public int at(int index) {
        if (head == null || index < 0) {
            return -1;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = next(current);
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = next(current);
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (head == null || index < 0 || size == 0)
            return;

        if (index == 0) {
            if (head.next == head) {
                head = null;
            } else {
                Node tail = head;
                while (tail.next != head) {
                    tail = next(tail);
                }
                head = head.next;
                tail.next = head;
            }
            size--;
            return;
        }
        Node current = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = next(current);
        }
        prev.next = current.next;
        if (current == head) {
            head = head.next;
        }
        size--;
    }
    @Override
    public int size() {
        return size;
    }
    private Node next(Node node) {
        System.out.print("Go to next node\n");
        return node.next;
    }
}
