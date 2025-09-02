package backjun;

import java.io.*;
import java.util.*;

public class problem_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int i=0; i<TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];

			for (int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[j][0] = x;
				arr[j][1] = y;
			}

			Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

			int count = 1;
			int min = arr[0][1];

			for (int j=1; j<N; j++) {
				if (arr[j][1] < min) {
					count++;
					min = arr[j][1];
				}
			}
			System.out.println(count);
		}
	}
}