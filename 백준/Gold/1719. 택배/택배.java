import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n+1][n+1];
        int[][] arr = new int[n+1][n+1];

        for(int i =1; i<=n;++i){
            for(int j =1; j<=n;++j){
                dp[i][j] = Integer.MAX_VALUE/10;
                arr[i][j] = Integer.MAX_VALUE/10;
                if(i==j){
                    dp[i][j] = 0;
                    arr[i][j] = 0;
                }
            }
        }

        for(int i =0; i<m;++i){
            int a= sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(arr[a][b] == 0 || arr[a][b] >c) {
                arr[a][b] = c;
                arr[b][a] = c;

                dp[a][b] =c;
                dp[b][a] = c;
            }
        }

        for(int k =1; k<=n;++k){
            for(int i =1; i<=n;++i){
                if(dp[i][k] == Integer.MAX_VALUE/10) {
                    continue;
                }
                for(int j =1; j<=n;++j){
                    if(dp[k][j] == Integer.MAX_VALUE/10) {
                        continue;
                    }
                    if(dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int[][] ans = new int[n+1][n+1];

        for(int i =1; i<=n;++i){
            for(int j =1; j<=n;++j){
                int min = dp[i][j];

                for(int k=1;k<=n;++k){
                    if(i == k) {
                        continue;
                    }

                    if(arr[i][k]== Integer.MAX_VALUE/10 || dp[k][j] == Integer.MAX_VALUE/10) {
                        continue;
                    }

                    if(arr[i][k] + dp[k][j] == min){
                        ans[i][j] = k;
                        break;
                    }
                }
            }
        }

/*        for(int i =1; i<=n;++i){
            for(int j =1; j<=n;++j){
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }*/

        for(int i =1; i<=n;++i){
            for(int j =1; j<=n;++j){
                if(i==j){
                    System.out.print("- ");
                } else {
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

}
