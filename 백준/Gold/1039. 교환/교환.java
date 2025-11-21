import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001][k + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n][0] = true;

        int len = String.valueOf(n).length();

        for (int depth = 0; depth < k; depth++) {
            int size = q.size();
            if (size == 0) break;

            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                char[] arr = String.valueOf(cur).toCharArray();

                for (int i = 0; i < len; i++) {
                    for (int j = i + 1; j < len; j++) {
                        char tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;

                        if (arr[0] == '0') {
                            tmp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = tmp;
                            continue;
                        }

                        int next = 0;
                        for (int t = 0; t < len; t++) {
                            next = next * 10 + (arr[t] - '0');
                        }

                        if (!visited[next][depth + 1]) {
                            visited[next][depth + 1] = true;
                            q.offer(next);
                        }

                        tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }

        int ans = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur > ans) ans = cur;
        }

        System.out.println(ans);
    }
}
