package backjun;

import java.io.*;
import java.util.*;

public class problem_2667 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;

	static int[] dx = {1, -1, 0, 0}; // 행 (상, 하)
	static int[] dy = {0, 0, -1, 1}; // 열 (좌, 우)

	static List<Integer> sizes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];

		// 배열 초기화
		for (int i=1; i<=N; i++) {
			String input = br.readLine();
			for (int j=1; j<=N; j++) {
				graph[i][j] = input.charAt(j-1) - '0';
			}
		}

		int count = 0;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					sizes.add(dfs(i, j));
					count++;
				}
			}
		}

		System.out.println(count);
		Collections.sort(sizes);
		for (int s : sizes) {
			System.out.println(s);
		}

	}

	public static int dfs(int x, int y) {
		// 방문 처리
		visited[x][y] = true;

		int size = 1;

		for (int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			// 배열 범위 (1 ~ N)
			if (nextX >= 1 && nextX <=N && nextY >= 1 && nextY <= N) {
				// 방문하지 않았고 집이 존재하면
				if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
					size += dfs(nextX, nextY);
				}
			}
		}
		return size;
	}
}
