package backjun;

import java.io.*;

public class problem_10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[][] arr = new char[5][15];

		int max = 0;
		for (int i=0; i<5; i++) {
			char[] line = br.readLine().toCharArray();
			int length = line.length;
			if (length > max) max = length;

			for (int j=0; j<length; j++) {
				arr[i][j] = line[j];
			}
		}

		for (int i=0; i<max; i++) {
			for (int j=0; j<5; j++) {
				if (arr[j][i] != '\u0000') sb.append(arr[j][i]);
			}
		}

		System.out.println(sb);
		br.close();
	}
}