import java.util.*;
import java.io.*;

public class Main {

    static int[][][] dp = new int[61][61][61];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Node> dq = new ArrayDeque<>();

        for(int i = 0; i < 60; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE / 10;
                }
            }
        }

        if(n ==1) {
            int x = sc.nextInt();
            dq.addLast(new Node(x,0,0));
            dp[x][0][0] = 0;
        } else if(n ==2) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dq.addLast(new Node(x,y,0));
            dp[x][y][0] = 0;
        } else {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            dq.addLast(new Node(x, y, z));
            dp[x][y][z] = 0;
        }


        while(!dq.isEmpty()) {
            Node node = dq.pollFirst();
            int x = node.x;
            int y = node.y;
            int z = node.z;
            int nx,ny,nz;

            //모든 뮤탈의 쿠션을 계산합니다.

            // 9,3,1
            nx = Math.max(x - 9,0) ;
            ny = Math.max(y-3,0) ;
            nz = Math.max(z-1, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

            // 9,1,3
            nx = Math.max(x - 9, 0);
            ny = Math.max(y - 1, 0);
            nz = Math.max(z - 3, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

            // 3,9,1
            nx = Math.max(x - 3, 0);
            ny = Math.max(y - 9, 0);
            nz = Math.max(z - 1, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

            // 3,1,9
            nx = Math.max(x - 3, 0);
            ny = Math.max(y - 1, 0);
            nz = Math.max(z - 9, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

            // 1,3,9
            nx = Math.max(x - 1, 0);
            ny = Math.max(y - 3, 0);
            nz = Math.max(z - 9, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

            // 1,9,3
            nx = Math.max(x - 1, 0);
            ny = Math.max(y - 9, 0);
            nz = Math.max(z - 3, 0);
            if(dp[nx][ny][nz] > dp[x][y][z] + 1) {
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                dq.addLast(new Node(nx, ny, nz));
            }

        }

        System.out.println(dp[0][0][0]);
    }


    static class Node {
        int x, y, z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}