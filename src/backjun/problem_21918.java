package backjun;

import java.io.*;
import java.util.*;

public class problem_21918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 전구 개수
		int M = Integer.parseInt(st.nextToken());  // 명령어 개수

		boolean[] arr = new boolean[N];

		// 전구 값 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()) == 1);
		}

		// 명령어 수행
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			switch (a) {
				case 1:
					arr[b-1] = (c == 1);
					break;
				case 2:
					for (int j = b-1; j < c; j++) {
						arr[j] = !arr[j];
					}
					break;
				case 3:
					for (int j = b-1; j < c; j++) {
						arr[j] = false;
					}
					break;
				case 4:
					for (int j = b-1; j < c; j++) {
						arr[j] = true;
					}
					break;
			}
		}
		for (int i=0; i<N; i++) {
			System.out.print(arr[i] ? "1 " : "0 ");
		}
	}
}

