package LinkedListImplementation;

import java.util.HashSet;

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

		if (position > countPosition || position < 0) {
			System.out.println("Invalid Position");
		}
	}

	public void swapNodes(int data1, int data2) {

		if (data1 == data2) { // Both nodes are same
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
			if (next2 == node1) { // Adjacent Nodes : Type 1: Node1 ---> Node2
				previous2.setNext(node1);
				node1.setNext(node2);
				node2.setNext(next1);
			} else if (next1 == node2) { // Adjacent Nodes : Type 1: Node1 --->
											// Node2
				previous1.setNext(node2);
				node2.setNext(node1);
				node1.setNext(next2);
			} else { // Nodes that aren't adjacent
				node2.setNext(next1);
				node1.setNext(next2);
				if (previous1 == null) { // Node 1 is at the head of the list
					head = node2;
					previous2.setNext(node1);
				} else if (previous2 == null) { // Node 1 is at the head of the
												// list
					head = node1;
					previous1.setNext(node2);
				} else { // Neither of the nodes are at the head of the list
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

	public void reverse() {

		Node temp = head;
		Node prev = null;
		while (temp != null) {
			Node next = temp.getNext();
			temp.setNext(prev);
			if (next == null) {
				head = temp;
			}
			prev = temp;
			temp = next;
		}
	}

	public void removeDups() {
		Node temp = head;
		HashSet<Integer> unique = new HashSet<Integer>();
		Node prev = null;
		while (temp != null) {
			if (unique.contains(temp.getData())) {
				prev.setNext(temp.getNext());
			} else {
				unique.add(temp.getData());
			}
			prev = temp;
			temp = temp.getNext();
		}
	}

	public Node kthToLast(int k) {

		Node temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.getNext();
		}
		System.out.println(length);

		if (k > length) {
			System.out.println("Invalid value of K");
			return null;
		}
		int diff = length - k + 1;

		System.out.println(diff);

		int counter = 0;
		Node kthNode = null;
		temp = head;
		while (temp != null) {
			if (counter == diff - 1) {
				kthNode = temp;
				break;
			}
			counter++;
			temp = temp.getNext();
		}

		return kthNode;
	}

	public Node kthNode2Pointers(int k) {

		Node pointer1 = head;
		Node pointer2 = head;

		for (int i = 0; i < k; i++) {
			if (pointer1.getNext() != null) {
				pointer1 = pointer1.getNext();
			} else {
				System.out.println("Invalid value of K");
				return null;
			}

		}

		while (pointer1 != null) {
			pointer1 = pointer1.getNext();
			pointer2 = pointer2.getNext();
		}

		return pointer2;
	}

	/*public Node partition(int key) {

		Node k = head;
		Node keyNode = null;
		while (k != null) {
			if (k.getData() == key) {
				keyNode = k;
			}
			k = k.getNext();
		}

		if (keyNode == null) {
			System.err.println("Key not found");
			return head;
		}
		System.out.println("debgug");
		Node pointer = keyNode.getNext();
		Node pointer2 = head;
		while (pointer != null) {
			if (pointer.getData() < keyNode.getData()) {
				int temp = pointer.getData();
				pointer.setData(pointer2.getData());
				pointer2.setData(temp);
				pointer2 = pointer2.getNext();

			}
			print();
			pointer = pointer.getNext();

		}

		return head;

	}*/

	public void reverseSecondHalf() {

		Node p1 = head;
		Node p2 = head;

		Node prevP2 = null;
		while (p1 != null && p1.getNext() != null) {
			p1 = p1.getNext().getNext();
			prevP2 = p2;
			p2 = p2.getNext();
		}

		Node temp = p2;
		Node prev = null;

		while (temp != null) {
			Node next = temp.getNext();
			if (next == null) {
				prevP2.setNext(temp);
			}
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}

	}
	
	public void partition(int key) {
		
		Node keyNode = search(key);
		
		Node toReplace = keyNode;
		
		if(null == keyNode) {
			System.out.println("Node not found");
			return;
		} 
		
		Node temp = keyNode.getNext();
		
		while(temp != null) {
			if(temp.getData() < keyNode.getData()) {
				int tdata = temp.getData();
				temp.setData(toReplace.getData()); 
				toReplace.setData(tdata);
				toReplace = toReplace.getNext();
			}
			temp = temp.getNext();
		}
		
	}
	
	public Node search(int key) {
		
		Node temp = head;
		
		while(temp!=null) {
			if(temp.getData() == key) {
				return temp;
			}
			temp = temp.getNext();
		}
		
		return null;
	}
	
	public LinkedList addTwoLinkedLists(LinkedList l1, LinkedList l2) {
		LinkedList result = new LinkedList();
		
		Node p1 = l1.head;
		Node p2 = l2.head;
		int carry = 0;
		
		while(p1!=null && p2!=null) {
			int r = p1.getData() + p2.getData() + carry;
			if(r>=10) {
				r = r - 10;
				carry = 1;
			}
			result.push(r);
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		while(p1!= null) {
			result.push(p1.getData() + carry);
			carry = 0;
			p1 = p1.getNext();
		}
		while(p2!= null) {
			result.push(p2.getData() + carry);
			carry = 0;
			p2 = p2.getNext();
		}
		
		return result;
	}
}
