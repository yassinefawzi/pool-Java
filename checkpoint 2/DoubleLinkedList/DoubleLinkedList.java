public class DoubleLinkedList implements LinkedList {
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		int value;
		Node next;
		Node prev;

		Node(int value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	@Override
	public int at(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}

		Node current;
		if (index < (size + 1) / 2) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = next(current);
			}
		} else {
			current = tail;
			for (int i = size - 1; i > index; i--) {
				current = prev(current);
			}
		}

		return current.value;
	}

	@Override
	public void add(int value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}

		size++;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= size) {
			return;
		}

		if (size == 1) {
			head = null;
			tail = null;
		} else if (index == 0) {
			head = head.next;
			head.prev = null;
		} else if (index == size - 1) {
			tail = tail.prev;
			tail.next = null;
		} else {
			Node current;

			if (index < (size + 1) / 2) {
				current = head;
				for (int i = 0; i < index; i++) {
					current = next(current);
				}
			} else {
				current = tail;
				for (int i = size - 1; i > index; i--) {
					current = prev(current);
				}
			}

			current.prev.next = current.next;
			current.next.prev = current.prev;
		}

		size--;
	}

	@Override
	public int size() {
		return size;
	}

	private Node next(Node node) {
		System.out.println("Go to next node");
		return node.next;
	}

	private Node prev(Node node) {
		System.out.println("Go to previous node");
		return node.prev;
	}
}