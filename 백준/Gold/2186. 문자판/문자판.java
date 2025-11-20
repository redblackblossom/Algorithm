import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static char[][] arr;
	static int[][][] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static String target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new char[n][m];

		for (int i = 0; i < n; ++i) {
			String line = br.readLine();
			for (int j = 0; j < m; ++j) {
				arr[i][j] = line.charAt(j);
			}
		}

		target = br.readLine();

		dp = new int[n][m][target.length()];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == target.charAt(0)) {
					ans += dfs(i, j, 0);
				}
			}
		}

		System.out.println(ans);
	}

	static int dfs(int x, int y, int idx) {
		if (arr[x][y] != target.charAt(idx)) {
			return 0;
		}

		if (idx == target.length() - 1) {
			return 1;
		}

		if (dp[x][y][idx] != -1) {
			return dp[x][y][idx];
		}

		int res = 0;

		for (int dir = 0; dir < 4; ++dir) {
			for (int step = 1; step <= k; ++step) {
				int nx = x + dx[dir] * step;
				int ny = y + dy[dir] * step;

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					break;
				}

				res += dfs(nx, ny, idx + 1);
			}
		}

		dp[x][y][idx] = res;
		return res;
	}
}
