package backjun;

import java.io.*;
import java.util.*;

public class problem_1743 {
	static int N;
	static int M;
	static int K;

	static int[][] graph;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];

		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[r][c] = 1;
		}

		List<Integer> list = new ArrayList<>();

		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					list.add(dfs(i,j));
				}
			}
		}

		System.out.println(Collections.max(list));
	}

	public static int dfs(int x, int y) {
		visited[x][y] = true;

		int size = 1;

		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
				if (!visited[nx][ny] && graph[nx][ny] == 1) {
					size+= dfs(nx, ny);
				}
			}
		}
		return size;
	}
}
