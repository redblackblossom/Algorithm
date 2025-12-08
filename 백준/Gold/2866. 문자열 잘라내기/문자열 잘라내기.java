import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; ++i) {
            String s = br.readLine();
            for (int j = 0; j < c; ++j) {
                arr[i][j] = s.charAt(j);
            }
        }

        int low = 0;
        int high = r - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isUnique(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean isUnique(int cut) {
        Set<String> set = new HashSet<>();
        for (int col = 0; col < c; ++col) {
            StringBuilder sb = new StringBuilder();
            for (int row = cut; row < r; ++row) {
                sb.append(arr[row][col]);
            }
            String s = sb.toString();
            if (!set.add(s)) return false;
        }
        return true;
    }
}
