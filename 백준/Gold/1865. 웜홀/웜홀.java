import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int TC = 0; TC < tc; ++TC) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int w = sc.nextInt();

			int tot = 2 * m + w;
			Node[] edges = new Node[tot];
			int idx = 0;

			long[] dist = new long[n + 1];
			Arrays.fill(dist, Long.MAX_VALUE / 2);
			dist[1] = 0;

			for (int i = 0; i < m; ++i) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				edges[idx++] = new Node(s, e, t);
				edges[idx++] = new Node(e, s, t);
			}

			for (int i = 0; i < w; ++i) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				edges[idx++] = new Node(s, e, -t);
			}

			boolean updated;
			for (int i = 0; i < n - 1; ++i) {
				updated = false;
				for (int j = 0; j < tot; ++j) {
					int s = edges[j].start;
					int e = edges[j].end;
					long v = edges[j].value;
					//if (dist[s] == Long.MAX_VALUE / 2) continue;
					if (dist[e] > dist[s] + v) {
						dist[e] = dist[s] + v;
						updated = true;
					}
				}
				if (!updated) break;
			}

			boolean isCycle = false;
			for (int j = 0; j < tot; ++j) {
				int s = edges[j].start;
				int e = edges[j].end;
				long v = edges[j].value;
				//if (dist[s] == Long.MAX_VALUE / 2) continue;
				if (dist[e] > dist[s] + v) {
					isCycle = true;
					break;
				}
			}

			System.out.println(isCycle ? "YES" : "NO");
		}
	}

	static class Node {
		int start, end;
		long value;
		Node(int start, int end, long value) {
			this.start = start; this.end = end; this.value = value;
		}
	}
}
