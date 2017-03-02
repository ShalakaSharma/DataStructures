package Tries;

import java.util.ArrayList;

public class TrieMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("shalaka");
		list.add("sharma");
		list.add("shalini");
		list.add("rohit");
		list.add("anchal");
		list.add("karun");
		
		
		Trie trie = new Trie(list);
		System.out.println(trie.contains("ka"));
	}
}
