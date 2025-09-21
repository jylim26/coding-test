package retry;


import java.io.*;
import java.util.*;

public class problem_2644 {
	static boolean[] visited;
	static int n;
	static int m;

	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		// 그래프 및 방문 배열 초기화
		graph = new ArrayList<>();
		for (int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1];

		// 촌수 계산해야할 대상
		st = new StringTokenizer(br.readLine());
		int targetA = Integer.parseInt(st.nextToken());
		int targetB = Integer.parseInt(st.nextToken());

		// 촌수 관계 설정
		m = Integer.parseInt(br.readLine());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}



		System.out.println(bfs(targetA, targetB));
	}

	public static int bfs(int node, int target) {
		Queue<Integer> q = new LinkedList<>();
		visited[node] = true;
		q.offer(node);

		int[] dist = new int[n+1];

		while(!q.isEmpty()) {
			int cur = q.poll();
			if (cur == target) return dist[cur];
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}
		return -1;
	}
}
