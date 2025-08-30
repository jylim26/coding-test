package backjun;

import java.io.*;
import java.util.*;

public class problem_9996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), "*");
		String start = st.nextToken();
		String end = st.nextToken();

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			if (line.length() < start.length() + end.length()) {
				sb.append("NE").append("\n");
			} else {
				sb.append((line.startsWith(start) && line.endsWith(end)) ? "DA" : "NE").append("\n");
			}
		}
		System.out.println(sb);
	}
}
