package Tries;

import java.util.HashMap;

public class TrieNode {

	private char character;

	private HashMap<Character, TrieNode> children;

	private boolean terminates;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}

	public TrieNode(char character) {
		this.character = character;
		this.children = new HashMap<Character, TrieNode>();
	}

	public char getChar() {
		return character;
	}

	public void setChar(char character) {
		this.character = character;
	}

	public boolean terminates() {
		return terminates;
	}

	public void setTerminates(boolean terminates) {
		this.terminates = terminates;
	}

	public TrieNode getChild(char c) {
		return children.get(c);
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

}
