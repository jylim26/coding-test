package retry;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.util.*;

//3 25
public class problem_2583 {
	static int M;
	static int N;
	static int K;

	static int[][] graph;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new int[M][N];
		visited = new boolean[M][N];

		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				graph[i][j] = 1;
			}
		}

		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for (int j=b; j<d; j++) {
				for (int l=a; l<c; l++) {
					graph[j][l] = 0;
				}
			}
		}

		int count = 0;
		List<Integer> sizes = new ArrayList<>();
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					sizes.add(dfs(i, j));
					count++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");

		Collections.sort(sizes);
		for (int s : sizes) {
			sb.append(s).append(" ");
		}

		System.out.println(sb);
	}

	public static int dfs(int x, int y) {
		visited[x][y] = true;
		int size = 1;

		for (int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx>=0 && nx<M && ny>=0 && ny<N) {
				if (!visited[nx][ny] && graph[nx][ny] == 1) {
					size += dfs(nx, ny);
				}
			}
		}
		return size;
	}
}

