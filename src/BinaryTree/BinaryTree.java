package BinaryTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	static int index;

	Node root;

	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	public void inOrderTraversal() {

		inOrder(root);
		System.out.println();
	}

	void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			visit(node);
			inOrder(node.right);
		}
	}

	void visit(Node node) {
		System.out.print(node.value + " ");
	}

	public void preOrderTraversal() {

		preOrder(root);
		System.out.println();
	}

	void preOrder(Node node) {
		if (node != null) {
			visit(node);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrderTraversal() {

		postOrder(root);
		System.out.println();
	}

	void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			visit(node);
		}
	}

	public void printLeafNodes() {

		printLeafs(root);

	}

	public void printLeafs(Node root) {
		if (!root.hasLeft() && !root.hasRight()) {
			System.out.println(root.value);
			return;
		}
		printLeafs(root.left);
		printLeafs(root.right);
	}

	public int findMaxSum() {
		return maxSumRec(root, 0);
	}

	public int maxSumRec(Node root, int sum) {
		if (root == null) {
			return sum;
		}
		sum = sum + root.value;
		if (root.hasLeft() && root.hasRight()) {
			return Math.max(maxSumRec(root.left, sum),
					maxSumRec(root.right, sum));
		} else if (root.hasLeft()) {
			return maxSumRec(root.left, sum);
		} else if (root.hasRight()) {
			return maxSumRec(root.right, sum);
		}
		return sum;
	}

	public int findMinSum() {
		System.out.println();
		return minSumRec(root, 0);
	}

	public int minSumRec(Node root, int sum) {
		if (root == null) {
			return sum;
		}
		sum = sum + root.value;
		if (root.hasLeft() && root.hasRight()) {
			return Math.min(minSumRec(root.left, sum),
					minSumRec(root.right, sum));
		} else if (root.hasLeft()) {
			return minSumRec(root.left, sum);
		} else if (root.hasRight()) {
			return minSumRec(root.right, sum);
		}
		return sum;
	}

	public void levelOrderTraversal() {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Node tempRoot = queue.poll();
			
			System.out.print(tempRoot.value + " ");
			
			if (tempRoot.hasLeft()) {
				queue.add(tempRoot.left);
			}

			if (tempRoot.hasRight()) {
				queue.add(tempRoot.right);
			}

		}
		System.out.println();
	}

	public String getLevelOrderTraversal(Node root) {

		StringBuffer levelOrder = new StringBuffer();

		if (root == null) {
			return levelOrder.toString();
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Node tempRoot = queue.poll();

			levelOrder.append(tempRoot.value);
			levelOrder.append(" ");

			if (tempRoot.hasLeft()) {
				queue.add(tempRoot.left);
			}

			if (tempRoot.hasRight()) {
				queue.add(tempRoot.right);
			}

		}

		levelOrder.deleteCharAt(levelOrder.length() - 1);

		return levelOrder.toString();
	}

	public void serializeTree(Node root, String fileName) throws IOException {

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			File file = new File(fileName);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			writeTree(root, bw);
			bw.flush();
		} finally {
			if (fw != null) {
				fw.close();
			}
			if (bw != null) {
				bw.close();
			}
		}

	}

	public void writeTree(Node root, BufferedWriter bw) throws IOException {

		String content;

		if (root == null) {
			content = "# ";
			bw.write(content);
			return;
		} else {
			content = root.value + " ";
		}

		bw.write(content);
		writeTree(root.left, bw);
		writeTree(root.right, bw);
	}

	public Node deserializeTree(String fileName) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File file = new File(fileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String content = "";
			String preOrder = "";
			while ((content = br.readLine()) != null) {
				preOrder += content;
			}
			String preOrderArr[] = preOrder.split(" ");
			Node root = new Node();
			return (createTree(root, preOrderArr));

		} finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		}

	}
	
	public Node createTree(Node root, String[] preOrderArr) {
		
		String str = preOrderArr[index];
		
		if(str.equals("#")) {
			return null;
		}
		root = new Node();
		root.value = Integer.parseInt(str);
		
		if(index == preOrderArr.length) {
			return root;
		}
		index = index + 1;
		root.left = createTree(root.left, preOrderArr);
		index = index + 1;
		root.right = createTree(root.right, preOrderArr);
		
		return root;
	}
	
	public Node createTreeInorderPreOrder(int[] inOrder, int[] preOrder) {
		index= 0;
		return buildTree(inOrder, preOrder, 0, inOrder.length);
		
	}

	
	private Node buildTree(int[] inOrder, int[] preOrder, int start, int end) {
		
		if(index==preOrder.length) {
			return null;
		}
		
		if(start>end) {
			return null;
		}
		
		
		Node root = new Node(preOrder[index]);
		index++;
		if(start == end) {
			return root;
		}
		
		
		
		int inOrderIndex = search(inOrder, start, end, root.value);
		
		root.left = buildTree(inOrder, preOrder, start, inOrderIndex-1);
		root.right = buildTree(inOrder, preOrder, inOrderIndex+1, end);
		
		return root;
	}

	private int search(int[] inOrder, int start, int end, int value) {
		
		for(int i=start;i<=end;i++) {
			if(value == inOrder[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void setParents(Node parent, Node current) {
		if(current == null) {
			return;
		}
		current.parent  = parent;
		parent = current;
		setParents(parent, current.left);
		setParents(parent, current.right);
	}
}
