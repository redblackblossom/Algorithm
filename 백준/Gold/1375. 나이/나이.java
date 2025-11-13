import java.io.*;
import java.util.*;

public class Main {

    static int n, m, Q;
    static List<Integer>[] arr;
    static List<Integer>[] r_arr;
    static int[] ch;
    static int visitId = 1;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        r_arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
            r_arr[i] = new ArrayList<>();
        }

        int idx = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (!map.containsKey(a)) map.put(a, idx++);
            if (!map.containsKey(b)) map.put(b, idx++);

            int aIdx = map.get(a);
            int bIdx = map.get(b);

            arr[aIdx].add(bIdx);
            r_arr[bIdx].add(aIdx);
        }

        ch = new int[n + 1];

        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());

        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (!map.containsKey(a) || !map.containsKey(b)) {
                sb.append("gg\n");
                continue;
            }

            int a_idx = map.get(a);
            int b_idx = map.get(b);

            if (a_idx == b_idx) {
                sb.append("gg\n");
                continue;
            }

            visitId++;
            if (dfsIter(arr, a_idx, b_idx)) {
                sb.append(a).append('\n');
                continue;
            }

            visitId++;
            if (dfsIter(r_arr, a_idx, b_idx)) {
                sb.append(b).append('\n');
            } else {
                sb.append("gg\n");
            }
        }

        System.out.print(sb.toString());
    }

    static boolean dfsIter(List<Integer>[] graph, int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        ch[start] = visitId;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == end) return true;

            for (int next : graph[cur]) {
                if (ch[next] != visitId) {
                    ch[next] = visitId;
                    stack.push(next);
                }
            }
        }
        return false;
    }
}
