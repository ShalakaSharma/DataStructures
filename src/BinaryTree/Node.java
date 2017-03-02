package BinaryTree;

public class Node {
	int value;
	Node left;
	Node right;
	Node parent;
	
	public Node() {
		super();
	}
	
	public Node(int value) {
		this.value = value;
	}
	
	public boolean hasLeft() {
		if(left==null) {
			return false;
		}
		return true;
	}
	
	public boolean hasRight() {
		if(right==null) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return value+"";
	}
}
