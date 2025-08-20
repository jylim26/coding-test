package backjun;

import java.io.*;

public class problem_11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] graph = new int[N+1][N+1];

		// 그래프 초기화
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(input[j-1]);
			}
		}

		// 거쳐야할 정점
		for (int k = 1; k <= N; k++) {
			// 출발 정점
			for (int i = 1; i <= N; i++) {
				// 도착 정점
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
