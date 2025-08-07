import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[][][] dp;

    static int[] dx1 = {0,1,0,-1};
    static int[] dy1 = {1,0,-1,0};
    static int[] dx2 = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy2 = {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[m][n];
        dp = new int[m][n][k+1];


        for(int j = 0; j<m; ++j){
            for(int i =0; i<n;++i){
                arr[j][i] = sc.nextInt();
                for(int l = 0; l <= k; ++l) {
                    dp[j][i][l] = Integer.MAX_VALUE / 10; // Initialize dp array with -1
                }
            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0,0,0, 0));

        dp[0][0][0] = 0;

        while(!dq.isEmpty()){
            Node now = dq.pollFirst();

            for(int i =0; i<4;++i){
                int xx = now.x + dx1[i];
                int yy = now.y + dy1[i];
                int vval = now.val + 1;
                if(xx<0 || xx>=m || yy<0 || yy>=n){
                    continue;
                }
                if(arr[xx][yy] == 1) {
                    continue;
                }
                if(dp[xx][yy][now.horse] > vval){
                    dp[xx][yy][now.horse] = vval;
                    dq.addLast(new Node(xx, yy, now.horse, vval));
                }
            }

            for(int i=0; i<8;++i){
                int xx = now.x + dx2[i];
                int yy = now.y + dy2[i];
                int hhorse = now.horse + 1;
                int vval = now.val + 1;
                if(hhorse > k) {
                    continue;
                }
                if(xx<0 || xx>=m || yy<0 || yy>=n){
                    continue;
                }
                if(arr[xx][yy] == 1) {
                    continue;
                }
                if(dp[xx][yy][hhorse] > vval){
                    dp[xx][yy][hhorse] = vval;
                    dq.addLast(new Node(xx, yy,  hhorse, vval));
                }

            }

        }

        int ans = Integer.MAX_VALUE;
        for(int i =0; i <= k; ++i) {
            if(dp[m-1][n-1][i] < ans) {
                ans = dp[m-1][n-1][i];
            }
        }

        if(ans == Integer.MAX_VALUE / 10) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    static class Node{
        int x,y, horse, val;

        Node(int x, int y, int horse, int val) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.val = val;
        }
    }
}