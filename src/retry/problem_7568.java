package retry;

import java.io.*;

public class problem_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(line[0]);
			arr[i][1] = Integer.parseInt(line[1]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			int rank = 1;
			for (int j=0; j<N; j++) {
				if (i==j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}
}