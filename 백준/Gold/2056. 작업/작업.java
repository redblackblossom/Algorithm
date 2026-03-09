import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] time;
    static int[] indegree;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        time = new int[N];
        indegree = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
            int cnt = sc.nextInt();
            indegree[i] = cnt;

            for (int j = 0; j < cnt; j++) {
                int prev = sc.nextInt() - 1;
                graph.get(prev).add(i);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            ans = Math.max(ans, dp[now]);

            for (int next : graph.get(now)) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(ans);
    }
}