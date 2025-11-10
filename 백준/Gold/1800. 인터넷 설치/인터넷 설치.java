import java.util.*;

public class Main {

	static int n;
	static int p;
	static int k;
	static List<List<Node>> m = new ArrayList<>();
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
		k = sc.nextInt();

		for(int i =0; i<n+1; ++i){
			m.add(new ArrayList<>());
		}

		for(int i =0; i<p;++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int val = sc.nextInt();
			m.get(a).add(new Node(b, val));
			m.get(b).add(new Node(a, val));
		}

		dp = new int[n+1][k+1];

		for(int i =0; i<n+1; ++i){
			for(int j =0; j<k+1;++j){
				dp[i][j] = Integer.MAX_VALUE/10;
			}
		}


		dp[1][0] = 0;

		PriorityQueue<Que> pq = new PriorityQueue<>((o1, o2) ->o1.val - o2.val);
		pq.add(new Que(1,0,0));

		while(!pq.isEmpty()){
			Que now = pq.poll();
			if(dp[now.e][now.cnt] < now.val) continue;

			for(int i =0; i<m.get(now.e).size(); ++i) {
				Node next = m.get(now.e).get(i);

				//그냥 가는 경우
				if(dp[next.e][now.cnt] > Math.max(dp[now.e][now.cnt], next.val)){
					dp[next.e][now.cnt] = Math.max(dp[now.e][now.cnt], next.val);
					pq.add(new Que(next.e, dp[next.e][now.cnt], now.cnt));
				}

				//할인 쿠폰 쓰는 경우
				if(now.cnt < k){
					if(dp[next.e][now.cnt + 1] > dp[now.e][now.cnt]){
						dp[next.e][now.cnt + 1] = dp[now.e][now.cnt];
						pq.add(new Que(next.e, dp[next.e][now.cnt + 1], now.cnt + 1));
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for(int i =0; i<=k; ++i){
			ans = Math.min(ans, dp[n][i]);
		}

		if(ans == Integer.MAX_VALUE/10) ans = -1;
		System.out.println(ans);
	}

	static class Node {
		int e;
		int val;
		Node(int e, int val) {
			this.e = e;
			this.val = val;
		}
	}

	static class Que{
		int e;
		int val;
		int cnt;
		Que(int e, int val, int cnt){
			this.e = e;
			this.val = val;
			this.cnt = cnt;
		}
	}

}
