import java.util.*;

public class Main {

	static int[][] dp;
	static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		dp = new int[n + 1][5];
		//UNIST
		for(int i=1; i<=n; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < 5; j++) {
				dp[i][j] = dp[i-1][j];
			}

			if (s.startsWith("U")) {
				dp[i][0] = dp[i][0] + 1;
				dp[i][0] = dp[i][0] % MOD;
			}
			if (s.startsWith("UN")) {
				dp[i][1] = dp[i][1] + 1;
				dp[i][1] = dp[i][1] % MOD;
			}
			if (s.startsWith("UNI")) {
				dp[i][2] = dp[i][2] + 1;
				dp[i][2] = dp[i][2] % MOD;
			}
			if (s.startsWith("UNIS")) {
				dp[i][3] = dp[i][3] + 1;
				dp[i][3] = dp[i][3] % MOD;
			}
			if (s.startsWith("UNIST")) {
				dp[i][4] = dp[i][4] + 1;
				dp[i][4] = dp[i][4] % MOD;
			}
			
			if (s.startsWith("NIST")) {
				dp[i][4] = dp[i][4] + dp[i-1][0];
				dp[i][4] = dp[i][4] % MOD;
			}
			if (s.startsWith("NIS")) {
				dp[i][3] = dp[i][3] + dp[i-1][0];
				dp[i][3] = dp[i][3] % MOD;
			}
			if (s.startsWith("NI")) {
				dp[i][2] = dp[i][2] + dp[i-1][0];
				dp[i][2] = dp[i][2] % MOD;
			}
			if (s.startsWith("N")) {
				dp[i][1] = dp[i][1] + dp[i-1][0];
				dp[i][1] = dp[i][1] % MOD;
			}

			if (s.startsWith("IST")) {
				dp[i][4] = dp[i][4] + dp[i-1][1];
				dp[i][4] = dp[i][4] % MOD;
			}
			if (s.startsWith("IS")) {
				dp[i][3] = dp[i][3] + dp[i-1][1];
				dp[i][3] = dp[i][3] % MOD;
			}
			if (s.startsWith("I")) {
				dp[i][2] = dp[i][2] + dp[i-1][1];
				dp[i][2] = dp[i][2] % MOD;
			}

			if (s.startsWith("ST")) {
				dp[i][4] = dp[i][4] + dp[i-1][2];
				dp[i][4] = dp[i][4] % MOD;
			}
			if (s.startsWith("S")) {
				dp[i][3] = dp[i][3] + dp[i-1][2];
				dp[i][3] = dp[i][3] % MOD;
			}

			if (s.startsWith("T")) {
				dp[i][4] = dp[i][4] + dp[i-1][3];
				dp[i][4] = dp[i][4] % MOD;
			}



		}

		System.out.println(dp[n][4]);
	}
}
