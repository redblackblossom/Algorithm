import java.util.*;

public class Main {
	static int n;
	static int[] A;
	static int[] B;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n];
		B = new int[n];
		dp = new int[n][n];

		for(int i =0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		System.out.println(recursive(0,0));
	}

	static int recursive(int AIdx, int BIdx) {
		if(AIdx == n || BIdx == n) {
			return 0;
		}
		if(dp[AIdx][BIdx] != -1) {
			return dp[AIdx][BIdx];
		} else {
			int case1 = recursive(AIdx + 1, BIdx);
			int case2 = recursive(AIdx +1, BIdx + 1);
			int case3 = 0;
			if(A[AIdx] > B[BIdx]) {
				case3 = B[BIdx] + recursive(AIdx, BIdx + 1);
			}

			return dp[AIdx][BIdx] = Math.max(case1, Math.max(case2, case3));
		}
	}
}
