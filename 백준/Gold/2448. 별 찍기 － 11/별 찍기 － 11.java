import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][2*n-1];

        int start = 0;
        int end = 2 * n - 2;
        int mid = (start + end) / 2;

        recursive(start, end, mid, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2 * n - 1; ++j) {
                if (arr[i][j] == 1) {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void recursive(int start, int end, int mid, int depth) {
        if(end - start ==4){
            arr[0][mid] =1;

            arr[1][mid-1] = 1;
            arr[1][mid+1] = 1;

            arr[2][mid-2] = 1;
            arr[2][mid-1] = 1;
            arr[2][mid] = 1;
            arr[2][mid+1] = 1;
            arr[2][mid+2] = 1;
        } else {
            int parentStart = (start + mid)/2 + 1;
            int parentEnd = (mid + end)/2;
            int parentDepth = depth / 2;

            recursive(parentStart, parentEnd, mid, parentDepth);

            //왼쪽을 그리기
            for(int i =0; i<parentDepth; ++i) {
                for(int j =0; j<parentEnd - parentStart + 1;++j) {
                    arr[parentDepth + i][start +j] = arr[i][parentStart + j];
                }
            }

            //오른쪽을 그리기
            for(int i =0; i<parentDepth; ++i) {
                for(int j =0; j<parentEnd - parentStart + 1;++j) {
                    arr[parentDepth + i][mid +1 +j] = arr[i][parentStart + j];
                }
            }
        }
    }
}