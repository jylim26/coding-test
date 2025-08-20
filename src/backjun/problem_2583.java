package backjun;

import java.io.*;
import java.util.*;

public class problem_2583 {
	static boolean[][] visited;
	static int M; // 세로 행
	static int N; // 가로 열
	static int K;

	static int[] dx = {-1, 1, 0, 0}; // 좌우
	static int[] dy = {0, 0, 1, -1}; // 상하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[M][N];

		// 직사각형 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			// 꼭짓점으로 직사각형에 대해 색칠 (방문처리)
			for (int j = b; j < d; j++) {
				for (int l = a; l < c; l++) {
					visited[j][l] = true;
				}
			}
		}

		int count = 0; // 분리된 영역 수
		List<Integer> sizes = new ArrayList<>(); // 각 영역별 넓이

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					sizes.add(dfs(i, j));
					count++;
				}
			}
		}

		System.out.println(count);
		Collections.sort(sizes);
		for (int s : sizes) {
			System.out.print(s + " ");
		}
	}

	public static int dfs(int x, int y) {
		visited[x][y] = true;

		int size = 1;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
				if (!visited[nextX][nextY]) {
					size += dfs(nextX, nextY);
				}
			}
		}
		return size;
	}
}
