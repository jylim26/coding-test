package backjun;

import java.io.*;

public class problem_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		// 배열에 몸무게, 키 저장 [ {55,185}, {58,183} ... ]
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			arr[i][0] = x;
			arr[i][1] = y;
		}


		// 비교대상 사람(i)과 전체비교
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int rank = 1; // 등수 초기화
			for (int j = 0; j < N; j++) {
				if (i == j) continue; // 본인은 비교 대상에서 제외

				// 비교대상보다 몸무게, 키가 작으면 등수 밀림
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}

		System.out.println(sb);
	}
}