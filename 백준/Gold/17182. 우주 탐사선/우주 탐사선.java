import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[][] arr;
    static int[] val;
    static int[] ch;
    static int[] ans;
    static int aans = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][N];
        val = new int[N-1];
        ch = new int[N-1];
        ans = new int[N-1];

        int ttmp = 0;
        for(int i =0;i<N;++i){
            if(i ==K) continue;
            val[ttmp] = i;
            ttmp++;
        }

        for(int i =0; i<N;++i) {
            for(int j =0; j<N;++j) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int k = 0; k<N;++k) {
            for(int i =0; i<N;++i) {
                for(int j =0; j<N;++j) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        DFS(N-1, 0);
        System.out.println(aans);

    }

    static void DFS(int n, int depth) {
        if(n == depth) {
            int tmp = 0;
            // K에서 첫번째로 가기
            tmp += arr[K][ans[0]];
            for(int i =1; i<n;++i){
                tmp += arr[ans[i-1]][ans[i]];
            }

            aans = Math.min(aans, tmp);

        } else {
            for(int i=0; i<n;++i){
                if(ch[i] ==0) {
                    ans[depth] = val[i];
                   // System.out.println(ans[depth]);
                    ch[i] =1;
                    DFS(n,depth+1);
                    ch[i]= 0;
                }
            }
        }
    }
}