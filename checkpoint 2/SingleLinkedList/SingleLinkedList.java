public class SingleLinkedList implements LinkedList {
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
        if (index < 0 || head == null || index >= size) {
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
        } else {
            Node current = head;
            while (current.next != null) {
                current = next(current);
            }
            current.next = newNode;
        }

        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || head == null || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            Node prev = null;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = next(current);
            }

            prev.next = current.next;
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
