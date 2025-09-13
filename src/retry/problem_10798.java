package retry;

import java.io.*;

public class problem_10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[5][15];

		int max = 0;
		for (int i=0; i<5; i++) {
			String line = br.readLine();
			if (line.length() > max) max = line.length();

			for (int j=0; j<line.length(); j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<max; i++) {
			for (int j=0; j<5; j++) {
				if (arr[j][i] != '\u0000') sb.append(arr[j][i]);
			}
		}
		System.out.println(sb);
	}
}