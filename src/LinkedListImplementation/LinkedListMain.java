package LinkedListImplementation;

public class LinkedListMain {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		linkedList.push(40);
		linkedList.push(35);
		linkedList.push(25);
		linkedList.push(20);
		linkedList.push(15);
		linkedList.push(10);

		linkedList.print();

		Node head = linkedList.getHead();

		Node temp = head;
		Node previous_node = null;
		while (temp != null) {
			if (temp.getData() == 25) {
				previous_node = temp;
				break;
			}
			temp = temp.getNext();
		}

		linkedList.insertAfter(previous_node, 30);

		linkedList.print();

		linkedList.insertAtEnd(45);

		linkedList.print();

		linkedList.push(50);

		linkedList.print();

		linkedList.push(60);

		linkedList.print();

		linkedList.deleteKey(50);

		linkedList.print();

		linkedList.push(70);

		linkedList.print();

		linkedList.deleteKey(70);

		linkedList.print();

		linkedList.deleteByPosition(4);

		linkedList.print();

		linkedList.deleteByPosition(0);

		linkedList.print();
		
		linkedList.deleteByPosition(7);

		linkedList.print();
		
		linkedList.deleteByPosition(-1);

		linkedList.print();

		linkedList.swapNodes(45, 10);

		linkedList.print();

		linkedList.swapNodes(45, 10);

		linkedList.print();

		linkedList.swapNodes(30, 35);

		linkedList.print();
		
		linkedList.swapNodes(30, 35);

		linkedList.print();
		
		linkedList.swapNodes(35, 30);

		linkedList.print();
		
		linkedList.swapNodes(35, 30);

		linkedList.print();
		
		linkedList.swapNodes(40, 40);

		linkedList.print();
		
		linkedList.swapNodes(100, 40);

		linkedList.print();

	}
}
