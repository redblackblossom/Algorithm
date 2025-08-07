import java.util.*;

public class Main {
    static int[][] map = new int[101][101];
    static int[][] accMap = new int[102][102];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int x = a; x < a + 10; ++x) {
                for(int y = b; y < b + 10; ++y) {
                    map[x][y] = 1;
                }
            }
        }
        
        for(int i = 1; i <= 100; ++i) {
            for(int j = 1; j <= 100; ++j) {
                accMap[i][j] = accMap[i-1][j] + accMap[i][j-1] - accMap[i-1][j-1] + map[i-1][j-1];
            }
        }

        int answer = 0;
        for(int x1 = 1; x1 <= 100; ++x1) {
            for(int y1 = 1; y1 <= 100; ++y1) {
                for(int x2 = x1; x2 <= 100; ++x2) {
                    for(int y2 = y1; y2 <= 100; ++y2) {
                        int area = accMap[x2][y2] - accMap[x1-1][y2] - accMap[x2][y1-1] + accMap[x1-1][y1-1];
                        int realArea = (x2 - x1 + 1) * (y2 - y1 + 1);
                        if(area == realArea) {
                            answer = Math.max(answer, area);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
