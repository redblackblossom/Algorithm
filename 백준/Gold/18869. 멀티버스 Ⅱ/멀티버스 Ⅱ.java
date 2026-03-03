import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] arr, idx;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        M = fs.nextInt();
        N = fs.nextInt();

        arr = new int[M][N];
        idx = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = fs.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int[] sorted = arr[i].clone();
            Arrays.sort(sorted);

            HashMap<Integer, Integer> comp = new HashMap<>(N * 2);
            int rank = 0;
            comp.put(sorted[0], 0);

            for (int j = 1; j < N; j++) {
                if (sorted[j] != sorted[j - 1]) {
                    rank++;
                    comp.put(sorted[j], rank);
                }
            }

            for (int k = 0; k < N; k++) {
                idx[i][k] = comp.get(arr[i][k]);
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                boolean same = true;
                for (int k = 0; k < N; k++) {
                    if (idx[i][k] != idx[j][k]) {
                        same = false;
                        break;
                    }
                }
                if (same) ans++;
            }
        }

        System.out.println(ans);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}