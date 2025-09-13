package retry;

import java.io.*;

public class problem_10026 {
	static int N;

	static char[][] graph1;
	static char[][] graph2;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph1 = new char[N][N];
		graph2 = new char[N][N];
		visited = new boolean[N][N];

		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				char c = line.charAt(j);
				graph1[i][j] = c;
				if (c == 'G') c = 'R';
				graph2[i][j] = c;
			}
		}

		StringBuilder sb = new StringBuilder();

		int count=0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, graph1);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		visited = new boolean[N][N];
		count=0;

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, graph2);
					count++;
				}
			}
		}

		sb.append(count);
		System.out.println(sb);
	}

	public static void dfs(int x, int y, char[][] graph) {
		visited[x][y] = true;

		char cur = graph[x][y];

		for (int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx>=0 && nx<N && ny>=0 && ny<N) {
				if (!visited[nx][ny] && graph[nx][ny] == cur) {
					dfs(nx, ny, graph);
				}
			}
		}
	}
}
