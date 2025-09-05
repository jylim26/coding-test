package backjun;

import java.io.*;
import java.util.*;

public class problem_7576 {

    static int[][] graph;
    static int[][] dist;
    static int M;
    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 익은 토마토들이 동시에 실행되어야 하므로, 큐에 동시에 삽입
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                count = Math.max(count, dist[i][j]);
            }
        }
        System.out.println(count);
    }
}
