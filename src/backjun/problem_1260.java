package backjun;

import java.io.*;
import java.util.*;

public class problem_1260 {

	static List<List<Integer>> graph;
	static boolean[] dfsVisited;
	static boolean[] bfsVisited;

	static int N;
	static int M;
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>(N+1);
		dfsVisited = new boolean[N+1];
		bfsVisited = new boolean[N+1];

		for (int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i=0; i<N+1; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(V);
		System.out.println();
		bfs(V);
	}

	public static void dfs(int node) {
		dfsVisited[node] = true;
		System.out.print(node + " ");
		for (int next : graph.get(node)) {
			if (!dfsVisited[next]) {
				dfs(next);
			}
		}
	}

	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		bfsVisited[node] = true;
		q.offer(node);

		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int next : graph.get(cur)) {
				if (!bfsVisited[next]) {
					bfsVisited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}
