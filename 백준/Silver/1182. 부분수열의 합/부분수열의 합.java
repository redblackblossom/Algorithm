import java.util.*;

public class Main {

    static int answer = 0;
    static int[] arr;
    static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextInt();
        }

        DFS(0,n,0,0);

        System.out.println(answer);

    }

    static void DFS(int depth, int n, int res, int cnt){
        if(depth == n){
            if(res == s && cnt > 0) {
                answer++;
            }
        } else {
            DFS(depth+1, n, res, cnt);
            DFS(depth+1, n, res + arr[depth], cnt +1);
        }
    }
}
