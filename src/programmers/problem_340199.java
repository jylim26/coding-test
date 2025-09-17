package programmers;

public class problem_340199 {
	class Solution {
		public int solution(int[] wallet, int[] bill) {
			int answer = 0;

			int bBill = Math.max(bill[0], bill[1]);
			int sBill = Math.min(bill[0], bill[1]);

			int bWallet = Math.max(wallet[0], wallet[1]);
			int sWallet = Math.min(wallet[0], wallet[1]);

			while(true) {
				if (sBill > sWallet || bBill > bWallet) {
					bBill /= 2;
					answer++;
				}

				if (bBill < sBill) {
					int temp = bBill;
					bBill = sBill;
					sBill = temp;
				}

				if (sBill <= sWallet && bBill <= bWallet) {
					break;
				}
			}

			return answer;
		}
	}
}
