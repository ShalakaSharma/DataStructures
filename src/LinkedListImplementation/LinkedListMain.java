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

		linkedList.reverse();

		linkedList.print();

		linkedList.push(45);

		linkedList.print();

		System.out.println("Remove Dups");

		linkedList.removeDups();

		linkedList.print();

		linkedList.push(30);

		System.out.println("Remove Dups");

		linkedList.print();

		linkedList.removeDups();

		linkedList.print();
		
		System.out.println("kth to last");

		Node n = linkedList.kthToLast(10);

		if (n != null) {
			System.out.println(n.getData());
		} else {
			System.out.println("k was invalid");
		}
		
		System.out.println("kth to last 2 pointers");

		n = linkedList.kthNode2Pointers(2);

		if (n != null) {
			System.out.println(n.getData());
		} else {
			System.out.println("k was invalid");
		}
		
		System.out.println("reverse second half");
		
		linkedList.reverseSecondHalf();
		
		linkedList.print();
		
		linkedList.setHead(null);
		
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(10);
		linkedList.push(5);
		linkedList.push(8);
		linkedList.push(5);
		linkedList.push(3);
		
		linkedList.print();
		
		linkedList.partition(3);
		
		linkedList.print();
		
		LinkedList l1 = new LinkedList();
		
		LinkedList l2 = new LinkedList();
		
		l1.push(6);
		l1.push(1);
		l1.push(7);
		
		l1.print();
		
		l2.push(2);
		l2.push(9);
		l2.push(5);
		
		l2.print();
		
		LinkedList l3 = new LinkedList();
		l3 = l3.addTwoLinkedLists(l1, l2);
		
		l3.print();
		
	}

}
