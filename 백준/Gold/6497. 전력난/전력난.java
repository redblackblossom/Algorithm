import java.util.*;

public class Main {

	static int [] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int n = 1;
		int m = 1;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==0 && m==0) break;

			parent = new int[n];
			int tot = 0;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int val = sc.nextInt();
				tot += val;
				pq.add(new Node(a, b, val));
			}
			int cnt  = m-1;
			while(!pq.isEmpty()) {
				Node node = pq.poll();

				if(find(node.start) != find(node.end)) {
					union(node.start, node.end);
					ans += node.val;
					cnt--;
				}

				if(cnt == 0) break;
			}
			System.out.println(tot - ans);
		}
    }

	static int find(int a){
		if(parent[a] == a) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[a] = b;
		}
	}

	static class Node implements Comparable<Node>{
		int start;
		int end;
		int val;

		Node(int start, int end, int val) {
			this.start = start;
			this.end = end;
			this.val = val;
		}


		@Override
		public int compareTo(Node o){
			return this.val - o.val;
		}

	}

}
