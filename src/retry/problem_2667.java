package retry;

import java.io.*;
import java.util.*;

// 2:27
public class problem_2667 {
	static int N;

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			String[] line = br.readLine().split("");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		int count = 0;
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					list.add(dfs(i, j));
					count++;
				}
			}
		}

		System.out.println(count);
		Collections.sort(list);
		for (int n : list) {
			System.out.println(n);
		}
	}

	public static int dfs(int x, int y) {
		visited[x][y] = true;
		int size = 1;

		for (int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					size += dfs(nx, ny);
				}
			}
		}
		return size;
	}
}
