import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();

        Node[] arr = new Node[N];
        int[] dp = new int[N];

        for(int i =0; i<N;++i) {
            arr[i] = new Node(0,0);
            arr[i].cnt = sc.nextInt();
            arr[i].val = sc.nextInt();
        }

        if(arr[0].cnt <= N){
            dp[arr[0].cnt-1] = arr[0].val;
        }

        for(int i =1; i<N;++i){
            int nextCnt = i + arr[i].cnt -1;
            if(nextCnt >= N) {
                dp[i] = Math.max(dp[i-1],  dp[i]);
                continue;
            }

            dp[nextCnt] = Math.max(dp[nextCnt], dp[i-1] + arr[i].val);
            dp[i] = Math.max(dp[i-1],  dp[i]);
        }
        
        System.out.println(dp[N-1]);


    }

    static class Node {
        int cnt;
        int val;

        Node (int a, int b) {
            cnt = a;
            val = b;
        }
    }
}
