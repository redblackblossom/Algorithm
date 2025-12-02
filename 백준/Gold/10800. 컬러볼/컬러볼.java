import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int color;
        int size;

        Node(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Node o) {
            return this.size - o.size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Node[] balls = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[i] = new Node(i, c, s);
        }

        Arrays.sort(balls);

        int[] res = new int[n];
        int[] colorSum = new int[200001];
        int tot = 0;

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && balls[j].size < balls[i].size) {
                tot += balls[j].size;
                colorSum[balls[j].color] += balls[j].size;
                j++;
            }
            res[balls[i].idx] = tot - colorSum[balls[i].color];
        }

        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
