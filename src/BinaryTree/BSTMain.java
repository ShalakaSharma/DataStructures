package BinaryTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BSTMain {

	public static void main(String[] args) throws IOException {

		BinarySearchTree tree = new BinarySearchTree();

		// 50
		// / \
		// 30 70
		// / \ / \
		// 20 40 60 80

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.levelOrderTraversal();

		System.out.println("----delete 50-----");

		tree.delete(50);
		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.levelOrderTraversal();

		tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("----delete 20 ----");

		tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.delete(20);
		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.levelOrderTraversal();

		System.out.println("----delete 70 ----");

		tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.delete(70);
		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.levelOrderTraversal();

		System.out.println("----print leaf nodes-----");

		tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.printLeafNodes();

		System.out.println("-----max sum----");

		System.out.println(tree.findMaxSum());

		System.out
				.println("----inserting 35 , delete 80, 60 and then max sum ----");
		tree.insert(35);

		tree.delete(80);
		tree.delete(60);
		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.levelOrderTraversal();

		System.out.println(tree.findMaxSum());

		System.out.println("-----min sum----");

		System.out.println(tree.findMinSum());

		tree.serializeTree(tree.root, "src/files/serializetree.txt");

		BinaryTree bt = new BinaryTree();

		bt.root = bt.deserializeTree("src/files/serializetree.txt");

		bt.levelOrderTraversal();

		int arr[] = { 10, 20, 30, 40, 50, 60, 70 };

		BinarySearchTree bst = new BinarySearchTree();

		bst.root = bst.createMinimalBSTFromSortedArray(arr);

		bst.levelOrderTraversal();

		ArrayList<LinkedList<Node>> result = bst
				.createLinkedListUsingLevelOrder(bst.root);

		System.out.println(result);

		tree.preOrderTraversal();
		tree.levelOrderTraversal();

		result = bst.createLinkedListUsingPreOrder(bst.root);

		System.out.println(result);

		int inOrder[] = { 10, 20, 30, 40, 50, 60, 70 };

		int preOrder[] = { 40, 20, 10, 30, 60, 50, 70 };

		tree.root = tree.createTreeInorderPreOrder(inOrder, preOrder);

		tree.levelOrderTraversal();

		System.out.println(bst.checkBST(bt.root));
		bt.inOrderTraversal();

		tree.insert(25);
		tree.insert(35);
		tree.levelOrderTraversal();
		Node root = tree.root.left.right.right;
		tree.setParents(null, tree.root);
		tree.levelOrderTraversal();
		
		Node node = tree.findInOrderNextNode(root);
		if (node != null) {
			System.out.println(node.value);
		} else {
			System.out.println("null");
		}
	}
}
