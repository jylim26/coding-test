package retry;

import java.io.*;
import java.util.*;

public class problem_3055 {
	static int R;
	static int C;

	static char[][] graph;

	static int[] dx = {-1, 1, 0 ,0};
	static int[] dy = {0, 0, -1, 1};

	static int[][] dist;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];
		dist = new int[R][C];
		visited = new boolean[R][C];

		Queue<int[]> water = new LinkedList<>();
		Queue<int[]> hog = new LinkedList<>();

		for (int i=0; i<R; i++) {
			String line = br.readLine();
			for (int j=0; j<C; j++) {
				graph[i][j] = line.charAt(j);
			}
		}

		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (graph[i][j] == '*') {
					water.offer(new int[]{i, j});
				}
				else if (graph[i][j] == 'S') {
					hog.offer(new int[]{i, j});
					dist[i][j] = 0;
					graph[i][j] = '.';
				}
			}
		}

		int result = bfs(water, hog);
		System.out.println(result == -1 ? "KAKTUS" : result);

	}

	public static int bfs(Queue<int[]> water, Queue<int[]> hog) {
		while(!hog.isEmpty()) {
			int waterSize = water.size();
			for (int i=0; i<waterSize; i++) {
				int[] cur = water.poll();

				for (int dir=0; dir<4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];

					if (nx>=0 && nx<R && ny>=0 && ny<C) {
						if (graph[nx][ny] == '.') {
							graph[nx][ny] = '*';
							water.offer(new int[]{nx, ny});
						}
					}
				}
			}

			int size = hog.size();
			for (int i=0; i<size; i++) {
				int[] cur = hog.poll();

				for (int dir=0; dir<4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];

					if (nx>=0 && nx<R && ny>=0 && ny<C) {
						if (!visited[nx][ny]) {
							if (graph[nx][ny] == 'D') {
								return dist[cur[0]][cur[1]] + 1;
							}
							if (graph[nx][ny] == '.') {
								visited[nx][ny] = true;
								dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
								hog.offer(new int[]{nx, ny});
							}
						}
					}
				}
			}
		}
		return -1;
	}
}

