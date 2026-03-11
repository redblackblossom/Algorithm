import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] ch;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ch = new int[N];
        ans = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        DFS(N, M, 0);
        System.out.print(sb);
    }

    static void DFS(int n, int r, int cnt) {
        if (r == cnt) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = 0; i < n; i++) {
                ch[i] = 1;
                ans[cnt] = arr[i];
                DFS(n, r, cnt + 1);
                ch[i] = 0;
            }
        }
    }
}