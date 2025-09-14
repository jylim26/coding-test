package programmers;

public class problem_258711 {
    static final int MAX = 1_000_000;

    public int[] solution(int[][] edges) {
        int MAX_IDX =0;
        int[] input, output;

        input = new int[MAX+1];
        output = new int[MAX+1];

        for(int[] edge : edges) {
            output[edge[0]]++;
            input[edge[1]]++;
            MAX_IDX = Math.max(MAX_IDX, Math.max(edge[0],edge[1]));
        }

        int totalGraph = 0;

        int stickGraph = 0;
        int donutGraph = 0;
        int eightGraph = 0;

        int edgeIdx = 0;
        for(int idx = 1; idx<= MAX_IDX; idx++) {
            if(input[idx] >= 2 && output[idx] >= 2) eightGraph++;
            else if(output[idx] == 0 && input[idx] > 0)   stickGraph++;
            else if(output[idx] >= 2 && input[idx] == 0) {
                edgeIdx = idx;
                totalGraph=output[idx];
            }
        }
        donutGraph =totalGraph-(eightGraph+stickGraph);
        int[] answer = {edgeIdx, donutGraph, stickGraph, eightGraph};
        return answer;
    }
}
