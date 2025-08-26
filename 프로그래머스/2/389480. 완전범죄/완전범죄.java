import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int items = info.length;
        // dp[a][b] : a (< n), b (< m) 무게로 도달했을 때 처리한 물건 수 (−1 = 불가능)
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        // 첫 물건 배분
        int wA = info[0][0];
        int wB = info[0][1];
        if (wA < n) dp[wA][0] = 1;
        if (wB < m) dp[0][wB] = 1;

        // 나머지 물건
        for (int i = 1; i < items; i++) {
            int wa = info[i][0];
            int wb = info[i][1];
            int[][] next = new int[n][m];
            for (int[] row : next) Arrays.fill(row, -1);

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dp[a][b] == -1) continue;

                    // A에게 준다
                    if (a + wa < n)
                        next[a + wa][b] = Math.max(next[a + wa][b], dp[a][b] + 1);

                    // B에게 준다
                    if (b + wb < m)
                        next[a][b + wb] = Math.max(next[a][b + wb], dp[a][b] + 1);
                }
            }
            dp = next;
        }

        // A의 최소 무게 찾기
        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b] == items) answer = Math.min(answer, a);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
