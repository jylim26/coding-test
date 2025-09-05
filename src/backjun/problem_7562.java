package backjun;

import java.io.*;
import java.util.*;

public class problem_7562 {
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[][] dist;
	static int I;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int i=0; i<TC; i++) {
			I = Integer.parseInt(br.readLine());
			dist = new int[I][I];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());

			System.out.println(bfs(x, y, targetX, targetY));;
		}
	}

	public static int bfs(int x, int y, int targetX, int targetY) {
		if (x == targetX && y == targetY) return 0;

		for (int i = 0; i < I; i++) Arrays.fill(dist[i], -1);

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});

		dist[x][y] = 0;

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i=0; i<8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx>=0 && nx<I && ny>=0 && ny<I && dist[nx][ny] == -1) {
					dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
					if (nx == targetX && ny == targetY) return dist[nx][ny];
					q.offer(new int[]{nx, ny});
				}
			}
		}
		return -1;
	}
}
