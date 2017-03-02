package Tries;

import java.util.ArrayList;

public class Trie {

	private TrieNode root;

	public Trie(ArrayList<String> list) {
		root = new TrieNode();
		for (String s : list) {
			addWord(root, s);
		}
	}

	public Trie(String[] list) {
		root = new TrieNode();
		for (String s : list) {
			addWord(root, s);
		}
	}

	public void addWord(TrieNode curr, String word) {
		/*
		 * if (null != children) { System.out.println(children.toString()); }
		 */
		if (word == null || word.length() == 0) {
			return;
		}

		char firstChar = word.charAt(0);

		TrieNode child = curr.getChild(firstChar);

		if (child == null) {
			child = new TrieNode(firstChar);
			curr.getChildren().put(firstChar, child);
		}

		if (word.length() > 1) {
			addWord(child, word.substring(1));
		} else {
			child.setTerminates(true);
		}
	}

	public boolean contains(String prefix, boolean exact) {

		TrieNode lastNode = root;

		for (int i = 0; i < prefix.length(); i++) {
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null) {
				return false;
			}
		}

		return !exact || lastNode.terminates();
	}

	public boolean contains(String prefix) {
		return contains(prefix, false);
	}
}
