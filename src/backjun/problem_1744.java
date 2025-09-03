package backjun;

import java.io.*;
import java.util.*;

public class problem_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 1) {
                plus.add(x);
            } else if (x == 1) {
                one++;
            } else if (x == 0) {
                zero++;
            } else {
                minus.add(x);
            }
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int result = 0;

        for (int i=0; i<plus.size(); i+=2) {
            if (i + 1 < plus.size()) {
                result += plus.get(i) * plus.get(i + 1);
            } else {
                result += plus.get(i);
            }
        }

        for (int i=0; i<minus.size(); i+=2) {
            if (i + 1 < minus.size()) {
                result += minus.get(i) * minus.get(i + 1);
            } else {
                if (zero > 0) { // 0으로 남은 마이너스값 없애기
                    zero--;
                } else { // 0 이없으면 그냥 더하기
                    result += minus.get(i);
                }
            }
        }

        result+=one;

        System.out.println(result);
    }
}