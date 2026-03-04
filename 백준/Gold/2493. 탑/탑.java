import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static Deque<Node> dq = new ArrayDeque<>();
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; --i) {
            while (!dq.isEmpty()) {
                Node top = dq.peekLast();

                if (top.val <= arr[i]) {
                    ans[top.idx - 1] = i + 1;
                    dq.pollLast();
                } else {
                    break;
                }
            }
            dq.addLast(new Node(i + 1, arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int idx;
        int val;

        Node(int a, int b) {
            idx = a;
            val = b;
        }
    }
}