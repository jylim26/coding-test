package backjun;

import java.io.*;
import java.util.*;

public class problem_2178 {
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] graph;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static int[][] dist; // 시작지점부터 x,y 까지의 최단거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		dist = new int[N+1][M+1];

		// 미로 그래프 초기화
		for (int i=1; i<N+1; i++) {
			String line = br.readLine();
			for (int j=1; j<M+1; j++) {
				graph[i][j] = line.charAt(j-1) - '0';
			}
		}

		bfs(1,1);
		System.out.println(dist[N][M]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[]{x,y}); // (1,1) Queue 진입

		dist[x][y] = 1; // 시작지점부터 카운트

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			// 현재정점(cur[0], cur[1]) 기준에서 상하좌우로 벽이 아닌 경우에 탐색
			for (int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					// 방문하지 않았고 벽이 아니면 탐색
					if (!visited[nx][ny] && graph[nx][ny] != 0) {
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // cur 기준 +1
						visited[nx][ny] = true;
						q.offer(new int[]{nx, ny});
					}
				}
			}
		}
	}
}
