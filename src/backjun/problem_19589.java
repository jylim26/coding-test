package backjun;

import java.io.*;
import java.util.*;

public class problem_19589 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		Queue<Integer> q = new PriorityQueue<>();

		q.offer(arr[0][1]);

		for (int i=1; i<N; i++) {
			if (!q.isEmpty() && q.peek() <= arr[i][0]) {
				q.poll();
			}
			q.offer(arr[i][1]);
		}
		System.out.println(q.size());
	}
}
