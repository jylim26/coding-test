package backjun;

import java.io.*;
import java.util.*;

public class problem_10709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[][] arr = new char[H][W];

		// char 배열에 입력데이터 저장
		for (int i=0; i<H; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<W; j++) {
				arr[i][j] = input[j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<H; i++) {
			int cnt = 0;
			for (int j=0; j<W; j++) {
				// 구름을 만나면 출력하고 0으로 초기화
				if (arr[i][j] == 'c') {
					cnt = 0;
					sb.append(cnt++).append(" ");
				}
				// 구름을 만나지 않은 경우
				else {
					if (cnt == 0) { // 한 번도 만나지 못한 경우
						sb.append(-1).append(" ");
					} else { // '.' 인 경우
						sb.append(cnt++).append(" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
