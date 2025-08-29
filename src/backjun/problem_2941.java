package backjun;

import java.io.*;


public class problem_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		String[] arr = {"dz=", "z=", "c=", "c-", "d-", "lj", "nj", "s="};

		// 크로아티아 알파벳을 찾아서 치환
		for (int i=0; i<arr.length; i++) {
			if (line.contains(arr[i])) {
				line = line.replace(arr[i], "#");
			}
		}

		System.out.println(line.length());

	}
}
