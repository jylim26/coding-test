package backjun;

import java.io.*;

public class problem_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i=0; i<N; i++) {
			String line = br.readLine();

			boolean[] arr = new boolean[26];
			boolean isGroupWord = true;

			char prev = 0;

			for (int j=0; j<line.length(); j++) {
				char cur = line.charAt(j);
				if (cur != prev) {
					if (arr[cur - 'a']) {
						isGroupWord = false;
						break;
					} else {
						arr[cur - 'a'] = true;
					}
				}
				prev = cur;
			}
			if (isGroupWord) count++;
		}
		System.out.println(count);
	}
}
