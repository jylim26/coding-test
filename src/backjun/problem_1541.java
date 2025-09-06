package backjun;

import java.io.*;

public class problem_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] arr = line.split("-");

		for (int i=0; i<arr.length; i++) {
			if (arr[i].contains("+")) {

				String[] plusArr = arr[i].split("\\+");
				int sum = 0;
				for (String s : plusArr) {
					sum += Integer.parseInt(s);
				}
				arr[i] = String.valueOf(sum);
			}
		}

		int result = Integer.parseInt(arr[0]);
		for (int i=1; i<arr.length; i++) {
			result -= Integer.parseInt(arr[i]);
		}
		System.out.println(result);
	}
}

