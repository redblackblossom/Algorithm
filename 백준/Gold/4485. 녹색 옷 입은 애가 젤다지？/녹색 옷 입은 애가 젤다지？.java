import java.util.*;

public class Main {

    static int INF = Integer.MAX_VALUE/10;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t =1;

        while (true){
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }

            int[][] arr = new int[n][n];
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    dp[i][j] = INF;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dp[0][0] = arr[0][0];
            pq.add(new Node(0, 0, dp[0][0]));

            while(!pq.isEmpty()) {
                Node now = pq.poll();
                int x = now.x;
                int y= now.y;
                int val = now.val;

                if(dp[x][y] < val){
                    continue;
                }

                for(int i =0; i<4;++i){
                    int xx = x + dx[i];
                    int yy = y + dy[i];

                    if(xx < 0 || xx >= n || yy < 0 || yy >= n) {
                        continue;
                    }

                    int vval = val + arr[xx][yy];

                    if(dp[xx][yy] > vval){
                        dp[xx][yy] = vval;
                        pq.add(new Node(xx, yy, vval));
                    }
                }
            }
            System.out.println("Problem " +t+": "+ dp[n-1][n-1]);
            t++;

        }



    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int val;

        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
