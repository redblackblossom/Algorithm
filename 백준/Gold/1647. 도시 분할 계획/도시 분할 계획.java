import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        parent = new int[N];

        for(int i =0; i<N;++i) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> o1.val - o2.val
        );

        for(int i =0; i<M;++i){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int val = sc.nextInt();

            pq.add(new Node(a, b, val));

        }

        int cnt = N-2;
        int ans = 0;
        while(cnt != 0) {
            Node now = pq.poll();
            int a = now.a;
            int b = now.b;
            int val = now.val;

            if(find(a) != find(b)) {
                union(a, b);
                ans += val;
                cnt--;
            }
        }

        System.out.println(ans);

    }

    static class Node {
        int a;
        int b;
        int val;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.val = c;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b){
            parent[a] = b;
        }
    }

    static int find(int v){
        if(parent[v] == v){
            return v;
        } else {
            return parent[v] = find(parent[v]);
        }
    }
}