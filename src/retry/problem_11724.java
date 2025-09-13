package retry;

import java.io.*;
import java.util.*;

public class problem_11724 {
	static int N;
	static int M;

	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		graph = new ArrayList<>(N+1);
		for (int i=0; i<N+1; i++) graph.add(new ArrayList<>());

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int size = 0;
		for (int i=1; i<N+1; i++) {
			if (!visited[i]) {
				dfs(i);
				size++;
			}
		}
		System.out.println(size);
	}

	public static void dfs(int n) {
		visited[n] = true;
		for (int next : graph.get(n)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
