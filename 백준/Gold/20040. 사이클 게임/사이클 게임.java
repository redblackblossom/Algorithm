import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[a] = b; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];           
        for (int i = 1; i <= n; i++) parent[i] = i;

        int cnt = 0;
        int answer = 0; // 0이면 사이클 없음
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cnt++;                           
            if (find(a) == find(b)) {
                answer = cnt;                
                break;
            } else {
                union(a, b);
            }
        }

        System.out.println(answer);          
    }
}
