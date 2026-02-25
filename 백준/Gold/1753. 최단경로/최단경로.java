import java.util.*;

public class Main
{
    static int V;
    static int E;
    static int start;
    static long[] dist;
    static List<List<Node1>> m = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        dist = new long[V+1];

        for(int i =0; i<V+1;++i){
            m.add(new ArrayList<>());
        }

        for(int i =0; i<E;++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            m.get(start).add(new Node1(end,value));
        }
        for(int i =1; i<V+1;++i){
            dist[i] = Long.MAX_VALUE /10;
        }

        dist[start] =0;

        PriorityQueue<Node1> pq = new PriorityQueue<>((o1,o2) -> (int)(o1.val - o2.val));
        
        pq.add(new Node1(start,0));

        while(!pq.isEmpty()) {
            Node1 now = pq.poll();

            if(dist[now.end] < now.val) {
                continue;
            }

            for(int i =0; i<m.get(now.end).size(); ++i){
                Node1 next = m.get(now.end).get(i);

                if(now.val + next.val < dist[next.end]) {
                    dist[next.end] = now.val + next.val;
                    pq.add(new Node1(next.end ,now.val + next.val ));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] >= Long.MAX_VALUE / 20) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }
        System.out.print(sb.toString());
        
    }

    static class Node1 {
        int end;
        long val;

        Node1(int a, long b) {
            end = a;
            val = b;
        }
    }
}