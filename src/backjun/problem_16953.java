package backjun;

import java.io.*;
import java.util.*;

public class problem_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int count = 1;

		while(A < B) {
			if (B % 10 == 1) {
				B = B / 10;
			} else if (B % 2 == 0) {
				B = B / 2;
			} else {
				break;
			}
			count++;
		}
		System.out.println(A == B ? count : -1);
	}
}
