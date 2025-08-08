import java.util.*;

public class Main {

    static int[] arr;
    static int[] output;

    static StringBuilder sb;

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

        sb = new StringBuilder();
        DFS(0, 0, n, m);

        System.out.println(sb.toString());
    }

    static void DFS(int start, int depth, int n, int r){
        if(depth == r){
            for(int i =0; i<r;++i){
                sb.append(output[i]);
                sb.append(" ");
            }
            sb.append('\n');
        } else {
            for(int i =0; i<n;++i){
                output[depth] = arr[i];
                DFS(i,depth+1, n,r);
            }
        }
    }
}
