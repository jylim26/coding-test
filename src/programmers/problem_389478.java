package programmers;

public class problem_389478 {

	class Solution {
		public int solution(int n, int w, int num) {
			int t = (num - 1) % (2 * w);
			int col = (t < w) ? t : (2 * w - 1 - t);

			int layer = (num - 1) / w;

			int full = n / w;
			int rem = n % w;

			int colHeight = full;

			if (rem > 0) {
				if (full % 2 == 0) {
					if (col < rem) colHeight++;
				} else {
					if (col >= w - rem) colHeight++;
				}
			}

			int answer = colHeight - layer;
			return answer;
		}
	}

}
