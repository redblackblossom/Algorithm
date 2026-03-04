import java.util.*;

public class Main {

    static int M;
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        for(int i =0; i<N;++i) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start =1;
        int end = arr[N-1] + 1;
        int mid = 1;

        while(start +1 < end) {
            mid = (start + end) /2;
            if(calc(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(start !=1) {
            System.out.println(start);
        } else {
            if(calc(start)) {
                System.out.println(start);
            } else {
                System.out.println(0);
            }
        }
    }

    static boolean calc(int val) {
        int acc = 0;
        for(int i =0; i<N;++i){
            acc += arr[i]/val;
        }

        if(acc >= M) {
            return true;
        } else {
            return false;
        }
    }
}