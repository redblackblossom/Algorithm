import java.util.*;

public class Main {
    static int L;
    static int C;

    static char[] arr;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        ch = new int[C];
        sc.nextLine();
        String[] tmp = sc.nextLine().split(" ");

        for(int i =0; i<C;++i){
            arr[i] = tmp[i].charAt(0);
        }
        
        Arrays.sort(arr);

        DFS(C,L, 0,0);
    }

    static void DFS(int n, int r, int cnt, int now) {
        if(r == cnt){
            if(check()){
                for(int i =0; i<C;++i){
                    if(ch[i] == 1){
                        System.out.print(arr[i]);
                    }
                }
                System.out.println();
            }

           
        } else {
            //선택
            if(now == n) return;
            if(cnt <L){
                ch[now] = 1;
                DFS(n,r,cnt+1, now+1);
                ch[now] = 0;
            }

            //안선택
            DFS(n,r,cnt, now+1);
        }
    }

    static boolean check() {
        int j = 0;
        int m = 0;
        for(int i =0; i<C;++i) {
            if(ch[i] == 1) {
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] =='u'){
                    j ++;
                } else {
                    m++;
                }
            }
        }

        if(j >=1 && m>=2) {
            return true;
        } else {
            return false;
        }
    }
}