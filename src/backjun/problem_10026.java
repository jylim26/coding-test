package backjun;

import java.io.*;

public class problem_10026 {
	static int N;
	static boolean[][] visited;

	static char[][] graph1;
	static char[][] graph2;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		graph1 = new char[N][N];
		graph2 = new char[N][N];

		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<N; j++) {
				char c = input.charAt(j);
				graph1[i][j] = c;
				if (c == 'R' || c == 'G') c = 'R';
				graph2[i][j] = c;
			}
		}

		// 일반인
		int count1 = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, graph1);
					count1++;
				}
			}
		}

		// 적록색약 (방문 초기화)
		visited = new boolean[N][N];
		int count2 = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, graph2);
					count2++;
				}
			}
		}
		System.out.println(count1 + " " + count2);
	}

	public static void dfs(int x, int y, char[][] graph) {
		visited[x][y] = true;

		char c = graph[x][y];

		for (int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if (graph[nextX][nextY] == c && !visited[nextX][nextY]) {
					dfs(nextX, nextY, graph);
				}
			}
		}
	}
}
