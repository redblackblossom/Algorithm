import java.util.*;

public class Main {

	static int N;
	static int R;
	static int D;
	static int d_x;
	static int d_y;

	static Pair[] points;
	static List<List<Integer>> m = new ArrayList<>();


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		D = sc.nextInt();
		d_x = sc.nextInt();
		d_y = sc.nextInt();

		points = new Pair[N];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Pair(x, y);
		}

		for(int i = 0; i < N; i++) {
			m.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {

			for (int j = i+1; j < N; j++) {
				double dist = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
				if (dist <= R) {
					m.get(i).add(j);
					m.get(j).add(i);
				}

			}
		}

		double ans = 0;

		for(int i = 0; i < N; i++) {
			int now = i;
			if(calcRange(points[now].x, points[now].y) <= R){
				ans += D;
			} else {
				boolean[] visited = new boolean[N];
				Queue<Pair> q = new LinkedList<>();
				q.add(new Pair(now, 0));
				visited[now] = true;
				while (!q.isEmpty()) {
					Pair p = q.poll();
					int curr = p.x;
					int depth = p.y;

					if (calcRange(points[curr].x, points[curr].y) <= R) {
						ans += D / Math.pow(2,depth);
						break;
					}

					for (int next : m.get(curr)) {
						if (!visited[next]) {
							visited[next] = true;
							q.add(new Pair(next, depth + 1));
						}
					}
				}
			}

		}

		System.out.println(ans);

	}

	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	static double calcRange(int x1, int y1) {
		return Math.sqrt(Math.pow(x1 - d_x, 2) + Math.pow(y1 - d_y, 2));
	}

}
