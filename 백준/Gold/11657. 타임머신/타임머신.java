import java.util.*;

public class Main {

	static Node[] nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		nodes = new Node[m];
		long[] dp = new long[n+1];
		dp[1] = 0;
		for (int i = 2; i <= n; ++i) {
			dp[i] = Long.MAX_VALUE / 4;
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			long value = sc.nextLong();
			nodes[i] = new Node(start, end, value);
		}
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j < m; ++j) {
				int start = nodes[j].start;
				int end = nodes[j].end;
				long value = nodes[j].value;
				if (dp[start] == Long.MAX_VALUE / 4) continue;
				if (dp[end] > dp[start] + value) {
					dp[end] = dp[start] + value;
				}
			}
		}

		int ch = 0;
		for (int j = 0; j < m; ++j) {
			int start = nodes[j].start;
			int end = nodes[j].end;
			long value = nodes[j].value;
			if (dp[start] != Long.MAX_VALUE / 4 && dp[end] > dp[start] + value) {
				ch = 1;
			}
		}
		if (ch == 1) {
			System.out.println("-1");
		} else {
			for (int i = 2; i <= n; ++i) {
				if (dp[i] == Long.MAX_VALUE / 4) {
					System.out.println("-1");
				} else {
					System.out.println(dp[i]);
				}
			}
		}
	}

	static class Node {
		int start;
		int end;
		long value;
		Node(int start, int end, long value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
	}
}
