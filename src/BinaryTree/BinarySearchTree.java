package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree extends BinaryTree {

	public void insert(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			root = newNode;
			return;
		}

		Node iterator = root;

		Node intermediateRoot = root;

		while (iterator != null) {
			if (value <= iterator.value) {
				intermediateRoot = iterator;
				iterator = iterator.left;
			} else {
				intermediateRoot = iterator;
				iterator = iterator.right;
			}
		}
		if (value <= intermediateRoot.value) {
			intermediateRoot.left = newNode;
		} else {
			intermediateRoot.right = newNode;
		}

	}

	public void delete(int key) {
		Node iterator = root;
		Node parent = null;
		boolean keyFound = false;
		while (iterator != null) {
			if (iterator.value == key) {
				keyFound = true;
				break;
			} else if (iterator.value > key) {
				parent = iterator;
				iterator = iterator.left;
			} else {
				parent = iterator;
				iterator = iterator.right;
			}

		}

		if (keyFound) {
			Node toDelete = iterator;
			if (toDelete.hasLeft() && toDelete.hasRight()) {
				iterator = toDelete.right;
				Node minNode = toDelete.right;
				Node parentOfMinNode = toDelete;
				while (iterator != null) {

					if (minNode.value > iterator.value) {
						minNode = iterator;
					}
					if (iterator.hasLeft()) {
						parentOfMinNode = iterator;
						iterator = iterator.left;
					} else if (iterator.hasRight()) {
						parentOfMinNode = iterator;
						iterator = iterator.right;
					} else {
						toDelete.value = minNode.value;
						if (parentOfMinNode.left == minNode) {
							parentOfMinNode.left = null;
						} else {
							parentOfMinNode.right = null;
						}
						iterator = null;
					}
				}

			} else if (toDelete.hasLeft() || toDelete.hasRight()) {
				if (toDelete.hasLeft()) {
					if (parent.left == toDelete) {
						parent.left = toDelete.left;
					} else {
						parent.right = toDelete.left;
					}
				} else {
					if (parent.left == toDelete) {
						parent.left = toDelete.right;
					} else {
						parent.right = toDelete.right;
					}
				}
			} else {
				if (parent.left == toDelete) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
	}

	// create bst from sorted array

	public Node createMinimalBSTFromSortedArray(int[] arr) {

		return createMinimalBSTFromSortedArrayRec(arr, 0, arr.length - 1);
	}

	private Node createMinimalBSTFromSortedArrayRec(int[] arr, int start,
			int end) {
		if (start > end) {
			return null;
		}
		Node root = new Node();
		int mid = (start + end) / 2;
		int rootNodevalue = arr[mid];
		root.value = rootNodevalue;
		root.left = createMinimalBSTFromSortedArrayRec(arr, start, mid - 1);
		root.right = createMinimalBSTFromSortedArrayRec(arr, mid + 1, end);
		return root;
	}

	public ArrayList<LinkedList<Node>> createLinkedListUsingLevelOrder(Node root) {
		
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		
		if (root == null) {
			return null;
		}

		LinkedList<Node> linkedList = new LinkedList<Node>();

		linkedList.add(root);
		

		while (!linkedList.isEmpty()) {
			
			result.add(linkedList);
			
			LinkedList<Node> parents = linkedList;
			
			linkedList = new LinkedList<Node>();

			for(Node parent: parents) {
				if (parent.hasLeft()) {
					linkedList.add(parent.left);
				}

				if (parent.hasRight()) {
					linkedList.add(parent.right);
				}
			}
			

		}
		return result;
		
	}

	public ArrayList<LinkedList<Node>> createLinkedListUsingPreOrder(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		
			 createLinkedListUsingPreOrderRec(root, 0, result);
		
			 return result;	
	}
	
	private void createLinkedListUsingPreOrderRec(Node root, int level, ArrayList<LinkedList<Node>> result) {
		
		if(root == null) {
			return;
		}
		LinkedList<Node> current = null;
		boolean isNew = false;
		if(result.size() == level) {
			current = new LinkedList<Node>();
			isNew = true;
		} else {
			current = result.get(level);
		}
		 
		current.add(root);
		if(isNew) {
			result.add(current);
		} else {
			result.set(level, current);
		}
		createLinkedListUsingPreOrderRec(root.left, level+1, result);
		
		createLinkedListUsingPreOrderRec(root.right, level+1, result);
	}
	
	public boolean checkBST(Node root) {
		return checkBSTRec(root, null, null);
	}
	
	private boolean checkBSTRec(Node root, Integer min, Integer max) {
		
		if(root == null) {
			return true;
		}
		
		if((min != null && root.value <= min) || (max !=null && root.value >=max)) {
			return false;
		}
		
		if((!checkBSTRec(root.left, min, root.value)) || (!checkBSTRec(root.right, root.value, max))) {
			return false;
		}
		
		return true;
	}
	
	public Node findInOrderNextNode(Node node) {
		
		if(node.right == null) {
			Node temp = node;
			while(temp.parent.value < node.value) {
				temp = temp.parent;
			}
			return temp.parent;
		}
		
		Node root = node.right;
		return findMin(root, node.right.value);
		
	}
	
	private Node findMin(Node root, int min) {
		
		if(root.value < min) {
			min = root.value;
		}
		
		if(root.left == null) {
			return root;
		}
		return findMin(root.left, min);
		
	}
}
