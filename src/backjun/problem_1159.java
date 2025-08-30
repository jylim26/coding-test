package backjun;

import java.io.*;

public class problem_1159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 성을 카운트할 배열
		int[] arr = new int[26];

		for (int i=0; i<N; i++) {
			String line = br.readLine();
			char first = line.charAt(0);
			arr[first - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arr.length; i++) {
			if (arr[i] >= 5) {
				sb.append((char) (i + 'a'));
			}
		}

		System.out.println(sb.length() > 0 ? sb : "PREDAJA");
	}
}
