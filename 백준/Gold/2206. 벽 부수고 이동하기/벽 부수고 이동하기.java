import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[][][] dp;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();


        arr = new int[n][m];
        dp = new int[n][m][2];

        for(int i =0; i<n;++i){
            for(int j = 0; j<m;++j){
                for(int k =0; k<2;++k){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i =0; i<n;++i){
            String tmp = sc.nextLine();
            for(int j = 0; j<m;++j){
                if(tmp.charAt(j) == '1'){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0,0,0));
        dp[0][0][0] = 1;

        while(!dq.isEmpty()){
            Node now = dq.pollFirst();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;
            int nowValue = dp[x][y][cnt];

            for(int i =0; i<4;++i){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx<0 || xx>=n || yy<0 || yy>=m){
                    continue;
                }

                int nextValue =  nowValue + 1;

                if(arr[xx][yy]==1 && cnt ==1){
                    continue;
                }
                if(arr[xx][yy]==0 && dp[xx][yy][cnt] > nextValue){
                    dp[xx][yy][cnt] = nextValue;
                    dq.addLast(new Node(xx,yy,cnt));
                } else if(arr[xx][yy]==1 && cnt == 0 && dp[xx][yy][cnt] > nextValue){
                    dp[xx][yy][1] = nextValue;
                    dq.addLast(new Node(xx,yy,1));
                }
            }
        }
        int asnwer = Integer.MAX_VALUE;
        for(int i = 0; i<2;++i){
            asnwer = Math.min(asnwer, dp[n-1][m-1][i]);
        }
        if(asnwer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(asnwer);
        }
    }


    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
