import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n ,d;
		n = sc.nextInt();
		PriorityQueue<Node> pq1 = new PriorityQueue<>(
			(o1,o2) ->{
				if(o1.a == o2.a){
					return o2.b - o1.b;
				} else {
					return o2.a - o1.a;
				}
			}
		);

		PriorityQueue<Node> pq2 = new PriorityQueue<>(
			(o1,o2) ->{
				return o2.b - o1.b;
			}
		);


		for(int i =0; i<n;++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(a > b) {
				int c = a;
				a = b;
				b = c;
			}

			pq1.add(new Node(a,b));
		}
		d = sc.nextInt();
		int ans =0;
		while(!pq1.isEmpty()){
			Node now = pq1.poll();
			pq2.add(now);

			while(!pq2.isEmpty()){
				Node next = pq2.peek();
				if(next.b - now.a <= d){
					ans = Math.max(ans, pq2.size());
					break;
				} else {
					pq2.poll();
				}
			}
		}

		System.out.println(ans);
    }

	static class Node {
		int a;
		int b;
		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
