import java.util.*;

public class Main
{

    static int MOD = 9901;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[3][n+1];
        dp[0][0] = 1;

        for(int i =1; i<n+1;++i) {
            
            dp[0][i] += ((dp[0][i-1] + dp[1][i-1]) % MOD + dp[2][i-1]) % MOD;

            dp[1][i] += (dp[0][i-1] + dp[2][i-1]) % MOD;

            dp[2][i] += (dp[0][i-1] + dp[1][i-1]) % MOD;
        }

        int ans = (dp[0][n] + dp[1][n] + dp[2][n]) % MOD;

        System.out.println(ans);
    }
}