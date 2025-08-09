import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws FileNotFoundException {
        // System.setIn(new FileInputStream("Test4.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int min = Math.min(n, m);

        int[][] arr = new int[n][m];
        int[][] ch = new int[n][m];
        int[][] ch2 = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < min / 2; ++i) {
            int x = i;
            int y = i;


            Deque<Integer> dq = new ArrayDeque<>();
            dq.addLast(arr[x][y]);
            ch[x][y] = 1;
            for (int d = 0; d < 4; ++d) {
                while (true) {
                    int xx = x + dx[d];
                    int yy = y + dy[d];
                    if (xx >= 0 && xx < n && yy >= 0 && yy < m && ch[xx][yy] == 0) {
                        ch[xx][yy] = 1;
                        dq.addLast(arr[xx][yy]);
                        x = xx;
                        y = yy;
                    } else {
                        break;
                    }
                }
            }

            int height = n - 2 * i;               
            int width  = m - 2 * i;                 
            int len = 2 * (height + width) - 4;     
            int k = r % len;                        


            while (k-- > 0) {
                dq.addFirst(dq.removeLast());
            }


            x = i;
            y = i;
            ch2[x][y] = 1;
            arr[x][y] = dq.pollFirst();
            for (int d = 0; d < 4; ++d) {
                while (true) {
                    int xx = x + dx[d];
                    int yy = y + dy[d];
                    if (xx >= 0 && xx < n && yy >= 0 && yy < m && ch2[xx][yy] == 0) {
                        ch2[xx][yy] = 1;
                        arr[xx][yy] = dq.pollFirst();
                        x = xx;
                        y = yy;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
