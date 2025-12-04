import java.util.*;

public class Main {

	static int n;
	static List<List<Integer>> m;
	static int[] ch;
	static Deque<Integer> dq = new ArrayDeque<>();
	static List<Integer> cycle = new ArrayList<>();
	static int[] ans;
	static boolean found = false;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ch = new int[n+1];
		ans = new int[n+1];
		m = new ArrayList<>();
		for(int i =0; i <= n; i++) {
			m.add(new ArrayList<>());
		}

		for(int i =0; i<n;++i){
			int a = sc.nextInt();
			int b = sc.nextInt();
			m.get(a).add(b);
			m.get(b).add(a);
		}

		DFS(1,0);

		Deque<Integer> dq2 = new ArrayDeque<>();
		for(int i =0; i<n+1;++i){
			ans[i] = -1;
		}
		for(int v : cycle) {
			dq2.addLast(v);
			ans[v] = 0;
		}

		while(!dq2.isEmpty()) {
			int v = dq2.removeFirst();
			for(int nv : m.get(v)) {
				if(ans[nv] == -1 ) {
					ans[nv] = ans[v] + 1;
					dq2.addLast(nv);
				}
			}
		}

		for(int i =1; i<=n;++i){
			System.out.print(ans[i] + " ");
		}

	}

	static void DFS(int v, int p) {
		ch[v] = 1;
		dq.addLast(v);
		for(int i=0; i<m.get(v).size(); ++i) {
			int nv = m.get(v).get(i);
			if(ch[nv] == 0) {
				DFS(nv, v);
			}
			else if(ch[nv] == 1 && nv != p && !found) {
				found = true;
				int now = v;
				while(now != nv) {
					now = dq.removeLast();
					cycle.add(now);
				}

				return;
			}
		}

		if(!dq.isEmpty()) {
			dq.removeLast();
		}

	}
}
