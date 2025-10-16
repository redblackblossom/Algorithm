import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t-->0) {
			int n = sc.nextInt();

			int[] arr = new int[n];
			int[][] dp = new int[n][n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					dp[i][j] =-1;
					if(i==j) dp[i][j] = arr[i];
				}
			}

			System.out.println(recursive(dp, arr, 0, n-1));

		}
	}

	static int recursive(int[][] dp,int[] arr, int start, int end) {
		if(start == end) return dp[start][end];
		if(Math.abs(start - end) == 1) {
			return dp[start][end] = Math.max(arr[start], arr[end]);
		} else if(dp[start][end] != -1) {
			return dp[start][end];
		} else {
			int leftPick = arr[start] + Math.min(recursive(dp,arr, start+2, end), recursive(dp,arr, start+1, end-1));
			int rightPick = arr[end] + Math.min(recursive(dp,arr, start+1, end-1), recursive(dp,arr, start, end-2));
			return dp[start][end] = Math.max(leftPick, rightPick);
		}
	}
}
