import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static int[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new int[n];
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        a--;
        b--;
        int start = 1;
        int end = 1000000001;
        int mid = 0;
        while(start + 1 < end) {
            mid = (start + end) / 2;
            found = false;
            visited = new int[n];
            DFS(a,b, mid);
            if(found) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }

    public static void DFS(int v, int b, int value){
        if(v==b){
            found = true;
        } else {
            if(found){
                return;
            }
            for(int i = 0; i < list.get(v).size(); ++i) {
                Node node = list.get(v).get(i);
                if(visited[node.x] == 0 && node.val >= value) {
                    visited[node.x] = 1;
                    DFS(node.x, b, value);
                    //visited[node.x] = 0;
                }
            }
        }
    }

    static class Node {
        int x;
        int val;

        Node(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
}