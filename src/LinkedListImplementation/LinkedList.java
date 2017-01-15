package LinkedListImplementation;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void push(int data) {

		Node newNode = new Node();

		newNode.setData(data);

		newNode.setNext(head);

		head = newNode;
	}

	public void insertAfter(Node previous_node, int data) {

		Node newNode = new Node();

		newNode.setData(data);

		newNode.setNext(previous_node.getNext());

		previous_node.setNext(newNode);

	}

	public void insertAtEnd(int data) {

		Node newNode = new Node();

		newNode.setData(data);

		newNode.setNext(null);

		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(newNode);

	}

	public void deleteKey(int key) {
		if (head == null) {
			return;
		}
		Node temp = head;
		Node previous = null;
		boolean isKeyPresent = false;
		while (temp != null) {
			if (key == temp.getData()) {
				isKeyPresent = true;
				if (previous == null) {
					head = temp.getNext();
				} else {
					previous.setNext(temp.getNext());
				}
				break;
			}
			previous = temp;
			temp = temp.getNext();
		}

		if (!isKeyPresent) {
			System.out.println("Key not found");
		}
	}

	public void deleteByPosition(int position) {

		if (head == null) {
			return;
		}
		Node temp = head;
		Node previous = null;
		int countPosition = -1;
		while (temp != null) {
			countPosition++;
			if (countPosition == position) {
				if (previous == null) {
					head = temp.getNext();
				} else {
					previous.setNext(temp.getNext());
				}
				break;
			}
			previous = temp;
			temp = temp.getNext();
		}

		if (position > countPosition || position<0) {
			System.out.println("Invalid Position");
		}
	}

	public void swapNodes(int data1, int data2) {

		if (data1 == data2) { 							// Both nodes are same
			System.out.println("Both nodes are same");
			return;
		}
		Node temp = head;

		Node node1 = null;
		Node node2 = null;
		Node previous1 = null;
		Node previous2 = null;
		Node previous = null;

		while (temp != null) {

			if (data1 == temp.getData()) {
				node1 = temp;
				previous1 = previous;
			} else if (data2 == temp.getData()) {
				node2 = temp;
				previous2 = previous;
			}
			previous = temp;
			temp = temp.getNext();
		}

		if (node1 != null && node2 != null) {
			Node next2 = node2.getNext();
			Node next1 = node1.getNext();
			if (next2 == node1) { 					// Adjacent Nodes  : Type 1:  Node1 ---> Node2
				previous2.setNext(node1);
				node1.setNext(node2);
				node2.setNext(next1);
			} else if (next1 == node2) { 			// Adjacent Nodes  : Type 1:  Node1 ---> Node2
				previous1.setNext(node2);
				node2.setNext(node1);
				node1.setNext(next2);
			} else { 								// Nodes that aren't adjacent
				node2.setNext(next1);
				node1.setNext(next2);
				if (previous1 == null) { 			// Node 1 is at the head of the list
					head = node2;
					previous2.setNext(node1);
				} else if (previous2 == null) { 	// Node 1 is at the head of the list
					head = node1;
					previous1.setNext(node2);
				} else { 							// Neither of the nodes are at the head of the list
					previous1.setNext(node2);
					previous2.setNext(node1);
				}
			}
		} else {
			System.out.println("Atleast one node is not in the list");
		}
	}

	public void print() {
		Node temp = head;
		if (temp != null) {
			System.out.print(temp.getData());
			temp = temp.getNext();
		}
		while (temp != null) {
			System.out.print(" ---> " + temp.getData());
			temp = temp.getNext();
		}

		System.out.println();
	}
}
