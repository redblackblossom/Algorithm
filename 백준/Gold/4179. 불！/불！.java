import java.util.*;

public class Main
{
    static int r;
    static int c;
    static int[][] arr;
    static Deque<Node> J = new ArrayDeque<>();
    static Deque<Node> F = new ArrayDeque<>();
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        arr = new int[r][c];

        String tmp;
        for(int i =0; i<r;++i){
            tmp = sc.next();

            for(int j =0; j<c;++j) {
                if(tmp.charAt(j)=='#'){
                    arr[i][j] = -1;
                } else if(tmp.charAt(j)=='F') {
                    arr[i][j] = -2;
                    F.addLast(new Node(i,j,0));
                } else if(tmp.charAt(j)=='J') {
                    arr[i][j] = -3;
                    J.addLast(new Node(i,j,0));
                }
            }
        }

        int now = 0;

        while(true) {

            if(J.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                System.exit(0);
            }

            while(!J.isEmpty()) {
                Node nowJ = J.peekFirst();
                if(nowJ.idx == now){
                    J.removeFirst();
                    int x = nowJ.x;
                    int y = nowJ.y;

                    if(arr[x][y] != -3){
                        continue;
                    }

                    for(int i =0;i<4;++i){
                        int xx = x + dx[i];
                        int yy = y + dy[i];

                        if(xx<0 || xx>=r || yy<0 || yy >=c) {
                            System.out.println(now+1);
                            System.exit(0);
                        }

                        if(arr[xx][yy] ==-1 || arr[xx][yy] == -2){
                            continue;
                        }

                        if(arr[xx][yy] ==0){
                            arr[xx][yy] = -3;
                            J.addLast(new Node(xx, yy, now+1));
                        }
                    }
                } else {
                    break;
                }
            }

            while(!F.isEmpty()) {
                Node nowF = F.peekFirst();
                if(nowF.idx == now){
                    F.removeFirst();
                    int x = nowF.x;
                    int y = nowF.y;

                    for(int i =0;i<4;++i){
                        int xx = x + dx[i];
                        int yy = y + dy[i];

                        if(xx<0 || xx>=r || yy<0 || yy >=c || arr[xx][yy] ==-1){
                            continue;
                        }

                        if(arr[xx][yy] ==0 || arr[xx][yy] ==-3){
                            arr[xx][yy] = -2;
                            F.addLast(new Node(xx, yy, now+1));
                        }
                    }
                } else {
                    break;
                }
            }

            now++;
        }

    }

    static class Node {
        int x;
        int y;
        int idx;

        Node (int a, int b, int c) {
            x = a; 
            y = b;
            idx = c;
        }
    }
}