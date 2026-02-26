import java.util.*;

public class Main {
    static int N, M, A, B;
    static long C;
    static List<List<Node>> adj = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt() - 1;
        B = sc.nextInt() - 1;
        C = sc.nextLong();

        long low = 0;
        long high = 0;

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long w = sc.nextLong();
            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
            high = Math.max(high, w);
        }

        dist = new long[N];
        long answer = -1;
        long startHigh = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (solve(mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean solve(long limit) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[A] = 0;
        pq.add(new State(A, 0));

        while (!pq.isEmpty()) {
            State now = pq.poll();

            if (dist[now.curr] < now.time) continue;

            for (Node next : adj.get(now.curr)) {
                if (next.val <= limit) {
                    long nextTime = now.time + next.val;
                    if (nextTime <= C && dist[next.end] > nextTime) {
                        dist[next.end] = nextTime;
                        pq.add(new State(next.end, nextTime));
                    }
                }
            }
        }

        return dist[B] <= C;
    }

    static class Node {
        int end;
        long val;

        Node(int end, long val) {
            this.end = end;
            this.val = val;
        }
    }

    static class State implements Comparable<State> {
        int curr;
        long time;

        State(int curr, long time) {
            this.curr = curr;
            this.time = time;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.time, o.time);
        }
    }
}