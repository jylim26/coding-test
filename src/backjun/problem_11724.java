package backjun;

import java.io.*;
import java.util.*;

public class problem_11724 {
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}

		visited = new boolean[N+1];

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 그래프
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int cnt = 0;
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int node) {
		visited[node] = true; // 방문처리
		// 해당 노드와 연결된 노드들 중
		for (int next : graph.get(node)) {
			// 방문하지 않았으면
			if (!visited[next])
				// 방문
				dfs(next);
		}
	}
}
