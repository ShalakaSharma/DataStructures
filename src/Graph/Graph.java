package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int v;

	private LinkedList<Integer> adjacencyList[];

	Graph(int v) {
		this.v = v;
		adjacencyList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.bfs(2);
		System.out.println("------");
		g.dfs(2);

	}

	public void bfs(int s) {
		Queue<Integer> visited = new LinkedList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		visited.add(s);
		queue.add(s);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			LinkedList<Integer> adj = adjacencyList[current];
			for (Integer i : adj) {
				if (!visited.contains(i)) {
					queue.add(i);
					visited.add(i);
				}
			}

		}
	}

	public void dfsRec(int current, Queue<Integer> visited) {
		System.out.println(current);
		LinkedList<Integer> adj = adjacencyList[current];
		for (Integer i : adj) {
			if (!visited.contains(i)) {
				visited.add(i);
				dfsRec(i,visited);
			}
		}

	}
	
	public void dfs(int s) {
		Queue<Integer> visited = new LinkedList<Integer>();
		visited.add(s);
		dfsRec(s, visited);
	}
}
