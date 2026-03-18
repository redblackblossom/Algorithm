import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int ans = 0;
    static int[] choice = new int[3];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        for(int i =0;i<N;++i){
            for(int j =0; j<M;++j){
                arr[i][j] = sc.nextInt();
            }
        }


        DFS(N*M, 3, 0, 0);
        System.out.println(ans);
    }

    static void DFS(int n, int r, int depth, int now){
        if(depth == r){
            int[][] arr2 = new int[N][M];

            Deque<Node> dq = new ArrayDeque<>();


            for(int i =0; i<N;++i){
                for(int j = 0; j<M;++j){
                    arr2[i][j] = arr[i][j];
                    if(arr2[i][j]==2){
                        dq.addLast(new Node(i,j));
                    }
                }
            }

            for(int i =0; i<3;++i){
                int x = choice[i] / M;
                int y = choice[i] % M;
                arr2[x][y] = 1;
            }

            while(!dq.isEmpty()) {
                Node nowNode = dq.pollFirst();

                for(int i =0; i<4;++i){
                    int nextX = nowNode.x + dx[i];
                    int nextY = nowNode.y + dy[i];

                    if(nextX <0 || nextX >= N || nextY <0 || nextY >= M) {
                        continue;
                    }

                    if(arr2[nextX][nextY] == 0){
                        arr2[nextX][nextY] =2;
                        dq.addLast(new Node(nextX, nextY));
                    }

                }
            }

            int cnt = 0;


            for(int i =0; i<N;++i){
                for(int j = 0; j<M;++j){
                    if(arr2[i][j] ==0){
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);


        } else {
            if(now >= n){
                return;
            }
            //선택
            int x = now / M;
            int y = now % M;

            if(arr[x][y] == 0){
                choice[depth] = now;
                DFS(n,r,depth+1, now+1);
            }
            //안선택
            DFS(n,r,depth, now+1);
        }
    }


    static int to2(int x, int y){
        return M * x + y;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}