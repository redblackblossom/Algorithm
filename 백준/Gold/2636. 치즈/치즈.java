import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] ch;
    // ch 1: 방문함 , ch 2 :삭제되어야할 칸

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int n,m;
    static int cnt = 0;
    static int before = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i =0; i<n; ++i) {
            for(int j =0; j<m; ++j) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int answer =0;
        while(true) {
            if(cnt == 0){
                break;
            }
            ch = new int[n][m];
            DFS(0,0);
            before = cnt;

            for(int i =0; i<n; ++i) {
                for(int j =0; j<m; ++j) {
                    if(ch[i][j] == 2) {
                        map[i][j] = 0; // 삭제
                        cnt--;
                    }
                }
            }

            answer++;
        }

        System.out.println(answer);
        System.out.println(before);

    }

    static void DFS(int x, int y){
        for(int i =0; i<4;++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >=n || ny<0 || ny >=m){
                continue;
            }
            if(ch[nx][ny] != 0) {
                continue;
            }
            if(map[nx][ny] == 0){
                ch[nx][ny] = 1; // 방문함
                DFS(nx,ny);
            } else {
                ch[nx][ny] = 2;
            }
        }

    }
}