import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] nodes = new Node[n];
		int[] dp = new int[n];

		for(int i =0; i<n;++i){
			int a = sc.nextInt();
			int b = sc.nextInt();
			nodes[i] = new Node(a,b);
		}

		Arrays.sort(nodes, (o1,o2) -> o1.start - o2.start);
		Arrays.fill(dp, 1);
		for(int i =1; i<n;++i) {
			for(int j = 0; j<i;++j){
				if(nodes[i].end > nodes[j].end && dp[j] +1 > dp[i]) {
					dp[i] =  dp[j] +1;
				}
			}
		}
		int max = 0;
		for(int i =0; i<n;++i) {
			max = Math.max(dp[i], max);
		}

		System.out.println(n - max);

	}

	static class Node {
		int start;
		int end;

		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
