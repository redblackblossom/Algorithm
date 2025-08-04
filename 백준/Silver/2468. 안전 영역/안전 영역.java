import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[][] ch;
    static int answer = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int high = 0; high < 100; high++) {
            // -1 물에 잠기지 않는다
            // -2 물에 잠긴다
            ch = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] <= high) {
                        ch[i][j] = -2; // 물에 잠김
                    } else {
                        ch[i][j] = -1; // 물에 잠기지 않음
                    }
                }
            }

            int cnt = 0;
            for(int i =0; i<n;++i){
                for(int j = 0; j<n;++j){

                    if(ch[i][j] == -1) {
                        cnt++;
                        DFS(i, j, high);
                    }
                    answer = Math.max(cnt, answer);
                }
            }

        }

        System.out.println(answer);

    }

    static void DFS(int x, int y, int high) {
        for(int i =0; i<4;++i){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) {
                continue;
            }
            if(ch[nx][ny] ==-1) {
                ch[nx][ny] = 1;
                DFS(nx, ny, high);
            }
        }
    }
}