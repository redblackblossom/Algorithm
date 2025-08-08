import java.util.*;

public class Main {

    static int[] arr;
    static int[] output;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        output = new int[m];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        DFS(0, 0, n, m);
        System.out.print(sb.toString());
    }


    static void DFS(int start, int depth, int n, int r){
        if(depth == r) {
            for(int i = 0; i < r; ++i){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = start; i<n;++i){
                output[depth] = arr[i];
                DFS(i, depth + 1, n, r);
            }
        }
    }
}
