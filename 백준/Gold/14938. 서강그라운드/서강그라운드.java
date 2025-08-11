import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE /2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, r;
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i =0; i<r;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            a--;
            b--;

            dp[a][b] = c;
            dp[b][a] = c;
        }

        for(int k =0; k<n;++k) {
            for(int i =0; i<n;++i) {
                if(dp[i][k] == INF) {
                    continue;
                }

                for(int j =0; j<n;++j){
                    if(dp[k][j] == INF) {
                        continue;
                    }
                    if(dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int answer = 0;

        for(int start =0; start<n;++start) {
            int tmp =0;
            for(int end =0; end<n;++end){
                if(dp[start][end] == INF) {
                    continue;
                }
                if(dp[start][end] <= m) {
                    tmp += arr[end];
                }
            }

            if(tmp > answer) {
                answer = tmp;
            }
        }

        System.out.println(answer);
    }

}
