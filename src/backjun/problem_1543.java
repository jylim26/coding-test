package backjun;

import java.io.*;

public class problem_1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();

		int count = 0;

		int n = doc.length();
		int m = word.length();

		for (int i=0; i<=n-m;) {
			String target = doc.substring(i, i + word.length());

			// 단어가 일치하면 겹치지 않게 점프
			if (target.equals(word)) {
				count++;
				i += word.length();
			} else {
				i += 1;
			}
		}
		System.out.println(count);
	}
}
