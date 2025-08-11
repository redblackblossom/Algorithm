import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		parent = new int[n+1];
		
		
		for(int i =0; i<n;++i) {
			parent[i] = i;
		}
		
		for(int i =0; i<m;++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			union(a,b);
			union(b,a);
		}
		
		Set<Integer> s = new HashSet<>();
/*		for(int i =1; i<=n;++i) {
			System.out.println(find(i));
			;
		}*/
		
		for(int i =1; i<=n;++i) {
			if(!s.contains(find(i))) {
				s.add(find(i));
			}
		}
		
		System.out.println(s.size());
		
	}
	
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		} else {
			return parent[v] = find(parent[v]);
		}
	}
	
	static void union(int a, int b) {
		int aa = find(a);
		int bb = find(b);
		
		if(aa != bb) {
			parent[bb] = aa;
		}
		
	}
	
}
