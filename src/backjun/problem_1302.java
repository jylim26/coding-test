package backjun;

import java.io.*;
import java.util.*;

public class problem_1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<TC; i++) {
			String line = br.readLine();

			if (map.get(line) == null) {
				map.put(line, 1);
			} else {
				int count = map.get(line) + 1;
				map.put(line, count);
			}
		}

		// 가장 많이 팔린 책의 제목을 담을 리스트
		List<String> results = new ArrayList<>();

		int max = -1;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			int count = e.getValue();

			if (count > max) {
				max = count;
				results.clear();
				results.add(e.getKey());
			} else if(count == max){
				results.add(e.getKey());
			}
		}

		Collections.sort(results);
		System.out.println(results.get(0));
	}
}
