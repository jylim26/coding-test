package backjun;

import java.io.*;

public class problem_20546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int amount = Integer.parseInt(br.readLine());

		int[] arr = new int[14];
		String[] input = br.readLine().split(" ");
		for (int i=0; i<input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		// 준현
		int junMoney = amount;
		int junStock = 0;

		for (int i=0; i<arr.length; i++) {
			// 주가보다 보유현금이 많으면 전량 매수
			if (junMoney >= arr[i]) {
				int cnt = junMoney / arr[i]; // 구매가능 개수
				junStock += cnt; // 보유주식 개수
				junMoney -= arr[i] * cnt; // 남은 현금
			}
		}

		// 성민
		int sungMoney = amount;
		int sungStock = 0;

		int increaseCnt = 0;
		int decreaseCnt = 0;

		for (int i=1; i<arr.length; i++) {
			// 전일대비 상승
			if (arr[i] > arr[i - 1]) {
				increaseCnt++;
				decreaseCnt = 0;
			}
			// 전일대비 하락
			else if (arr[i] < arr[i - 1])  {
				decreaseCnt++;
				increaseCnt = 0;
			}

			// 3일 연속 상승 시
			if (decreaseCnt >= 3 && sungMoney >= arr[i]) {
				int cnt = sungMoney / arr[i];
				sungStock += cnt;
				sungMoney -= arr[i] * cnt;
			} else if (increaseCnt >= 3) {
				sungMoney += arr[i] * sungStock;
				sungStock = 0;
			}
		}

		int junResult = arr[13] * junStock + junMoney;
		int sungResult = arr[13] * sungStock + sungMoney;

		if (junResult == sungResult)
			System.out.println("SAMESAME");
		else
			System.out.println(junResult > sungResult ? "BNP" : "TIMING");
	}
}
