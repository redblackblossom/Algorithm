import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][N];
        parent = new int[N];

        for(int i =0; i<N;++i){
            parent[i] = i;
        }

        for(int i = 0; i<N;++i) {
            for(int j = 0; j<N;++j) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i =0; i<N;++i){
            for(int j =0; j<N;++j) {
                if(arr[i][j] ==1){
                    union(i,j);
                }
            }
        }
        int[] ans = new int[M];
        for(int i =0; i<M;++i){
            ans[i] = sc.nextInt();
            ans[i]--;
        }
        int idx = find(ans[0]);

        String returnVal = "YES";
        for(int i =1; i<M;++i){
            if(idx != find(ans[i])) {
                returnVal = "NO";
                break;
            }
        }

        System.out.println(returnVal);

    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }

    static int find(int v) {
        if(parent[v] == v){
            return v;
        } else {
            return parent[v] = find(parent[v]);
        }
    }
}