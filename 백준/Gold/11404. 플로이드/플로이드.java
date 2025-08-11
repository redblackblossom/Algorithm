import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE / 10;
                if(i == j) {
                    dp[i][j] = 0;
                }
            }

        }

        for(int i =0; i<m;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(dp[a][b] > c) {
                dp[a][b] = c;
            }
        }

        for(int k= 1; k<=n;++k){
            for(int i = 1; i<=n;++i){
                for(int j = 1; j<=n;++j){
                    if(dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        for(int i =1; i<=n;++i){
            for(int j =1; j<=n;++j){
                if(dp[i][j] == Integer.MAX_VALUE / 10){
                    System.out.print("0 ");
                } else {
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}
