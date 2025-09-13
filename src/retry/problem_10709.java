package retry;

import java.io.*;
import java.util.*;

public class problem_10709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[][] arr = new char[H][W];

		for (int i=0; i<H; i++) {
			String line = br.readLine();
			for (int j=0; j<W; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<H; i++) {
			int meetCloud = 0;
			int minute = 0;
			for (int j=0; j<W; j++) {
				if (arr[i][j] == 'c') {
					minute = 0;
					meetCloud = 1;
					sb.append(0).append(" ");
				} else {
					if (meetCloud == 0) {
						sb.append(-1).append(" ");
					} else {
						sb.append(++minute).append(" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
